import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class tampilanController {
    tampilanView view;
    tampilanModel model;
    public tampilanController(tampilanView tampilanView,tampilanModel tampilanModel){
        this.view = tampilanView;
        this.model = tampilanModel;

        if(model.getdata()!=0){
            String datatabel[][] = model.readTabel();
            view.tabel1.setModel((new JTable(datatabel, view.kolom)).getModel());
        }
        else{
            JOptionPane.showMessageDialog(null,"DATA KOSONG");
        }

        view.tabel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try{
                    int baris = view.tabel1.getSelectedRow();
                    String datapilih = view.tabel1.getValueAt(baris,0).toString();
                    if(datapilih != null){
                        String pilih;
                        pilih = view.tabel1.getValueAt(baris,0).toString();
                        view.tf_id.setText(pilih);
                        pilih = view.tabel1.getValueAt(baris,1).toString();
                        view.tf_nmbrg.setText(pilih);
                        pilih = view.tabel1.getValueAt(baris, 2).toString();
                        view.tf_harga.setText(pilih);
                        pilih = view.tabel1.getValueAt(baris, 3).toString();
                        view.tf_stok.setText(pilih);
                    }
                }
                catch (Exception e1){
                    System.out.println(e1.getMessage());
                    System.out.println("Error");
                }
            }
        });

        view.btn_total.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(view.tf_harga.getText().equalsIgnoreCase("")){
                    JOptionPane.showMessageDialog(null,"Tidak ada data yang dipilih");
                }
                else{
                    String ttl = view.getTotal();
                    view.tf_total.setText(ttl);
                }


            }
        });

        view.btn_bayar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String jumlah = view.getJumlah();
                int jmlh = Integer.parseInt(jumlah);
                String bayar = view.getbayar();
                int byr = Integer.parseInt(bayar);
                String total = view.getTotal();
                int tot = Integer.parseInt(total);
                String kembali = view.getkembalian();
                String stok = view.getStok();
                int stk = Integer.parseInt(stok);

                if(bayar.equalsIgnoreCase("")){
                    JOptionPane.showMessageDialog(null,"Bayar Belum Diisi");
                }
                else{
                    if(jmlh>stk){
                        JOptionPane.showMessageDialog(null,"Pembelian Melebihi Stok");
                    }
                    else{
                        if(tot>byr){
                            view.tf_kembalian.setText(kembali);
                            JOptionPane.showMessageDialog(null,"Uang Tidak Cukup");
                        }
                        else{
                            view.tf_kembalian.setText(kembali);

                            String nama = view.getnama();
                            String namaBrg = view.getnamaBarang();
                            String ttl = String.valueOf(tot);
                            String id = view.getId();
                            model.insertabel(nama,namaBrg,jumlah,ttl);
                            jmlh = Integer.parseInt(jumlah);

                            int sisa = stk-jmlh;
                            String sisa2 = String.valueOf(sisa);
                            model.updatetabel(id,sisa2);
                            String dataKontak[][] = model.readTabel();
                            view.tabel1.setModel((new JTable(dataKontak, view.kolom)).getModel());
                            JOptionPane.showMessageDialog(null,"Terimah Kasih");
                            reset();
                        }
                    }
                }

            }
        });

        view.btn_reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        });

        view.btn_kembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginModel model = new loginModel();
                loginView view = new loginView();
                new loginController(view,model);
            }
        });


    }
    public void reset(){
        view.tf_id.setText("");
        view.tf_nama.setText("");
        view.tf_nmbrg.setText("");
        view.tf_total.setText("");
        view.tf_stok.setText("");
        view.tf_kembalian.setText("");
        view.tf_bayar.setText("");
        view.tf_jumlah.setText("");
        view.tf_harga.setText("");
    }
}
