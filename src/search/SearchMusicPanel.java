package search;

import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import interfaces.Setting;
import main.MainMusicRowPanel;

public class SearchMusicPanel extends JPanel implements Setting {
	public static int length;
	public ArrayList<SearchMusicRowPanel> rows = new ArrayList <SearchMusicRowPanel>();
	
	public void setLength (int length) {this.length = length;}
	
	@Override
	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setLayout(new GridLayout(SearchPanel.maxLength,1));
		this.setComponents();
		this.addComponents();
	}

	@Override
	public void setComponents() {
		// TODO Auto-generated method stub
		rows.add(new SearchMusicRowPanel(0));
		rows.get(0).setThis(null);
		
		for (int i = 1; i < length; i++) {
			rows.add(new SearchMusicRowPanel(i));
			rows.get(i).setThis(rows.get(i - 1));
		}
	}

	@Override
	public void addComponents() {
		// TODO Auto-generated method stub
		for (SearchMusicRowPanel row : rows)
			this.add(row);
	}

}
