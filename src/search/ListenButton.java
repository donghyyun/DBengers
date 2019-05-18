package search;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import interfaces.Setting;
import mainClasses.DB;
import mainClasses.SearchFrame;

public class ListenButton extends JButton implements Setting{
	
	public static int numOfListen = 0;
	public int num;
	
	public void setThis(Component prevComp, int count) {
		// TODO Auto-generated method stub
		this.setText("Listen");
		this.setFont(SearchPanel.font);
		this.setBorderPainted(true);
		this.setBounds(SearchFrame.frameWidth/10 + 370, SearchFrame.frameHeight/10 + 40*(numOfListen++), 100, 35);
		this.addActionListener(new Listener());
		num = count;
	}

	public void setComponents() {}

	public void addComponents() {}
	
	class Listener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			DB.getInstance().addMusicPlaynum(DB.currentID,SearchPanel.musicNames.get(num).getText());
			DB.getInstance().addToHistory(DB.currentID, SearchPanel.musicNames.get(num).getText());
		}
	}

	@Override
	public void setThis(Component prevComp) {}
}
