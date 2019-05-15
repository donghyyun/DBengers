package mainClasses;

import java.awt.Component;

import javax.swing.JFrame;
import myPage.MyPageUserPanel;

public class MyPageFrame extends JFrame{
	public MyPageFrame() {
	}
	public static final int startX = mainClasses.MainFrame.startX + mainClasses.MainFrame.frameWidth / 3;
	public static final int startY = mainClasses.MainFrame.startY - mainClasses.MainFrame.frameHeight / 4;
	public static final int frameWidth = mainClasses.MainFrame.frameWidth+100;
	public static final int frameHeight = mainClasses.MainFrame.frameHeight+80;
	
	public static final int marginHeight = frameHeight / 20;
	public static final int marginWidth = frameWidth / 20;
	
	public static final int buttonWidth = frameWidth / 20;
	public static final int buttonHeight = frameWidth / 20;
	
	
	public MyPageUserPanel myPageUserPanel;
	
	public void setThis() {
		getContentPane().setLayout(null);
		this.setLocation(startX, startY);
		this.setSize(frameWidth, frameHeight);
		this.setVisible(true);
		myPageUserPanel = new MyPageUserPanel();
		getContentPane().add(myPageUserPanel);
	}
}
