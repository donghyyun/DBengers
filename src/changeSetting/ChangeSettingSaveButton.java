package changeSetting;

import mainClasses.*;


import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ChangeSettingSaveButton extends JButton implements interfaces.Setting{
	
	
	@Override
	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setText("Save");
		this.setFont(ChangeSettingUserInfoPanel.font);
		this.setBorderPainted(true);
		this.setBounds(prevComp.getX(), prevComp.getY() + prevComp.getHeight() + ChangeSettingFrame.marginHeight, prevComp.getWidth() / 2, this.getFont().getSize() +  ChangeSettingFrame.marginHeight);
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
			Object [] infos= {MainController.changeSettingFrame.changeSettingPanel.userInfoPanel.id.getText(),
					MainController.changeSettingFrame.changeSettingPanel.userInfoPanel.nameTextF.getText(),
					MainController.changeSettingFrame.changeSettingPanel.userInfoPanel.pwTextF.getText(),
					MainController.changeSettingFrame.changeSettingPanel.userInfoPanel.nickNameTextF.getText(),
					MainController.changeSettingFrame.changeSettingPanel.userInfoPanel.addressTextF.getText(),
					MainController.changeSettingFrame.changeSettingPanel.userInfoPanel.profilePhotoTextF.getText(),
					MainController.changeSettingFrame.changeSettingPanel.userInfoPanel.eMailTextF.getText(),
					MainController.changeSettingFrame.changeSettingPanel.userInfoPanel.phoneNumTextF.getText(),
					MainController.changeSettingFrame.changeSettingPanel.userInfoPanel.alarmCheckB.one.isSelected(),
					MainController.changeSettingFrame.changeSettingPanel.userInfoPanel.alarmCheckB.two.isSelected()
			};
			
			DB.getInstance().changeUserInfo(infos);
			JOptionPane.showMessageDialog(null, "Information Change Success", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
			
			MainController.changeSettingFrame.setVisible(false);
			MainController.myPageFrame.setVisible(false);
			
			MainController.changeSettingFrame = null;
			MainController.myPageFrame = null;
		}
		
	}
	
}
