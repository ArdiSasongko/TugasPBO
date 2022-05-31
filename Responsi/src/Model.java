import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Model {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/aslab_db";
    static final String USER = "root";
    static final String PASS = "";

    Connection koneksi;
    Statement statement;

    public Model(){
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }

    public String[][] readTabel(){
        try{
            int jmlData = 0;

            String[][] data;
            data = new String[getBanyakData()][5];

            String query = "Select * from aslab";
            ResultSet resultSet;
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("judul"); //harus sesuai nama kolom di mysql
                data[jmlData][1] = resultSet.getString("portofolio");
                data[jmlData][2] = resultSet.getString("microteaching");
                data[jmlData][3] = resultSet.getString("wawancara");
                data[jmlData][4] = resultSet.getString("nilai");
                jmlData++;
            }
            return data;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }


    public void insertData(String judul, String portofolio, String microteaching, String wawancara, String akhir){
        int jmlData=0;
        try {
            String query;
            query = "Select * from aslab WHERE judul=" + judul; // cek apakah data sudah ada
            System.out.println(judul + " " + portofolio + " " + microteaching + " " + wawancara);
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                jmlData++;
            }

            if (jmlData==0) { // jika data dengan no hp tsb belum ada
                query = "INSERT INTO aslab VALUES('"+judul+"','"+portofolio+"','"+microteaching+"','"+wawancara+"','"+akhir+"')";

                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil ditambahkan");
                JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data sudah ada");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public void updateTabel(String judul, String portofolio, String microteaching, String wawancara,String akhir){
        int jmlData=0;
        try {
            String query = "Select * from aslab WHERE judul=" + judul;
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                jmlData++;
            }

            if (jmlData==1) { // karena no hp merupakan unique value, maka dapat dipastikan hanya ada satu jika ada
                query = "UPDATE aslab SET judul='" + judul + "', portofolio='" + portofolio + "', microteaching='" + microteaching + "',wawancara ='" + wawancara + "' WHERE judul=" + judul;
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil diupdate");
                JOptionPane.showMessageDialog(null, "Data Berhasil diupdate");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data Tidak Ada");
            }

        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public int getBanyakData(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "Select * from aslab";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jmlData++;
            }
            return jmlData;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }

    public void deleteTabel (String judul) {
        try{
            String query = "DELETE FROM aslab WHERE judul = '"+judul+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");

        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
}
