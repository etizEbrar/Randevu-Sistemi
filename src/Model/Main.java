package Model;

import Helper.DBConnection;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {


        System.out.println("Hello world!");
        DBConnection d=new DBConnection();
        d.connDb();
      //  Hasta h=new Hasta();
       // h.login("12345678","12");
        Admin a=new Admin();
        a.getList();
      //  h.register("beste","kucuk","33413125599","1234","05389839690");
        Randevu r=new Randevu();

       System.out.println(r.getList("Mugla"));
       r.getDoctorsByCategoryID(1);

    }


}