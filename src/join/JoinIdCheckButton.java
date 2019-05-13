package join;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import interfaces.Setting;
import mainClasses.JoinFrame;

public class JoinIdCheckButton extends JButton implements Setting {
	private Font font = new Font("Arial", Font.BOLD, JoinUserInfoPanel.font.getSize() / 2);
	
	@Override
	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setText("ID check");
		this.setFont(font);
		this.setBorderPainted(true);
		this.setBounds(prevComp.getX() + prevComp.getWidth() + JoinFrame.marginWidth / 2, prevComp.getY(), prevComp.getWidth() / 3, this.getFont().getSize() + JoinFrame.marginHeight / 2);
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
