import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Controller {

    Model lihatmodel;
    View lihatview;

    public Controller(View View, Model Model) {
        this.lihatmodel = Model;
        this.lihatview = View;

        if (lihatmodel.getBanyakData()!=0) {
            String dataTabel[][] = lihatmodel.readTabel();
            lihatview.tabel.setModel((new JTable(dataTabel, lihatview.namaKolom)).getModel());
        }
        else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }

        lihatview.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String judul = lihatview.getJudul();
                String portofolio = lihatview.getPorto();
                String microteaching = lihatview.getMicro();
                String wawancara = lihatview.getWawancara();
                int por = Integer.parseInt(portofolio);
                int micro = Integer.parseInt(microteaching);
                int wawan = Integer.parseInt(wawancara);
                int hasil = ((por+micro+wawan)/3);
                String akhir = Integer.toString(hasil);
                lihatmodel.insertData(judul, portofolio, microteaching, wawancara,akhir);

                String dataKontak[][] = lihatmodel.readTabel();
                lihatview.tabel.setModel((new JTable(dataKontak, lihatview.namaKolom)).getModel());
            }
        });

        lihatview.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String judul = lihatview.getJudul();
                String portofolio = lihatview.getPorto();
                String microteaching = lihatview.getMicro();
                String wawancara = lihatview.getWawancara();
                int por = Integer.parseInt(portofolio);
                int micro = Integer.parseInt(microteaching);
                int wawan = Integer.parseInt(wawancara);
                int hasil = ((por+micro+wawan)/3);
                String akhir = Integer.toString(hasil);
                lihatmodel.updateTabel(judul, portofolio, microteaching, wawancara, akhir);

                String dataKontak[][] = lihatmodel.readTabel();
                lihatview.tabel.setModel((new JTable(dataKontak, lihatview.namaKolom)).getModel());
            }
        });


        lihatview.btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String dataKontak[][] = lihatmodel.readTabel();
                lihatview.tabel.setModel((new JTable(dataKontak, lihatview.namaKolom)).getModel());
            }
        });


        lihatview.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                int baris = lihatview.tabel.getSelectedRow();
                int kolom = lihatview.tabel.getSelectedColumn(); // ga kepake sekarang

                String dataterpilih = lihatview.tabel.getValueAt(baris, 0).toString();

                System.out.println(dataterpilih);

                int input = JOptionPane.showConfirmDialog(null,
                        "Apa anda ingin menghapus Judul " + dataterpilih + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);
                if (input == 0) {
                    lihatmodel.deleteTabel(dataterpilih);
                    String dataKontak[][] = lihatmodel.readTabel();
                    lihatview.tabel.setModel(new JTable(dataKontak, lihatview.namaKolom).getModel());
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                }
            }
        }
        );
    }
}
