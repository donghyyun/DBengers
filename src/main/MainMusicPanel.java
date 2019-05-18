package main;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JPanel;

import interfaces.Setting;

public class MainMusicPanel extends JPanel implements Setting {
	public static final int num = 20;
	
	public MainMusicRowPanel[] rows = new MainMusicRowPanel[20];
	
	
	@Override
	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setLayout(new GridLayout(num, 1));
		this.setComponents();
		this.addComponents();
	}

	@Override
	public void setComponents() {
		// TODO Auto-generated method stub
		rows[0] = new MainMusicRowPanel(0);
		rows[0].setThis(null);
		
		for (int i = 1; i < rows.length; i++) {
			rows[i] = new MainMusicRowPanel(i);
			rows[i].setThis(rows[i - 1]);
		}
			
	}

	@Override
	public void addComponents() {
		// TODO Auto-generated method stub
		for (MainMusicRowPanel row : rows)
			this.add(row);
	}

}
