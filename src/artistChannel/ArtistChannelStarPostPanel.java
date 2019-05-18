package artistChannel;

import java.awt.Component;
import java.awt.Font;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import interfaces.Setting;
import mainClasses.ArtistChannelMusicFrame;
import mainClasses.ArtistChannelStarPostFrame;
import mainClasses.DB;
import myPlayList.ListenButton;

public class ArtistChannelStarPostPanel extends JPanel implements Setting{
	
public ArtistChannelStarPostPanel() {this.setThis(null);}
	
	ArrayList<JLabel> titles = new ArrayList<JLabel>();
	ArrayList<JLabel> dates = new ArrayList<JLabel>();
	ArrayList<JLabel> likes = new ArrayList<JLabel>();
	ArrayList<JLabel> views = new ArrayList<JLabel>();
	ArrayList<JLabel> descripts = new ArrayList<JLabel>();
	ArrayList<Integer> starpostID;
	ArrayList<String> titleName;
	ArrayList<Date> dateTime;
	ArrayList<Integer> likeNum;
	ArrayList<Integer> viewNum;
	ArrayList<String> description;
	String currentArtistID;
	JLabel title = new JLabel("Title                           Date                           Likes     Views");
	
	ArrayList<ListenButton> listenButton = new ArrayList<ListenButton>();

	public void setThis(Component prevComp) {
		currentArtistID = DB.getInstance().getArtistID(ArtistChannelPanel.currentArtistName);
		starpostID = DB.getInstance().getStarPostID(currentArtistID);
		titleName = DB.getInstance().getStarPostTitle(starpostID);
		dateTime = DB.getInstance().getStarPostDate(starpostID);
		likeNum = DB.getInstance().getStarPostLike(starpostID);
		viewNum = DB.getInstance().getStarPostView(starpostID);
		description = DB.getInstance().getStarPostDescript(starpostID);
		this.setBounds(0, 0, ArtistChannelStarPostFrame.frameWidth, ArtistChannelStarPostFrame.frameHeight);
		this.setLayout(null);
		this.setComponents();
		this.addComponents();
	}

	public void setComponents() {
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		for(int i=0; i<starpostID.size(); i++)
		{
			titles.add(new JLabel(titleName.get(i)));
			titles.get(i).setBounds((int)(ArtistChannelStarPostFrame.frameWidth * 0.1), (int)(ArtistChannelStarPostFrame.frameHeight * 0.1 + 80*i), 140, 30);
			String convertedDate = transFormat.format(dateTime.get(i));
			dates.add(new JLabel(convertedDate));
			dates.get(i).setBounds((int)(ArtistChannelStarPostFrame.frameWidth * 0.1)+140, (int)(ArtistChannelStarPostFrame.frameHeight * 0.1 + 80*i), 140, 30);
			likes.add(new JLabel(Integer.toString(likeNum.get(i))));
			likes.get(i).setBounds((int)(ArtistChannelStarPostFrame.frameWidth * 0.1)+280, (int)(ArtistChannelStarPostFrame.frameHeight * 0.1 + 80*i), 20, 30);
			views.add(new JLabel(Integer.toString(viewNum.get(i))));
			views.get(i).setBounds((int)(ArtistChannelStarPostFrame.frameWidth * 0.1)+330, (int)(ArtistChannelStarPostFrame.frameHeight * 0.1 + 80*i), 20, 30);
			descripts.add(new JLabel(description.get(i)));
			descripts.get(i).setBounds((int)(ArtistChannelStarPostFrame.frameWidth * 0.1), (int)(ArtistChannelStarPostFrame.frameHeight * 0.1 + 15 + 80*i), 300, 50);
		}
		title.setFont(new Font("Arial", Font.BOLD, ArtistChannelStarPostFrame.frameHeight / 30));
		title.setBounds((int)(ArtistChannelStarPostFrame.frameWidth * 0.1), (int)(ArtistChannelStarPostFrame.frameHeight * 0.1)-30, 400, 40);
		
	}

	public void addComponents() {
		this.add(title);
		for(int i=0; i<starpostID.size(); i++)
		{
			this.add(titles.get(i));
			this.add(dates.get(i));
			this.add(likes.get(i));
			this.add(views.get(i));
			this.add(descripts.get(i));
		}
	}

}
