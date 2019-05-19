package main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import interfaces.Setting;

public class MainMusicRowPanel extends JPanel implements Setting {
	
	private int rowNum;
	public int music_id;
	public JLabel[] songInfo = {new JLabel("No Data"), new JLabel("No Data"), new JLabel("No Data")};
	
	public MainMusicPlayButton play;
	public MainMusicDownloadButton download;
	public MainMusicAddToListButton add;
	
	public static Font buttonFont = new Font ("Arial", Font.BOLD, MainPanel.smallFont.getSize() * 3 / 4);
	private Font infoFont = new Font ("Arial", Font.PLAIN, MainPanel.smallFont.getSize() * 3 / 4);
	
	MainMusicRowPanel (int row) {
		this.rowNum = row;
	}
	
	public void setLabels() {
		for (JLabel l : songInfo) {
			l.setFont(infoFont);
			l.setHorizontalAlignment(JLabel.LEFT);
			l.setBorder(new LineBorder(Color.black, 1));
			l.setSize(l.getPreferredSize());
		}
	}
	
	@Override
	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setLayout(new GridLayout(1, 5));
		this.setBorder(new LineBorder(Color.black, 1));
		
		if (prevComp != null)
			this.setLocation(prevComp.getX(), prevComp.getY() + prevComp.getHeight());
		else
			this.setLocation(0, 0);
		
		this.setComponents();
		this.addComponents();
		this.setSize(this.getPreferredSize());
	}

	@Override
	public void setComponents() {
		// TODO Auto-generated method stub
		setLabels();
		
		play = new MainMusicPlayButton(rowNum);
		download = new MainMusicDownloadButton(rowNum);
		add = new MainMusicAddToListButton(rowNum);
		
		play.setThis(null);
		download.setThis(null);
		add.setThis(null);
	}

	@Override
	public void addComponents() {
		// TODO Auto-generated method stub
		for (int i = 0; i < songInfo.length; i++)
			this.add(songInfo[i]);
		
		this.add(play);
		this.add(add);
		this.add(download);
	}

}
