package changeSetting;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import interfaces.Setting;
import mainClasses.*;


public class ChangeSettingUserInfoPanel extends JPanel implements Setting {
	private JLabel[] labels = {new JLabel("Name"), new JLabel("ID"), new JLabel("PW"), new JLabel("Nickname")
								, new JLabel("Birthday"), new JLabel("Address"), new JLabel("Profile Photo"), new JLabel("E-mail")
								, new JLabel("Phone num"), new JLabel("Is Artist"), new JLabel("Alarms")};
	
	public JLabel id = new JLabel("id");
	public JTextField nameTextF = new JTextField();
	public JTextField pwTextF = new JTextField();
	public JTextField nickNameTextF = new JTextField();
	public JLabel birthday = new JLabel("birthday");
	public JTextField addressTextF = new JTextField();
	public JTextField profilePhotoTextF = new JTextField();
	public JTextField eMailTextF = new JTextField();
	public JTextField phoneNumTextF = new JTextField();
	public ChangeSettingCheckBoxPanel artistCheckB = new ChangeSettingCheckBoxPanel("yes", "no");
	public ChangeSettingCheckBoxPanel alarmCheckB = new ChangeSettingCheckBoxPanel("Email", "SMS");
	
	
	
	
	
	private Component[] fields = {nameTextF, id, pwTextF, nickNameTextF
								, birthday, addressTextF, profilePhotoTextF, eMailTextF
								, phoneNumTextF, artistCheckB, alarmCheckB};
	
	public static Font font = new Font ("Arial", Font.BOLD, ChangeSettingFrame.frameHeight / 30);
	
	private void setLabels(){
		for (JLabel label : labels) {
			label.setFont(font);
			label.setHorizontalAlignment(JLabel.LEFT);
		}
	}
	
	private void setFields() {
		for (int i = 0; i < fields.length; i++) {
			if (fields[i] instanceof JLabel)
				((JLabel)fields[i]).setText(MainController.myPageFrame.myPagePanel.myPageUserInfoPanel.infoHash.get(labels[i].getText()));
			else if (fields[i] instanceof JTextField)
				((JTextField)fields[i]).setText(MainController.myPageFrame.myPagePanel.myPageUserInfoPanel.infoHash.get(labels[i].getText()));
			else if (fields[i] instanceof ChangeSettingCheckBoxPanel){
				ChangeSettingCheckBoxPanel temp = (ChangeSettingCheckBoxPanel)fields[i];
				if (temp.one.getText().equals("yes")) {
					
					if (MainController.myPageFrame.myPagePanel.myPageUserInfoPanel.infoHash.get(labels[i].getText()).equals("true"))
						temp.one.setSelected(true);
					else
						temp.two.setSelected(true);
					
				} else {
					if (MainController.myPageFrame.myPagePanel.myPageUserInfoPanel.infoHash.get("Alarm to mail").equals("true"))
						temp.one.setSelected(true);
					
					if (MainController.myPageFrame.myPagePanel.myPageUserInfoPanel.infoHash.get("Alarm to SMS").equals("true"))
						temp.two.setSelected(true);
				}
			}
		}
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
			this.add(fields[i]);
		}
	}

}
