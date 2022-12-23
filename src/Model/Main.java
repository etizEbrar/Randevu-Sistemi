package Model;

import Helper.DBConnection;

public class Main {
    public static void main(String[] args) {


        System.out.println("Hello world!");
        DBConnection d=new DBConnection();
        d.connDb();
    }


}