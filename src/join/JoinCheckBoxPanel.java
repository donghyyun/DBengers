package join;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

import interfaces.Setting;

public class JoinCheckBoxPanel extends JPanel implements Setting {
	
	public JCheckBox one = new JCheckBox();
	public JCheckBox two = new JCheckBox();
	
	public JoinCheckBoxPanel(String one, String two) {
		this.one.setText(one);
		this.two.setText(two);
		this.setThis(null);
	}
	

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
		this.add(one);
		this.add(two);
	}

}
