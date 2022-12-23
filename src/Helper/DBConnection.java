package Helper;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class DBConnection {

    // Connection c = null;

    public DBConnection() {

    }
    Connection connection = null;
    public Connection connDb() {


        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hastane", "root", "ahbubenyokmu123");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from person");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("ad"));
            }
            return connection;
        } catch (Exception e) {
            e.printStackTrace();


        }
        return connection;
    }
}
