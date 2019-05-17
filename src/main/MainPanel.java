package main;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import interfaces.Setting;

public class MainPanel extends JPanel implements Setting {
	public JLabel rank = new JLabel("Rank", JLabel.LEFT);
	public JTextField searchTextF = new JTextField();
	public MainSearchButton searchButton = new MainSearchButton();
	public MainMyPlayListButton myPlayListButton = new MainMyPlayListButton();
	public MainMyPageButton myPageButton = new MainMyPageButton();
	
	public MainAllButton allButton = new MainAllButton();
	public MainGenreButton genreButton = new MainGenreButton();
	public MainLikeButton likeButton = new MainLikeButton();
	public MainDateButton dateButton = new MainDateButton();
	public MainArtistButton artistButton = new MainArtistButton();
	
	public JScrollPane scroll = new JScrollPane();
	
	public static final int width = mainClasses.MainFrame.frameWidth;
	public static final int height = mainClasses.MainFrame.frameWidth;
	public static final int startX = width / 20;
	public static final int startY = height / 20;
	
	public static Font font = new Font ("Arial", Font.BOLD, height / 20);
	
	
	
	public static final int marginHeight = height / 20;
	public static final int marginWidth = width / 20;
	
	public static final int rankButtonWidth = (width - (2 * marginWidth)) / 4;
			
	public MainPanel() {this.setThis(null);}
	
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
		
		searchTextF.setLocation(startX, myPlayListButton.getY() + myPlayListButton.getHeight() + marginHeight * 3);
		searchTextF.setSize(myPlayListButton.getWidth() + myPageButton.getWidth(), font.getSize() + marginHeight);
		searchButton.setThis(searchTextF);
		
		artistButton.setThis(searchTextF);
		
		rank.setFont(font);
		rank.setSize(rank.getPreferredSize());
		rank.setLocation(searchTextF.getX(), searchTextF.getY() + searchTextF.getHeight() + marginHeight * 2);
		
		allButton.setThis(rank);
		genreButton.setThis(allButton);
		likeButton.setThis(genreButton);
		dateButton.setThis(likeButton);
	}

	public void addComponents() {
		// TODO Auto-generated method stub
		this.add(myPlayListButton);
		this.add(myPageButton);
		this.add(searchTextF);
		this.add(searchButton);
		this.add(rank);
		this.add(allButton);
		this.add(genreButton);
		this.add(likeButton);
		this.add(dateButton);
		this.add(artistButton);
	}

}
