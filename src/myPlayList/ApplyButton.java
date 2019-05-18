package myPlayList;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;

import interfaces.Setting;
import mainClasses.AddPlayListFrame;
import mainClasses.DB;
import mainClasses.MyPlayListFrame;

public class ApplyButton extends JButton implements Setting{
	
	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setText("Apply");
		this.setFont(AddPlayListPanel.font);
		this.setBorderPainted(true);
		this.setBounds((int) (AddPlayListFrame.frameWidth / 1.3), (int) (AddPlayListFrame.frameHeight / 1.3), 100, this.getFont().getSize() +  AddPlayListFrame.marginHeight);
		this.addActionListener(new Listener());
	}

	public void setComponents() {}

	public void addComponents() {}
	
	class Listener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			DB.getInstance().addPlayList(DB.currentID, AddPlayListPanel.newPlaylistName.getText());
			DB.getInstance().addHashtag(DB.currentID, AddPlayListPanel.newPlaylistName.getText(), AddPlayListPanel.hashtags.getText());
			
			String str = AddPlayListPanel.hashtags.getText();
			ArrayList<String> hashtags = new ArrayList<String>(Arrays.asList(str.split(",")));
			
			DB.getInstance().addHashTag_Hashtag(DB.currentID, AddPlayListPanel.newPlaylistName.getText(), hashtags);
			DB.getInstance().addHashTag_HashtagNames(hashtags);

			mainClasses.MainController.addPlayListFrame.setVisible(false);
			mainClasses.MainController.addPlayListFrame = null;
			
			mainClasses.MainController.myPlayListFrame.setVisible(false);
			mainClasses.MainController.myPlayListFrame = null;
			
			mainClasses.MainController.myPlayListFrame = new mainClasses.MyPlayListFrame();
			mainClasses.MainController.myPlayListFrame.setThis();
		}
	}
}
