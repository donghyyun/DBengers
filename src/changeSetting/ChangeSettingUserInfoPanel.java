package changeSetting;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import interfaces.Setting;
import mainClasses.ChangeSettingFrame;


public class ChangeSettingUserInfoPanel extends JPanel implements Setting {
	private JLabel[] labels = {new JLabel("ID: "), new JLabel("Name: "), new JLabel("PW: "), new JLabel("Nickname: ")
								, new JLabel("Birthday: "), new JLabel("Address: "), new JLabel("Profile Photo: "), new JLabel("E-mail: ")
								, new JLabel("Phone num: "), new JLabel("Is Artist "), new JLabel("Alarm to mail "), new JLabel("Alarm to SMS")};
	
	public JLabel id = new JLabel("id");
	public JTextField nameTextF = new JTextField();
	public JTextField pwTextF = new JTextField();
	public JTextField nickNameTextF = new JTextField();
	public JLabel birthday = new JLabel("birthday");
	public JTextField addressTextF = new JTextField();
	public JTextField profilePhotoTextF = new JTextField();
	public JTextField eMailTextF = new JTextField();
	public JTextField phoneNumTextF = new JTextField();
	
	public ChangeSettingCheckBoxPanel[] checkBoxes = {new ChangeSettingCheckBoxPanel(), 
														new ChangeSettingCheckBoxPanel(), new ChangeSettingCheckBoxPanel()};
	
	
	
	
	private Component[] fields = {id, pwTextF, nameTextF, nickNameTextF
								, birthday, addressTextF, profilePhotoTextF, eMailTextF
								,phoneNumTextF, checkBoxes[0], checkBoxes[1], checkBoxes[2]};
	
	public static Font font = new Font ("Arial", Font.BOLD, ChangeSettingFrame.frameHeight / 30);
	
	private void setLabels(){
		for (JLabel label : labels) {
			label.setFont(font);
			label.setHorizontalAlignment(JLabel.LEFT);
		}
	}
	
	private void setFields() {
		for (int i = 0; i < checkBoxes.length; i++)
			checkBoxes[i].setThis(null);
		
		//id, birthday setText();
		id.setText("ID");
		birthday.setText("BIRTHDAY");
		
	}
	
	@Override
	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setLocation(ChangeSettingFrame.frameWidth / 6, ChangeSettingFrame.frameHeight / 7);
		this.setLayout(new GridLayout(labels.length, 2));
		this.setComponents();
		this.addComponents();
		this.setSize(this.getPreferredSize());
	}

	@Override
	public void setComponents() {
		// TODO Auto-generated method stub
		setLabels();
		setFields();
	}

	@Override
	public void addComponents() {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < labels.length; i++) {
			this.add(labels[i]);
			//if (i >= labels.length - checkBoxes.length)
			//	checkBoxes[i - 9].setThis(null);
			this.add(fields[i]);
		}
	}

}
