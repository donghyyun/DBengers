package join;

import java.awt.Component;

import javax.swing.JPanel;

import interfaces.Setting;
import mainClasses.JoinFrame;

public class JoinUserPanel extends JPanel implements Setting {
	private JoinUserInfoPanel userInfoPanel = new JoinUserInfoPanel();
	private JoinRegisterButton regButton = new JoinRegisterButton();
	private JoinCancelButton canButton = new JoinCancelButton();
	private JoinIdCheckButton idCheckButton = new JoinIdCheckButton();
	
	public JoinUserPanel() {this.setThis(null);}

	@Override
	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setBounds(0, 0, JoinFrame.frameWidth, JoinFrame.frameHeight);
		this.setLayout(null);
		this.setComponents();
		this.addComponents();
	}

	@Override
	public void setComponents() {
		// TODO Auto-generated method stub
		userInfoPanel.setThis(null);
		regButton.setThis(userInfoPanel);
		canButton.setThis(regButton);
		idCheckButton.setThis(userInfoPanel);
	}

	@Override
	public void addComponents() {
		// TODO Auto-generated method stub
		this.add(userInfoPanel);
		this.add(regButton);
		this.add(canButton);
		this.add(idCheckButton);
	}

}
