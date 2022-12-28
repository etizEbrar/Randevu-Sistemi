package Model;
import Helper.DBConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Randevu {
    DBConnection conn = new DBConnection();
    Connection con = conn.connDb();
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement preparedStatement = null;
    public int id;
    public Hasta hastaId;
    public Doktor doktorId;
    public SaglikKurumu kurumId;
    public LocalDate tarih;
    public Model.Kategori Kategori;
    public ArrayList<SaglikKurumu> getList(String item) throws SQLException {
        ArrayList<SaglikKurumu> list = new ArrayList<>();
        SaglikKurumu obj;
        try {
            st = con.createStatement();
            String query ="    SELECT ilce FROM saglikkurumu WHERE il = '"+ item +"'     ";
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
    

}



