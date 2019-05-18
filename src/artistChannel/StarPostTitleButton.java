package artistChannel;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import interfaces.Setting;
import mainClasses.ArtistChannelFrame;
import mainClasses.DB;

public class StarPostTitleButton extends JButton implements Setting{

	int currentStarpostID;
	
	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setText("example title");
		this.setFont(new Font ("Arial", Font.BOLD, ArtistChannelFrame.frameHeight / 35));
		this.setContentAreaFilled(false);
		this.setBorderPainted(true);
		this.setBounds((int) (ArtistChannelFrame.frameWidth * 0.1), (int) (ArtistChannelFrame.frameHeight * 0.8), 100, 40);
		this.addActionListener(new Listener());
	}

	public void setComponents() {}

	public void addComponents() {}
	
	class Listener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			DB.getInstance().addStarpostView(currentStarpostID);
		}
	}
}
