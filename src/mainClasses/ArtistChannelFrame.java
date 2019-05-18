package mainClasses;

import java.awt.Component;

import javax.swing.JFrame;

import artistChannel.ArtistChannelPanel;

public class ArtistChannelFrame extends JFrame{

	public static final int startX = mainClasses.MainFrame.startX + mainClasses.MainFrame.frameWidth / 3;
	public static final int startY = mainClasses.MainFrame.startY - mainClasses.MainFrame.frameHeight / 4;
	public static final int frameWidth = mainClasses.MainFrame.frameWidth;
	public static final int frameHeight = mainClasses.MainFrame.frameHeight;
	
	public static final int marginHeight = frameHeight / 20;
	public static final int marginWidth = frameWidth / 20;
	
	public ArtistChannelPanel artistChannelPanel;
	
	public void setThis(String currentArtistName) {
		getContentPane().setLayout(null);
		this.setLocation(startX, startY);
		this.setSize(frameWidth, frameHeight);
		this.setVisible(true);
		artistChannelPanel = new ArtistChannelPanel(currentArtistName);
		getContentPane().add(artistChannelPanel);
	}

	public void setComponents() {}

	public void addComponents() {}
}
