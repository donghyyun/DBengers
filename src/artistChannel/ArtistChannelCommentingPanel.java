package artistChannel;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JTextField;

import interfaces.Setting;
import mainClasses.ArtistChannelCommentFrame;

public class ArtistChannelCommentingPanel extends JPanel implements Setting {

	public ArtistChannelCommentingPanel() {this.setThis(null);}
	
	public static JTextField commentBox = new JTextField("Write comment here :)");
	SendCommentButton sendButton = new SendCommentButton();
	
	public void setThis(Component prevComp) {
		this.setBounds(0, (int) (ArtistChannelCommentFrame.frameHeight * 0.9), ArtistChannelCommentFrame.frameWidth, (int) (ArtistChannelCommentFrame.frameHeight * 0.1));
		this.setLayout(null);
		this.setBackground(Color.orange);
		this.setComponents();
		this.addComponents();
	}

	public void setComponents() {
		commentBox.setBounds(ArtistChannelCommentFrame.frameWidth/4, 10, (int)(ArtistChannelCommentFrame.frameWidth/3), (int)(ArtistChannelCommentFrame.frameHeight * 0.05));
		commentBox.setBackground(Color.LIGHT_GRAY);
		sendButton.setThis(null);
	}

	public void addComponents() {
		this.add(commentBox);
		this.add(sendButton);
	}
}
