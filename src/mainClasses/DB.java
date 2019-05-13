package mainClasses;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DB {
	private Connection con = null;
	private static DB db = new DB();

	private DB() {        	
        String url = "jdbc:mysql://172.17.193.12/DBengers?serverTimezone=UTC";
        
        try {
			con = DriverManager.getConnection(url, "kdh", "thisgood");
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
	
	
	
	public void insertUserList(String [] infos) {
		PreparedStatement pstmt = null;
		//(name,id,password,now(),nickname, birthday, gender, address, profile_photo, email, phone_num,voucher_name,is_artist,is_block,alarm_to_mail,alarm_to_sms,liked_artist);
		String sql = "INSERT INTO User VALUES(?, ?, ?,now(), ?, ?, ?, ?, ?, ?, ?, null, false, false, false , false, null)";
    	System.out.println("insertUserList entered!!");
    	
    	try {
    		pstmt = con.prepareStatement(sql);
    		for (int i = 0; i < infos.length; i++) {
    			if (i == 4) {
    				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    				Calendar c = Calendar.getInstance();
    				try{
    				   c.setTime(sdf.parse(infos[i]));
    				}catch(ParseException e){e.printStackTrace();}
    				
    				c.add(Calendar.DAY_OF_MONTH, 1);  
    				String newDate = sdf.format(c.getTime());  
    				pstmt.setDate(i + 1, Date.valueOf(newDate));
    			}
    				
    			else
    				pstmt.setString(i + 1, infos[i]);
			}
    		pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("createStatement problem: ");
			e.printStackTrace();
		}    	
	}
	
	public boolean checkLogin(String id, String pw) {
		Statement st = null;
		ResultSet result = null;

    	System.out.println("checkID entered!!");
    	try {
			st = con.createStatement();
			// executeQuery : 쿼리를 실행하고 결과를 ResultSet 객체로 반환한다.
    		result = st.executeQuery("SELECT * FROM User WHERE id='"+ id +"' AND password='" + pw + "'");
    		System.out.println("SELECT * FROM User WHERE id='"+ id +"' AND password='" + pw + "'");
    		if (!result.next()) {
    			System.out.println("return false");
    			return false;
    		}

		} catch (SQLException e) {
			System.out.println("createStatement problem: ");
			e.printStackTrace();
		}
    	System.out.println("return true");
    	return true;
	}
	
	public boolean checkId(String id) {
		Statement st = null;
		ResultSet result = null;

    	System.out.println("checkID entered!!");
    	try {
			st = con.createStatement();
			// executeQuery : 쿼리를 실행하고 결과를 ResultSet 객체로 반환한다.
    		result = st.executeQuery("SELECT * FROM User WHERE id='" + id +"'");
    		System.out.println("SELECT * FROM User WHERE id='" + id + "'");
    		if (!result.next()) {
    			System.out.println("return true");
    			return true;
    		}
    		
		} catch (SQLException e) {
			System.out.println("createStatement problem: ");
			e.printStackTrace();
		}
    	System.out.println("return false");
    	return false;
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
