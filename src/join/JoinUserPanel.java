package join;

import java.awt.Component;

import javax.swing.JPanel;

import interfaces.Setting;
import mainClasses.JoinFrame;

public class JoinUserPanel extends JPanel implements Setting {
	public JoinUserInfoPanel joinUserInfoPanel = new JoinUserInfoPanel();
	public JoinRegisterButton regButton = new JoinRegisterButton();
	public JoinCancelButton canButton = new JoinCancelButton();
	public JoinIdCheckButton idCheckButton = new JoinIdCheckButton();
	
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
		joinUserInfoPanel.setThis(null);
		regButton.setThis(joinUserInfoPanel);
		canButton.setThis(regButton);
		idCheckButton.setThis(joinUserInfoPanel);
	}

	@Override
	public void addComponents() {
		// TODO Auto-generated method stub
		this.add(joinUserInfoPanel);
		this.add(regButton);
		this.add(canButton);
		this.add(idCheckButton);
	}

}
