import java.util.List;


public class  Doktor extends User implements IRandevu{
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
}
