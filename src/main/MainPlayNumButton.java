package main;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import interfaces.Setting;
import mainClasses.DB;

public class MainPlayNumButton extends JButton implements Setting {

	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setText("Play_num");
		this.setFont(MainPanel.smallFont);
		this.setBorderPainted(true);
		this.setSize(this.getPreferredSize().width, this.getFont().getSize() + MainPanel.marginHeight);
		this.setLocation(prevComp.getX() + prevComp.getWidth(), prevComp.getY());
		this.addActionListener(new Listener());
	}

	public void setComponents() {}

	public void addComponents() {}
	
	public class Listener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ArrayList<String> infos = new ArrayList<String>();
			
			infos = DB.getInstance().getMusicInfoByRank("Play_num");
			
			for (String info : infos) 
				mainClasses.MainController.mainFrame.mainPanel.musicPanel.rows[infos.indexOf(info) / 3].songInfo[infos.indexOf(info) % 3].setText(info);

			mainClasses.MainController.mainFrame.mainPanel.scroll.setVisible(true);
			
		}
	}
}
