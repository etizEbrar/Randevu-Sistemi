public class User {
    public User(){


    }
<<<<<<< HEAD
    public int id;
    public String ad;
    public String soyad;

    public String sifre;
    public int tcNo;
   // public String sehir;
    public int telNo;
    public UserType UserType;


    public User(String ad, String soyad, int tcNo, int telNo,UserType userType){
                this.ad = ad;
                this.soyad = soyad;
                this.tcNo = tcNo;
               // this.sehir = sehir;
                this.telNo=telNo;
                this.UserType=userType;
=======
    public String ad;
    public String soyad;
    public int tcNo;
    public String sehir;
    public int telNo;
    //public enum cinsiyet{}

    public User(String ad, String soyad, int tcNo, String sehir, int telNo){
        this.ad = ad,
                this.soyad = soyad,
                this.tcNo = tcNo,
                this.sehir = sehir,
>>>>>>> ac448ae3c1661cea5e22a085e4053a83365f28cb

        //cinsiyet = cinsiyet
    }

<<<<<<< HEAD



=======
    public void UserEkle(){

    }

    public void UserSil(){

    }

    public void UserGuncelle(){

    }

    public void UserOku(){

    }
>>>>>>> ac448ae3c1661cea5e22a085e4053a83365f28cb
}
