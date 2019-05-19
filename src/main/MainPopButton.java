package main;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import interfaces.Setting;
import mainClasses.DB;

public class MainPopButton extends JButton implements Setting {

	@Override
	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setText("Pop");
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
			
			ArrayList<String> infos = new ArrayList<String>();
			
			infos = DB.getInstance().getMusicInfoByGenre("Pop");
			int length = infos.size() / 4;
			
			for (String info : infos) {
				if (infos.indexOf(info) % 4 != 0)
					mainClasses.MainController.mainFrame.mainPanel.musicPanel.rows.get(infos.indexOf(info) / 4).songInfo[infos.indexOf(info) % 4 - 1].setText(info);
				else
					mainClasses.MainController.mainFrame.mainPanel.musicPanel.rows.get(infos.indexOf(info) / 4).music_id = Integer.parseInt(info);
				
				mainClasses.MainController.mainFrame.mainPanel.musicPanel.rows.get(infos.indexOf(info) / 4).setVisible(true);
			}
			
			for (int i = length; i < MainMusicPanel.num; i++)
				mainClasses.MainController.mainFrame.mainPanel.musicPanel.rows.get(i).setVisible(false);

			mainClasses.MainController.mainFrame.mainPanel.scroll.setVisible(true);
			
		}
	}

}
