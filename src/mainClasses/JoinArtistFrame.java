package mainClasses;

import javax.swing.JFrame;

import join.JoinArtistPanel;

public class JoinArtistFrame extends JFrame{
	public JoinArtistFrame() {
	}
	public static final int startX = mainClasses.MainFrame.startX + mainClasses.MainFrame.frameWidth / 3;
	public static final int startY = mainClasses.MainFrame.startY - mainClasses.MainFrame.frameHeight / 4;
	public static final int frameWidth = mainClasses.MainFrame.frameWidth;
	public static final int frameHeight = (int) (mainClasses.MainFrame.frameHeight*1.2);
	
	public static final int marginHeight = frameHeight / 20;
	public static final int marginWidth = frameWidth / 20;
	
	public JoinArtistPanel joinArtistPanel;
	

	public void setThis() {
		getContentPane().setLayout(null);
		this.setLocation(startX, startY);
		this.setSize(frameWidth, frameHeight);
		this.setVisible(true);
		joinArtistPanel = new JoinArtistPanel();
		getContentPane().add(joinArtistPanel);
	}
}
