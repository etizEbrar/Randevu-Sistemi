package Model;

import Helper.DBConnection;

public class Main {
    public static void main(String[] args) {


        System.out.println("Hello world!");
        DBConnection d=new DBConnection();
        d.connDb();
        Hasta h=new Hasta();
        h.register("beste","kucuk","33413125599","1234","05389839690");
    }


}