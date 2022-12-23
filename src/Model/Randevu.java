package Model;

import Model.Doktor;
import Model.Hasta;
import Model.SaglikKurumu;

import java.time.LocalDate;

public class Randevu {

    public int id;
    public Hasta hastaId;
    public Doktor doktorId;
    public SaglikKurumu kurumId;
    public LocalDate tarih;
    public Model.Kategori Kategori;

}



