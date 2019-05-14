package join;

import java.awt.Component;

import javax.swing.JPanel;

import interfaces.Setting;
import mainClasses.JoinArtistFrame;

public class JoinArtistPanel extends JPanel implements Setting{
	public JoinArtistInfoPanel joinArtistInfoPanel = new JoinArtistInfoPanel();
	public JoinArtistRegisterButton regButton = new JoinArtistRegisterButton();
	public JoinArtistCancelButton canButton = new JoinArtistCancelButton();
	
	public JoinArtistPanel() {this.setThis(null);}

	public void setThis(Component prevComp) {
		this.setBounds(0, 0, JoinArtistFrame.frameWidth, JoinArtistFrame.frameHeight);
		this.setLayout(null);
		this.setComponents();
		this.addComponents();
	}

	public void setComponents() {
		joinArtistInfoPanel.setThis(null);
		regButton.setThis(joinArtistInfoPanel);
		canButton.setThis(regButton);
	}

	public void addComponents() {
		this.add(joinArtistInfoPanel);
		this.add(regButton);
		this.add(canButton);
	}
}
