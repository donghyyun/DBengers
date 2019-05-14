package login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import mainClasses.DB;

public class LogButtonActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource().toString().contains("text=Login")) {			
			if(DB.getInstance().checkLogin(mainClasses.MainController.mainFrame.logPanel.getLogInfoPanel().idTextF.getText()
							, new String(mainClasses.MainController.mainFrame.logPanel.getLogInfoPanel().pwTextF.getPassword()))) {
				
				//지울때는 항상 setVisible(false) 할
				mainClasses.MainController.mainFrame.logPanel.setVisible(false);
				mainClasses.MainController.mainFrame.remove(mainClasses.MainController.mainFrame.logPanel);
				mainClasses.MainController.mainFrame.add(mainClasses.MainController.mainFrame.mainPanel);
			
			}	
			else {
				JOptionPane.showMessageDialog(null, "Wrong ID or PW!", "WARNING", JOptionPane.ERROR_MESSAGE);
			}
				
				
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
