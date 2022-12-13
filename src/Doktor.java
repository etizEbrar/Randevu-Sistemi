import java.util.List;

<<<<<<< HEAD
public class Doktor extends User implements IRandevu{
    public Doktor(){

    }
     public int id;
    public  Departman Departman;
    public int KurumId;
    public List<Randevu> RandevuList;
    @Override
    public List<Randevu> ListRandevu() {
        return null;
    }

    @Override
    public void DeleteRandevu() {

    }
=======
public class Doktor extends User {
    public Doktor(){

    }

    public String Brans;
    public int KurumId;
    public List<Randevu> RandevuList;
>>>>>>> ac448ae3c1661cea5e22a085e4053a83365f28cb
}
