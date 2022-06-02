import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class koneksi {
    String dbUrl = "jdbc:mysql://localhost/tugasakhir_ppbo";
    String dbUsername = "root";
    String dbPassword = "";
    static final String driver = "com.mysql.cj.jdbc.Driver"; //newer version includes cj
    PreparedStatement pst;
    Connection konek;
    Statement statement; //untuk melakukan eksekusi query
    public koneksi() {
        try{
            Class.forName(driver); //load driver
            //membuka koneksi ke database
            konek = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
            System.out.println("Koneksi Berhasil");
        } catch(Exception ex){
            System.out.println("Koneksi gagal");
        }
    }
}
