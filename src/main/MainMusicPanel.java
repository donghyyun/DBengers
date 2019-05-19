package main;

import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import interfaces.Setting;

public class MainMusicPanel extends JPanel implements Setting {
	public static final int num = 20;
	private int length;
	public ArrayList<MainMusicRowPanel> rows = new ArrayList <MainMusicRowPanel>();
	
	public void setLength (int length) {this.length = length;}
	
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
		rows.add(new MainMusicRowPanel(0));
		rows.get(0).setThis(null);
		
		for (int i = 1; i < num; i++) {
			rows.add(new MainMusicRowPanel(i));
			rows.get(i).setThis(rows.get(i - 1));
		}
		
		for (int i = length; i < num; i++) {rows.get(i).setVisible(false);}
			
	}

	@Override
	public void addComponents() {
		// TODO Auto-generated method stub
		for (MainMusicRowPanel row : rows)
			this.add(row);
	}

}
