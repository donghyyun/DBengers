package join;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import interfaces.Setting;
import mainClasses.DB;
import mainClasses.JoinArtistFrame;
import mainClasses.MainController;

public class JoinArtistRegisterButton extends JButton implements Setting{
	public static String artistId;

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
			
			
			String [] infos = {artistId,
					MainController.joinArtistFrame.joinArtistPanel.joinArtistInfoPanel.artistNameTextF.getText(), 
					MainController.joinArtistFrame.joinArtistPanel.joinArtistInfoPanel.birthdayTextF.getText(),
					MainController.joinArtistFrame.joinArtistPanel.joinArtistInfoPanel.introduceTextF.getText(),
					MainController.joinArtistFrame.joinArtistPanel.joinArtistInfoPanel.debutDateTextF.getText(),
					MainController.joinArtistFrame.joinArtistPanel.joinArtistInfoPanel.debutSongTextF.getText(),
					MainController.joinArtistFrame.joinArtistPanel.joinArtistInfoPanel.typeTextF.getText(),
					MainController.joinArtistFrame.joinArtistPanel.joinArtistInfoPanel.genderTextF.getText(),
					MainController.joinArtistFrame.joinArtistPanel.joinArtistInfoPanel.agencyTextF.getText(),
					MainController.joinArtistFrame.joinArtistPanel.joinArtistInfoPanel.nationalityTextF.getText(),
					MainController.joinArtistFrame.joinArtistPanel.joinArtistInfoPanel.constellationTextF.getText(),
					MainController.joinArtistFrame.joinArtistPanel.joinArtistInfoPanel.bloodTypeTextF.getText(),
					"0",
					MainController.joinArtistFrame.joinArtistPanel.joinArtistInfoPanel.fanclubTextF.getText(),
					MainController.joinArtistFrame.joinArtistPanel.joinArtistInfoPanel.youtubeTextF.getText(),
					MainController.joinArtistFrame.joinArtistPanel.joinArtistInfoPanel.facebookTextF.getText(),
					MainController.joinArtistFrame.joinArtistPanel.joinArtistInfoPanel.twitterTextF.getText()
			};
			DB.getInstance().insertArtistList(infos);
			
			// SAVE ARTIST DATA TO DB!!
			JOptionPane.showMessageDialog(null, "Welcome to DB Melon!\n(user & artist sign-up success)", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
			
			mainClasses.MainController.joinArtistFrame.setVisible(false);
			mainClasses.MainController.joinArtistFrame = null;
		}
	}
}
