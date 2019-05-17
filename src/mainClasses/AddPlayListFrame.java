package mainClasses;

import java.awt.Component;

import javax.swing.JFrame;

import interfaces.Setting;
import myPlayList.AddPlayListPanel;

public class AddPlayListFrame extends JFrame implements Setting{

	public static final int startX = mainClasses.MainFrame.startX + mainClasses.MainFrame.frameWidth / 3;
	public static final int startY = mainClasses.MainFrame.startY - mainClasses.MainFrame.frameHeight / 4;
	public static final int frameWidth = mainClasses.MainFrame.frameWidth;
	public static final int frameHeight = mainClasses.MainFrame.frameHeight / 2;
	
	public static final int marginHeight = frameHeight / 20;
	public static final int marginWidth = frameWidth / 20;
	
	public AddPlayListPanel addPlayListPanel;
	
	public void setThis(Component prevComp) {
		getContentPane().setLayout(null);
		this.setLocation(startX, startY);
		this.setSize(frameWidth, frameHeight);
		this.setVisible(true);
		addPlayListPanel = new AddPlayListPanel();
		getContentPane().add(addPlayListPanel);
	}

	public void setComponents() {}

	public void addComponents() {}

	
	
}
