package join;

import mainClasses.*;


import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import mainClasses.DB;
import mainClasses.JoinFrame;

public class JoinRegisterButton extends JButton implements interfaces.Setting{
	
	
	@Override
	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setText("Register");
		this.setFont(JoinUserInfoPanel.font);
		this.setBorderPainted(true);
		this.setBounds(prevComp.getX(), prevComp.getY() + prevComp.getHeight() + JoinFrame.marginHeight, prevComp.getWidth() / 2, this.getFont().getSize() +  JoinFrame.marginHeight);
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
			//String birthday = String.valueOf(Integer.parseInt(MainController.joinFrame.joinUserPanel.joinUserInfoPanel.birthdayTextF.getText()) + 1);
			//birthday = birthday.substring(0, 4) + "-" + birthday.substring(4, 6) + "-" + birthday.substring(6);
			
			//String birthday = new SimpleDateFormat("yyyy-MM-dd").format(MainController.joinFrame.joinUserPanel.joinUserInfoPanel.birthdayTextF.getText());
			String [] infos = {MainController.joinFrame.joinUserPanel.joinUserInfoPanel.nameTextF.getText(), 
					MainController.joinFrame.joinUserPanel.joinUserInfoPanel.idTextF.getText(),
					new String(MainController.joinFrame.joinUserPanel.joinUserInfoPanel.pwTextF.getPassword()),
					MainController.joinFrame.joinUserPanel.joinUserInfoPanel.nickNameTextF.getText(),
					MainController.joinFrame.joinUserPanel.joinUserInfoPanel.birthdayTextF.getText(),
					MainController.joinFrame.joinUserPanel.joinUserInfoPanel.genderTextF.getText(),
					MainController.joinFrame.joinUserPanel.joinUserInfoPanel.addressTextF.getText(),
					MainController.joinFrame.joinUserPanel.joinUserInfoPanel.profilePhotoTextF.getText(),
					MainController.joinFrame.joinUserPanel.joinUserInfoPanel.eMailTextF.getText(),
					MainController.joinFrame.joinUserPanel.joinUserInfoPanel.phoneNumTextF.getText()};
			
			DB.getInstance().insertUserList(infos);
			
			JOptionPane.showMessageDialog(null, "Welcome to DB Melon!", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
			mainClasses.MainController.joinFrame.setVisible(false);
			mainClasses.MainController.joinFrame = null;
		}
	}
	
}
