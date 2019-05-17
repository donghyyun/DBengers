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
	public JoinNextButton nextButton = new JoinNextButton();
	
	public JoinUserPanel() {this.setThis(null);}
	public JoinUserPanel(int version) {this.setThis2(null);}

	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setBounds(0, 0, JoinFrame.frameWidth, JoinFrame.frameHeight);
		this.setLayout(null);
		this.setComponents();
		this.addComponents();
	}

	public void setThis2(Component prevComp) {
		// TODO Auto-generated method stub
		this.setBounds(0, 0, JoinFrame.frameWidth, JoinFrame.frameHeight);
		this.setLayout(null);
		this.setComponents();
		nextButton.setThis(joinUserInfoPanel);
		this.addComponents_withNext();
	}

	public void setComponents() {
		// TODO Auto-generated method stub
		joinUserInfoPanel.setThis(null);
		regButton.setThis(joinUserInfoPanel);
		canButton.setThis(regButton);
		idCheckButton.setThis(joinUserInfoPanel);
		nextButton.setThis(joinUserInfoPanel);
	}

	public void addComponents() {
		// TODO Auto-generated method stub
		this.add(joinUserInfoPanel);
		this.add(regButton);
		this.add(canButton);
		this.add(idCheckButton);
	}
	
	public void addComponents_withNext() {
		this.add(joinUserInfoPanel);
		this.add(nextButton);
		this.add(canButton);
		this.add(idCheckButton);
	}

}
