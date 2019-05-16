package changeSetting;

import java.awt.Component;

import javax.swing.JPanel;

import interfaces.Setting;
import mainClasses.ChangeSettingFrame;

public class ChangeSettingPanel extends JPanel implements Setting {
	public ChangeSettingUserInfoPanel UserInfoPanel = new ChangeSettingUserInfoPanel();
	public ChangeSettingSaveButton saveButton = new ChangeSettingSaveButton();
	public ChangeSettingCancelButton canButton = new ChangeSettingCancelButton();
	
	public ChangeSettingPanel() {this.setThis(null);}

	@Override
	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setBounds(0, 0, ChangeSettingFrame.frameWidth, ChangeSettingFrame.frameHeight);
		this.setLayout(null);
		this.setComponents();
		this.addComponents();
	}

	@Override
	public void setComponents() {
		// TODO Auto-generated method stub
		UserInfoPanel.setThis(null);
		saveButton.setThis(UserInfoPanel);
		canButton.setThis(saveButton);
	}

	@Override
	public void addComponents() {
		// TODO Auto-generated method stub
		this.add(UserInfoPanel);
		this.add(saveButton);
		this.add(canButton);
	}
}
