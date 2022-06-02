import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class adminView extends JFrame {
    JLabel ljudul = new JLabel("TAMPILAN ADMIN");
    JLabel lid = new JLabel("ID");
    JLabel lnama = new JLabel("NAMA");
    JLabel lharga = new JLabel("HARGA");
    JLabel lstok = new JLabel("STOK");

    JTextField tf_id = new JTextField();
    JTextField tf_nama = new JTextField();
    JTextField tf_harga = new JTextField();
    JTextField tf_stok = new JTextField();

    JButton btn_tambah = new JButton("Tambah");
    JButton btn_update = new JButton("Update");
    JButton btn_hapus = new JButton("Hapus");
    JButton btn_reset = new JButton("Reset");
    JButton btn_pembeli = new JButton("DATA PEMBELI");

    JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    Object kolom[] = {"id","nama","harga","Stok"};

    public adminView(){
        dtm = new DefaultTableModel(kolom,0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);

        setTitle("Data Tes");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(1000,500);

        add(scrollPane);
        scrollPane.setBounds(20,20,500,400);

        add(ljudul);
        add(lid);
        add(lharga);
        add(lnama);
        add(lstok);

        add(tf_id);
        add(tf_harga);
        add(tf_nama);
        add(tf_stok);

        add(btn_tambah);
        add(btn_update);
        add(btn_hapus);
        add(btn_reset);
        add(btn_pembeli);

        ljudul.setBounds(550,20,500,20);
        ljudul.setFont(new java.awt.Font("Tahoma",1,24));
        lid.setBounds(550,70,100,50);
        tf_id.setBounds(610,85,100,20);

        lnama.setBounds(550,100,100,50);
        tf_nama.setBounds(610,115,100,20);

        lharga.setBounds(550,130,100,50);
        tf_harga.setBounds(610,145,100,20);

        lstok.setBounds(550,160,100,50);
        tf_stok.setBounds(610,175,100,20);

        btn_tambah.setBounds(610, 220,100,20);
        btn_update.setBounds(720,220,100,20);
        btn_hapus.setBounds(610,250,100,20);
        btn_reset.setBounds(720,250,100,20);
        btn_pembeli.setBounds(625, 300,200,20);
    }

    public String getId(){
        return tf_id.getText();
    }

    public String getNama(){
        return tf_nama.getText();
    }

    public String getHarga(){
        return tf_harga.getText();
    }

    public String getstok(){
        return tf_stok.getText();
    }


}
