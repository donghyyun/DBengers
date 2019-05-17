package myPlayList;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import interfaces.Setting;
import mainClasses.MyPlayListFrame;
import mainClasses.PlayListMusicFrame;


public class PlayListButton extends JButton implements Setting {
	
	public static int playListNum = 0;
	public String playlistName;
	
	public void setThis(Component prevComp) {
		this.setText("PlayList");	// should get the play-list name from the Database!
		this.setFont(MyPlayListPanel.font);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setBounds(MyPlayListFrame.marginWidth, MyPlayListFrame.marginHeight  + 40*(playListNum++), 230, 35);
		this.addActionListener(new Listener());
	}

	public void setComponents() {}

	public void addComponents() {}

	public class Listener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// when click, the corresponding play-list should pop up!
			System.out.println("playlistName: "+playlistName);
			mainClasses.MainController.playListMusicFrame = new PlayListMusicFrame();
			mainClasses.MainController.playListMusicFrame.setThis(playlistName);
			System.out.println("PlayListButton pressed");
		}
		
	}
	
}
