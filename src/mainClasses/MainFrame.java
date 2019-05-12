package mainClasses;
import java.awt.Component;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	public static int screenWidth = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public static int screenHeight = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
	public static int startX = screenWidth / 3;
	public static int startY = screenHeight / 6;
	public static int frameWidth = screenWidth / 3;
	public static int frameHeight = screenHeight * 2 / 3;
	
	
	login.LogPanel logPanel = new login.LogPanel();
	
	public void setThis() {
		this.setBounds(startX, startY, frameWidth, frameHeight);
		this.setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	
}
