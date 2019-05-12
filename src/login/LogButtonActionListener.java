package login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class LogButtonActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//System.out.println(e.getSource().toString());
		if (e.getSource().toString().contains("text=Login")) {
			System.out.println("Login button pressed");
			//mainClasses.MainFrame.my.changePanel();
		} else if (e.getSource().toString().contains("text=Join")) {
			System.out.println("Join button pressed");
			int ans = JOptionPane.showOptionDialog(null, "Do you want to sign up as a Artist?", "User type check", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
			//make question to choose user artist
			if (ans == JOptionPane.CANCEL_OPTION || ans == JOptionPane.CLOSED_OPTION)
				return;
			
			if (ans == JOptionPane.NO_OPTION) {
				mainClasses.MainController.joinFrame = new mainClasses.JoinFrame();
				mainClasses.MainController.joinFrame.setThis();
			}
				
			else
				System.out.println("Artist signup");
		}
	}
	
}
