package Model;

public class Admin extends User {

    public Admin() {
    }

    public int id;

    public Admin(String ad, String soyad, String tcNo, String telNo, Model.UserType userType, int id) {
        super(ad, soyad, tcNo, telNo, userType);
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}
