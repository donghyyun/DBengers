package mainClasses;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import interfaces.Setting;

public class ArtistListPanel extends JPanel implements Setting {

	public ArrayList<ArtistListButton> artistlistbuttons = new ArrayList<ArtistListButton>();
	public ArrayList<String> artistList;
	
	int numofartist;
	
	ArtistListPanel() {this.setThis(null);}
	
	@Override
	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		artistList = DB.getInstance().getArtistInfo();
//		System.out.println("setthis log");
		numofartist = artistList.size();
		ArtistListButton.artistlistnum = 0;
		this.setBounds(0, 0, ArtistListFrame.frameWidth, ArtistListFrame.frameHeight);
		this.setLayout(null);
		this.setComponents();
		this.addComponents();
	}

	@Override
	public void setComponents() {
		for(int i=0; i< numofartist ;i++)
		{	
//			System.out.println("set component log");
			artistlistbuttons.add(new  ArtistListButton());
			artistlistbuttons.get(i).setThis(this);
			artistlistbuttons.get(i).setText(artistList.get(i));
		}		
	}

	@Override
	public void addComponents() {
		// TODO Auto-generated method stub
		for(int i = 0; i < numofartist; i++) {
//			System.out.println("add component log");
			this.add(artistlistbuttons.get(i));
		}
	}
	
	
}
