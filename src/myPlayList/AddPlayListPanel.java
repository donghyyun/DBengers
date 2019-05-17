package myPlayList;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import interfaces.Setting;
import mainClasses.AddPlayListFrame;
import mainClasses.JoinArtistFrame;

public class AddPlayListPanel extends JPanel implements Setting{

	JLabel playlistName = new JLabel("Playlist Name: ");
	JLabel hashtagName = new JLabel("Hashtags: ");
	static JTextField newPlaylistName;
	static JTextField hashtags;
	ApplyButton apply = new ApplyButton();
	
	public static Font font = new Font ("Arial", Font.BOLD, JoinArtistFrame.frameHeight / 40);
	
	public AddPlayListPanel() {this.setThis(null);}
	
	public void setThis(Component prevComp) {
		newPlaylistName = new JTextField("Name of new playlist");
		hashtags = new JTextField("Write hashtags (ex: 여행,운동,...)");
		
		playlistName.setBounds(AddPlayListFrame.frameWidth/7, AddPlayListFrame.frameHeight/3, 100, 35);
		hashtagName.setBounds(AddPlayListFrame.frameWidth/7, AddPlayListFrame.frameHeight/3+45, 80, 35);
		newPlaylistName.setBounds(AddPlayListFrame.frameWidth/3, AddPlayListFrame.frameHeight/3, 250, 35);
		hashtags.setBounds(AddPlayListFrame.frameWidth/3, AddPlayListFrame.frameHeight/3+45, 250, 35);
		this.setBounds(0, 0, AddPlayListFrame.frameWidth, AddPlayListFrame.frameHeight);
		this.setLayout(null);
		this.setComponents();
		this.addComponents();		
	}

	@Override
	public void setComponents() {apply.setThis(null);}

	@Override
	public void addComponents() {
		this.add(playlistName);
		this.add(newPlaylistName);
		this.add(hashtagName);
		this.add(hashtags);
		this.add(apply);
	}

}
