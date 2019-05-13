package mainClasses;

public class MainController {
	public static MainFrame mainFrame = new MainFrame();
	public static JoinFrame joinFrame;

	public static void main(String[] args) {
		 //TODO Auto-generated method stub
		mainFrame.setThis();
		mainFrame.add(mainFrame.getLogPanel());
	}
}