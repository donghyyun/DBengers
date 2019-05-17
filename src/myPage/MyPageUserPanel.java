package myPage;

import java.awt.Component;

import javax.swing.JPanel;

import interfaces.Setting;
import mainClasses.MyPageFrame;

public class MyPageUserPanel extends JPanel implements Setting {
	public MyPageUserInfoPanel myPageUserInfoPanel = new MyPageUserInfoPanel();
	public MyPageUploadButton uploadButton = new MyPageUploadButton();
	public MyPageCheckButton checkButton = new MyPageCheckButton();
	public MyPagePurchaseButton purchaseButton = new MyPagePurchaseButton();
	public MyPageChangeSettingsButton changeSettingsButton = new MyPageChangeSettingsButton();
	
	public MyPageUserPanel() {this.setThis(null);}

	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setBounds(0, 0, MyPageFrame.frameWidth, MyPageFrame.frameHeight);
		this.setLayout(null);
		this.setComponents();
		this.addComponents();
	}

	public void setComponents() {
		// TODO Auto-generated method stub
		myPageUserInfoPanel.setThis(null);
		uploadButton.setThis(myPageUserInfoPanel);
		checkButton.setThis(uploadButton);
		purchaseButton.setThis(myPageUserInfoPanel);
		changeSettingsButton.setThis(myPageUserInfoPanel);
	}

	public void addComponents() {
		// TODO Auto-generated method stub
		this.add(myPageUserInfoPanel);
		this.add(uploadButton);
		this.add(checkButton);
		this.add(purchaseButton);
		this.add(changeSettingsButton);
	}
}
