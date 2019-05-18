package mainClasses;

import javax.swing.JFrame;

import artistChannel.ArtistChannelAlbumPanel;
import artistChannel.ArtistChannelMusicPanel;

public class ArtistChannelAlbumFrame extends JFrame{
	public ArtistChannelAlbumFrame(){};

	public static final int startX = mainClasses.MainFrame.startX + mainClasses.MainFrame.frameWidth / 3;
	public static final int startY = mainClasses.MainFrame.startY - mainClasses.MainFrame.frameHeight / 4;
	public static final int frameWidth = (int)(mainClasses.MainFrame.frameWidth * 1.3);
	public static final int frameHeight = (int)(mainClasses.MainFrame.frameHeight * 0.7);
	
	public static final int marginHeight = frameHeight / 20;
	public static final int marginWidth = frameWidth / 20;
	
	public ArtistChannelAlbumPanel artistChannelAlbumPanel;
	
	public void setThis() {
		getContentPane().setLayout(null);
		this.setLocation(startX, startY);
		this.setSize(frameWidth, frameHeight);
		this.setVisible(true);
		artistChannelAlbumPanel = new ArtistChannelAlbumPanel();
		getContentPane().add(artistChannelAlbumPanel);
	}
}
