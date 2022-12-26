package Model;

import Helper.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class Admin extends User {

    DBConnection conn =null;
    Connection con = conn.connDb();
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement preparedStatement = null;
    public Admin() {
    }

    public int id;

    public Admin(String ad, String soyad, String tcNo, String telNo, Model.UserType userType) {
        super(ad, soyad, tcNo, telNo, userType);

    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<SaglikKurumu> getList() throws SQLException{
        ArrayList<SaglikKurumu> list = new ArrayList<>();
        SaglikKurumu obj;

        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM saglikKurumu");
            while (rs.next()) {
                obj = new SaglikKurumu ();
                obj.setId(rs.getInt("id"));
                obj.setIsim(rs.getString("name"));
                obj.setIl(rs.getString("il"));
                obj.setIlce(rs.getString("ilce"));
                obj.setKategori(rs.getInt("kategoriID"));

                list.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            st.close();
            rs.close();
            con.close();
        }

        return list;
    }
    public boolean addSaglikKurumu(String name, String il, String ilce,String adres,String kategoriID) throws SQLException {
        String query = "INSERT INTO saglikKurumu " + "(name,il,ilce,kategoriID,adres) VALUES" + "(?,?,?,?,?)";
        boolean key = false;
        try {
            st = con.createStatement();
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, il);
            preparedStatement.setString(3, ilce);
            preparedStatement.setString(4, kategoriID);
            preparedStatement.setString(5,adres);
            preparedStatement.executeUpdate();
            key = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (key)
            return true;
        else
            return false;
    }
    public boolean deleteSaglikKurumu(int id) throws SQLException {
        String query = "DELETE FROM  saglikKurumu WHERE saglikKurumuID=?";
        boolean key = false;
        Connection con = conn.connDb();
        try {
            st = con.createStatement();
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            key = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (key)
            return true;
        else
            return false;
    }
    public boolean updateSaglikKurumu(int id,String name, String il, String ilce,String adres,String kategoriID) throws SQLException {
        String query = "UPDATE clinic SET name=?,il=?,ilce=?,adres=?,kategoriID=? WHERE id=?";
        boolean key = false;
        Connection con = conn.connDb();
        try {
            st = con.createStatement();
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, il);
            preparedStatement.setString(3, ilce);
            preparedStatement.setString(4, kategoriID);
            preparedStatement.setString(5,adres);
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
            key = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (key)
            return true;
        else
            return false;
    }


}
