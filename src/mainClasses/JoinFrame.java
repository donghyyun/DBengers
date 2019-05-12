package mainClasses;

import java.awt.Component;

import javax.swing.JFrame;

import join.JoinUserPanel;

public class JoinFrame extends JFrame{
	public JoinFrame() {
	}
	public static final int startX = mainClasses.MainFrame.startX + mainClasses.MainFrame.frameWidth / 3;
	public static final int startY = mainClasses.MainFrame.startY - mainClasses.MainFrame.frameHeight / 4;
	public static final int frameWidth = mainClasses.MainFrame.frameWidth;
	public static final int frameHeight = mainClasses.MainFrame.frameHeight;
	
	public static final int marginHeight = frameHeight / 20;
	public static final int marginWidth = frameWidth / 20;
	
	public JoinUserPanel usrPanel;
	

	public void setThis() {
		getContentPane().setLayout(null);
		this.setLocation(startX, startY);
		this.setSize(frameWidth, frameHeight);
		this.setVisible(true);
		usrPanel = new JoinUserPanel();
		getContentPane().add(usrPanel);
	}
}
