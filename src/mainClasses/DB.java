package mainClasses;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


import javax.swing.JLabel;

import myPlayList.MyPlayListPanel;

public class DB {
	private Connection con = null;
	private static DB db = new DB();

	private String[] artist_ids = new String[20];
	private String[] artist_names = new String[20];
	public static String currentID;

	private DB() {        	

        String url = "jdbc:mysql://172.17.192.58/DBengers?serverTimezone=UTC";
        
        try {
			con = DriverManager.getConnection(url, "pjh", "thisgood");
		} catch (SQLException e) {
			System.out.println("connection problem: ");
			e.printStackTrace();
		}
    }
	
	public static DB getInstance() {return db;}
	
	public void insertUserList(Object [] infos) {
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO User VALUES(?, ?, ?,now(), ?, ?, ?, ?, ?, ?, null, false, false, ?, ?, null, ?)";
		
    	System.out.println("insertUserList entered!!");
    	
    	try {
    		pstmt = con.prepareStatement(sql);
    		for (int i = 0; i < infos.length; i++) {
    			
    			if (i == 4) {
    				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    				Calendar c = Calendar.getInstance();
    				try{
    				   c.setTime(sdf.parse((String)infos[i]));
    				}catch(ParseException e){e.printStackTrace();}
    				
    				c.add(Calendar.DAY_OF_MONTH, 1);  
    				String newDate = sdf.format(c.getTime());  
    				pstmt.setDate(i + 1, Date.valueOf(newDate));
    			}
    				
    			else if(infos[i] instanceof Boolean) {
    				pstmt.setBoolean(i + 1, (boolean) infos[i]);
    			}
    			else
    				pstmt.setString(i + 1, (String)infos[i]);
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
	
	public void changeUserInfo(Object[] infos) {
		PreparedStatement pstmt = null;
		String sql = "UPDATE User SET name=?, password=?, nickname=?, address=?, profile_photo=?, "
				+ "email=?, phone_num=?, alarm_to_mail=?, alarm_to_sms=? where id='" + (String)infos[0] + "'";
		
    	System.out.println("changeUserInfo entered!!");
    	System.out.println(sql);
    	
    	try {
    		pstmt = con.prepareStatement(sql);
    		
    		for (int i = 1; i < infos.length; i++) {
    			
    			if(infos[i] instanceof Boolean) {
    				pstmt.setBoolean(i, (boolean) infos[i]);
    			}
    			else
    				pstmt.setString(i, (String) infos[i]);
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
    		//System.out.println("SELECT * FROM User WHERE id='"+ id +"' AND password='" + pw + "'");
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

    		if (!result.next()) {
    			return true;
    		}
    		
		} catch (SQLException e) {
			System.out.println("createStatement problem: ");
			e.printStackTrace();
		}
    	return false;
	}
	
	public ArrayList<String> getMusicInfoByGenre(String genre){
		Statement st = null;
		ResultSet result = null;
		
		Statement stTemp1 = null;
		ResultSet rsTemp1 = null;
		
		Statement stTemp2 = null;
		ResultSet rsTemp2 = null;
		
		
		String sql = "SELECT music_id, name, artist_id, album_id"
				+ " FROM Music WHERE genre='" + genre + "'";
		
		ArrayList<String> infos = new ArrayList<String>();
    	
    	try {
    		st = con.createStatement();
    		stTemp1 = con.createStatement();
    		stTemp2 = con.createStatement();
    		
    		result = st.executeQuery(sql);
    		
    		
    		String artist_id;
    		int album_id;
    		
    		while (result.next()) {
    			
    			if (infos.size() > 80)
    				return infos;
    			
    			infos.add(String.valueOf(result.getInt("music_id")));
    			
    			infos.add(result.getString("name"));
    			artist_id = result.getString("artist_id");
    			album_id = result.getInt("album_id");
    			
    			
    			rsTemp1 = stTemp1.executeQuery("SELECT name FROM Artist WHERE id='" + artist_id + "'");
    	    	while (rsTemp1.next()) {
    	    		infos.add(rsTemp1.getString("name"));
    	    	}
    	    	
    			
    			rsTemp2 = stTemp2.executeQuery("SELECT title FROM Album WHERE id=" + album_id);
    			while (rsTemp2.next()) {
    				infos.add(rsTemp2.getString("title"));
    			}
    		}
    		
		} catch (SQLException e) {
			System.out.println("createStatement problem: ");
			e.printStackTrace();
		}
    	
    	return infos;
	}
	
	public ArrayList<String> getMusicInfoByRank(String sortBy){
		Statement st = null;
		ResultSet result = null;
		
		Statement stTemp1 = null;
		ResultSet rsTemp1 = null;
		
		Statement stTemp2 = null;
		ResultSet rsTemp2 = null;
		
		
		String sql = "SELECT music_id, name, artist_id, album_id"
				+ " FROM Music order by ";
		
		if (sortBy.equalsIgnoreCase("All")) 
			sql += "music_id";
		 else if(sortBy.equalsIgnoreCase("Play_num")) 
			sql += "play_num";
		 else if(sortBy.equalsIgnoreCase("Download")) 
			sql += "download_num";
		 else
			sql += "released_date";
		
		sql += " desc";
		
		ArrayList<String> infos = new ArrayList<String>();
    	
    	try {
    		st = con.createStatement();
    		stTemp1 = con.createStatement();
    		stTemp2 = con.createStatement();
    		
    		result = st.executeQuery(sql);
    		
    		
    		String artist_id;
    		int album_id;
    		
    		while (result.next()) {
    			
    			if (infos.size() > 80)
    				return infos;
    			
    			infos.add(String.valueOf(result.getInt("music_id")));
    			infos.add(result.getString("name"));
    			artist_id = result.getString("artist_id");
    			album_id = result.getInt("album_id");
    			
    			
    			rsTemp1 = stTemp1.executeQuery("SELECT name FROM Artist WHERE id='" + artist_id + "'");
    	    	while (rsTemp1.next()) {
    	    		infos.add(rsTemp1.getString("name"));
    	    	}
    	    	
    			
    			rsTemp2 = stTemp2.executeQuery("SELECT title FROM Album WHERE id=" + album_id);
    			while (rsTemp2.next()) {
    				infos.add(rsTemp2.getString("title"));
    			}
    		}
    		
		} catch (SQLException e) {
			System.out.println("createStatement problem: ");
			e.printStackTrace();
		}
    	
    	return infos;
	}
	
	public ArrayList<String> getUserInfo(String id) {
    	Statement st = null;
		ResultSet result = null;
		Statement st2 = null;
		ResultSet result2 = null;
		String sql = "SELECT name, id, password, password_change_date, nickname, birthday, gender, address, email, phone_num,"
				+ "voucher_name, is_artist, alarm_to_mail, alarm_to_sms "
				+ " FROM User WHERE id='"+id+"'"; 
		String sql2 = "SELECT streaming_num, download_num FROM My_Voucher WHERE id='"+id+"'";
		ArrayList<String> infos = new ArrayList<String>();

    	//System.out.println("getUserInfo entered!!");
    	
    	try {
    		
    		st = con.createStatement();
    		st2 = con.createStatement();
			// executeQuery : 쿼리를 실행하고 결과를 ResultSet 객체로 반환한다.
    		result = st.executeQuery(sql);
    		result2 = st2.executeQuery(sql2);
    		
    		while (result.next()) {
    			infos.add(result.getString("name"));
    	    	infos.add(result.getString("id"));
    	    	infos.add(result.getString("password"));
    	    	infos.add(String.valueOf(result.getDate("password_change_date")));
    	    	infos.add(result.getString("nickname"));
    	    	infos.add(String.valueOf(result.getDate("birthday")));
    	    	infos.add(result.getString("gender"));
    	    	infos.add(result.getString("address"));
    	    	infos.add(result.getString("email"));
    	    	infos.add(result.getString("phone_num"));
    	    	infos.add(result.getString("voucher_name"));
    	    	infos.add(String.valueOf(result.getBoolean("is_artist")));
    	    	infos.add(String.valueOf(result.getBoolean("alarm_to_mail")));
    	    	infos.add(String.valueOf(result.getBoolean("alarm_to_sms")));
    	    	
    	    	break;
    		}
    		while (result2.next()) {
    			infos.add(String.valueOf(result2.getInt("streaming_num")));
    			infos.add(String.valueOf(result2.getInt("download_num")));
    			
    			break;
    		}
    	
    		
		} catch (SQLException e) {
			System.out.println("createStatement problem: ");
			e.printStackTrace();
		}
    	
    	return infos;
	}
	
	public ArrayList<String> voucherInfo() {
    	Statement st = null;
		ResultSet result = null;
		String sql = "SELECT * FROM Voucher"; 
		ArrayList<String> voucherinfos = new ArrayList<String>();
		try {
			st = con.createStatement();
			// executeQuery : 쿼리를 실행하고 결과를 ResultSet 객체로 반환한다.
			result = st.executeQuery(sql);
			
			while (result.next()) {
    			voucherinfos.add(result.getString("voucher_name"));
    			voucherinfos.add(result.getString("voucher_price"));
    			voucherinfos.add(result.getString("download_num"));
    			voucherinfos.add(result.getString("streaming_num"));    	    	
    	    }
    		
		} catch (SQLException e) {
			System.out.println("createStatement problem: ");
			e.printStackTrace();
		}
    	
    	return voucherinfos;
	}
	
	public ArrayList<String> getArtistName() {
		Statement st = null;
		ResultSet result = null;
		String sql = "SELECT name FROM Artist"; 
		ArrayList<String> artists = new ArrayList<String>();

    	try {
    		st = con.createStatement();
			// executeQuery : 쿼리를 실행하고 결과를 ResultSet 객체로 반환한다.
    		result = st.executeQuery(sql);
    		while (result.next()) {
    			artists.add(result.getString("name"));
    		}
	    	
		} catch (SQLException e) {
			System.out.println("getPlayListInfo problem: ");
			e.printStackTrace();
		}
    	
    	return artists;
	}
	
	public boolean checkMyPlaylist (String userId, int musicId, String playlistName) {
		Statement st = null;
		ResultSet result = null;
		
		String sql = "SELECT * FROM User_PlayList_Music WHERE user_id='" + userId + "' and name='" + playlistName + "'and music_id=" + musicId;
		System.out.println(sql);
		try {
    		st = con.createStatement();
    		result = st.executeQuery(sql);
    		
    		if (!result.next()) {
    			return true;
    		}

    	} catch (SQLException e) {
			System.out.println("addToMyPlaylist problem: ");
			e.printStackTrace();
		}
		return false;
	}
	
	public void addToMyPlaylist(String userId, int musicId, String playlistName) {
		Statement st = null;
		
		String sql = "INSERT INTO User_PlayList_Music VALUES ('" + userId + "', " + "'" + playlistName + "', " + musicId + ")";
		try {
    		st = con.createStatement();
    		st.executeUpdate(sql);

    	} catch (SQLException e) {
			System.out.println("addToMyPlaylist problem: ");
			e.printStackTrace();
		}
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
		String sql = "INSERT INTO User_PlayList(id, name, num_like, hashtag, play_num) VALUES ('"+id+"', '"+playlistName+"', 0, ' ', 0)"; 
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
			System.out.println("changePlayList problem: ");
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getPlayListMusic(String id, String playlistName) {
		Statement st = null;
		ResultSet result = null;
		// get music_id to search music info later
		String sql = "SELECT music_id FROM User_PlayList_music WHERE user_id='"+id+"' AND name = '"+playlistName+"'";
		ArrayList<Integer> musicIDs = new ArrayList<Integer>();
		ArrayList<String> musics = new ArrayList<String>();
	
		MyPlayListPanel.numOfPlayList = 0;
		try {
			st = con.createStatement();
			// executeQuery : 쿼리를 실행하고 결과를 ResultSet 객체로 반환한다.
			result = st.executeQuery(sql);
			
			int j=0;
			while (result.next()) {
    			musicIDs.add(result.getInt("music_id"));
    			System.out.println("MusicID: "+musicIDs.get(j++));
    			MyPlayListPanel.numOfPlayList++;
    		}
			
			// use music_id to get music name
			for(int i=0; i<musicIDs.size();i++)
			{
				sql = "SELECT name FROM Music WHERE music_id='"+musicIDs.get(i)+"'";
				st = con.createStatement();
				result = st.executeQuery(sql);
				int k=0;
				while (result.next()) {
	    			musics.add(result.getString("name"));
	    			System.out.println("Music name: "+musics.get(k++));
	    		}
			}

		} catch (SQLException e) {
			System.out.println("getPlayListMusic problem: ");
			e.printStackTrace();
		}
    	
    	return musics;
	}

	public ArrayList<String> getPlayListMusicArtist(String id, String playlistName) {
		Statement st = null;
		ResultSet result = null;
		// get music_id to search music info later
		String sql = "SELECT music_id FROM User_PlayList_music WHERE user_id='"+id+"' AND name = '"+playlistName+"'";
		ArrayList<Integer> musicIDs = new ArrayList<Integer>();
		ArrayList<String> artistIDs = new ArrayList<String>();
		ArrayList<String> artists = new ArrayList<String>();
	
		MyPlayListPanel.numOfPlayList = 0;
		try {
			st = con.createStatement();
			// executeQuery : 쿼리를 실행하고 결과를 ResultSet 객체로 반환한다.
			result = st.executeQuery(sql);
			
			while (result.next()) {
    			musicIDs.add(result.getInt("music_id"));
    			MyPlayListPanel.numOfPlayList++;
    		}
			
			// use music_id to get artist_id
			for(int i=0; i<musicIDs.size();i++)
			{
				sql = "SELECT artist_id FROM Music WHERE music_id='"+musicIDs.get(i)+"'";
				st = con.createStatement();
				result = st.executeQuery(sql);
				
				while (result.next()) {
	    			artistIDs.add(result.getString("artist_id"));
	    		}
			}
			
			// use artist_id to get artist name
			for(int i=0; i<artistIDs.size();i++)
			{
				sql = "SELECT name FROM Artist WHERE id='"+artistIDs.get(i)+"'";
				st = con.createStatement();
				result = st.executeQuery(sql);
				
				while (result.next()) {
	    			artists.add(result.getString("name"));
	    		}
			}

		} catch (SQLException e) {
			System.out.println("getPlayListMusicArtist problem: ");
			e.printStackTrace();
		}
    	
    	return artists;
	}
	
	public void addMusicPlaynum(String userID, String musicName) {
		Statement st = null;
		Statement st2= null;
		String sql = "UPDATE Music SET play_num = play_num+1 WHERE name = '"+musicName+"'";
		String sql2 = "UPDATE My_Voucher SET streaming_num = streaming_num-1 WHERE id = '"+userID+"'";
    	try {
    		st = con.createStatement();
    		st2 = con.createStatement();
			// executeQuery : 쿼리를 실행하고 결과를 ResultSet 객체로 반환한다.
    		st.executeUpdate(sql);
    		st2.executeUpdate(sql2);

    	} catch (SQLException e) {
			System.out.println("addMusicPlaynum problem: ");
			e.printStackTrace();
		}
	}
	
	public void addMusicDownloadnum(String userID, String musicName) {
		Statement st = null;
		Statement st2= null;
		String sql = "UPDATE Music SET download_num = download_num+1 WHERE name = '"+musicName+"'";
		String sql2 = "UPDATE My_Voucher SET download_num = download_num-1 WHERE id = '"+userID+"'";
    	try {
    		st = con.createStatement();
    		st2 = con.createStatement();
			// executeQuery : 쿼리를 실행하고 결과를 ResultSet 객체로 반환한다.
    		st.executeUpdate(sql);
    		st2.executeUpdate(sql2);

    	} catch (SQLException e) {
			System.out.println("addMusicDownloadnum problem: ");
			e.printStackTrace();
		}
	}
	
	public void addToHistory(String userid, String musicname) {
		Statement st = null;
		long time = System.currentTimeMillis(); 
		Date now = new Date(time);
		String sql = "insert into Played_Music_History(user_id, name, playing_date) values ('"+userid+"', '"+musicname+"', '"+now+"')"; 
    	try {
    		st = con.createStatement();
			// executeQuery : 쿼리를 실행하고 결과를 ResultSet 객체로 반환한다.
    		st.executeUpdate(sql);

    	} catch (SQLException e) {
			System.out.println("addMusicPlaynum problem: ");
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getArtistInfo(String currentArtistName) {
		Statement st = null;
		ResultSet result = null;
		String sql = "SELECT name, birthday, introduction, debut_date, debut_song, type, gender, agency, nationality, constellation, blood_type, num_stars, fanclub, youtube, facebook, twitter FROM Artist WHERE name = '"+currentArtistName+"'"; 
		ArrayList<String> infos = new ArrayList<String>();
	
		try {
			st = con.createStatement();
			// executeQuery : 쿼리를 실행하고 결과를 ResultSet 객체로 반환한다.
			result = st.executeQuery(sql);
			
			while (result.next()) {
    			infos.add(result.getString("name"));
    			infos.add(result.getString("birthday"));
    			infos.add(result.getString("introduction"));
    			infos.add(result.getString("debut_date"));
    			infos.add(result.getString("debut_song"));
    			infos.add(result.getString("type"));
    			infos.add(result.getString("gender"));
    			infos.add(result.getString("agency"));
    			infos.add(result.getString("nationality"));
    			infos.add(result.getString("constellation"));
    			infos.add(result.getString("blood_type"));
    			infos.add(result.getString("num_stars"));
    			infos.add(result.getString("fanclub"));
    			infos.add(result.getString("youtube"));
    			infos.add(result.getString("facebook"));
    			infos.add(result.getString("twitter"));
    		}
	    	
		} catch (SQLException e) {
			System.out.println("getArtistInfo problem: ");
			e.printStackTrace();
		}
    	
    	return infos;
	}
	
	public String getArtistID(String artistName) {
		Statement st = null;
		ResultSet result = null;
		String sql = "SELECT id FROM Artist WHERE name = '"+artistName+"'"; 
		String info = null;
	
		try {
			st = con.createStatement();
			// executeQuery : 쿼리를 실행하고 결과를 ResultSet 객체로 반환한다.
			result = st.executeQuery(sql);
			
			while (result.next()) {
    			info = result.getString("id");
    		}
	    	
		} catch (SQLException e) {
			System.out.println("getArtistID problem: ");
			e.printStackTrace();
		}
    	
    	return info;
	}
	
	public ArrayList<String> getArtistField(){
		Statement st = null;
		ResultSet result = null;
		String sql = "SELECT column_name FROM information_schema.columns WHERE table_schema = 'DBengers' AND table_name = 'Artist'"; 
		ArrayList<String> infos = new ArrayList<String>();
	
		try {
			st = con.createStatement();
			// executeQuery : 쿼리를 실행하고 결과를 ResultSet 객체로 반환한다.
			result = st.executeQuery(sql);
			
			while (result.next()) {
    			infos.add(result.getString("column_name"));
    		}
	    	
		} catch (SQLException e) {
			System.out.println("getArtistField problem: ");
			e.printStackTrace();
		}
    	
    	return infos;
	}

	public void buy100Voucher(String userid) {
		Statement st = null;
		Statement st2 = null;
		String vouchername = "100 Streaming";
		String sql = "UPDATE User SET voucher_name='"+vouchername+"' WHERE id='"+userid+"'";
		String sql2 = "INSERT INTO My_Voucher (id, download_num, streaming_num) VALUES('"+userid+"', (SELECT download_num from Voucher "
				+ "WHERE voucher_name='"+vouchername+"'), (SELECT streaming_num from Voucher WHERE voucher_name='"+vouchername+"')) ON DUPLICATE KEY UPDATE "
				+ "download_num =(SELECT download_num from Voucher WHERE voucher_name='"+vouchername+"')"
				+ ", streaming_num = (SELECT streaming_num from Voucher WHERE voucher_name='"+vouchername+"')"
				+ "";
    	try {
    		st = con.createStatement();
    		st2 = con.createStatement();
			// executeQuery : 쿼리를 실행하고 결과를 ResultSet 객체로 반환한다.
    		st.executeUpdate(sql);
    		st2.executeUpdate(sql2);
    		
    	} catch (SQLException e) {
			System.out.println("buy Voucher problem: ");
			e.printStackTrace();
		}
	}

	public void buy300Voucher(String userid) {
		Statement st = null;
		Statement st2 = null;
		String vouchername = "300 Streaming";
		String sql = "UPDATE User SET voucher_name='"+vouchername+"' WHERE id='"+userid+"'";
		String sql2 = "INSERT INTO My_Voucher (id, download_num, streaming_num) VALUES('"+userid+"', (SELECT download_num from Voucher "
				+ "WHERE voucher_name='"+vouchername+"'), (SELECT streaming_num from Voucher WHERE voucher_name='"+vouchername+"')) ON DUPLICATE KEY UPDATE "
				+ "download_num =(SELECT download_num from Voucher WHERE voucher_name='"+vouchername+"')"
				+ ", streaming_num = (SELECT streaming_num from Voucher WHERE voucher_name='"+vouchername+"')"
				+ "";
    	try {
    		st = con.createStatement();
    		st2 = con.createStatement();
			// executeQuery : 쿼리를 실행하고 결과를 ResultSet 객체로 반환한다.
    		st.executeUpdate(sql);
    		st2.executeUpdate(sql2);

    	} catch (SQLException e) {
			System.out.println("buy Voucher problem: ");
			e.printStackTrace();
		}
	}
	
	public void buyUnlimitVoucher(String userid) {
		Statement st = null;
		Statement st2 = null;
		String vouchername = "Unlimited Streaming";
		String sql = "UPDATE User SET voucher_name='"+vouchername+"' WHERE id='"+userid+"'";
		String sql2 = "INSERT INTO My_Voucher (id, download_num, streaming_num) VALUES('"+userid+"', (SELECT download_num from Voucher "
				+ "WHERE voucher_name='"+vouchername+"'), (SELECT streaming_num from Voucher WHERE voucher_name='"+vouchername+"')) ON DUPLICATE KEY UPDATE "
				+ "download_num =(SELECT download_num from Voucher WHERE voucher_name='"+vouchername+"')"
				+ ", streaming_num = (SELECT streaming_num from Voucher WHERE voucher_name='"+vouchername+"')"
				+ "";
    	try {
    		st = con.createStatement();
    		st2 = con.createStatement();
			// executeQuery : 쿼리를 실행하고 결과를 ResultSet 객체로 반환한다.
    		st.executeUpdate(sql);
    		st2.executeUpdate(sql2);

    	} catch (SQLException e) {
			System.out.println("buy Voucher problem: ");
			e.printStackTrace();
		}

	}
	
	public ArrayList<String> getArtistMusic(String artistID)
	{
		Statement st = null;
		ResultSet result = null;
		String sql = "SELECT name FROM Music WHERE artist_id='"+artistID+"'"; 
		ArrayList<String> infos = new ArrayList<String>();
		try {
			st = con.createStatement();
			// executeQuery : 쿼리를 실행하고 결과를 ResultSet 객체로 반환한다.
			result = st.executeQuery(sql);
			
			while (result.next()) {
    			infos.add(result.getString("name"));
    		}
	    	
		} catch (SQLException e) {
			System.out.println("getArtistMusic problem: ");
			e.printStackTrace();
		}
    	
    	return infos;
	}
	
	public ArrayList<String> getArtistMusicAlbum(String artistID, ArrayList<String> music)
	{
		Statement st = null;
		ResultSet result = null;
		String sql;
		ArrayList<String> infos;
		ArrayList<String> albumName = new ArrayList<String>();
		// get album_id using artist_id and music's name
		for(int m=0; m<music.size();m++)
		{
			sql = "SELECT album_id FROM Music where artist_id='"+artistID+"' AND name = '"+music.get(m)+"'"; 
			infos = new ArrayList<String>();

			try {
				st = con.createStatement();
				result = st.executeQuery(sql);
				
				while (result.next()) {
	    			infos.add(result.getString("album_id"));
	    		}
				
				// get album name using album_id
				for(int i=0; i<infos.size();i++)
				{
					sql = "SELECT title From Album where id = '"+infos.get(i)+"'";	
					st = con.createStatement();
					result = st.executeQuery(sql);
					
					while (result.next()) {
		    			albumName.add(result.getString("title"));
		    		}
				}
			} catch (SQLException e) {
				System.out.println("getArtistMusicAlbum problem: ");
				e.printStackTrace();
			}
		}
		
    	return albumName;
	}
	
	public ArrayList<String> getArtistAlbum(String artistID)
	{
		Statement st = null;
		ResultSet result = null;
		ArrayList<String> infos = new ArrayList<String>();
		ArrayList<String> albumName = new ArrayList<String>();
		// get artist's album_id using artist_id
		String sql = "SELECT album_id FROM Music where artist_id='"+artistID+"'"; 

		try {
			st = con.createStatement();
			result = st.executeQuery(sql);
			
			while (result.next()) {
    			infos.add(result.getString("album_id"));
    		}
			
			// get album name using album_id
			for(int i=0; i<infos.size();i++)
			{
				sql = "SELECT title From Album where id = '"+infos.get(i)+"'";	
				st = con.createStatement();
				result = st.executeQuery(sql);
				
				while (result.next()) {
	    			albumName.add(result.getString("title"));
	    		}
			}
		} catch (SQLException e) {
			System.out.println("getArtistAlbum problem: ");
			e.printStackTrace();
		}
		
    	return albumName;
	}
	
	public ArrayList<Date> getArtistAlbumDate(String artistID, ArrayList<String> albumName)
	{
		Statement st = null;
		ResultSet result = null;
		String sql = null;
		ArrayList<Date> albumDate = new ArrayList<Date>();
		
		for(int i=0; i<albumName.size();i++)
		{
			sql = "SELECT released_date FROM Album WHERE artist_id='"+artistID+"' AND title='"+albumName.get(i)+"'"; 

			try {
				st = con.createStatement();
				result = st.executeQuery(sql);
				
				while (result.next()) {
	    			albumDate.add(result.getDate("released_date"));
	    		}
				
			} catch (SQLException e) {
				System.out.println("getArtistAlbumDate problem: ");
				e.printStackTrace();
			}
		}
		
		
    	return albumDate;
	}
	
	public ArrayList<Integer> getArtistAlbumLikes(String artistID, ArrayList<String> albumName)
	{
		Statement st = null;
		ResultSet result = null;
		String sql = null;
		ArrayList<Integer> infos = new ArrayList<Integer>();
		// get num_stars from album
		for(int i=0;i<albumName.size();i++)
		{
			sql = "SELECT num_stars FROM Album WHERE artist_id='"+artistID+"' AND title='"+albumName.get(i)+"'"; 

			try {
				st = con.createStatement();
				result = st.executeQuery(sql);
				
				while (result.next()) {
	    			infos.add(result.getInt("num_stars"));
	    		}
				
			} catch (SQLException e) {
				System.out.println("getArtistAlbumLikes problem: ");
				e.printStackTrace();
			}
		}
		
    	return infos;
	}
	
	
	public ArrayList<Integer> getStarPostID(String artistID)
	{
		Statement st = null;
		ResultSet result = null;
		String sql = "SELECT star_post_id FROM Star_Post WHERE user_id='"+artistID+"'"; 
		ArrayList<Integer> starpostIDs = new ArrayList<Integer>();
	
		try {
			st = con.createStatement();
			// executeQuery : 쿼리를 실행하고 결과를 ResultSet 객체로 반환한다.
			result = st.executeQuery(sql);
			
			while (result.next()) {
    			starpostIDs.add(result.getInt("star_post_id"));
    		}
	    	
		} catch (SQLException e) {
			System.out.println("getStarPostID problem: ");
			e.printStackTrace();
		}
    	
    	return starpostIDs;
	}
	
	public ArrayList<Integer> getSearchMusicId(String id, String searchText) {
		Statement st = null;
		ResultSet result = null;
		// get music_id to search music info later
		String sql = "SELECT music_id FROM Music WHERE ("
				+ "name LIKE'%"+searchText+"%' "
				+ ")";
		ArrayList<Integer> musicIDs = new ArrayList<Integer>();
	
		try {
			st = con.createStatement();
			// executeQuery : 쿼리를 실행하고 결과를 ResultSet 객체로 반환한다.
			result = st.executeQuery(sql);
			
			while (result.next()) {
    			musicIDs.add(result.getInt("music_id"));
    			
    		}
		} catch (SQLException e) {
			System.out.println("getPlayListMusic problem: ");
			e.printStackTrace();
		}
		
		return musicIDs;
	}
		
	
	public ArrayList<String> getSearchMusic(String id, String searchText) {
		Statement st = null;
		ResultSet result = null;
		// get music_id to search music info later
		String sql = "SELECT music_id FROM Music WHERE ("
				+ "name LIKE'%"+searchText+"%' "
				+ ")";
		ArrayList<Integer> musicIDs = new ArrayList<Integer>();
		ArrayList<String> musics = new ArrayList<String>();
	
		try {
			st = con.createStatement();
			// executeQuery : 쿼리를 실행하고 결과를 ResultSet 객체로 반환한다.
			result = st.executeQuery(sql);
			
			while (result.next()) {
    			musicIDs.add(result.getInt("music_id"));
    			
    		}
			
			// use music_id to get music name
			for(int i=0; i< musicIDs.size(); i++)
			{
				sql = "SELECT name FROM Music WHERE music_id='" + musicIDs.get(i) + "'";
				st = con.createStatement();
				result = st.executeQuery(sql);
				while (result.next()) {
	    			musics.add(result.getString("name"));
	    		}
			}

		} catch (SQLException e) {
			System.out.println("getPlayListMusic problem: ");
			e.printStackTrace();
		}
    	
    	return musics;
	}

	
	public ArrayList<String> getStarPostTitle(ArrayList<Integer> starpostID)
	{
		Statement st = null;
		ResultSet result = null;
		String sql = null;
		ArrayList<String> infos = new ArrayList<String>();
		
		for(int i=0; i<starpostID.size(); i++)
		{
			sql = "SELECT title FROM Star_Post WHERE star_post_id='"+starpostID.get(i)+"'"; 
		
			try {
				st = con.createStatement();
				// executeQuery : 쿼리를 실행하고 결과를 ResultSet 객체로 반환한다.
				result = st.executeQuery(sql);
				
				while (result.next()) {
	    			infos.add(result.getString("title"));
	    		}
		    	
			} catch (SQLException e) {
				System.out.println("getStarPostTitle problem: ");
				e.printStackTrace();
			}
		}
    	
    	return infos;
	}
	
	public ArrayList<Date> getStarPostDate(ArrayList<Integer> starpostID)
	{
		Statement st = null;
		ResultSet result = null;
		String sql = null;
		ArrayList<Date> infos = new ArrayList<Date>();
		
		for(int i=0;i<starpostID.size();i++)
		{
			sql = "SELECT date FROM Star_Post WHERE star_post_id='"+starpostID.get(i)+"'"; 
			
			try {
				st = con.createStatement();
				// executeQuery : 쿼리를 실행하고 결과를 ResultSet 객체로 반환한다.
				result = st.executeQuery(sql);
				
				while (result.next()) {
	    			infos.add(result.getDate("date"));
	    		}
		    	
			} catch (SQLException e) {
				System.out.println("getStarPostDate problem: ");
				e.printStackTrace();
			}
		}
		
    	return infos;
	}
	
	public ArrayList<Integer> getStarPostLike(ArrayList<Integer> starpostID)
	{
		Statement st = null;
		ResultSet result = null;
		String sql = null;
		ArrayList<Integer> infos = new ArrayList<Integer>();
		
		for(int i=0;i<starpostID.size();i++)
		{
			sql = "SELECT like_num FROM Star_Post WHERE star_post_id='"+starpostID.get(i)+"'"; 
			
			try {
				st = con.createStatement();
				// executeQuery : 쿼리를 실행하고 결과를 ResultSet 객체로 반환한다.
				result = st.executeQuery(sql);
				
				while (result.next()) {
	    			infos.add(result.getInt("like_num"));
	    		}
		    	
			} catch (SQLException e) {
				System.out.println("getStarPostLike problem: ");
				e.printStackTrace();
			}
		}
    	
    	return infos;
	}
	
	public ArrayList<Integer> getStarPostView(ArrayList<Integer> starpostID)
	{
		Statement st = null;
		ResultSet result = null;
		String sql = null;
		ArrayList<Integer> infos = new ArrayList<Integer>();
		
		for(int i=0;i<starpostID.size();i++)
		{
			sql = "SELECT view_num FROM Star_Post WHERE star_post_id='"+starpostID.get(i)+"'"; 
			
			try {
				st = con.createStatement();
				// executeQuery : 쿼리를 실행하고 결과를 ResultSet 객체로 반환한다.
				result = st.executeQuery(sql);
				
				while (result.next()) {
	    			infos.add(result.getInt("view_num"));
	    		}
		    	
			} catch (SQLException e) {
				System.out.println("getStarPostView problem: ");
				e.printStackTrace();
			}
		}
		
    	
    	return infos;
	}
	
	public ArrayList<String> getStarPostDescript(ArrayList<Integer> starpostID)
	{
		Statement st = null;
		ResultSet result = null;
		String sql = null;
		ArrayList<String> infos = new ArrayList<String>();
		
		for(int i=0; i<starpostID.size();i++)
		{
			sql = "SELECT description FROM Star_Post WHERE star_post_id='"+starpostID.get(i)+"'"; 
			
			try {
				st = con.createStatement();
				// executeQuery : 쿼리를 실행하고 결과를 ResultSet 객체로 반환한다.
				result = st.executeQuery(sql);
				
				while (result.next()) {
	    			infos.add(result.getString("description"));
	    		}
		    	
			} catch (SQLException e) {
				System.out.println("getStarPostDescript problem: ");
				e.printStackTrace();
			}
		}
    	
    	return infos;
	}
	public ArrayList<String> getSearchMusicArtist(String id, String searchText) {
		Statement st = null;
		ResultSet result = null;
		// get music_id to search music info later
		String sql = "SELECT music_id FROM Music WHERE ("
				+ "name LIKE'%"+searchText+"%' "
				+ ")";
		ArrayList<Integer> musicIDs = new ArrayList<Integer>();
		ArrayList<String> musics = new ArrayList<String>();
		ArrayList<String> artistIDs = new ArrayList<String>();
		ArrayList<String> artists = new ArrayList<String>();
	
		try {
			st = con.createStatement();
			// executeQuery : 쿼리를 실행하고 결과를 ResultSet 객체로 반환한다.
			result = st.executeQuery(sql);
			
			while (result.next()) {
				musicIDs.add(result.getInt("music_id"));
    		}
			
			// use music_id to get artist_id
			for(int i=0; i<musicIDs.size();i++)
			{
				sql = "SELECT artist_id FROM Music WHERE music_id='"+musicIDs.get(i)+"'";
				st = con.createStatement();
				result = st.executeQuery(sql);
				
				while (result.next()) {
	    			artistIDs.add(result.getString("artist_id"));
	    		}
			}
			
			// use artist_id to get artist name
			for(int i=0; i<artistIDs.size();i++)
			{
				sql = "SELECT name FROM Artist WHERE id='"+artistIDs.get(i)+"'";
				st = con.createStatement();
				result = st.executeQuery(sql);
				
				while (result.next()) {
	    			artists.add(result.getString("name"));
	    		}
			}

		} catch (SQLException e) {
			System.out.println("getPlayListMusicArtist problem: ");
			e.printStackTrace();
		}
    	
    	return artists;
	}
	
	
	public ArrayList<Integer> getCommentID(String artistID)
	{
		Statement st = null;
		ResultSet result = null;
		String sql = "SELECT artist_comment_id FROM Artist_Comment_List WHERE artist_id='"+artistID+"'"; 
		ArrayList<Integer> commentIDs = new ArrayList<Integer>();
	
		try {
			st = con.createStatement();
			// executeQuery : 쿼리를 실행하고 결과를 ResultSet 객체로 반환한다.
			result = st.executeQuery(sql);
			
			while (result.next()) {
    			commentIDs.add(result.getInt("artist_comment_id"));
    		}
	    	
		} catch (SQLException e) {
			System.out.println("getCommentID problem: ");
			e.printStackTrace();
		}
    	
    	return commentIDs;
	}	
	public ArrayList<String> getCommentWriter(ArrayList<Integer> commentID)
	{
		Statement st = null;
		ResultSet result = null;
		String sql = null;
		ArrayList<String> infos = new ArrayList<String>();
		
		for(int i=0; i<commentID.size();i++)
		{
			sql = "SELECT user_id FROM Artist_Comment_List WHERE artist_comment_id='"+commentID.get(i)+"'"; 
			
			try {
				st = con.createStatement();
				// executeQuery : 쿼리를 실행하고 결과를 ResultSet 객체로 반환한다.
				result = st.executeQuery(sql);
				
				while (result.next()) {
	    			infos.add(result.getString("user_id"));
	    		}
		    	
			} catch (SQLException e) {
				System.out.println("getCommentWriter problem: ");
				e.printStackTrace();
			}
		}
    	
    	return infos;
	}
	
	public ArrayList<Date> getCommentDate(ArrayList<Integer> commentID)
	{
		Statement st = null;
		ResultSet result = null;
		String sql = null;
		ArrayList<Date> infos = new ArrayList<Date>();
		
		for(int i=0; i<commentID.size();i++)
		{
			sql = "SELECT comment_date FROM Artist_Comment_List WHERE artist_comment_id='"+commentID.get(i)+"'"; 
			
			try {
				st = con.createStatement();
				// executeQuery : 쿼리를 실행하고 결과를 ResultSet 객체로 반환한다.
				result = st.executeQuery(sql);
				
				while (result.next()) {
	    			infos.add(result.getDate("comment_date"));
	    		}
		    	
			} catch (SQLException e) {
				System.out.println("getCommentDate problem: ");
				e.printStackTrace();
			}
		}
    	
    	return infos;
	}
	
	public ArrayList<Integer> getCommentLike(ArrayList<Integer> commentID)
	{
		Statement st = null;
		ResultSet result = null;
		String sql = null;
		ArrayList<Integer> infos = new ArrayList<Integer>();
		
		for(int i=0; i<commentID.size();i++)
		{
			sql = "SELECT num_like FROM Artist_Comment_List WHERE artist_comment_id='"+commentID.get(i)+"'"; 
			
			try {
				st = con.createStatement();
				// executeQuery : 쿼리를 실행하고 결과를 ResultSet 객체로 반환한다.
				result = st.executeQuery(sql);
				
				while (result.next()) {
	    			infos.add(result.getInt("num_like"));
	    		}
		    	
			} catch (SQLException e) {
				System.out.println("getCommentLike problem: ");
				e.printStackTrace();
			}
		}
    	
    	return infos;
	}
	
	public ArrayList<Integer> getCommentDislike(ArrayList<Integer> commentID)
	{
		Statement st = null;
		ResultSet result = null;
		String sql = null;
		ArrayList<Integer> infos = new ArrayList<Integer>();
		
		for(int i=0; i<commentID.size();i++)
		{
			sql = "SELECT num_dislike FROM Artist_Comment_List WHERE artist_comment_id='"+commentID.get(i)+"'"; 
			
			try {
				st = con.createStatement();
				// executeQuery : 쿼리를 실행하고 결과를 ResultSet 객체로 반환한다.
				result = st.executeQuery(sql);
				
				while (result.next()) {
	    			infos.add(result.getInt("num_dislike"));
	    		}
		    	
			} catch (SQLException e) {
				System.out.println("getCommentDislike problem: ");
				e.printStackTrace();
			}
		}
    	
    	return infos;
	}
	
	public ArrayList<String> getCommentContent(ArrayList<Integer> commentID)
	{
		Statement st = null;
		ResultSet result = null;
		String sql = null;
		ArrayList<String> infos = new ArrayList<String>();
		
		for(int i=0; i<commentID.size();i++)
		{
			sql = "SELECT comment FROM Artist_Comment_List WHERE artist_comment_id='"+commentID.get(i)+"'"; 
			
			try {
				st = con.createStatement();
				// executeQuery : 쿼리를 실행하고 결과를 ResultSet 객체로 반환한다.
				result = st.executeQuery(sql);
				while (result.next()) {
	    			infos.add(result.getString("comment"));
	    		}
		    	
			} catch (SQLException e) {
				System.out.println("getCommentContent problem: ");
				e.printStackTrace();
			}
		}
    	
    	return infos;
	}
	
	
	public void sendComment(int commentNum, String artistID, String userID, String comment)
	{
		Statement st = null;
		String sql = "INSERT INTO Artist_Comment_List (artist_comment_id,artist_id,user_id,comment,num_like,num_dislike)"
				+ " VALUES ("+(commentNum+1)+",'"+artistID+"','"+userID+"','"+comment+"',0,0)"; 

		try {
			st = con.createStatement();
			st.executeUpdate(sql);
	    	
		} catch (SQLException e) {
			System.out.println("sendComment problem: ");
			e.printStackTrace();
		}
	}
	
	public int countComment(String artistID)
	{
		Statement st = null;
		ResultSet result = null;
		int count =0;
		String sql = "SELECT * FROM Artist_Comment_List WHERE artist_id='"+artistID+"'"; 
	
		try {
			st = con.createStatement();
			// executeQuery : 쿼리를 실행하고 결과를 ResultSet 객체로 반환한다.
			result = st.executeQuery(sql);
			
			while (result.next()) {count++;}
	    	
		} catch (SQLException e) {
			System.out.println("getCommentID problem: ");
			e.printStackTrace();
		}
    	
    	return count;
	}
	
	
	public void addStarpostView(int starpostID)
	{
		Statement st = null;
		String sql = "UPDATE Star_Post SET view_num = view_num+1 WHERE star_post_id = '"+starpostID+"'";

		try {
			st = con.createStatement();
			st.executeUpdate(sql);
	    	
		} catch (SQLException e) {
			System.out.println("addStarpostView problem: ");
			e.printStackTrace();
		}
	}
	
	public void addVideoHistory(String userID, int starpostID)
	{
		Statement st = null;
		String sql = "INSERT INTO Played_Video_History VALUES ('"+userID+"',"+starpostID+",'2019-05-19')";

		try {
			st = con.createStatement();
			st.executeUpdate(sql);
	    	
		} catch (SQLException e) {
			System.out.println("addVideoHistory problem: ");
			e.printStackTrace();
		}
	}
	
	public void addHashTag_Hashtag(String userID, String playlist, ArrayList<String> hashtags)
	{
		Statement st = null;
		String sql = null;
		
		for(int i=0; i<hashtags.size(); i++)
		{
			sql = "INSERT INTO Hashtag VALUES ('"+hashtags.get(i)+"','"+playlist+"','"+userID+"')";

			try {
				st = con.createStatement();
				st.executeUpdate(sql);
		    	
			} catch (SQLException e) {
				System.out.println("addHashTag_Hashtag problem: ");
				e.printStackTrace();
			}
		}
		
	}
	
	public void addHashTag_HashtagNames(ArrayList<String> hashtags)
	{
		Statement st = null;
		String sql = null;
		String sql2 = null;
		// first insert new hash-tags
		for(int i=0;i<hashtags.size();i++)
		{
			sql = "INSERT INTO HashtagNames VALUES ('"+hashtags.get(i)+"',0)";
			sql2 = "UPDATE HashtagNames SET cnt = cnt+1 WHERE tagname = '"+hashtags.get(i)+"'";
			try {
				st = con.createStatement();
				st.executeUpdate(sql);
				st.executeUpdate(sql2);
		    	
			} catch (SQLException e) {
				System.out.println("addHashTag_HashtagNames insert problem: ");
				try {
					st = con.createStatement();
					st.executeUpdate(sql2);
			    	
				} catch (SQLException eq) {
					System.out.println("addHashTag_HashtagNames add problem: ");
				}
			}
		}
	}
	
	public ArrayList<String> deleteHashTag_Hashtag(String userID, String playlistName)
	{
		Statement st = null;
		ResultSet result = null;
		ArrayList<String> hashtags = new ArrayList<String>();
		String sql = "DELETE FROM Hashtag WHERE playlist_name='"+playlistName+"' AND user_id='"+userID+"'";
		String sql1 = "SELECT tagname FROM Hashtag WHERE playlist_name='"+playlistName+"' AND user_id='"+userID+"'";

		try {
			st = con.createStatement();
			
			result = st.executeQuery(sql1);
			while(result.next())
				hashtags.add(result.getString("tagname"));
			
			st.executeUpdate(sql);
	    	
		} catch (SQLException e) {
			System.out.println("deleteHashTag_Hashtag problem: ");
			e.printStackTrace();
		}
		
		return hashtags;
	}
	
	public void deleteHashTag_HashtagNames(ArrayList<String> hashtags)
	{
		Statement st = null;
		String sql = null;
		String sql1 = null;
		String sql2 = null;
		ResultSet result = null;
		for(int i=0;i<hashtags.size();i++)
		{
			sql = "SELECT cnt FROM HashtagNames WHERE tagname ='"+hashtags.get(i)+"'";
			sql1 = "DELETE FROM HashtagNames WHERE tagname ='"+hashtags.get(i)+"'";
			sql2 = "UPDATE HashtagNames SET cnt = cnt-1 WHERE tagname = '"+hashtags.get(i)+"'";
			try {
				st = con.createStatement();
				result = st.executeQuery(sql);
				int temp=0;
				while(result.next())
					temp = result.getInt("cnt");
				if(temp ==1)
					st.executeUpdate(sql1);
				else
					st.executeUpdate(sql2);
		    	
			} catch (SQLException e) {
				System.out.println("deleteHashTag_HashtagNames problem: ");
			}
		}
	}
	
	public ArrayList<String> getTopHashtag()
	{
		ArrayList<String> tags = new ArrayList<String>();
		Statement st = null;
		String sql = "SELECT tagname FROM HashtagNames ORDER BY cnt DESC LIMIT 6";
		ResultSet result = null;
		try {
			st = con.createStatement();
			result = st.executeQuery(sql);
			while(result.next())
				tags.add(result.getString("tagname"));
	    	
		} catch (SQLException e) {
			System.out.println("addHashTag_Hashtag problem: ");
			e.printStackTrace();
		}

		return tags;
	}
	
	public ArrayList<String> getPlaylistNameByHashtag(String input)
	{
		ArrayList<String> names = new ArrayList<String>();
		Statement st = null;
		String sql = "SELECT playlist_name FROM Hashtag WHERE tagname='"+input+"'";
		ResultSet result = null;
		try {
			st = con.createStatement();
			result = st.executeQuery(sql);
			while(result.next())
				names.add(result.getString("playlist_name"));
	    	
		} catch (SQLException e) {
			System.out.println("getPlaylistNameByHashtag problem: ");
			e.printStackTrace();
		}
		
		return names;
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
