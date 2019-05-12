package join;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import interfaces.Setting;
import join.JoinRegisterButton.Listener;
import mainClasses.JoinFrame;

public class JoinCancelButton extends JButton implements Setting {

	@Override
	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setText("Cancel");
		this.setFont(JoinUserInfoPanel.font);
		this.setBorderPainted(true);
		this.setBounds(prevComp.getX() + prevComp.getWidth() + JoinFrame.marginWidth / 2, prevComp.getY(), prevComp.getWidth(), prevComp.getHeight());
		this.addActionListener(new Listener());
	}

	@Override
	public void setComponents() {}

	@Override
	public void addComponents() {}
	
	class Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			mainClasses.MainController.joinFrame.setVisible(false);
			mainClasses.MainController.joinFrame = null;
		}
	}
}
