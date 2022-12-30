package Model;

import Helper.DBConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

   public class Randevu {
    DBConnection conn = new DBConnection();
    Connection con = conn.connDb();
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement preparedStatement = null;
    public int id;
    public Hasta hastaId;
    public Doktor doktorId;

    public void setDoktor(String doktor) {
        this.doktor = doktor;
    }

    public String getDoktor() {
        return doktor;
    }

    public  String doktor;

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public  String date;
    public Doktor getDoktorId() {
        return doktorId;
    }

    public void setDoktorId(Doktor doktorId) {
        this.doktorId = doktorId;
    }

    public SaglikKurumu kurumId;
    public LocalDate tarih;
    public Model.Kategori Kategori;
    public ArrayList<SaglikKurumu> getList(String item) throws SQLException {
        ArrayList<SaglikKurumu> list = new ArrayList<>();
        SaglikKurumu obj;
        try {
            st = con.createStatement();
            String query ="    SELECT DISTINCT ilce FROM saglikkurumu WHERE il = '"+ item +"'  ORDER BY ilce ASC    ";
            rs = st.executeQuery(query);
            while (rs.next()) {
                obj = new SaglikKurumu ();
                obj.setIlce(rs.getString("ilce"));
                list.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //  st.close();
            //rs.close();
          //  con.close();
            System.out.println("list olustu");
        }

        return list;
    }
    public ArrayList<SaglikKurumu> getList2(String item) throws SQLException {
        ArrayList<SaglikKurumu> list = new ArrayList<>();
        SaglikKurumu obj;
        try {
            st = con.createStatement();
            String query ="    SELECT name FROM saglikkurumu WHERE ilce = '"+ item +"'     ";
            rs = st.executeQuery(query);
            while (rs.next()) {
                obj = new SaglikKurumu ();
                obj.setIsim(rs.getString("name"));
                list.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //  st.close();
            //rs.close();
            //  con.close();
            System.out.println("liste 2 olustu");
        }

        return list;
    }
    public List<Doktor> getDoctorsByCategoryID(int categoryID) throws SQLException {
        List<Doktor> doctors = new ArrayList<>();

        String sql = "SELECT d.doktorID, u.ad ,u.soyad FROM doktor d INNER JOIN user u ON d.userID = u.userID WHERE d.polikiniklikID = ?";

        try (

             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, categoryID);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int doc = rs.getInt("doktorID");
                String name = rs.getString("ad");
                String surname = rs.getString("soyad");
                doctors.add(new Doktor(name,surname,doc));
            }
            System.out.println("getDoctorsByCategoryID");
        }

        return doctors;
    }
    public boolean addRandevu(String il, String ilce, String hastane,String klinik,String doktor,String date) throws SQLException {
        String query = "INSERT INTO hastaRandevu " + "(il,ilce,hastane,klinik,doktor,date) VALUES" + "(?,?,?,?,?,?)";
        boolean key = false;
        try {
            st = con.createStatement();
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, il);
            preparedStatement.setString(2, ilce);
            preparedStatement.setString(3, hastane);
            preparedStatement.setString(4, klinik);
            preparedStatement.setString(5, doktor);
            preparedStatement.setString(6, date);
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

    public ArrayList<Randevu> getHastaList() throws SQLException {
        ArrayList<Randevu> list = new ArrayList<>();
        Randevu obj;
        Connection con = conn.connDb();

        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM hastaRandevu ");
            while (rs.next()) {
                obj = new Randevu();
                obj.setDoktor(rs.getString("doktor"));
                obj.setDate(rs.getString("date"));
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
    public ArrayList<SaglikKurumu> getList() throws SQLException {
        ArrayList<SaglikKurumu> list = new ArrayList<>();
        SaglikKurumu obj;

        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM saglikkurumu");
            while (rs.next()) {
                obj = new SaglikKurumu ();
                //  obj.setId(rs.getInt("saglikKurumuID"));
                obj.setIsim(rs.getString("name"));
                obj.setIl(rs.getString("il"));
                obj.setIlce(rs.getString("ilce"));
                // obj.setKategori(rs.getInt("kategoriID"));

                list.add(obj);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //   st.close();
            //rs.close();
            //con.close();
            System.out.println("list olustu");
        }

        return list;
    }
}








