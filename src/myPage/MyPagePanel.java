package myPage;

import java.awt.Component;

import javax.swing.JPanel;

import interfaces.Setting;
import mainClasses.MyPageFrame;

public class MyPagePanel extends JPanel implements Setting {
	public MyPageUserInfoPanel myPageUserInfoPanel = new MyPageUserInfoPanel();
	public MyPageUploadButton uploadButton = new MyPageUploadButton();
	public MyPageCheckButton checkButton = new MyPageCheckButton();
	public MyPagePurchaseButton purchaseButton = new MyPagePurchaseButton();
	public MyPageChangeSettingsButton changeSettingsButton = new MyPageChangeSettingsButton();
	
	public MyPagePanel() {this.setThis(null);}

	@Override
	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setBounds(0, 0, MyPageFrame.frameWidth, MyPageFrame.frameHeight);
		this.setLayout(null);
		this.setComponents();
		this.addComponents();
	}

	@Override
	public void setComponents() {
		// TODO Auto-generated method stub
		myPageUserInfoPanel.setThis(null);
		purchaseButton.setThis(myPageUserInfoPanel);
		checkButton.setThis(purchaseButton);
		uploadButton.setThis(checkButton);
		changeSettingsButton.setThis(myPageUserInfoPanel);
	}

	@Override
	public void addComponents() {
		// TODO Auto-generated method stub
		this.add(myPageUserInfoPanel);
		this.add(uploadButton);
		this.add(checkButton);
		this.add(purchaseButton);
		this.add(changeSettingsButton);
	}
}
