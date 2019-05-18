package main;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import interfaces.Setting;

public class MainPanel extends JPanel implements Setting {
	
	public JTextField searchTextF = new JTextField();
	public MainSearchButton searchButton = new MainSearchButton();
	public MainMyPlayListButton myPlayListButton = new MainMyPlayListButton();
	public MainMyPageButton myPageButton = new MainMyPageButton();
	
	public MainStarButton starButton = new MainStarButton();
	public MainRadioButton radioButton = new MainRadioButton(); 
	
	public JLabel music = new JLabel("MUSIC", JLabel.LEFT);
	
	public JLabel genre = new JLabel("Genre", JLabel.LEFT);
	public MainHiphopButton hiphop = new MainHiphopButton();
	public MainRnBButton rnb = new MainRnBButton();
	public MainBaladButton balad = new MainBaladButton();
	public MainPopButton pop = new MainPopButton();
	
	
	
	public JLabel rank = new JLabel("Rank", JLabel.LEFT);
	public MainAllButton allButton = new MainAllButton();
	public MainPlayNumButton playNumButton = new MainPlayNumButton();
	public MainDownloadNumButton downlaodNumButton = new MainDownloadNumButton();
	public MainDateButton dateButton = new MainDateButton();
	
	
	public MainMusicPanel musicPanel = new MainMusicPanel();
	public JScrollPane scroll;
	
	public static final int width = mainClasses.MainFrame.frameWidth;
	public static final int height = mainClasses.MainFrame.frameHeight;
	public static final int startX = width / 20;
	public static final int startY = height / 30;
	
	public static Font font = new Font ("Arial", Font.BOLD, height / 30);
	public static Font smallFont = new Font ("Arial", Font.BOLD, height / 40);
	
	
	
	public static final int marginHeight = height / 30;
	public static final int marginWidth = width / 20;
			
	public MainPanel() {this.setThis(null);}
	
	private void setLabels() {
		genre.setFont(smallFont);
		genre.setSize(genre.getPreferredSize());
		genre.setLocation(startX, hiphop.getY() + music.getHeight() / 2);
		
		rank.setFont(smallFont);
		rank.setSize(rank.getPreferredSize());
		rank.setLocation(startX, genre.getY() + hiphop.getHeight());
	}
	
	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setBounds(0, 0, width, height);
		this.setLayout(null);
		this.setComponents();
		this.addComponents();
	}

	public void setComponents() {
		// TODO Auto-generated method stub
		myPlayListButton.setThis(this);
		myPageButton.setThis(null);
		
		searchTextF.setLocation(startX, myPlayListButton.getY() + myPlayListButton.getHeight() + marginHeight * 2);
		searchTextF.setSize(myPlayListButton.getWidth() + myPageButton.getWidth(), font.getSize() + marginHeight);
		searchButton.setThis(searchTextF);
		
		starButton.setThis(searchTextF);
		radioButton.setThis(starButton);
		
		music.setFont(smallFont);
		music.setSize(music.getPreferredSize());
		music.setLocation(starButton.getX(), starButton.getY() + starButton.getHeight() + marginHeight);
		
		hiphop.setThis(music);
		rnb.setThis(hiphop);
		balad.setThis(rnb);
		pop.setThis(balad);
		
		setLabels();
		
		allButton.setThis(hiphop);
		playNumButton.setThis(allButton);
		downlaodNumButton.setThis(playNumButton);
		dateButton.setThis(downlaodNumButton);
		
		musicPanel.setThis(allButton);
		scroll = new JScrollPane(musicPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setLocation(marginWidth, allButton.getY() + allButton.getHeight());
		scroll.setSize(width - 2 * marginWidth, height - (scroll.getY() + 2 * marginHeight));
		
		scroll.setVisible(false);
	}

	public void addComponents() {
		// TODO Auto-generated method stub
		this.add(myPlayListButton);
		this.add(myPageButton);
		
		this.add(searchTextF);
		this.add(searchButton);
		
		this.add(starButton);
		this.add(radioButton);
		
		this.add(music);
		this.add(rank);
		this.add(genre);
		
		this.add(hiphop);
		this.add(rnb);
		this.add(balad);
		this.add(pop);
		
		this.add(allButton);
		this.add(playNumButton);
		this.add(downlaodNumButton);
		this.add(dateButton);
		
		this.add(scroll);
	}

}
