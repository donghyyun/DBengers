package search;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JPanel;

import interfaces.Setting;
import main.MainMusicRowPanel;

public class SearchMusicPanel extends JPanel implements Setting {
	public static final int num = 20;
	
	public SearchMusicRowPanel[] rows = new SearchMusicRowPanel[num];
	
	@Override
	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setLayout(new GridLayout(num,1));
		this.setComponents();
		this.addComponents();
	}

	@Override
	public void setComponents() {
		// TODO Auto-generated method stub
		rows[0] = new SearchMusicRowPanel(0);
		rows[0].setThis(null);
		
		for (int i = 1; i < rows.length; i++) {
			rows[i] = new SearchMusicRowPanel(i);
			rows[i].setThis(rows[i - 1]);
		}
	}

	@Override
	public void addComponents() {
		// TODO Auto-generated method stub
		for (SearchMusicRowPanel row : rows)
			this.add(row);
	}

}
