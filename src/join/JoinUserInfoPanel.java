package join;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import interfaces.Setting;
import mainClasses.JoinFrame;

public class JoinUserInfoPanel extends JPanel implements Setting {
	private JLabel[] labels = {new JLabel("ID: "), new JLabel("PW: "), /*new JLabel("PW Check: "),*/new JLabel("Name: "),  new JLabel("Nickname: ")
								, new JLabel("Birthday: "), new JLabel("Address: "), new JLabel("Profile Photo: "), new JLabel("E-mail: ")
								, new JLabel("Phone num: "), new JLabel("Alarm: ")};
	private Component[] fields = {new JTextField(), new JPasswordField(), new JTextField(), new JTextField()
								, new JTextField(), new JTextField(), new JTextField(), new JTextField()
								, new JTextField(), new JTextField()};
	
	public static Font font = new Font ("Arial", Font.BOLD, JoinFrame.frameHeight / 30);
	
	private void setLabels(){
		for (JLabel label : labels) {
			label.setFont(font);
			label.setHorizontalAlignment(JLabel.LEFT);
		}
	}
	
	@Override
	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setBounds(JoinFrame.frameWidth / 6, JoinFrame.frameHeight / 7, JoinFrame.frameWidth / 2, JoinFrame.frameHeight * 4 / 7);
		this.setLayout(new GridLayout(labels.length, 2));
		this.setComponents();
		this.addComponents();
		this.setSize(this.getPreferredSize());
	}

	@Override
	public void setComponents() {
		// TODO Auto-generated method stub
		setLabels();
	}

	@Override
	public void addComponents() {
		// TODO Auto-generated method stub
		for (int i = 0, j = 0; i < labels.length; i++, j += 2) {
			this.add(labels[i]);
			this.add(fields[i]);
		}
	}

}
