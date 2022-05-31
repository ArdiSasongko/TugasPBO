import javax.swing.JButton;
import javax.swing.JFrame;

public class menuView extends JFrame{
    JButton btnLihat = new JButton("Lihat Data");


    public menuView() {
        this.setLocationRelativeTo(null);
        setTitle("Data Peserta");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(300,400);

        add(btnLihat);
        btnLihat.setBounds(60, 170, 150, 20);
    }
}
