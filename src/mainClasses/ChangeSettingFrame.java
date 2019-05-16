package mainClasses;

import javax.swing.JFrame;


public class ChangeSettingFrame extends JFrame{
	
	
	public static final int startX = MainFrame.startX + MainFrame.frameWidth / 3;
	public static final int startY = MainFrame.startY - mainClasses.MainFrame.frameHeight / 4;
	public static final int frameWidth = MainFrame.frameWidth;
	public static final int frameHeight = MainFrame.frameHeight;
	
	public static final int marginHeight = frameHeight / 20;
	public static final int marginWidth = frameWidth / 20;
	
	public changeSetting.ChangeSettingPanel changeSettingPanel = new changeSetting.ChangeSettingPanel();

	public void setThis() {
		getContentPane().setLayout(null);
		this.setLocation(startX, startY);
		this.setSize(frameWidth, frameHeight);
		this.add(changeSettingPanel);
		this.setVisible(true);
	}
}
