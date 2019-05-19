package mainClasses;

import javax.swing.JFrame;

import artistChannel.ArtistChannelCommentPanel;
import artistChannel.ArtistChannelCommentingPanel;

public class ArtistChannelCommentFrame extends JFrame{

	public ArtistChannelCommentFrame(){};

	public static final int startX = mainClasses.MainFrame.startX + mainClasses.MainFrame.frameWidth / 3;
	public static final int startY = mainClasses.MainFrame.startY - mainClasses.MainFrame.frameHeight / 4;
	public static final int frameWidth = (int)(mainClasses.MainFrame.frameWidth * 1);
	public static final int frameHeight = (int)(mainClasses.MainFrame.frameHeight * 1.2);
	
	public static final int marginHeight = frameHeight / 20;
	public static final int marginWidth = frameWidth / 20;
	
	public ArtistChannelCommentPanel artistChannelCommentPanel;
	public ArtistChannelCommentingPanel artistChannelCommentingPanel;
	
	public void setThis() {
		getContentPane().setLayout(null);
		this.setLocation(startX, startY);
		this.setSize(frameWidth, frameHeight);
		this.setVisible(true);
		artistChannelCommentPanel = new ArtistChannelCommentPanel();
		artistChannelCommentingPanel = new ArtistChannelCommentingPanel();
		getContentPane().add(artistChannelCommentPanel);
		getContentPane().add(artistChannelCommentingPanel);
	}
}
