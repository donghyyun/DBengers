package myPlayList;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import interfaces.Setting;
import mainClasses.DB;
import mainClasses.MyPlayListFrame;

public class AddPlayListButton extends JButton implements Setting{
	
	public void setThis(Component prevComp) {
		this.setText("add playlist");	// should get the play-list name from the Database!
		this.setFont(MyPlayListPanel.font);
		this.setBorderPainted(true);
		this.setSize(this.getPreferredSize().width, this.getFont().getSize() + MyPlayListFrame.marginHeight);
		this.setLocation(MyPlayListFrame.frameWidth - (this.getWidth() + MyPlayListFrame.marginWidth * 2), MyPlayListFrame.frameHeight - (this.getHeight() + MyPlayListFrame.marginHeight * 2));

		this.addActionListener(new Listener());
	}

	public void setComponents() {}

	public void addComponents() {}

	public class Listener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// when click, the Add PlayList Frame should pop up 
			mainClasses.MainController.addPlayListFrame = new mainClasses.AddPlayListFrame();
			mainClasses.MainController.addPlayListFrame.setThis(null);
			System.out.println("AddPlayListButton pressed");
		}
		
	}
}
