package mainClasses;
import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.Window.Type;

public class MainFrame extends JFrame {
	public static int screenWidth = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public static int screenHeight = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
	public static int startX = screenWidth / 3;
	public static int startY = screenHeight / 6;
	public static int frameWidth = screenWidth / 3;
	public static int frameHeight = screenHeight * 2 / 3;
	
	
	public login.LogPanel logPanel = new login.LogPanel();
	public main.MainPanel mainPanel = new main.MainPanel();
	
	
	public void setThis() {
		this.setBounds(startX, startY, frameWidth, frameHeight);
		getContentPane().setLayout(null);
		this.add(logPanel);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
