package myPage;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import changeSetting.ChangeSettingCheckBoxPanel;
import interfaces.Setting;
import mainClasses.DB;
import mainClasses.JoinFrame;
import mainClasses.MainController;
import mainClasses.MyPageFrame;

public class MyPageUserInfoPanel extends JPanel implements Setting {
	
	private JLabel[] labels = {new JLabel("Name"), new JLabel("ID"), new JLabel("PW"),new JLabel("Last PW changed"),  new JLabel("Nickname")
								, new JLabel("Birthday"), new JLabel("Gender"),new JLabel("Address"), new JLabel("E-mail")
								, new JLabel("Phone num"), new JLabel("Voucher name"), new JLabel("Is Artist"), new JLabel("Alarm to mail") , new JLabel ("Alarm to SMS"), new JLabel("Streaming "), new JLabel("Download ")};
	
	public MyPageCheckBoxPanel isArtist = new MyPageCheckBoxPanel("yes", "no");
	public MyPageCheckBoxPanel alarm = new MyPageCheckBoxPanel("Email", "SMS");
	
	public Component[] fields = {new JLabel("Name"), new JLabel("ID"), new JLabel("PW"),new JLabel("Last PW changed"),  new JLabel("Nickname")
								, new JLabel("Birthday"), new JLabel("Gender"),new JLabel("Address"), new JLabel("E-mail")
								, new JLabel("Phone num"), new JLabel("Voucher name"), isArtist, alarm, new JLabel("0"), new JLabel("0")};

	public HashMap <String, String> infoHash = new HashMap <String, String>(); 
	public ArrayList<String> infos = new ArrayList<String>();
	
	public static Font font = new Font ("Arial", Font.BOLD, MyPageFrame.frameHeight / 30);
	
	private void setLabels(){
		for (JLabel label : labels) {
			label.setFont(font);
			label.setHorizontalAlignment(JLabel.LEFT);
		}
	}
	
	private void setFields() {
		infos = DB.getInstance().getUserInfo(DB.currentID);
		
		for (int i = 0; i < infos.size(); i++) {
			infoHash.put(labels[i].getText(), infos.get(i));
			System.out.println(labels[i].getText());
		}
			
		
		for (int i = 0; i < fields.length; i++) {
			if (fields[i] instanceof JLabel) {
				((JLabel)fields[i]).setText(infoHash.get(labels[i].getText()));
				((JLabel)fields[i]).setFont(font);
				((JLabel)fields[i]).setHorizontalAlignment(JLabel.CENTER);
			}
				
			else if (fields[i] instanceof MyPageCheckBoxPanel){
				MyPageCheckBoxPanel temp = (MyPageCheckBoxPanel)fields[i];
				temp.setAlignmentX(RIGHT_ALIGNMENT);
				if (temp.one.getText().equals("yes")) {
					
					if (infoHash.get(labels[i].getText()).equals("true"))
						temp.one.setSelected(true);
					else
						temp.two.setSelected(true);
					
				} else {
					if (infoHash.get("Alarm to mail").equals("true"))
						temp.one.setSelected(true);
					
					if (infoHash.get("Alarm to SMS").equals("true"))
						temp.two.setSelected(true);
				}
				
				temp.one.setEnabled(false);
				temp.two.setEnabled(false);
			}
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
		setFields();
	}

	@Override
	public void addComponents() {
		// TODO Auto-generated method stub
		for (int i = 0; i < fields.length; i++) {
			if (labels[i].getText().equals("Alarm to mail"))
				labels[i].setText("Alarm");
			if (i > 12)
				this.add(labels[i + 1]);
			else
				this.add(labels[i]);
			this.add(fields[i]);
		}
	}

}
