package main;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import interfaces.Setting;

public class MainMyPlayListButton extends JButton implements Setting {

	@Override
	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setText("My PlayList");
		this.setFont(MainPanel.font);
		this.setBorderPainted(true);
		this.setBounds(MainPanel.startX, MainPanel.startY, this.getPreferredSize().width, this.getFont().getSize() + MainPanel.marginHeight);
		this.addActionListener(new Listener());
	}

	@Override
	public void setComponents() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addComponents() {
		// TODO Auto-generated method stub

	}
	
	public class Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			mainClasses.MainController.myPlayListFrame = new mainClasses.MyPlayListFrame();
			mainClasses.MainController.myPlayListFrame.setThis();
		}
		
	}
}
