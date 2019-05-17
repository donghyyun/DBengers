package voucher;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import interfaces.Setting;
import voucher.VoucherInfoPanel;

public class VoucherPanel extends JPanel implements Setting {
	public VoucherInfoPanel voucherInfoPanel = new VoucherInfoPanel();
	public VoucherCancelButton voucherCancelButton = new VoucherCancelButton();
	
	public static final int width = mainClasses.MainFrame.frameWidth;
	public static final int height = mainClasses.MainFrame.frameWidth;
	public static final int startX = width / 20;
	public static final int startY = height / 20;
	
	public static Font font = new Font ("Arial", Font.BOLD, height / 20);
	
	public static final int marginHeight = height / 20;
	public static final int marginWidth = width / 20;
	
			
	public VoucherPanel() {this.setThis(null);}
	
	@Override
	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setBounds(0, 0, width, height);
		this.setLayout(null);
		this.setComponents();
		this.addComponents();
	}

	@Override
	public void setComponents() {
		// TODO Auto-generated method stub
		voucherInfoPanel.setThis(null);
		voucherCancelButton.setThis(voucherInfoPanel);
	}

	@Override
	public void addComponents() {
		// TODO Auto-generated method stub
		this.add(voucherInfoPanel);
		this.add(voucherCancelButton);	

	}

}
