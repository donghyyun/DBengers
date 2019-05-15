package myPage;

import mainClasses.*;


import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import mainClasses.DB;
import mainClasses.MyPageFrame;

public class MyPageUploadButton extends JButton implements interfaces.Setting{
	
	
	@Override
	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setText("Upload");
		this.setFont(MyPageUserInfoPanel.font);
		this.setBorderPainted(true);
		this.setBounds(prevComp.getX(), prevComp.getY() + prevComp.getHeight() + MyPageFrame.marginHeight, MyPageFrame.buttonWidth+100, MyPageFrame.buttonHeight+10);
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
			
			JOptionPane.showMessageDialog(null, "Upload!", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
			mainClasses.MainController.myPageFrame.setVisible(false);
			mainClasses.MainController.myPageFrame = null;
		}
	}
	
}
