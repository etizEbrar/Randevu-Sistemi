package Helper;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class DBConnection {

    Connection c = null;

    public DBConnection() {

    }
        public Connection connDb() {
            try {
                this.c = DriverManager
                        .getConnection("jdbc:mysql://localhost:3306/hastane", "root", "ahbubenyokmu123_");
                System.out.println("Bağlandı..");
                return c;
            } catch (Exception e) {
                e.printStackTrace();
            }

            return c;

        }

}
