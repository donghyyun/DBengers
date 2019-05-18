package mainClasses;

import java.awt.Font;

import javax.swing.JFrame;

import artistChannel.ArtistChannelStarPostPanel;

public class ArtistChannelStarPostFrame extends JFrame{
	public ArtistChannelStarPostFrame(){};

	public static final int startX = mainClasses.MainFrame.startX + mainClasses.MainFrame.frameWidth / 3;
	public static final int startY = mainClasses.MainFrame.startY - mainClasses.MainFrame.frameHeight / 4;
	public static final int frameWidth = (int)(mainClasses.MainFrame.frameWidth * 1.3);
	public static final int frameHeight = (int)(mainClasses.MainFrame.frameHeight * 0.7);
	
	public static final int marginHeight = frameHeight / 20;
	public static final int marginWidth = frameWidth / 20;
	
	public ArtistChannelStarPostPanel artistChannelStarPostPanel;
	
	public void setThis() {
		getContentPane().setLayout(null);
		this.setLocation(startX, startY);
		this.setSize(frameWidth, frameHeight);
		this.setVisible(true);
		artistChannelStarPostPanel = new ArtistChannelStarPostPanel();
		getContentPane().add(artistChannelStarPostPanel);
	}
}
