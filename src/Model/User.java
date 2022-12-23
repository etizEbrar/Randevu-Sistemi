package Model;

public class User {
    public User(){


    }

    public int id;
    public String ad;
    public String soyad;

    public String sifre;
    public int tcNo;
   // public String sehir;
    public int telNo;
    public Model.UserType UserType;


    public User(String ad, String soyad, int tcNo, int telNo,UserType userType) {
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
