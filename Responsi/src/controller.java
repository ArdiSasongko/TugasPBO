import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class controller {
    model lihatmodel;
    AslabView lihatview;
    
    public controller(AslabView AslabView,model model){
        this.lihatmodel = model;
        this.lihatview = AslabView;

        if (lihatmodel.getBanyakData()!=0) {
            String dataTabel[][] = lihatmodel.readTabel();
            lihatview.tabel.setModel((new JTable(dataTabel, lihatview.namaKolom)).getModel());
        }
        else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
         lihatview.btn_Tambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String judul = lihatview.getNama();
                String portofolio = lihatview.getPorto();
                String microteaching = lihatview.getMicro();
                String wawancara = lihatview.getWawancara();
                model.insertTabel(judul, portofolio, microteaching, wawancara);

                String dataTabel[][] = model.readTabel();
                lihatview.tabel.setModel((new JTable(dataTabel, lihatview.namaKolom)).getModel());
            }
        });
        
       

   
    }
}
