package search;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import interfaces.Setting;
import main.MainMusicAddToListButton;
import mainClasses.DB;

public class AddToListButton extends JButton implements Setting {
	int rowNum;
	
	AddToListButton(int rowNum) {this.rowNum = rowNum;}

	@Override
	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setText("Add to playlist");
		this.setFont(SearchMusicRowPanel.font);
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
			int musicId = mainClasses.MainController.searchFrame.searchPanel.musicPanel.rows[((AddToListButton)e.getSource()).rowNum].music_id;
			String playlistName = JOptionPane.showInputDialog("Type your playlist name");
			String musicName = mainClasses.MainController.searchFrame.searchPanel.musicPanel.rows[((AddToListButton)e.getSource()).rowNum].songInfo[0].getText();
			
			if (playlistName == null)
				return;
			
			if (!DB.getInstance().checkMyPlaylist(DB.currentID, musicId, playlistName))
				JOptionPane.showMessageDialog(null, "You have same music in same playlist", "WARNING", JOptionPane.ERROR_MESSAGE);
			else {
				DB.getInstance().addToMyPlaylist(DB.currentID, musicId, playlistName);
				JOptionPane.showMessageDialog(null, musicName + " " + musicId + " is added to " + playlistName, "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
		
	}

}
