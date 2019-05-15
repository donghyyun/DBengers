package mainClasses;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Random;

public class DB {
	private Connection con = null;
	private static DB db = new DB();
	private String[] artist_ids = new String[20];
	private String[] artist_names = new String[20];

	private DB() {        	
        String url = "jdbc:mysql://172.17.223.163/DBengers?serverTimezone=UTC";
        
        try {
			con = DriverManager.getConnection(url, "kdh", "thisgood");
		} catch (SQLException e) {
			System.out.println("connection problem: ");
			e.printStackTrace();
		}
    }
	
	public static DB getInstance() {return db;}
	
	private static String getRandomPhoneNum()
	{
		Random rand = new Random();
		int mid = rand.nextInt(9000)+1000;
		int end = rand.nextInt(9000)+1000;
		String phoneNum = "010-"+Integer.toString(mid)+"-"+Integer.toString(end);
		return phoneNum;
	}
	
	private static Date addDate(Date date, int num)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, num/5 + 20);
		
		DateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
		String tempDate = sdFormat.format(new Date(cal.getTimeInMillis()));
		
		
		return new Date(cal.getTimeInMillis());
	}
	
	private static Date getRandomDate()
	{
		Random random = new Random();
		int minDay = (int) LocalDate.of(1900, 1, 1).toEpochDay();
		int maxDay = (int) LocalDate.of(2019, 5, 1).toEpochDay();
		long randomDay = minDay + random.nextInt(maxDay - minDay);

		LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);

		return Date.valueOf(randomBirthDate);
	}
	
	
	private static String getRandomString(int length)
	{
	  StringBuffer buffer = new StringBuffer();
	  Random random = new Random();
	 
	  char chars[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	 
	  for (int i=0 ; i<length ; i++)
	  {
	    buffer.append(chars[random.nextInt(chars.length)]);
	  }
	  return buffer.toString();
	}
	public void StarPostgenerator() {
		PreparedStatement pstmt;
		String tableName = "Star_Post ";
		String sql = "INSERT INTO " + tableName + "(user_id, artist_name, star_post_id, title, description, photo, date, like_num, view_num, video) VALUES " + "(?,?,?,?,?,?,?,?,?,?)";
		for (int i = 1; i <= 20; i++) {
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, artist_ids[i-1]);	// user_id (artist)
				pstmt.setString(2, artist_names[i-1]);	// artist_name
				pstmt.setInt(3, i);	// star_post_id
				pstmt.setString(4, "title: " + getRandomString(4));	// title
				pstmt.setString(5, "desc : " + getRandomString(5));	// description
				if (i%2 == 0) {
					pstmt.setString(6, "photo : " + getRandomString(4));	// photo
					pstmt.setString(10, "null");	// video
				} else {
					pstmt.setString(10, "video : " + getRandomString(4));	// video
					pstmt.setString(6, "null");	// photo
				}
				pstmt.setDate(7, getRandomDate());	// date
				pstmt.setInt(8, 0);	// like_num
				pstmt.setInt(9, 0);	// view_num (only for video)
				
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void Musicgenerator() {
		PreparedStatement pstmt;
		String tableName = "Music ";
		String sql = "INSERT INTO " + tableName + "(music_id, artist_id, album_id, name, released_date, genre, lyrics, hashtag, like_num, play_num) VALUES " + "(?,?,?,?,?,?,?,?,?,?)";
		
		for (int i = 1; i <= 20; i++) {
			try {
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, i);	// music id
				pstmt.setString(2, artist_ids[i-1]);	// artist id (which is user id of artist)
				pstmt.setInt(3, i);	// album id
				pstmt.setString(4, "music"+i);	// music name
				pstmt.setDate(5, getRandomDate());	// released date
				if (i%2 == 0) {
					pstmt.setString(6, "Hiphop");
				}
				else if (i%5 == 0) {
					pstmt.setString(6, "Balad");
				}
				else if (i%7 == 0) {
					pstmt.setString(6, "R&B");
				}
				else if (i%9 == 0) {
					pstmt.setString(6, "Pop");
				}
				else {
					pstmt.setString(6, "Classic");
				}
				pstmt.setString(7, "lyric"+i+" "+getRandomString(10));	// lyrics
				pstmt.setString(8, "#"+getRandomString(4));	// hash tag
				pstmt.setInt(9, 0);	// like_num
				pstmt.setInt(10, 0);	// play_num
				
//				System.out.println(pstmt);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public void Usergenerator() {
		PreparedStatement pstmt;
		PreparedStatement pstmt2;
		String tableName = "User ";
		String tableName2 = "Artist ";
		String sql = "INSERT INTO " + tableName + "(name, id, password, password_change_date, nickname, birthday, gender, address, profile_photo, email, phone_num, voucher_name, is_artist, is_block, alarm_to_mail, alarm_to_sms, liked_artist) VALUES " + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String sql2 = "INSERT INTO " + tableName2 + "(id, name, birthday, introduction, debut_date, debut_song, type, gender, agency, nationality, constellation, blood_type, num_stars, fanclub, youtube, facebook, twitter) VALUES " + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";		
		int j = 0;
		for (int i = 1; i <= 100; i++) {
			try {
				
				pstmt = con.prepareStatement(sql);
				String name = "name"+getRandomString(4);
				String id = "id"+getRandomString(4);
				Date bday = getRandomDate();
				
				pstmt.setString(1, name);	// name
				pstmt.setString(2, id);	// id
				pstmt.setString(3, getRandomString(6));	// password
				
				pstmt.setDate(4, getRandomDate());	// password_change_date
				
				pstmt.setString(5, "n"+getRandomString(7));	// nickname
				
				pstmt.setDate(6, bday);	// birthday
				
				if (i%2 == 0) {
					// 2의 배수면 M
					pstmt.setString(7, "M");	// gender
				} else {
					// else, F
					pstmt.setString(7, "F");	// gender
				}
				pstmt.setString(8, getRandomString(10));	// address
				pstmt.setString(9, getRandomString(10));	// profile_photo
				pstmt.setString(10, name + "@gmail.com");	// email
				
				
				pstmt.setString(11, getRandomPhoneNum());	// phone_num
				
				if (i%2 == 0) {
					pstmt.setString(12, "Unlimited Streaming");	// voucher_name
				}
				else if (i%3 == 0) {
					pstmt.setString(12, "300 Streaming");	// voucher_name
				}
				else {
					pstmt.setString(12, "100 Streaming");	// voucher_name
				}
				pstmt.setInt(14, (int) 0);							// is_block
				
				if (i%2 ==0) {
					// 2의 배수면 0
					pstmt.setInt(15, 0);	// alarm_to_mail
				} else {
					pstmt.setInt(15, 1);
				}
				
				if (i%3 ==0) {
					// 3의 배수면 0
					pstmt.setInt(16, 0);	// alarm_to_sms
				} else {
					pstmt.setInt(16, 1);
				}
				
				if (i%5 == 0) {
					
					pstmt.setInt(13, 1);	// is_artist -> yes
					// set up for artist table
					pstmt2 = con.prepareStatement(sql2);
					
					pstmt2.setString(1, id);	// artist id (user id)
					
					// since this user is artist, store this id for putting into artist_id in music table
					artist_ids[j] = id;
					
					if (i%2 == 0) { 
						pstmt2.setString(2, name);	// artist name (짝수 : real name = artist name, 홀수 : another random name)
						artist_names[j] = name;
					} else {
						String tempname = getRandomString(4);
						pstmt2.setString(2,  "name" + tempname);
						artist_names[j] = "name"+tempname;
					}
					j++;
					
					pstmt2.setDate(3, bday);
					
					pstmt2.setString(4, "hi! my name is " + name);	// artist introduction
					
					pstmt2.setDate(5, addDate(bday, i));	// artist debut_date <- real birthday + 20 + i years
					
					pstmt2.setString(6, "song" + getRandomString(4));	// artist debut_song
					if (i%2 ==0) {
						pstmt2.setString(7, "solo");	// artist type solo
					} else {
						pstmt2.setString(7, "group");	// artist type group
					}
					if (i%2 ==0) {
						pstmt2.setString(8, "M");	// artist gender
					} else {
						pstmt2.setString(8, "F");	// artist gender
					}
					
					pstmt2.setString(9, "agency" + getRandomString(4));	// artist agency
					pstmt2.setString(10, "nation" + getRandomString(4));	// artist nationality
					pstmt2.setString(11, "const" + getRandomString(4));	// artist constellation
					
					if ((i/5)%4==0) {
						pstmt2.setString(12, "A");	// artist blood type = A, B, AB, O
					} 
					else if ((i/5)%4 == 1) {
						pstmt2.setString(12, "B");	// artist blood type = A, B, AB, O
					} 
					else if ((i/5)%4 == 2) {
						pstmt2.setString(12, "AB");	// artist blood type = A, B, AB, O
					} 
					else {
						pstmt2.setString(12, "O");	// artist blood type = A, B, AB, O
					}
					
					pstmt2.setInt(13, 0);	// artist num_stars = 0
					pstmt2.setString(14, "www." + getRandomString(4) + ".com");	// artist fanclub www.+random+.com
					pstmt2.setString(15, "youtube." + getRandomString(4) + ".com");	// artist youtube youtube. +random+ .com
					pstmt2.setString(16, "facebook." + getRandomString(4) + ".com");	// artist facebook facebook. +random+ .com
					pstmt2.setString(17, "twitter." + getRandomString(4) + ".com");	// artist twitter twitter. + random + .com
					
//					System.out.println("artist : " + i);
//					System.out.println(pstmt2);
					pstmt2.executeUpdate();
				}
				else {
					pstmt.setInt(13, 0);	// is_artist -> no
				}
				
				pstmt.setString(17, "null");	// liked_artist
				
//				System.out.println("user list : " + i);
//				System.out.println(pstmt);
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
	
	
	public void myPageUserList(String id) {
    	
    	Statement st = null;
		ResultSet result = null;

    	System.out.println("MyPage entered!!");
    	
    	try {
    		st = con.createStatement();
			// executeQuery : 쿼리를 실행하고 결과를 ResultSet 객체로 반환한다.
    		result = st.executeQuery("SELECT * FROM User WHERE id='"+id+"'" );
    		System.out.println("SELECT * FROM User WHERE id='" + id + "'");
    		
		} catch (SQLException e) {
			System.out.println("createStatement problem: ");
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
