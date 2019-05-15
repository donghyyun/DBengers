package myPage;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import interfaces.Setting;
import mainClasses.DB;
import mainClasses.MyPageFrame;

public class MyPagePurchaseButton extends JButton implements Setting {
	private Font font = new Font("Arial", Font.BOLD, MyPageUserInfoPanel.font.getSize() / 2);
	
	@Override
	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setText("Purchase");
		this.setFont(MyPageUserInfoPanel.font);
		this.setBorderPainted(true);
		this.setBounds(prevComp.getX() + prevComp.getWidth(), prevComp.getY()+255, MyPageFrame.buttonWidth+100, MyPageFrame.buttonHeight+10);
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
