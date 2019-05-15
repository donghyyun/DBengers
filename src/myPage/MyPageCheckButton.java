package myPage;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import interfaces.Setting;
import mainClasses.MyPageFrame;

public class MyPageCheckButton extends JButton implements Setting {

	@Override
	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setText("Check");
		this.setFont(MyPageUserInfoPanel.font);
		this.setBorderPainted(true);
		this.setBounds(prevComp.getX() + MyPageFrame.buttonWidth +100, prevComp.getY(), MyPageFrame.buttonWidth+100, MyPageFrame.buttonHeight+10);
		this.addActionListener(new Listener());
	}

	@Override
	public void setComponents() {}

	@Override
	public void addComponents() {}
	
	class Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			mainClasses.MainController.myPageFrame.setVisible(false);
			mainClasses.MainController.myPageFrame = null;
		}
	}
}