package Model;

import java.util.List;


   public class  Doktor extends User implements IRandevu {


    public Departman Departman;
    public int KurumId;
    public List<Randevu> RandevuList;
    public int DoktorID;



       public Doktor(String ad, String soyad, int doktorID) {
           super(ad, soyad);
           DoktorID = doktorID;
       }

       public Doktor() {
       }

       @Override

    public List<Randevu> ListRandevu() {
        return null;
    }

    @Override
    public void DeleteRandevu() {

    }
}
