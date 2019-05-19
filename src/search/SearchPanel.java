package search;

import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import interfaces.Setting;
import mainClasses.DB;
import mainClasses.SearchFrame;

public class SearchPanel extends JPanel implements Setting {
	public static final int width = mainClasses.SearchFrame.frameWidth;
	public static final int height = mainClasses.SearchFrame.frameHeight;
	public static final int startX = width / 20;
	public static final int startY = height / 30;
	
	public static final int marginHeight = height / 30;
	public static final int marginWidth = width / 20;
	
	public static final int maxLength = 20;
	
	public static Font font = new Font ("Arial", Font.BOLD, SearchFrame.frameHeight / 30);
	
	public String searchText = mainClasses.MainController.mainFrame.mainPanel.searchTextF.getText();
	
	private JLabel musicTitle = new JLabel("MusicTitle");
	private JLabel musicArtist = new JLabel("MusicArtist");
	public SearchMusicPanel musicPanel = new SearchMusicPanel();
	public JScrollPane scroll;
	
	public SearchPanel() {this.setThis(null);}

	public void setThis(Component prevComp) {
		this.setBounds(0, 0, SearchFrame.frameWidth, SearchFrame.frameHeight);
		this.setLayout(null);
		this.setComponents();
		this.addComponents();
	}

	public void setComponents() {
		musicTitle.setFont(font);
		musicTitle.setSize(musicTitle.getPreferredSize());
		musicTitle.setLocation(startX + marginWidth / 2, startY);
		musicArtist.setFont(font);
		musicArtist.setSize(musicArtist.getPreferredSize());
		musicArtist.setLocation(musicTitle.getX() + musicTitle.getWidth() + marginWidth * 2, musicTitle.getY());
		
		ArrayList <Integer> musicId = DB.getInstance().getSearchMusicId(DB.currentID,searchText);
		ArrayList <String> musicList = DB.getInstance().getSearchMusic(DB.currentID,searchText);
		ArrayList <String> artistList = DB.getInstance().getSearchMusicArtist(DB.currentID,searchText);
		

		int length = musicId.size() < maxLength ? musicId.size() : maxLength;
		
		musicPanel.setLength(length);
		musicPanel.setThis(null);
		musicPanel.setPreferredSize(musicPanel.getPreferredSize());
		
		for (int i = 0; i < length; i++) {
			musicPanel.rows.get(i).music_id = musicId.get(i);
			musicPanel.rows.get(i).songInfo[0].setText(musicList.get(i));
			musicPanel.rows.get(i).songInfo[1].setText(artistList.get(i));
		}
		
		scroll = new JScrollPane(musicPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setLocation(marginWidth, musicTitle.getY() + musicTitle.getHeight());
		scroll.setSize(width - 2 * marginWidth, (height - (scroll.getY() + 2 * marginHeight)));//height - (scroll.getY() + 2 * marginHeight));
		scroll.setViewportView(musicPanel);
		
		
	}

	public void addComponents() {
		this.add(musicTitle);
		this.add(musicArtist);
	
		this.add(scroll);
	}	
}
