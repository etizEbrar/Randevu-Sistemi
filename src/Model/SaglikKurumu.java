package Model;

public class SaglikKurumu {
    public int id;
    public String Isim;
    public String Il;
    public String Ilce;
    public String Adres;
    public Model.Kategori Kategori;


    public SaglikKurumu(int id,String Isim,String Il,String Ilce,String Adres,Kategori kategori) {
        this.id = id;
        this.Isim = Isim;
        this.Il=Il;
        this.Ilce=Ilce;
        this.Adres=Adres;
        this.Kategori= Kategori;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsim() {
        return Isim;
    }

    public void setIsim(String isim) {
        Isim = isim;
    }

    public String getIl() {
        return Il;
    }

    public void setIl(String il) {
        Il = il;
    }

    public String getIlce() {
        return Ilce;
    }

    public void setIlce(String ilce) {
        Ilce = ilce;
    }

    public String getAdres() {
        return Adres;
    }

    public void setAdres(String adres) {
        Adres = adres;
    }

    public Model.Kategori getKategori() {
        return Kategori;
    }

    public void setKategori(Model.Kategori kategori) {
        Kategori = kategori;
    }
}
