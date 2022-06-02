import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class loginView extends JFrame {
    koneksi conn = new koneksi();
    JLabel lusername = new JLabel("Username");
    JLabel lpass = new JLabel("Password");

    JTextField tf_username = new JTextField();
    JPasswordField tf_pass = new JPasswordField();

    JButton btn_masuk = new JButton("Masuk");
    JButton btn_pembeli = new JButton("Pembeli");

    public loginView(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(350,250);
        add(lusername);
        add(lpass);
        add(tf_pass);
        add(tf_username);
        add(btn_masuk);
        add(btn_pembeli);

        lusername.setBounds(20,30,100,20);
        tf_username.setBounds(20,50,150,20);

        lpass.setBounds(20,70,100,20);
        tf_pass.setBounds(20,90,150,20);

        btn_masuk.setBounds(20,120,100,20);
        btn_pembeli.setBounds(140,120,100,20);

        btn_masuk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public String getUser(){
        return tf_username.getText();
    }

    public String getPass(){
        return String.valueOf(tf_pass.getPassword());
    }


}
