package Model;

import Helper.DBConnection;

public class User {
    public User(){


    }
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



    public User(String ad, String soyad, String tcNo, String telNo,UserType userType) {
        super();
        this.ad = ad;
        this.soyad = soyad;
        this.tcNo = tcNo;
        // this.sehir = sehir;
        this.telNo = telNo;
        this.UserType = userType;
    }
    //public enum cinsiyet{}


}
