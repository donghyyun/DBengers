package main;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import interfaces.Setting;
import mainClasses.DB;

public class MainMusicDownloadButton extends JButton implements Setting {
	int rowNum;
	
	MainMusicDownloadButton(int rowNum) {this.rowNum = rowNum;}

	@Override
	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setText("Download");
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
			String musicName = mainClasses.MainController.mainFrame.mainPanel.musicPanel.rows.get(((MainMusicDownloadButton)e.getSource()).rowNum).songInfo[0].getText();
			
			DB.getInstance().addMusicDownloadnum(DB.currentID, 
					musicName);
			
			musicName += " is downloaded!";
			
			JOptionPane.showMessageDialog(null, musicName, "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}

}
