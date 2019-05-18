package artistChannel;

import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import interfaces.Setting;
import mainClasses.ArtistChannelFrame;
import mainClasses.DB;

public class ArtistChannelPanel extends JPanel implements Setting{

	public JLabel title = new JLabel("Star Channel");
	public ArrayList<JLabel> labels = new ArrayList<JLabel>();
	public ArrayList<JLabel> contents = new ArrayList<JLabel>();
	public ArrayList<String> labelName = new ArrayList<String>();
	public ArrayList<String> contentName = new ArrayList<String>();
	String currentArtistName;
	
	MusicButton musicButton = new MusicButton();
	AlbumButton albumButton = new AlbumButton();
	StarPostButton starpostButton = new StarPostButton();
	CommentButton commentButton = new CommentButton();
	
	public static Font font = new Font ("Arial", Font.BOLD, ArtistChannelFrame.frameHeight / 30);
	
	public ArtistChannelPanel(String ArtistName) {
		currentArtistName = ArtistName;
		this.setThis(null);	
	}

	public void setThis(Component prevComp) {
		
		contentName = DB.getInstance().getArtistInfo(currentArtistName);
		labelName = DB.getInstance().getArtistField();
		this.setBounds(0, 0, ArtistChannelFrame.frameWidth, ArtistChannelFrame.frameHeight);
		this.setLayout(null);
		this.setComponents();
		this.addComponents();
	}

	public void setComponents() {
		title.setFont(new Font("Arial", Font.BOLD, ArtistChannelFrame.frameHeight / 25));
		title.setBounds(ArtistChannelFrame.frameWidth/10+50, ArtistChannelFrame.frameHeight/10-35, 200, 35);
		for(int i=0; i<contentName.size() ;i++)
		{
			labels.add(new JLabel(labelName.get(i+1)));
			labels.get(i).setBounds(ArtistChannelFrame.frameWidth/10, ArtistChannelFrame.frameHeight/10+25*i, 150, 25);
			contents.add(new JLabel(contentName.get(i)));
			contents.get(i).setBounds(ArtistChannelFrame.frameWidth/10+155, ArtistChannelFrame.frameHeight/10+25*i, 150, 25);
		}
		musicButton.setThis(null);
		albumButton.setThis(null);
		starpostButton.setThis(null);
		commentButton.setThis(null);
	}

	public void addComponents() {
		this.add(title);
		for(int i=0; i<contentName.size(); i++)
		{
			this.add(labels.get(i));
			this.add(contents.get(i));
		}
		this.add(musicButton);
		this.add(albumButton);
		this.add(starpostButton);
		this.add(commentButton);
	}
}
