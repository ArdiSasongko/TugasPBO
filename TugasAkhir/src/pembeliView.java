import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class pembeliView extends JFrame{
    JLabel ljudul = new JLabel("TAMPILAN ADMIN");
    JLabel lnama = new JLabel("NAMA");
    JLabel lnamaBarang = new JLabel("BARANG");
    JLabel ljumlah = new JLabel("JUMLAH");
    JLabel ltotal = new JLabel("TOTAL");

    JTextField tf_nama = new JTextField();
    JTextField tf_namabarang = new JTextField();
    JTextField tf_jumlah = new JTextField();
    JTextField tf_total = new JTextField();

    JButton btn_update = new JButton("UPDATE");
    JButton btn_hapus = new JButton("HAPUS");
    JButton btn_reset = new JButton("RESET");
    JButton btn_kembali = new JButton("KEMBALI");

    JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    Object kolom[] = {"nama","nama_barang","jumlah","total"};

    public pembeliView(){
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
        add(lnama);
        add(ljumlah);
        add(lnamaBarang);
        add(ltotal);

        add(tf_nama);
        add(tf_jumlah);
        add(tf_namabarang);
        add(tf_total);


        add(btn_update);
        add(btn_hapus);
        add(btn_reset);
        add(btn_kembali);

        ljudul.setBounds(550,20,500,20);
        ljudul.setFont(new java.awt.Font("Tahoma",1,24));
        lnama.setBounds(550,70,100,50);
        tf_nama.setBounds(610,85,100,20);

        tf_nama.setEnabled(false);
        tf_nama.setEditable(false);

        lnamaBarang.setBounds(550,100,100,50);
        tf_namabarang.setBounds(610,115,100,20);

        ljumlah.setBounds(550,130,100,50);
        tf_jumlah.setBounds(610,145,100,20);

        ltotal.setBounds(550,160,100,50);
        tf_total.setBounds(610,175,100,20);

        btn_update.setBounds(610, 220,100,20);
        btn_hapus.setBounds(720,220,100,20);
        btn_reset.setBounds(610,250,100,20);
        btn_kembali.setBounds(720,250,100,20);
    }

    public String getNama(){ return tf_nama.getText();}

    public String getNamaBrg(){
        return tf_namabarang.getText();
    }

    public String getjumlah(){
        return tf_jumlah.getText();
    }

    public String getstok(){
        return tf_total.getText();
    }


}
