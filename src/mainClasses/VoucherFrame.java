package mainClasses;
import java.awt.Toolkit;

import javax.swing.JFrame;

import voucher.VoucherPanel;

import java.awt.Window.Type;

public class VoucherFrame extends JFrame {
	public VoucherFrame() {
	}
	public static final int startX = mainClasses.MyPageFrame.startX - mainClasses.MyPageFrame.frameWidth / 2;
	public static final int startY = mainClasses.MyPageFrame.startY + mainClasses.MyPageFrame.frameHeight / 3;
	public static final int frameWidth = mainClasses.MyPageFrame.frameWidth * 4 / 3;
	public static final int frameHeight = mainClasses.MyPageFrame.frameHeight / 2;
	
	public static final int marginHeight = frameHeight / 20;
	public static final int marginWidth = frameWidth / 20;
	
	
	public VoucherPanel voucherPanel;
	
	public void setThis() {
		getContentPane().setLayout(null);
		this.setLocation(startX, startY);
		this.setSize(frameWidth, frameHeight);
		this.setVisible(true);
		voucherPanel = new VoucherPanel();
		getContentPane().add(voucherPanel);
	}
}
