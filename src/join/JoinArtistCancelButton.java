package join;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import interfaces.Setting;
import mainClasses.JoinArtistFrame;

public class JoinArtistCancelButton extends JButton implements Setting{
	
	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setText("Cancel");
		this.setFont(JoinArtistInfoPanel.font);
		this.setBorderPainted(true);
		this.setBounds(prevComp.getX() + prevComp.getWidth() + JoinArtistFrame.marginWidth / 2, prevComp.getY(), prevComp.getWidth(), prevComp.getHeight());
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
