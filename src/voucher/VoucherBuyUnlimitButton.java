package voucher;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import interfaces.Setting;
import mainClasses.VoucherFrame;

public class VoucherBuyUnlimitButton extends JButton implements Setting {
	
	public static Font font = new Font ("Arial", Font.BOLD, VoucherFrame.frameHeight / 20);
	
	@Override
	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setText("Buy Unlimited Streaming");
		this.setFont(font);
		this.setBorderPainted(true);
		this.setBounds(prevComp.getX(), prevComp.getY()+prevComp.getHeight(), prevComp.getWidth()/4, prevComp.getHeight()/2);
		this.addActionListener(new Listener());
	}

	@Override
	public void setComponents() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addComponents() {
		// TODO Auto-generated method stub

	}
	
	public class Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JOptionPane.showMessageDialog(null, "You bought Unlimited Streaming", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);

		}
	}

}
