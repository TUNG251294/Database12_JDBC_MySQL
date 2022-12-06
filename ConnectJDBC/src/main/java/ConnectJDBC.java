import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectJDBC {
    private String hostName = "localhost:3306";
    private String dbName = "demoJDBC";
    private String username = "root";
    private String password = "votinh9$";

    private String connectionURL = "jdbc:mysql://" + hostName + "/" + dbName;

    public Connection connect() {
        //Tạo đối tượng Connection
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(connectionURL, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }


}

