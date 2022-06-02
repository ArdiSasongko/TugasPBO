import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public class controllerAdmin {
    modelAdmin model;
    adminView view;

    public controllerAdmin(adminView adminView, modelAdmin modelAdmin){
        this.model = modelAdmin;
        this.view = adminView;

        if(model.getdata()!=0){
            String datatabel[][] = model.readTabel();
            view.tabel.setModel((new JTable(datatabel, view.kolom)).getModel());
        }
        else{
            JOptionPane.showMessageDialog(null,"DATA KOSONG");
        }

        view.btn_tambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String id = view.getId();
                String nama = view.getNama();
                String harga = view.getHarga();
                String stok = view.getstok();
                model.insertabel(id, nama, harga, stok);

                String dataKontak[][] = model.readTabel();
                view.tabel.setModel((new JTable(dataKontak, view.kolom)).getModel());
            }
        });

        view.btn_update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String id = view.getId();
                String nama = view.getNama();
                String harga = view.getHarga();
                String stok = view.getstok();
                model.updateTabel(id, nama, harga, stok);

                String dataKontak[][] = model.readTabel();
                view.tabel.setModel((new JTable(dataKontak, view.kolom)).getModel());
            }
        });

        view.btn_hapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = view.getId();
                model.deleteTabel(id);

                String dataKontak[][] = model.readTabel();
                view.tabel.setModel((new JTable(dataKontak, view.kolom)).getModel());
            }
        });

        view.btn_reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.tf_id.setText(" ");
                view.tf_nama.setText(" ");
                view.tf_harga.setText(" ");
                view.tf_stok.setText(" ");
            }
        });

        view.btn_pembeli.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pembeliView vw = new pembeliView();
                pembeliModel md = new pembeliModel();
                new pembeliController(vw,md);
            }
        });
        view.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try{
                    int baris = view.tabel.getSelectedRow();
                    String datapilih = view.tabel.getValueAt(baris,0).toString();
                    if(datapilih != null){
                        String pilih;
                        pilih = view.tabel.getValueAt(baris,0).toString();
                        view.tf_id.setText(pilih);
                        pilih = view.tabel.getValueAt(baris, 1).toString();
                        view.tf_nama.setText(pilih);
                        pilih = view.tabel.getValueAt(baris, 2).toString();
                        view.tf_harga.setText(pilih);
                        pilih = view.tabel.getValueAt(baris, 3).toString();
                        view.tf_stok.setText(pilih);
                    }
                }
                catch (Exception e1){
                    System.out.println(e1.getMessage());
                    System.out.println("Error");
                }
            }
        });
        }
}


