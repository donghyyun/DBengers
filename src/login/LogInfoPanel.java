package login;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LogInfoPanel extends JPanel implements interfaces.Setting{
	private JLabel idLabel = new JLabel("ID:  ");
	private JLabel pwLabel = new JLabel("Password:  ");
	public JTextField idTextF = new JTextField();
	public JPasswordField pwTextF = new JPasswordField();
	
	public void setThis(Component prevComp) {
		this.setLayout(new GridLayout(2,2));
		this.setBounds(prevComp.getX(), prevComp.getY() + prevComp.getHeight() + 2 * LogPanel.marginHeight, prevComp.getWidth(), prevComp.getHeight());
	}
	
	public void setComponents() {}
	
	public void addComponents() {
		this.add(idLabel);
		this.add(idTextF);
		this.add(pwLabel);
		this.add(pwTextF);
	}
}
