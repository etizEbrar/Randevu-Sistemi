package Model;

import Helper.DBConnection;
import Helper.Helper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {

    DBConnection conn = new DBConnection();
    public Model.UserType UserType;
    public int id;
    public String ad;
    public String soyad;
    public String sifre;
    public String tcNo;
    public String telNo;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getAd() {
        return ad;
    }
    public void setAd(String ad) {
        this.ad = ad;
    }
    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getTcNo() {
        return tcNo;
    }

    public void setTcNo(String tcNo) {
        this.tcNo = tcNo;
    }


    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    // public String sehir;
    public Model.UserType getUserType() {
        return UserType;
    }

    public void setUserType(Model.UserType userType) {
        UserType = userType;
    }



    public User(String ad, String soyad, String tcNo, String sifre, UserType userType) {
        super();
        this.ad = ad;
        this.soyad = soyad;
        this.tcNo = tcNo;
        this.sifre=sifre;
        this.telNo = telNo;
        this.UserType = userType;
    }
    //public enum cinsiyet{}


    public User() {
    }

    public User(String ad,String soyad) {
        this.ad = ad;
        this.soyad=soyad;
    }
    public boolean login(String tcNo, String password) {
        boolean key;
        {
            key = false;

            if (tcNo.length() == 0 || password.length() == 0) {
                Helper.showMsg("fill");
            } else if (tcNo.length() != 11) {
                Helper.showMsg("warning");
            } else {
                key = false;

                try {
                    Connection con = conn.connDb();
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("SELECT *FROM user");
                    while (rs.next()) {
                        if (tcNo.equals(rs.getString("kimlikNo"))
                                && password.equalsIgnoreCase(rs.getString("sifre"))) {
                            if (rs.getString("userType").equals("Admin")) {
                                Hasta hasta = new Hasta();
                                hasta.setId(rs.getInt("userID"));
                                hasta.setSifre(rs.getString("sifre"));
                                hasta.setTcNo(rs.getString("kimlikNo"));
                                hasta.setAd(rs.getString("ad"));
                                hasta.setSoyad(rs.getString("soyad"));
                                hasta.setTelNo(rs.getString("telNo"));
                                hasta.setUserType(Model.UserType.Hasta);
                                key = true;
                            }
                        }
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                if (!key)
                    Helper.showMsg("Boyle bir admin bulunamadi lutfen kayit olunuz.");

            }
        }

        return (key);
    }

}
