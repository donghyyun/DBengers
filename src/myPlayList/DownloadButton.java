package myPlayList;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import interfaces.Setting;
import mainClasses.DB;
import mainClasses.PlayListMusicFrame;

public class DownloadButton extends JButton implements Setting{
	
	public static int numOfListen = 0;
	public int num;
	
	public void setThis(Component prevComp, int count) {
		// TODO Auto-generated method stub
		this.setText("Download");
		this.setFont(PlayListMusicPanel.font);
		this.setBorderPainted(true);
		this.setBounds(PlayListMusicFrame.frameWidth/10 + 370 +100, PlayListMusicFrame.frameHeight/10 + 40*(numOfListen++), 100, 35);
		this.addActionListener(new Listener());
		num = count;
	}

	public void setComponents() {}

	public void addComponents() {}
	
	class Listener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			DB.getInstance().addMusicDownloadnum(mainClasses.MainController.mainFrame.logPanel.getLogInfoPanel().idTextF.getText(),PlayListMusicPanel.musicNames.get(num).getText());
			//DB.getInstance().addToHistory(DB.currentID,PlayListMusicPanel.musicNames.get(num).getText());
			JOptionPane.showMessageDialog(null, "Download Done!", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	@Override
	public void setThis(Component prevComp) {}
}
