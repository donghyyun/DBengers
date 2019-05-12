package mainClasses;
import java.sql.*;

public class DB {
	private Connection con = null;
	private static DB db = new DB();

	private DB() {        	
        String url = "jdbc:mysql://localhost/DBengers_Project?serverTimezone=UTC";
        
        try {
			con = DriverManager.getConnection(url, "root", "vision2414");
		} catch (SQLException e) {
			System.out.println("connection problem: ");
			e.printStackTrace();
		}
    }
	
	public static DB getInstance() {return db;}
	
	
	public void showDatabases() {
		// Statement는 정적 SQL문을 실행하고 결과를 반환받기 위한 객체다. 
    	// Statement하나당 한개의 ResultSet 객체만을 열 수 있다.
    	Statement st = null;
    	ResultSet result = null;
    	
	    	try {
				st = con.createStatement();
				// executeQuery : 쿼리를 실행하고 결과를 ResultSet 객체로 반환한다.
	    		result = st.executeQuery("SHOW DATABASES");
	    		
	    		// 결과를 하나씩 출력한다.
		    	while (result.next()){
		    		String str = result.getNString(1);
		    		System.out.println(str);
		    	}
			} catch (SQLException e) {
				System.out.println("createStatement problem: ");
				e.printStackTrace();
			}
	}
	
	private void closeConnection(Connection con) {
		try {
            if(con != null && !con.isClosed())
                con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	
}
