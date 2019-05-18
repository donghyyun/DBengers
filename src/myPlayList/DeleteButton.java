package myPlayList;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;

import interfaces.Setting;
import mainClasses.DB;
import mainClasses.MyPlayListFrame;

public class DeleteButton extends JButton implements Setting{
	int buttonNum;	// used to distinguish which to delete
	public void setThis(Component prevComp, int num) {
		this.setText("delete");	// should get the play-list name from the Database!
		this.setFont(MyPlayListPanel.font);
		this.setBorderPainted(true);
		this.setBounds(prevComp.getX() + prevComp.getWidth() + MyPlayListFrame.marginWidth / 2, prevComp.getY(), 150, prevComp.getHeight());
		this.addActionListener(new Listener());
		buttonNum = num;
	}

	public void setComponents() {}

	public void addComponents() {}

	public class Listener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// when click, the corresponding play-list should be deleted from the Database
			// also, this play-list should be deleted from the MyPlayListFrame(or panel)
			DB.getInstance().deletePlayList(DB.currentID, MyPlayListPanel.playListButtons.get(buttonNum).getText());
			String str = DB.getInstance().deleteHashTag_Hashtag(DB.currentID, MyPlayListPanel.playListButtons.get(buttonNum).getText());
			ArrayList<String> hashtags = new ArrayList<String>(Arrays.asList(str.split(",")));
			DB.getInstance().deleteHashTag_HashtagNames(hashtags);
			
			mainClasses.MainController.myPlayListFrame.setVisible(false);
			mainClasses.MainController.myPlayListFrame = null;
			
			
			mainClasses.MainController.myPlayListFrame = new mainClasses.MyPlayListFrame();
			mainClasses.MainController.myPlayListFrame.setThis();
		}
		
	}

	@Override
	public void setThis(Component prevComp) {}
}
