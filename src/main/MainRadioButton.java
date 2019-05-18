package main;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import interfaces.Setting;

public class MainRadioButton extends JButton implements Setting {

	@Override
	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setText("Radio");
		this.setFont(MainPanel.font);
		this.setBorderPainted(true);
		this.setSize(this.getPreferredSize().width, prevComp.getSize().height);
		this.setLocation(prevComp.getX() + prevComp.getWidth(), prevComp.getY());
		this.addActionListener(new Listener());
	}

	@Override
	public void setComponents() {}

	@Override
	public void addComponents() {}
	
	// top 6 tags selected from hashtagnames table
	// sql : select name from HashtagNames order by cnt desc limit 6;
	// samples : 
	String tags [] = {"travel", "game", "study", "workout", "summer", "random"};
	Scanner scn = new Scanner(System.in);
	int choice = 0;
	
	
	public class Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JOptionPane.showMessageDialog(null, "RadioButton Presses", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
			//mainClasses.MainController.artistlistframe = new mainClasses.ArtistListFrame();
			//mainClasses.MainController.artistlistframe.setThis();
			System.out.println("== PlayLists with Hashtags ===");
			for(int i = 0; i < tags.length; i++) {
				
				System.out.println(i+1 + ". " + tags[i]);
			}
			System.out.println("select hashtag you want : ");
			choice = scn.nextInt();
			
			switch(choice) {
			case 1 :
				System.out.println(tags[choice-1]);
				break;
			case 2 :
				System.out.println(tags[choice-1]);
				break;
			case 3:
				System.out.println(tags[choice-1]);
				break;
			case 4 :
				System.out.println(tags[choice-1]);
				break;
			case 5 :
				System.out.println(tags[choice-1]);
				break;
			case 6 :
				System.out.println(tags[choice-1]);
				break;
			}
			
		}
	}

}
