package mainClasses;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverTest {
public static void main(String args[]) {
			Connection conn;
	
			try {
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				conn = DriverManager.getConnection(
						"jdbc:mysql://172.17.193.12/DBengers?serverTimezone=UTC", "ysh", "thisgood");
				System.out.println("Success!");
			} catch (SQLException ex) {
				System.out.println("SQLException:" + ex);
			} catch (Exception e) {
				System.out.println("Exception:" + e);
			}
		}
	}
