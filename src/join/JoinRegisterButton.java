package join;

import mainClasses.*;


import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class JoinRegisterButton extends JButton implements interfaces.Setting{
	
	private String pwd = System.getProperty("user.dir");
	
	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setText("Register");
		this.setFont(JoinUserInfoPanel.font);
		this.setBorderPainted(true);
		this.setBounds(prevComp.getX(), prevComp.getY() + prevComp.getHeight() + JoinFrame.marginHeight, prevComp.getWidth() / 2, this.getFont().getSize() +  JoinFrame.marginHeight);
		this.addActionListener(new Listener());
	}

	public void setComponents() {}

	public void addComponents() {}
	
	class Listener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			String gender = MainController.joinFrame.joinUserPanel.joinUserInfoPanel.genderCheckB.one.isSelected()? "M" : "F";
			
			Object [] infos = {MainController.joinFrame.joinUserPanel.joinUserInfoPanel.nameTextF.getText(), 
					MainController.joinFrame.joinUserPanel.joinUserInfoPanel.idTextF.getText(),
					new String(MainController.joinFrame.joinUserPanel.joinUserInfoPanel.pwTextF.getPassword()),
					MainController.joinFrame.joinUserPanel.joinUserInfoPanel.nickNameTextF.getText(),
					MainController.joinFrame.joinUserPanel.joinUserInfoPanel.birthdayTextF.getText(),
					gender,
					MainController.joinFrame.joinUserPanel.joinUserInfoPanel.addressTextF.getText(),
					MainController.joinFrame.joinUserPanel.joinUserInfoPanel.eMailTextF.getText(),
					MainController.joinFrame.joinUserPanel.joinUserInfoPanel.phoneNumTextF.getText(),
					MainController.joinFrame.joinUserPanel.joinUserInfoPanel.alarmCheckB.one.isSelected(),
					MainController.joinFrame.joinUserPanel.joinUserInfoPanel.alarmCheckB.two.isSelected(),
					pwd+ "/img/" +MainController.joinFrame.joinUserPanel.joinUserInfoPanel.profilePhotoTextF.getText()+".jpg"
					};
			
			DB.getInstance().insertUserList(infos);
			
			JOptionPane.showMessageDialog(null, "Welcome to DB Melon!", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
			mainClasses.MainController.joinFrame.setVisible(false);
			mainClasses.MainController.joinFrame = null;
		}
	}
	
}
