package mainClasses;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Random;

import myPlayList.MyPlayListPanel;

public class DB {
	private Connection con = null;
	private static DB db = new DB();
	private String[] artist_ids = new String[20];
	private String[] artist_names = new String[20];
	public static String currentID;

	private DB() {        	
        String url = "jdbc:mysql://119.202.40.103/DBengers?serverTimezone=UTC";
        
        try {
			con = DriverManager.getConnection(url, "pjh", "thisgood");
		} catch (SQLException e) {
			System.out.println("connection problem: ");
			e.printStackTrace();
		}
    }
	
	public static DB getInstance() {return db;}
	
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
	
	
	public void insertArtistList(String [] infos) {
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO Artist VALUES(";
		for (int i = 0; i < infos.length; i++) {
			if (i == infos.length - 1)
				sql += "?)";
			else
				sql += "?, ";
		}
    	
		    	
    	try {
    		pstmt = con.prepareStatement(sql);
    		for (int i = 0; i < infos.length; i++) {
    			if (i == 2 || i == 4) {
    				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    				Calendar c = Calendar.getInstance();
    				try{
    				   c.setTime(sdf.parse(infos[i]));
    				}catch(ParseException e){e.printStackTrace();}
    				
    				c.add(Calendar.DAY_OF_MONTH, 1);  
    				String newDate = sdf.format(c.getTime());  
    				pstmt.setDate(i + 1, Date.valueOf(newDate));
    			}
    				
    			else if (i == 12)
    				pstmt.setInt(i + 1, Integer.parseInt(infos[i]));
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
		
    	try {
			st = con.createStatement();
			// executeQuery : 쿼리를 실행하고 결과를 ResultSet 객체로 반환한다.
    		result = st.executeQuery("SELECT * FROM User WHERE id='"+ id +"' AND password='" + pw + "'");
    		System.out.println("SELECT * FROM User WHERE id='"+ id +"' AND password='" + pw + "'");
    		if (!result.next()) {
    			return false;
    		}
    		currentID = id;

		} catch (SQLException e) {
			System.out.println("createStatement problem: ");
			e.printStackTrace();
		}
    	return true;
	}
	
	public boolean checkId(String id) {
		Statement st = null;
		ResultSet result = null;

    	try {
			st = con.createStatement();
			// executeQuery : 쿼리를 실행하고 결과를 ResultSet 객체로 반환한다.
    		result = st.executeQuery("SELECT * FROM User WHERE id='" + id +"'");
    		System.out.println("SELECT * FROM User WHERE id='" + id + "'");
    		if (!result.next()) {
    			return true;
    		}
    		
		} catch (SQLException e) {
			System.out.println("createStatement problem: ");
			e.printStackTrace();
		}
    	return false;
	}
	
	
	public ArrayList<String> getUserInfo(String id) {
    	Statement st = null;
		ResultSet result = null;
		String sql = "SELECT name, id, password, password_change_date, nickname, birthday, gender, address, profile_photo, email, phone_num,"
				+ "voucher_name, is_artist, alarm_to_mail, alarm_to_sms "
				+ " FROM User WHERE id='"+id+"'"; 
		ArrayList<String> infos = new ArrayList<String>();

    	System.out.println("getUserInfo entered!!");
    	
    	try {
    		st = con.createStatement();
			// executeQuery : 쿼리를 실행하고 결과를 ResultSet 객체로 반환한다.
    		result = st.executeQuery(sql);
    		
    		while (result.next()) {
    			infos.add(result.getString("name"));
    	    	infos.add(result.getString("id"));
    	    	infos.add(result.getString("password"));
    	    	infos.add(String.valueOf(result.getDate("password_change_date")));
    	    	infos.add(result.getString("nickname"));
    	    	infos.add(String.valueOf(result.getDate("birthday")));
    	    	infos.add(result.getString("gender"));
    	    	infos.add(result.getString("address"));
    	    	infos.add(result.getString("profile_photo"));
    	    	infos.add(result.getString("email"));
    	    	infos.add(result.getString("phone_num"));
    	    	infos.add(result.getString("voucher_name"));
    	    	infos.add(String.valueOf(result.getBoolean("is_artist")));
    	    	infos.add(String.valueOf(result.getBoolean("alarm_to_mail")));
    	    	infos.add(String.valueOf(result.getBoolean("alarm_to_sms")));
    		}
	    	
    	
    		
		} catch (SQLException e) {
			System.out.println("createStatement problem: ");
			e.printStackTrace();
		}
    	
    	return infos;
	}
	
	public ArrayList<String> getPlayListInfo(String id) {
		Statement st = null;
		ResultSet result = null;
		String sql = "SELECT name FROM User_PlayList WHERE id='"+id+"'"; 
		ArrayList<String> infos = new ArrayList<String>();

    	MyPlayListPanel.numOfPlayList = 0;
    	try {
    		st = con.createStatement();
			// executeQuery : 쿼리를 실행하고 결과를 ResultSet 객체로 반환한다.
    		result = st.executeQuery(sql);
    		
    		while (result.next()) {
    			infos.add(result.getString("name"));
    			MyPlayListPanel.numOfPlayList++;
    		}
	    	
		} catch (SQLException e) {
			System.out.println("getPlayListInfo problem: ");
			e.printStackTrace();
		}
    	
    	return infos;
	}
	
	public void deletePlayList(String id, String playlistName) {
		Statement st = null;
		String sql = "DELETE FROM User_PlayList WHERE id='"+id+"' AND name='"+playlistName+"'"; 
    	try {
    		st = con.createStatement();
			// executeQuery : 쿼리를 실행하고 결과를 ResultSet 객체로 반환한다.
    		st.executeUpdate(sql);

    	} catch (SQLException e) {
			System.out.println("deletePlayList problem: ");
			e.printStackTrace();
		}
	}
	
	public void addPlayList(String id, String playlistName) {
		Statement st = null;
		String sql = "INSERT INTO User_PlayList VALUES ('"+id+"', '"+playlistName+"', 0, ' ')"; 
    	try {
    		st = con.createStatement();
			// executeQuery : 쿼리를 실행하고 결과를 ResultSet 객체로 반환한다.
    		st.executeUpdate(sql);

    	} catch (SQLException e) {
			System.out.println("addPlayList problem: ");
			e.printStackTrace();
		}
	}
	
	public void addHashtag(String id, String playlistName, String hashtags) {
		Statement st = null;
		String sql = "UPDATE User_PlayList SET hashtag = '"+ hashtags +"' WHERE id = '"+id+"' AND name = '"+playlistName+"'"; 
    	try {
    		st = con.createStatement();
			// executeQuery : 쿼리를 실행하고 결과를 ResultSet 객체로 반환한다.
    		st.executeUpdate(sql);

    	} catch (SQLException e) {
			System.out.println("addPlayList problem: ");
			e.printStackTrace();
		}
	}
	
	public void changePlayListName(String id, String playlistName, String newName) {
		Statement st = null;
		String sql = "UPDATE User_PlayList SET name = '"+newName+"' WHERE id = '"+id+"' AND name = '"+playlistName+"'"; 
    	try {
    		st = con.createStatement();
			// executeQuery : 쿼리를 실행하고 결과를 ResultSet 객체로 반환한다.
    		st.executeUpdate(sql);

    	} catch (SQLException e) {
			System.out.println("addPlayList problem: ");
			e.printStackTrace();
		}
	}
	
	
	public void closeConnection() {
		try {
            if(con != null && !con.isClosed())
                con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}
