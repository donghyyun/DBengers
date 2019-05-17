package mainClasses;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import interfaces.Setting;
import join.JoinArtistInfoPanel;

public class ArtistListButton extends JButton implements Setting{
	public static int artistlistnum = 0;
	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setText("Artist");
		this.setFont(JoinArtistInfoPanel.font);
		this.setBorderPainted(true);
//		this.setBounds(prevComp.getX() + prevComp.getWidth() + JoinArtistFrame.marginWidth / 2, prevComp.getY(), prevComp.getWidth(), prevComp.getHeight());
		this.setBounds(ArtistListFrame.marginWidth, ArtistListFrame.marginHeight  + 40*(artistlistnum++), 230, 35);
		this.addActionListener(new Listener());
	}

	public void setComponents() {}

	public void addComponents() {}
	
	class Listener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			mainClasses.MainController.joinArtistFrame.setVisible(false);
			mainClasses.MainController.joinArtistFrame = null;
		}
	}
}
