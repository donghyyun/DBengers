package myPage;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import interfaces.Setting;
import mainClasses.*;

public class MyPageChangeSettingsButton extends JButton implements Setting {
	private Font font = new Font("Arial", Font.BOLD, MyPageUserInfoPanel.font.getSize() / 2);
	
	@Override
	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setText("Change Settings");
		this.setFont(MyPageUserInfoPanel.font);
		this.setBorderPainted(true);
		this.setSize(this.getPreferredSize().width, this.getFont().getSize() + MyPageFrame.marginHeight);
		this.setLocation(MyPageFrame.frameWidth - (this.getWidth() + MyPageFrame.marginWidth), prevComp.getY() - (this.getHeight() + MyPageFrame.marginHeight));
		this.addActionListener(new Listener());
	}

	@Override
	public void setComponents() {}

	@Override
	public void addComponents() {}
	
	class Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			MainController.changeSettingFrame = new ChangeSettingFrame();
		}
	}
}
