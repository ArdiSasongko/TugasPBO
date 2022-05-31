import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class View extends JFrame{
    JLabel ljudul = new JLabel("Judul");
    JLabel lportofolio = new JLabel("Portofolio");
    JLabel lwawancara = new JLabel("Microteaching");
    JLabel lmicroteaching = new JLabel("Wawancara");

    JTextField tfjudul = new JTextField();
    JTextField tfportofolio = new JTextField();
    JTextField tfmicroteaching = new JTextField();
    JTextField tfwawancara = new JTextField();


    JButton btnTambah = new JButton("Tambah");
    JButton btnUpdate = new JButton("Update");
    JButton btnDelete = new JButton("Delete");
    JButton btnClear = new JButton("Clear");

    JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    Object namaKolom[] = {"Judul", "Portofolio", "Microteaching", "Wawancara", "Nilai"};

    public View() {
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);

        setTitle("Data Peserta");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(900,400);

        add(scrollPane);
        scrollPane.setBounds(20, 20, 480, 300);

        add(ljudul);
        ljudul.setBounds(510, 20, 90, 20);
        add(tfjudul);
        tfjudul.setBounds(510, 40, 120, 20);

        add(lportofolio);
        lportofolio.setBounds(510, 60, 90, 20);
        add(tfportofolio);
        tfportofolio.setBounds(510, 80, 120, 20);

        add(lwawancara);
        lwawancara.setBounds(510, 100, 90, 20);
        add(tfwawancara);
        tfwawancara.setBounds(510, 120, 120, 20);

        add(lmicroteaching);
        lmicroteaching.setBounds(510, 140, 90, 20);
        add(tfmicroteaching);
        tfmicroteaching.setBounds(510, 160, 120, 20);

        add(btnTambah);
        btnTambah.setBounds(510, 190, 90, 20);

        add(btnUpdate);
        btnUpdate.setBounds(510, 220, 90, 20);

        add(btnDelete);
        btnDelete.setBounds(510, 250, 90, 20);

        add(btnClear);
        btnClear.setBounds(510, 280, 90, 20);
    }

    public String getJudul(){
        return tfjudul.getText();
    }

    public String getPorto(){
        return tfportofolio.getText();
    }

    public String getMicro(){
        return tfmicroteaching.getText();
    }

    public String getWawancara(){
        return tfwawancara.getText();
    }


}

