package main;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import interfaces.Setting;

public class MainBaladButton extends JButton implements Setting {

	@Override
	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setText("Balad");
		this.setFont(MainPanel.smallFont);
		this.setBorderPainted(true);
		this.setSize(this.getPreferredSize().width, prevComp.getSize().height);
		this.setLocation(prevComp.getX() + prevComp.getWidth(), prevComp.getY());
		this.addActionListener(new Listener());
	}

	@Override
	public void setComponents() {}

	@Override
	public void addComponents() {}
	
	public class Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			//mainClasses.MainController.artistlistframe = new mainClasses.ArtistListFrame();
			//mainClasses.MainController.artistlistframe.setThis();
		}
	}

}
