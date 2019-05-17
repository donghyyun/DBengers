package voucher;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import interfaces.Setting;
import mainClasses.DB;
import mainClasses.JoinFrame;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class VoucherInfoPanel extends JPanel implements Setting {
	
	//public JLabel[]labels = {new JLabel("voucher_name"), new JLabel("voucher_price"), new JLabel("download_num"),new JLabel("streaming_num")};
	public JLabel[][]dblabels = new JLabel [3][4];
	public VoucherBuyButton voucherbuyButton = new VoucherBuyButton();

	public static Font font = new Font ("Arial", Font.BOLD, JoinFrame.frameHeight / 30);
	
	private void setDbLabels() {
		ArrayList<String> infos = new ArrayList<String>();
		
		infos = DB.getInstance().voucherInfo();
		
		for (int i = 0; i < dblabels.length; i++) {
			for(int j = 0; j < dblabels[0].length; j++) {
				dblabels[i][j].setText(infos.get(i));
				dblabels[i][j].setFont(font);
				dblabels[i][j].setHorizontalAlignment(JLabel.LEFT);
			}
		}
	}
	
	@Override
	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setBounds(JoinFrame.frameWidth / 6, JoinFrame.frameHeight / 7, JoinFrame.frameWidth / 2, JoinFrame.frameHeight * 4 / 7);
		this.setLayout(new GridLayout(dblabels.length, 2));
		this.setComponents();
		this.addComponents();
		this.setSize(this.getPreferredSize());
	}

	@Override
	public void setComponents() {
		// TODO Auto-generated method stub
		setDbLabels();
		//voucherbuyButton.setThis(null);
	}

	@Override
	public void addComponents() {
		// TODO Auto-generated method stub
		for (int i = 0; i < dblabels.length; i++) {
			for(int j = 0; j < dblabels[0].length; j++) {
				this.add(dblabels[i][j]);
			}
		}
	}

}
