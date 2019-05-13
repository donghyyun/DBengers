package login;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LogPanel extends JPanel implements interfaces.Setting{
	private Font headFont = new Font ("Arial", Font.BOLD, height / 10);
	private Font buttonFont = new Font ("Arial", Font.BOLD, headFont.getSize() / 2);
	
	
	private JLabel headLabel = new JLabel("DB Melon", JLabel.CENTER);
	private LogInfoPanel logInfoPanel = new LogInfoPanel();
	private JButton loginButton = new JButton();
	private JButton joinButton = new JButton();
	
	private LogButtonActionListener actListener = new LogButtonActionListener();
	
	static final int width = mainClasses.MainFrame.frameWidth;
	static final int height = mainClasses.MainFrame.frameHeight;
	public static final int marginHeight = height / 20;
	
	final int startY = height / 5;
	
	public LogPanel() {this.setThis(null);}
	
	@Override
	public void setThis(Component prevComp) {
		this.setBounds(0, 0, LogPanel.width, LogPanel.height);
		this.setLayout(null);
		addComponents();
		setComponents();
	}
	
	@Override
	public void setComponents() {
		headLabel.setFont(headFont);
		headLabel.setForeground(new Color(105, 225, 83));
		headLabel.setSize(headLabel.getPreferredSize().width, headLabel.getPreferredSize().height);
		headLabel.setLocation(width / 2 - headLabel.getPreferredSize().width / 2, startY);
		
		logInfoPanel.setThis(headLabel);
		logInfoPanel.addComponents();
		
		loginButton.setBounds(logInfoPanel.getX(), logInfoPanel.getY() + logInfoPanel.getHeight() + 2 * marginHeight, logInfoPanel.getWidth() / 2, buttonFont.getSize() + marginHeight);
		loginButton.setBorderPainted(true);
		loginButton.addActionListener(actListener);
		loginButton.setText("Login");
		loginButton.setFont(buttonFont);
		
		joinButton.setBounds(loginButton.getX() + loginButton.getWidth(), loginButton.getY(), loginButton.getWidth(), loginButton.getHeight());
		joinButton.setBorderPainted(true);
		joinButton.addActionListener(actListener);
		joinButton.setText("Join");
		joinButton.setFont(buttonFont);
	}
	
	@Override
	public void addComponents() {
		this.add(headLabel);
		this.add(logInfoPanel);
		this.add(loginButton);
		this.add(joinButton);
	}
	
	public LogInfoPanel getLogInfoPanel() {return logInfoPanel;}
}
