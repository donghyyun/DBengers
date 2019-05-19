package main;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import interfaces.Setting;
import mainClasses.DB;

public class MainRadioButton extends JButton implements Setting {

	@Override
	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setText("HashTags");
		this.setFont(MainPanel.font);
		this.setBorderPainted(true);
		this.setSize(this.getPreferredSize().width, prevComp.getSize().height);
		this.setLocation(prevComp.getX() + prevComp.getWidth(), prevComp.getY());
		this.addActionListener(new Listener());
	}

	@Override
	public void setComponents() {}

	@Override
	public void addComponents() {}
	
	// top 6 tags selected from hashtagnames table
	// sql : select name from HashtagNames order by cnt desc limit 6;
	// samples : 
	
	
	ArrayList<String> hashtags = null;
	Scanner scn = new Scanner(System.in);
	int choice = 0;
	
	
	public class Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			hashtags = DB.getInstance().getTopHashtag();
			JOptionPane.showMessageDialog(null, "Hashtag Button Pressed", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
			//mainClasses.MainController.artistlistframe = new mainClasses.ArtistListFrame();
			//mainClasses.MainController.artistlistframe.setThis();
			System.out.println("== PlayLists with Hashtags ===");
			for(int i = 0; i < hashtags.size(); i++) {
				
				System.out.println(i+1 + ". " + hashtags.get(i));
			}
			System.out.println("select hashtag you want : ");
			choice = scn.nextInt();
			ArrayList<String> playlistNames;
			switch(choice) {
			case 1 :
				System.out.println("#"+hashtags.get(choice-1));
				playlistNames = DB.getInstance().getPlaylistNameByHashtag(hashtags.get(choice-1));
				for(int j = 0; j < playlistNames.size(); j++) {
					System.out.println(playlistNames.get(j));
				}
				break;
			case 2 :
				System.out.println("#"+hashtags.get(choice-1));
				playlistNames = DB.getInstance().getPlaylistNameByHashtag(hashtags.get(choice-1));
				for(int j = 0; j < playlistNames.size(); j++) {
					System.out.println(playlistNames.get(j));
				}
				break;
			case 3:
				System.out.println("#"+hashtags.get(choice-1));
				playlistNames = DB.getInstance().getPlaylistNameByHashtag(hashtags.get(choice-1));
				for(int j = 0; j < playlistNames.size(); j++) {
					System.out.println(playlistNames.get(j));
				}
				break;
			case 4 :
				System.out.println("#"+hashtags.get(choice-1));
				playlistNames = DB.getInstance().getPlaylistNameByHashtag(hashtags.get(choice-1));
				for(int j = 0; j < playlistNames.size(); j++) {
					System.out.println(playlistNames.get(j));
				}
				break;
			case 5 :
				System.out.println("#"+hashtags.get(choice-1));
				playlistNames = DB.getInstance().getPlaylistNameByHashtag(hashtags.get(choice-1));
				for(int j = 0; j < playlistNames.size(); j++) {
					System.out.println(playlistNames.get(j));
				}
				break;
			case 6 :
				System.out.println("#"+hashtags.get(choice-1));
				playlistNames = DB.getInstance().getPlaylistNameByHashtag(hashtags.get(choice-1));
				for(int j = 0; j < playlistNames.size(); j++) {
					System.out.println(playlistNames.get(j));
				}
				break;
			}
			
		}
	}

}
