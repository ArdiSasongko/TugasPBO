import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class tampilanView extends JFrame {
    JLabel lnama = new JLabel("Masukan Nama");
    JLabel ltersedia = new JLabel("Barang Yang Tersedia");
    JLabel lnmbrg = new JLabel("Nama");
    JLabel lharga = new JLabel("Harga");
    JLabel ljumlah = new JLabel("Masukan Jumlah");
    JLabel ltotal = new JLabel("Total");
    JLabel lbayar = new JLabel("Bayar");
    JLabel lkembalian = new JLabel("Kembalian");
    JLabel lstok = new JLabel("Stok");

    JTextField tf_nama = new JTextField();
    JTextField tf_nmbrg = new JTextField();
    JTextField tf_harga = new JTextField();
    JTextField tf_jumlah = new JTextField();
    JTextField tf_total = new JTextField();
    JTextField tf_bayar = new JTextField();
    JTextField tf_kembalian = new JTextField();
    JTextField tf_stok = new JTextField();
    JTextField tf_id = new JTextField();

    JButton btn_bayar = new JButton("Bayar");
    JButton btn_total = new JButton("Total");
    JButton btn_reset = new JButton("Batal");
    JButton btn_kembali = new JButton("Kembali");

    JTable tabel1 = new JTable();
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    Object kolom[] = {"id","nama","harga","Stok"};

    public tampilanView(){

        dtm = new DefaultTableModel(kolom,0);
        tabel1 = new JTable(dtm);
        scrollPane = new JScrollPane(tabel1);

        setTitle("Data Tes");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(700,500);

        add(scrollPane);
        scrollPane.setBounds(50,70,500,200);

        add(lnama);
        add(lnmbrg);
        add(ltersedia);
        add(lharga);
        add(ljumlah);
        add(ltotal);
        add(lbayar);
        add(lkembalian);
        add(lstok);

        add(tf_bayar);
        add(tf_nama);
        add(tf_nmbrg);
        add(tf_harga);
        add(tf_jumlah);
        add(tf_total);
        add(tf_kembalian);
        add(tf_stok);
        add(tf_id);

        add(btn_bayar);
        add(btn_total);
        add(btn_reset);
        add(btn_kembali);

        lnama.setBounds(50,10,100,20);
        tf_nama.setBounds(150,10,100,20);

        lstok.setBounds(50,320,50,20);
        tf_stok.setBounds(100,320,100,20);

        tf_stok.setEnabled(false);
        tf_stok.setEditable(false);

        ltersedia.setBounds(50,50,300,20);
        ltersedia.setFont(new java.awt.Font("Tahoma",2,14));

        lnmbrg.setBounds(50,300,50,20);
        tf_nmbrg.setBounds(100,300,100,20);

        tf_id.setBounds(50,270,50,20);

        tf_id.setEnabled(false);
        tf_id.setEditable(false);

        tf_nmbrg.setEnabled(false);
        tf_nmbrg.setEditable(false);

        lharga.setBounds(240,300,50,20);
        tf_harga.setBounds(290,300,100,20);

        tf_harga.setEditable(false);
        tf_harga.setEnabled(false);

        ljumlah.setBounds(430,300,100,20);
        tf_jumlah.setBounds(550,300,100,20);

        ltotal.setBounds(430,320,100,20);
        tf_total.setBounds(550,320,100,20);

        tf_total.setEditable(false);
        tf_total.setEnabled(false);

        lbayar.setBounds(430,340,100,20);
        tf_bayar.setBounds(550,340,100,20);

        lkembalian.setBounds(430,360,100,20);
        tf_kembalian.setBounds(550,360,100,20);

        tf_kembalian.setEditable(false);
        tf_kembalian.setEnabled(false);

        btn_total.setBounds(300,400,100,20);
        btn_reset.setBounds(420,400,100,20);
        btn_bayar.setBounds(540,400,100,20);
        btn_kembali.setBounds(300,425,340,20);
    }

    public String getId(){
        return tf_id.getText();
    }
    public  String getStok(){ return tf_stok.getText();}
    public String getnama(){
        return tf_nama.getText();
    }

    public String getnamaBarang(){
        return tf_nmbrg.getText();
    }

    public String getJumlah(){
        return tf_jumlah.getText();
    }

    public String getTotal(){
        String harga = getHarga();
        String jumlah = getJumlah();
        int jmlh = Integer.parseInt(jumlah);
        int hrg = Integer.parseInt(harga);
        int total = jmlh*hrg;
        return String.valueOf(total);
    }

    public String getbayar(){
        return tf_bayar.getText();
    }
    public String getHarga(){
        return tf_harga.getText();
    }

    public String getkembalian(){
        int total = Integer.parseInt(getTotal());
        int bayar = Integer.parseInt(getbayar());
        int kembalian = bayar-total;
        return String.valueOf(kembalian);

    }


}
