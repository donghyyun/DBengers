package mainClasses;

public class MainController {
	public static MainFrame mainFrame = new MainFrame();
	public static JoinFrame joinFrame;
	public static MyPageFrame myPageFrame;
	public static JoinArtistFrame joinArtistFrame;
	public static ChangeSettingFrame changeSettingFrame; 
	public static ArtistListFrame artistlistframe;

	public static void main(String[] args) {
		 //TODO Auto-generated method stub
		
		mainFrame.setThis();
		mainFrame.add(mainFrame.logPanel);
		
		//DB쓰고나서 closeConnection() 해주세요!!
<<<<<<< HEAD
		//DBInsert.getInstance().Usergenerator();
		//DBInsert.getInstance().Musicgenerator();
=======
//		DBInsert.getInstance().Usergenerator();
//		DBInsert.getInstance().Musicgenerator();
>>>>>>> ysh
//		DBInsert.getInstance().StarPostgenerator();
//		DBInsert.getInstance().closeConnection();
	}
}