package voucher;

import java.awt.Component;

import javax.swing.JPanel;

import interfaces.Setting;
import mainClasses.VoucherFrame;

public class VoucherPanel extends JPanel implements Setting {
	public VoucherInfoPanel voucherInfoPanel = new VoucherInfoPanel();
	public VoucherCancelButton cancelButton = new VoucherCancelButton();
	public VoucherBuyUnlimitButton buyUnlimitButton = new VoucherBuyUnlimitButton();
	public VoucherBuy300Button buy300Button = new VoucherBuy300Button();
	public VoucherBuy100Button buy100Button = new VoucherBuy100Button();
	
	public VoucherPanel() {this.setThis(null);}

	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setBounds(0, 0, VoucherFrame.frameWidth, VoucherFrame.frameHeight);
		this.setLayout(null);
		this.setComponents();
		this.addComponents();
	}

	public void setComponents() {
		// TODO Auto-generated method stub
		voucherInfoPanel.setThis(null);
		buyUnlimitButton.setThis(voucherInfoPanel);
		buy300Button.setThis(buyUnlimitButton);
		buy100Button.setThis(buy300Button);
		cancelButton.setThis(buyUnlimitButton);
		
	}

	public void addComponents() {
		// TODO Auto-generated method stub
		this.add(voucherInfoPanel);
		this.add(cancelButton);
		this.add(buyUnlimitButton);
		this.add(buy300Button);
		this.add(buy100Button);

	}
}
