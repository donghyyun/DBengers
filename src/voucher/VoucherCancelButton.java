package voucher;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import interfaces.Setting;

public class VoucherCancelButton extends JButton implements Setting {

	@Override
	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setText("Cancel");
		this.setFont(VoucherPanel.font);
		this.setBorderPainted(true);
		this.setSize(this.getPreferredSize().width, this.getFont().getSize() + VoucherPanel.marginHeight);
		this.setLocation(VoucherPanel.width - (this.getWidth() + VoucherPanel.marginWidth), VoucherPanel.startY);
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
			mainClasses.MainController.myPageFrame = new mainClasses.MyPageFrame();
			mainClasses.MainController.myPageFrame.setThis();
		}
	}

}
