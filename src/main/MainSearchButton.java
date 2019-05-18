package main;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import interfaces.Setting;
import main.MainMyPageButton.Listener;

public class MainSearchButton extends JButton implements Setting {
	
	
	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setText("Search");
		this.setFont(MainPanel.font);
		this.setBorderPainted(true);
		this.setSize(this.getPreferredSize().width, this.getFont().getSize() + MainPanel.marginHeight);
		this.setLocation(prevComp.getX() + prevComp.getWidth(), prevComp.getY());
		this.addActionListener(new Listener());
	}

	public void setComponents() {}

	public void addComponents() {}
	
	public class Listener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			try{
				mainClasses.MainController.searchFrame = new mainClasses.SearchFrame();
				mainClasses.MainController.searchFrame.setThis();
	        }catch(ArrayIndexOutOfBoundsException a){
				JOptionPane.showMessageDialog(null, "No Data!", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
	        }catch(Exception a){
				JOptionPane.showMessageDialog(null, "No Data!", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
	        }finally{}			
		}
	}
}
