package mainClasses;
import java.sql.*;

public class DB {
	private Connection con = null;
	private static DB db = new DB();

	private DB() {        	
        String url = "jdbc:mysql://172.17.193.12/DBengers?serverTimezone=UTC";
        
        try {
			con = DriverManager.getConnection(url, "ysh", "thisgood");
		} catch (SQLException e) {
			System.out.println("connection problem: ");
			e.printStackTrace();
		}
    }
	
	public static DB getInstance() {return db;}
	
	
	public void addTuples() {
		PreparedStatement pstmt;
		String tableName = "test ";
		String sql = "INSERT INTO " + tableName + "(num) VALUES " + "(?)";
		
		
		for (int i = 0; i < 10; i++) {
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, (int) (Math.random() * 100) + 1);
				
				
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void showDatabases() {
		// Statement는 정적 SQL문을 실행하고 결과를 반환받기 위한 객체다. 
    	// Statement하나당 한개의 ResultSet 객체만을 열 수 있다.
    	Statement st = null;
    	ResultSet result = null;
    	
	    	try {
				st = con.createStatement();
				// executeQuery : 쿼리를 실행하고 결과를 ResultSet 객체로 반환한다.
	    		result = st.executeQuery("show tables");
	    		
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
	
	public void closeConnection(Connection con) {
		try {
            if(con != null && !con.isClosed())
                con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	
}
