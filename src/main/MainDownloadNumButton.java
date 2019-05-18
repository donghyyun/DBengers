package main;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import interfaces.Setting;
import mainClasses.DB;

public class MainDownloadNumButton extends JButton implements Setting {

	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setText("Download");
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
			
			infos = DB.getInstance().getMusicInfoByRank("Download");
			
			for (String info : infos) {
				if (infos.indexOf(info) % 4 != 0)
					mainClasses.MainController.mainFrame.mainPanel.musicPanel.rows[infos.indexOf(info) / 4].songInfo[infos.indexOf(info) % 4 - 1].setText(info);
				else
					mainClasses.MainController.mainFrame.mainPanel.musicPanel.rows[infos.indexOf(info) / 4].music_id = Integer.parseInt(info);
					
			}
			
			mainClasses.MainController.mainFrame.mainPanel.scroll.setVisible(true);
		}
	}
}
