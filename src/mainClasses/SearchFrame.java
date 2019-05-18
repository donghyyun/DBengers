package mainClasses;
import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.Window.Type;
import search.SearchPanel;

public class SearchFrame extends JFrame {
	
	public SearchFrame() {};
	
	public static int screenWidth = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public static int screenHeight = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
	public static int startX = screenWidth / 3;
	public static int startY = screenHeight / 6;
	public static int frameWidth = screenWidth / 2;
	public static int frameHeight = screenHeight * 2 / 3;
	
	public search.SearchPanel searchPanel = new search.SearchPanel();
	
	public void setThis() {
		this.setBounds(startX, startY, frameWidth, frameHeight);
		getContentPane().setLayout(null);
		this.add(searchPanel);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
