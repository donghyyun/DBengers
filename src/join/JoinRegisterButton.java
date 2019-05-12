package join;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

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
			//register new 'user' in db
		}
	}
	
}
