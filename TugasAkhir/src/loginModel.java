import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginModel {
    koneksi conn = new koneksi();
    public void login(String username, String pass){
        int jmldata = 0;
        try{
            conn.pst = conn.konek.prepareStatement("select * from admin where username=? AND password=?");
            conn.pst.setString(1, username);
            conn.pst.setString(2, pass);
            ResultSet rs = conn.pst.executeQuery();

            while(rs.next()){
                jmldata++;
            }
            if(jmldata==1){
                adminView adminView = new adminView();
                modelAdmin modelAdmin = new modelAdmin();
                new controllerAdmin(adminView,modelAdmin);
            }
            else{
                JOptionPane.showMessageDialog(null,"Tidak Bisa Login");
            }

        }
        catch (SQLException ex){
            System.out.println("GAGAL");
        }
    }
}
