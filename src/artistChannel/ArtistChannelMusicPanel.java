package artistChannel;

import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import interfaces.Setting;
import mainClasses.ArtistChannelFrame;
import mainClasses.ArtistChannelMusicFrame;
import mainClasses.DB;
import myPlayList.ListenButton;

public class ArtistChannelMusicPanel extends JPanel implements Setting{

	public ArtistChannelMusicPanel() {this.setThis(null);}
	
	ArrayList<JLabel> musics = new ArrayList<JLabel>();
	ArrayList<JLabel> albums = new ArrayList<JLabel>();
	ArrayList<String> musicName;
	ArrayList<String> albumName;
	String currentArtistID;
	JLabel title = new JLabel("Music Name               Album Name");
	
	ArrayList<ListenButton> listenButton = new ArrayList<ListenButton>();

	public void setThis(Component prevComp) {
		currentArtistID = DB.getInstance().getArtistID(ArtistChannelPanel.currentArtistName);
		musicName = DB.getInstance().getArtistMusic(currentArtistID);
		albumName = DB.getInstance().getArtistMusicAlbum(currentArtistID, musicName);
		this.setBounds(0, 0, ArtistChannelMusicFrame.frameWidth, ArtistChannelMusicFrame.frameHeight);
		this.setLayout(null);
		this.setComponents();
		this.addComponents();
	}

	public void setComponents() {
		for(int i=0; i<musicName.size(); i++)
		{
			musics.add(new JLabel(musicName.get(i)));
			musics.get(i).setBounds((int)(ArtistChannelMusicFrame.frameWidth * 0.1), (int)(ArtistChannelMusicFrame.frameHeight * 0.1 + 30*i), 150, 35);
			albums.add(new JLabel(albumName.get(i)));
			albums.get(i).setBounds((int)(ArtistChannelMusicFrame.frameWidth * 0.1)+150, (int)(ArtistChannelMusicFrame.frameHeight * 0.1 + 30*i), 150, 35);
			listenButton.add(new ListenButton());
			listenButton.get(i).setText("Play");
			listenButton.get(i).setBounds((int)(ArtistChannelMusicFrame.frameWidth * 0.1)+300, (int)(ArtistChannelMusicFrame.frameHeight * 0.1 + 30*i), 100, 35);
		}
		title.setFont(new Font("Arial", Font.BOLD, ArtistChannelMusicFrame.frameHeight / 30));
		title.setBounds((int)(ArtistChannelMusicFrame.frameWidth * 0.1), (int)(ArtistChannelMusicFrame.frameHeight * 0.1)-30, 300, 40);
		
	}

	public void addComponents() {
		this.add(title);
		for(int i=0; i<musicName.size(); i++)
		{
			this.add(musics.get(i));
			this.add(albums.get(i));
			this.add(listenButton.get(i));
		}
	}
}
