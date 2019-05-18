package voucher;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import interfaces.Setting;
import mainClasses.DB;
import mainClasses.VoucherFrame;
import myPlayList.MyPlayListPanel;

public class VoucherBuy100Button extends JButton implements Setting {
	
	public static Font font = new Font ("Arial", Font.BOLD, VoucherFrame.frameHeight / 20);
	
	@Override
	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setText("Buy 100 Streaming");
		this.setFont(font);
		this.setBorderPainted(true);
		this.setBounds(prevComp.getX() +  prevComp.getWidth(), prevComp.getY(), prevComp.getWidth(), prevComp.getHeight());
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
			JOptionPane.showMessageDialog(null, "You bought 100 Streaming", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
			DB.getInstance().buy100Voucher(mainClasses.MainController.mainFrame.logPanel.getLogInfoPanel().idTextF.getText());
			mainClasses.MainController.myPageFrame.setVisible(false);
			mainClasses.MainController.myPageFrame = null;
			mainClasses.MainController.voucherFrame.setVisible(false);
			mainClasses.MainController.voucherFrame = null;

		}
	}

}
