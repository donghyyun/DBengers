package myPlayList;

import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import interfaces.Setting;
import mainClasses.DB;
import mainClasses.PlayListMusicFrame;

public class PlayListMusicPanel extends JPanel implements Setting{

	public ArrayList<ListenButton> listenButtons = new ArrayList<ListenButton>();
	public ArrayList<DownloadButton> downloadButtons = new ArrayList<DownloadButton>();
	public static ArrayList<JLabel> musicNames = new ArrayList<JLabel>();
	public ArrayList<JLabel> artistNames = new ArrayList<JLabel>();
	public ArrayList<String> musics;
	public ArrayList<String> artists;
	public String playListName;
	public static int numOfMusicInPlayList = 0;	// number of music in the play-list
	
	public static Font font = new Font ("Arial", Font.BOLD, PlayListMusicFrame.frameHeight / 30);
	
	public PlayListMusicPanel(String playlistName) {
		this.playListName = playlistName;
		this.setThis(null);
	}

	public void setThis(Component prevComp) {
		ListenButton.numOfListen = 0;
		DownloadButton.numOfListen = 0;
		musics = DB.getInstance().getPlayListMusic(DB.currentID, playListName);
		artists = DB.getInstance().getPlayListMusicArtist(DB.currentID, playListName);
		numOfMusicInPlayList = musics.size();
		System.out.println("Music: "+musics.get(0)+"\nArtist: "+artists.get(0));
		this.setBounds(0, 0, PlayListMusicFrame.frameWidth, PlayListMusicFrame.frameHeight);
		this.setLayout(null);
		this.setComponents();
		this.addComponents();
	}

	public void setComponents() {
		for(int i=0; i<numOfMusicInPlayList ;i++)
		{
			listenButtons.add(new ListenButton());
			listenButtons.get(i).setThis(null,i);
			downloadButtons.add(new DownloadButton());
			downloadButtons.get(i).setThis(null,i);
			musicNames.add(new JLabel(musics.get(i)));
			musicNames.get(i).setBounds(PlayListMusicFrame.frameWidth/10, PlayListMusicFrame.frameHeight/10+40*i, 180, 35);
			artistNames.add(new JLabel(artists.get(i)));
			artistNames.get(i).setBounds(PlayListMusicFrame.frameWidth/10+190, PlayListMusicFrame.frameHeight/10+40*i, 180, 35);
		}
	}

	public void addComponents() {
		
		for(int i=0; i<numOfMusicInPlayList; i++)
		{
			this.add(musicNames.get(i));
			this.add(artistNames.get(i));
			this.add(listenButtons.get(i));
			this.add(downloadButtons.get(i));
		}
	}	
}
