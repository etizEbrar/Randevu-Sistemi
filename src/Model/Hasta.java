package Model;

import Helper.Helper;

import java.sql.*;
import java.util.List;

public class Hasta extends User implements IRandevu {

    Connection con = conn.connDb();
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement preparedStatement = null;
    public Hasta() {
        super();
    }

    public Hasta(String ad, String soyad, String tcNo, String sifre, String telNo, Model.UserType userType) {
        super(ad, soyad, tcNo, sifre, userType);
    }

    @Override
    public List<Randevu> ListRandevu() {
        return null;
    }
    @Override
    public void DeleteRandevu() {

    }

    public boolean register( String ad, String soyad, String tcNo, String sifre,String telNo) {
        int key = 0;
        boolean duplicate = false;
        String query = "INSERT INTO user" + "(ad,soyad,kimlikNo,telNo,sifre,userType) VALUES" + " (?,?,?,?,?,?)";
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM user WHERE kimlikNo='" + tcNo + "'");
            while (rs.next()) {
                duplicate = true;
                Helper.showMsg("bu tc numarasina ait bir kayit bulunmaktadir");
                break;
            }
            if (!duplicate) {

                preparedStatement = con.prepareStatement(query);
                preparedStatement.setString(1, ad);
                preparedStatement.setString(2, soyad);
                preparedStatement.setString(3, tcNo);
                preparedStatement.setString(4, telNo);
                preparedStatement.setString(5, sifre);
                preparedStatement.setString(6,"Hasta");

                preparedStatement.executeUpdate();
                key = 1;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (key == 1) {
            System.out.println("KAYIT OLUNDU");
            return true;
        } else {
            return false;
        }
    }
    public boolean login(String tcNo, String password) {
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM user WHERE tcNo = ? AND password = ?");
            preparedStatement.setString(1, tcNo);
            preparedStatement.setString(2, password);
            ResultSet result = preparedStatement.executeQuery();
            // Eğer kullanıcı veritabanında bulunursa, login işlemi başarılıdır
            return result.next();
        } catch (SQLException e) {
            // Login işlemi sırasında bir hata oluşursa, false döner
            return false;
        }
    }


}
