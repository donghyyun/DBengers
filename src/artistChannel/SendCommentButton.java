package artistChannel;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.JButton;

import interfaces.Setting;
import mainClasses.ArtistChannelCommentFrame;
import mainClasses.DB;

public class SendCommentButton extends JButton implements Setting{

	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setText("Send");
		this.setFont(ArtistChannelPanel.font);
		this.setBorderPainted(true);
		this.setBounds((int) (ArtistChannelCommentFrame.frameWidth * 0.6), 10, 70, 40);
		this.addActionListener(new Listener());
	}

	public void setComponents() {}

	public void addComponents() {}
	
	class Listener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			int count = DB.getInstance().countComment(ArtistChannelPanel.currentArtistID);
			DB.getInstance().sendComment(count, ArtistChannelPanel.currentArtistID, DB.currentID, ArtistChannelCommentingPanel.commentBox.getText());
		
		}
	}
}
