package myPlayList;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import interfaces.Setting;
import mainClasses.DB;
import mainClasses.MyPlayListFrame;

public class ChangeNameButton extends JButton implements Setting{
	int buttonNum;	// used to distinguish which to change name
	public void setThis(Component prevComp, int num) {
		this.setText("Change Name");
		this.setFont(MyPlayListPanel.font);
		this.setBorderPainted(true);
		this.setBounds(prevComp.getX() + prevComp.getWidth() + MyPlayListFrame.marginWidth / 2, prevComp.getY(), prevComp.getWidth(), prevComp.getHeight());
		this.addActionListener(new Listener());
		buttonNum = num;
	}

	public void setComponents() {}

	public void addComponents() {}

	public class Listener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// when click, it should change the corresponding play-list name 
			String newName = JOptionPane.showInputDialog("Type in new name");
			DB.getInstance().changePlayListName(DB.currentID, MyPlayListPanel.playListButtons.get(buttonNum).getText(), newName);
			System.out.println("ChangeNameButton Pressed");
		}
		
	}

	@Override
	public void setThis(Component prevComp) {}
}
