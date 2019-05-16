package changeSetting;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

import interfaces.Setting;

public class ChangeSettingCheckBoxPanel extends JPanel implements Setting {
	
	public JCheckBox yes = new JCheckBox("yes");
	public JCheckBox no = new JCheckBox("no");
	

	@Override
	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setLayout(new GridLayout(1,2));
		this.addComponents();
		this.setSize(this.getPreferredSize());
	}

	@Override
	public void setComponents() {}

	@Override
	public void addComponents() {
		// TODO Auto-generated method stub
		this.add(yes);
		this.add(no);
	}

}
