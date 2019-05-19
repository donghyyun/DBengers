package main;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import interfaces.Setting;
import mainClasses.DB;

public class MainMusicPlayButton extends JButton implements Setting {
	int rowNum;
	
	MainMusicPlayButton(int rowNum) {this.rowNum = rowNum;}

	@Override
	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setText("Play");
		this.setFont(MainMusicRowPanel.buttonFont);
		this.setBorderPainted(true);
		this.setSize(this.getPreferredSize());
		this.addActionListener(new Listener());
	}

	@Override
	public void setComponents() {}

	@Override
	public void addComponents() {}
	
	public class Listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String musicName = mainClasses.MainController.mainFrame.mainPanel.musicPanel.rows.get(((MainMusicPlayButton)e.getSource()).rowNum).songInfo[0].getText();
			DB.getInstance().addMusicPlaynum(DB.currentID, 
					musicName);
			DB.getInstance().addToHistory(DB.currentID, 
					musicName);
			musicName += " is playing now!";
			
			JOptionPane.showMessageDialog(null, musicName, "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}

}
