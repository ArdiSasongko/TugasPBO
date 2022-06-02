import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class pembeliController {
    pembeliView view;
    pembeliModel model;
    public pembeliController(pembeliView pembeliView, pembeliModel pembeliModel){
        this.view = pembeliView;
        this.model = pembeliModel;

        if(model.getdata()!=0){
            String datatabel[][] = model.readTabel();
            view.tabel.setModel((new JTable(datatabel, view.kolom)).getModel());
        }
        else{
            JOptionPane.showMessageDialog(null,"DATA KOSONG");
        }

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
                        view.tf_nama.setText(pilih);
                        pilih = view.tabel.getValueAt(baris, 1).toString();
                        view.tf_namabarang.setText(pilih);
                        pilih = view.tabel.getValueAt(baris, 2).toString();
                        view.tf_jumlah.setText(pilih);
                        pilih = view.tabel.getValueAt(baris, 3).toString();
                        view.tf_total.setText(pilih);
                    }
                }
                catch (Exception e1){
                    System.out.println(e1.getMessage());
                    System.out.println("Error");
                }
            }
        });

        view.btn_update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = view.getNama();
                String namaBrg = view.getNamaBrg();
                String harga = view.getjumlah();
                String stok = view.getstok();
                model.updateTabel(nama, namaBrg, harga, stok);

                String dataKontak[][] = model.readTabel();
                view.tabel.setModel((new JTable(dataKontak, view.kolom)).getModel());
            }
        });

        view.btn_hapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = view.getNama();
                model.deleteTabel(nama);

                String dataKontak[][] = model.readTabel();
                view.tabel.setModel((new JTable(dataKontak, view.kolom)).getModel());
            }
        });

        view.btn_reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.tf_nama.setText("");
                view.tf_namabarang.setText("");
                view.tf_jumlah.setText("");
                view.tf_total.setText("");
            }
        });

        view.btn_kembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminView adminView = new adminView();
                modelAdmin modelAdmin = new modelAdmin();
                new controllerAdmin(adminView,modelAdmin);
            }
        });

    }
}
