package join;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import interfaces.Setting;

import mainClasses.JoinArtistFrame;

public class JoinArtistRegisterButton extends JButton implements Setting{

	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setText("Register");
		this.setFont(JoinArtistInfoPanel.font);
		this.setBorderPainted(true);
		this.setBounds(prevComp.getX(), prevComp.getY() + prevComp.getHeight() + JoinArtistFrame.marginHeight, prevComp.getWidth() / 2, this.getFont().getSize() +  JoinArtistFrame.marginHeight);
		this.addActionListener(new Listener());
	}

	public void setComponents() {}

	public void addComponents() {}
	
	class Listener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			// SAVE ARTIST DATA TO DB!!
			
			JOptionPane.showMessageDialog(null, "Welcome to DB Melon!\n(user & artist sign-up success)", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
			mainClasses.MainController.joinArtistFrame.setVisible(false);
			mainClasses.MainController.joinArtistFrame = null;
		}
	}
}
