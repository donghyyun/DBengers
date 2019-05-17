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
	private JLabel[] labels = {new JLabel("ID: "), new JLabel("PW: "), new JLabel("Name: "),  new JLabel("Nickname: ")
								, new JLabel("Birthday: "), new JLabel("Address: "), new JLabel("Profile Photo: "), new JLabel("E-mail: ")
								, new JLabel("Phone num: "), new JLabel("Gender: "), new JLabel("Alarm: ")};
	
	public JTextField idTextF = new JTextField();
	public JPasswordField pwTextF = new JPasswordField();
	public JTextField nameTextF = new JTextField();
	public JTextField nickNameTextF = new JTextField();
	public JTextField birthdayTextF = new JTextField();
	public JTextField addressTextF = new JTextField();
	public JTextField profilePhotoTextF = new JTextField();
	public JTextField eMailTextF = new JTextField();
	public JTextField phoneNumTextF = new JTextField();
	public JoinCheckBoxPanel genderCheckB = new JoinCheckBoxPanel("Male", "Female");
	public JoinCheckBoxPanel alarmCheckB = new JoinCheckBoxPanel("Email", "SMS");
	
	private Component[] fields = {idTextF, pwTextF, nameTextF, nickNameTextF
								, birthdayTextF, addressTextF, profilePhotoTextF, eMailTextF
								, phoneNumTextF, genderCheckB, alarmCheckB};
	
	public static Font font = new Font ("Arial", Font.BOLD, JoinFrame.frameHeight / 30);
	
	private void setLabels(){
		for (JLabel label : labels) {
			label.setFont(font);
			label.setHorizontalAlignment(JLabel.LEFT);
		}
	}
	
	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setBounds(JoinFrame.frameWidth / 6, JoinFrame.frameHeight / 7, JoinFrame.frameWidth / 2, JoinFrame.frameHeight * 4 / 7);
		this.setLayout(new GridLayout(labels.length, 2));
		this.setComponents();
		this.addComponents();
		this.setSize(this.getPreferredSize());
	}

	public void setComponents() {
		// TODO Auto-generated method stub
		setLabels();
	}

	public void addComponents() {
		// TODO Auto-generated method stub
		for (int i = 0; i < labels.length; i++) {
			this.add(labels[i]);
			this.add(fields[i]);
		}
	}

}
