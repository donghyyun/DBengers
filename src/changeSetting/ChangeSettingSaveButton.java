package changeSetting;

import mainClasses.*;


import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JOptionPane;

import mainClasses.DB;

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
			
		}
	}
	
}
