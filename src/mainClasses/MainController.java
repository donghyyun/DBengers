package mainClasses;

public class MainController {
	public static MainFrame mainFrame = new MainFrame();
	public static JoinFrame joinFrame;

	public static MyPageFrame myPageFrame;
	public static JoinArtistFrame joinArtistFrame;

	public static ChangeSettingFrame changeSettingFrame; 
	public static ArtistListFrame artistlistframe;
	public static VoucherFrame voucherFrame;

	public static MyPlayListFrame myPlayListFrame;
	public static AddPlayListFrame addPlayListFrame;
	public static PlayListMusicFrame playListMusicFrame;
	
	public static ArtistChannelFrame artistChannelFrame;
	public static ArtistChannelMusicFrame artistChannelMusicFrame;
	public static ArtistChannelAlbumFrame artistChannelAlbumFrame;
	
	public static void main(String[] args) {
		 //TODO Auto-generated method stub
		mainFrame.setThis();

		//DB쓰고나서 closeConnection() 해주세요!!
		DBInsert.getInstance().Usergenerator();
		DBInsert.getInstance().Musicgenerator();
//		DBInsert.getInstance().StarPostgenerator();
//		DBInsert.getInstance().closeConnection();
	}
}