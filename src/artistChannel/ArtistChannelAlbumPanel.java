package artistChannel;

import java.awt.Component;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import interfaces.Setting;
import mainClasses.ArtistChannelMusicFrame;
import mainClasses.DB;
import myPlayList.ListenButton;

public class ArtistChannelAlbumPanel extends JPanel implements Setting{
	
public ArtistChannelAlbumPanel() {this.setThis(null);}
	
	ArrayList<JLabel> albums = new ArrayList<JLabel>();
	ArrayList<JLabel> dates = new ArrayList<JLabel>();
	ArrayList<JLabel> likes = new ArrayList<JLabel>();
	ArrayList<String> albumName;
	ArrayList<Date> albumDate;
	ArrayList<Integer> albumLike; 
	String currentArtistID;
	
	ArrayList<ListenButton> listenButton = new ArrayList<ListenButton>();

	public void setThis(Component prevComp) {
		currentArtistID = DB.getInstance().getArtistID(ArtistChannelPanel.currentArtistName);
		albumName = DB.getInstance().getArtistAlbum(currentArtistID);
		albumDate = DB.getInstance().getArtistAlbumDate(currentArtistID, albumName);
		albumLike = DB.getInstance().getArtistAlbumLikes(currentArtistID, albumName);
		this.setBounds(0, 0, ArtistChannelMusicFrame.frameWidth, ArtistChannelMusicFrame.frameHeight);
		this.setLayout(null);
		this.setComponents();
		this.addComponents();
	}

	public void setComponents() {
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		for(int i=0; i<albumName.size(); i++)
		{
			albums.add(new JLabel(albumName.get(i)));
			albums.get(i).setBounds((int)(ArtistChannelMusicFrame.frameWidth * 0.1), (int)(ArtistChannelMusicFrame.frameHeight * 0.1 + 30*i), 150, 35);
			String convertedDate = transFormat.format(albumDate.get(i));
			dates.add(new JLabel(convertedDate));
			dates.get(i).setBounds((int)(ArtistChannelMusicFrame.frameWidth * 0.1)+150, (int)(ArtistChannelMusicFrame.frameHeight * 0.1 + 30*i), 150, 35);
			likes.add(new JLabel(Integer.toString(albumLike.get(i))));
			likes.get(i).setBounds((int)(ArtistChannelMusicFrame.frameWidth * 0.1)+300, (int)(ArtistChannelMusicFrame.frameHeight * 0.1 + 30*i), 150, 35);
		}
		
	}

	public void addComponents() {
		for(int i=0; i<albumName.size(); i++)
		{
			this.add(albums.get(i));
			this.add(dates.get(i));
			this.add(likes.get(i));
		}
	}
}
