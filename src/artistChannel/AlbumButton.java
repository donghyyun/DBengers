package artistChannel;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import interfaces.Setting;
import mainClasses.ArtistChannelAlbumFrame;
import mainClasses.ArtistChannelFrame;

public class AlbumButton extends JButton implements Setting{
	
	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setText("Album");
		this.setFont(ArtistChannelPanel.font);
		this.setBorderPainted(true);
		this.setBounds((int) (ArtistChannelFrame.frameWidth * 0.3), (int) (ArtistChannelFrame.frameHeight * 0.8), 95, 35);
		this.addActionListener(new Listener());
	}

	public void setComponents() {}

	public void addComponents() {}
	
	class Listener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			mainClasses.MainController.artistChannelAlbumFrame = new ArtistChannelAlbumFrame();
			mainClasses.MainController.artistChannelAlbumFrame.setThis();;
		}
	}
}
