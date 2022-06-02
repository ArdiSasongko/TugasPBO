import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class pembeliModel {
    koneksi conn = new koneksi();

    public int getdata(){
        int jmldata = 0;
        try{
            conn.statement = conn.konek.createStatement();
            String query = "SELECT*FROM pembeli";
            ResultSet rs = conn.statement.executeQuery(query);
            while (rs.next()){
                jmldata++;
            }
            return jmldata;
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL ERROR");
            return 0;
        }
    }

    public String[][] readTabel(){
        try{
            int jmldata = 0;
            String[][] data;
            data = new String[getdata()][4];

            String query = "SELECT*FROM pembeli";
            ResultSet rs;
            rs = conn.statement.executeQuery(query);
            while (rs.next()){
                data[jmldata][0] = rs.getString("nama");
                data[jmldata][1] = rs.getString("nama_barang");
                data[jmldata][2] = String.valueOf(rs.getInt("jumlah"));
                data[jmldata][3] = String.valueOf(rs.getInt("total"));
                jmldata++;
            }
            return data;
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL ERROR");
            return null;
        }
    }

    public void updateTabel(String nama, String nama_barang, String jumlah, String total){
        int jmlData=0;
        try {
            String query = "Select * from pembeli WHERE nama=" + nama;
            ResultSet resultSet = conn.statement.executeQuery(query);

            while (resultSet.next()){
                jmlData++;
            }

            if (jmlData==1) {
                query = "UPDATE pembeli SET nama_barang='" + nama_barang + "', jumlah='" + jumlah + "', total='" + total + "' WHERE nama=" + nama;
                conn.statement = (Statement) conn.konek.createStatement();
                conn.statement.executeUpdate(query); //execute querynya
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

    public void deleteTabel (String nama) {
        try{
            String query = "DELETE FROM pembeli WHERE nama = '"+nama+"'";
            conn.statement = conn.konek.createStatement();
            conn.statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");

        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
}
