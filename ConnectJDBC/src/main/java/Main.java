import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        ConnectJDBC connectJDBC = new ConnectJDBC();
        Connection connection = connectJDBC.connect();

        String query = "SELECT * FROM users";

        Statement stm = null;
        try {
            //Tạo đối tượng Statement
            stm = connection.createStatement();

            //Thực thi truy vấn và trả về đối tượng ResultSet
            ResultSet rs = stm.executeQuery(query);

            //Duyệt kết quả trả về
            while (rs.next()){  //Di chuyển con trỏ xuống bản ghi kế tiếp
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");

                System.out.println(id + " - " + username + " - " + password + " - " + email);
            }
            //Đóng kết nối
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
