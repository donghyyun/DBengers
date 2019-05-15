package join;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import interfaces.Setting;
import mainClasses.JoinArtistFrame;

public class JoinArtistInfoPanel extends JPanel implements Setting{

	private JLabel[] labels = {new JLabel("Artist name: "), new JLabel("Birthday: "), new JLabel("Introduce: "),  new JLabel("Debut date: ")
			, new JLabel("Debut song: "), new JLabel("Type: "), new JLabel("Gender: "), new JLabel("Agency: "), new JLabel("Nationality: ")
			, new JLabel("Constellation: "), new JLabel("Blood type: "), new JLabel("Fanclub: "), new JLabel("Youtube: ")
			, new JLabel("Facebook: "), new JLabel("Twitter: ")};

	public JLabel typeLabel = new JLabel("Solo/Group");
	public JLabel genderLabel = new JLabel("(M)ale/(F)emale");
	public JLabel bloodTypeLabel = new JLabel("A/B/O/AB");
	public JLabel fanclubLabel = new JLabel("URL");
	public JLabel youtubeLabel = new JLabel("URL");
	public JLabel facebookLabel = new JLabel("URL");
	public JLabel twitterLabel = new JLabel("URL");
	
	public JTextField artistNameTextF = new JTextField();
	public JTextField birthdayTextF = new JTextField();
	public JTextField introduceTextF = new JTextField();
	public JTextField debutDateTextF = new JTextField();
	public JTextField debutSongTextF = new JTextField();
	public JTextField typeTextF = new JTextField();
	public JTextField genderTextF = new JTextField();
	public JTextField agencyTextF = new JTextField();
	public JTextField nationalityTextF = new JTextField();
	public JTextField constellationTextF = new JTextField();
	public JTextField bloodTypeTextF = new JTextField();
	public JTextField fanclubTextF = new JTextField();
	public JTextField youtubeTextF = new JTextField();
	public JTextField facebookTextF = new JTextField();
	public JTextField twitterTextF = new JTextField();
	
	
	private Component[] fields = {artistNameTextF,birthdayTextF,introduceTextF,debutDateTextF,debutSongTextF,typeTextF,genderTextF,agencyTextF,nationalityTextF
			,constellationTextF,bloodTypeTextF,fanclubTextF,youtubeTextF,facebookTextF,twitterTextF};
	
	public static Font font = new Font ("Arial", Font.BOLD, JoinArtistFrame.frameHeight / 40);
	public static Font font2 = new Font ("Arial", Font.PLAIN, JoinArtistFrame.frameHeight / 60);

	
	private void setLabels(){
		for (JLabel label : labels) {
		label.setFont(font);
		label.setHorizontalAlignment(JLabel.LEFT);
		}
		typeLabel.setFont(font2);
		typeLabel.setHorizontalAlignment(JLabel.LEFT);
		genderLabel.setFont(font2);
		genderLabel.setHorizontalAlignment(JLabel.LEFT);
		bloodTypeLabel.setFont(font2);
		bloodTypeLabel.setHorizontalAlignment(JLabel.LEFT);
		fanclubLabel.setFont(font2);
		fanclubLabel.setHorizontalAlignment(JLabel.LEFT);
		youtubeLabel.setFont(font2);
		youtubeLabel.setHorizontalAlignment(JLabel.LEFT);
		facebookLabel.setFont(font2);
		facebookLabel.setHorizontalAlignment(JLabel.LEFT);
		twitterLabel.setFont(font2);
		twitterLabel.setHorizontalAlignment(JLabel.LEFT);
	}
	
	
	public void setThis(Component prevComp) {
		this.setBounds(JoinArtistFrame.frameWidth / 6, JoinArtistFrame.frameHeight / 7, JoinArtistFrame.frameWidth / 2, JoinArtistFrame.frameHeight * 4 / 7);
		this.setLayout(new GridLayout(labels.length, 2));
		this.setComponents();
		this.addComponents();
		this.setSize(this.getPreferredSize());
	}

	public void setComponents() {
		setLabels();
		
	}

	public void addComponents() {
		for (int i = 0; i < labels.length; i++) {
			this.add(labels[i]);
			this.add(fields[i]);
			if(i==5)
				this.add(typeLabel);
			else if(i==6)
				this.add(genderLabel);
			else if(i==10)
				this.add(bloodTypeLabel);
			else if(i==12)
				this.add(fanclubLabel);
			else if(i==13)
				this.add(youtubeLabel);
			else if(i==14)
				this.add(facebookLabel);
			else if(i==15)
				this.add(twitterLabel);
			else
				this.add(new JLabel(" "));
		}
	}

}
