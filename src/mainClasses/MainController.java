package mainClasses;

public class MainController {
	public static MainFrame mainFrame = new MainFrame();
	public static JoinFrame joinFrame;
	public static JoinArtistFrame joinArtistFrame;

	public static void main(String[] args) {
		 //TODO Auto-generated method stub
		mainFrame.setThis();
		mainFrame.add(mainFrame.logPanel);
		
		//DB쓰고나서 closeConnection() 해주세요!!
		//DB.getInstance().addTuples();
		//DB.getInstance().closeConnection();
	}
}