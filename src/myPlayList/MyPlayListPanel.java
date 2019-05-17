package myPlayList;

import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JPanel;

import interfaces.Setting;
import mainClasses.DB;
import mainClasses.MyPlayListFrame;

public class MyPlayListPanel extends JPanel implements Setting{
		
	public static ArrayList<PlayListButton> playListButtons = new ArrayList<PlayListButton>();
	public ArrayList<DeleteButton> deleteButtons = new ArrayList<DeleteButton>();
	public ArrayList<ChangeNameButton> changeNameButtons = new ArrayList<ChangeNameButton>();
	public AddPlayListButton addPlayListButton = new AddPlayListButton();
	public ArrayList<String> playLists;
	
	public static int numOfPlayList = 0;	// number of play-lists of the user
	
	public static Font font = new Font ("Arial", Font.BOLD, MyPlayListFrame.frameHeight / 30);
	
	public MyPlayListPanel() {this.setThis(null);}

	public void setThis(Component prevComp) {
		PlayListButton.playListNum = 0;
		playLists = DB.getInstance().getPlayListInfo(DB.currentID);
		this.setBounds(0, 0, MyPlayListFrame.frameWidth, MyPlayListFrame.frameHeight);
		this.setLayout(null);
		this.setComponents();
		this.addComponents();
	}

	public void setComponents() {

		for(int i=0; i<numOfPlayList ;i++)
		{
			playListButtons.add(new PlayListButton());
			playListButtons.get(i).setThis(this);
			playListButtons.get(i).setText(playLists.get(i));
			deleteButtons.add(new DeleteButton());
			deleteButtons.get(i).setThis(playListButtons.get(i), i);
			changeNameButtons.add(new ChangeNameButton());
			changeNameButtons.get(i).setThis(deleteButtons.get(i), i);
		}
		addPlayListButton.setThis(changeNameButtons.get(numOfPlayList-1));
	}

	public void addComponents() {
		
		for(int i=0; i<numOfPlayList; i++)
		{
			this.add(playListButtons.get(i));
			this.add(deleteButtons.get(i));
			this.add(changeNameButtons.get(i));
		}
		this.add(addPlayListButton);		

	}
}
