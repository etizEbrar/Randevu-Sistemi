package Model;

import Helper.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class SaglikKurumu {
    public int id;
    public String Isim;
    public String Il;
    public String Ilce;
    public String Adres;
    public Model.Kategori Kategori;

   // DBConnection conn =null;
   DBConnection conn = new DBConnection();
    Connection con = conn.connDb();
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement preparedStatement = null;

    public SaglikKurumu() {
    }

    public SaglikKurumu(int id, String Isim, String Il, String Ilce, String Adres, Kategori kategori) {
        this.id = id;
        this.Isim = Isim;
        this.Il = Il;
        this.Ilce = Ilce;
        this.Adres = Adres;
        this.Kategori = Kategori;
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

    public Integer getKategori(Kategori Kategori) {
        int i;
        if (Kategori == Model.Kategori.Hastane)
            i = 1;
        else if (Kategori == Model.Kategori.SaglikOcagi) {
            i = 2;
        } else
            i = 3;
        return i;
    }

    public void setKategori(int kategori) {
        if (kategori == 1)
            Kategori = Model.Kategori.Hastane;
        else if (kategori == 2) {
            Kategori = Model.Kategori.SaglikOcagi;
        } else
            Kategori = Model.Kategori.DisHastanesi;
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