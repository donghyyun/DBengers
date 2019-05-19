package artistChannel;

import java.awt.Component;
import java.awt.Font;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import interfaces.Setting;
import mainClasses.ArtistChannelCommentFrame;
import mainClasses.DB;

public class ArtistChannelCommentPanel extends JPanel implements Setting{

public ArtistChannelCommentPanel() {this.setThis(null);}
	
	ArrayList<JLabel> writers = new ArrayList<JLabel>();
	ArrayList<JLabel> dates = new ArrayList<JLabel>();
	ArrayList<JLabel> likes = new ArrayList<JLabel>();
	ArrayList<JLabel> dislikes = new ArrayList<JLabel>();
	ArrayList<JLabel> comments = new ArrayList<JLabel>();
	ArrayList<String> writerName;
	ArrayList<Date> dateTime;
	ArrayList<Integer> likeNum;
	ArrayList<Integer> dislikeNum;
	ArrayList<String> commentContent;
	String currentArtistID;
	ArrayList<Integer> commentID;
	
	public void setThis(Component prevComp) {
		currentArtistID = DB.getInstance().getArtistID(ArtistChannelPanel.currentArtistName);
		commentID = DB.getInstance().getCommentID(currentArtistID);
		writerName = DB.getInstance().getCommentWriter(commentID);
		dateTime = DB.getInstance().getCommentDate(commentID);
		likeNum = DB.getInstance().getCommentLike(commentID);
		dislikeNum = DB.getInstance().getCommentDislike(commentID);
		commentContent = DB.getInstance().getCommentContent(commentID);
		this.setBounds(0, 0, ArtistChannelCommentFrame.frameWidth, (int) (ArtistChannelCommentFrame.frameHeight * 0.9));
		this.setLayout(null);
		this.setComponents();
		this.addComponents();
	}

	public void setComponents() {
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("commentID.size(): "+commentID.size());
		for(int i=0; i<commentID.size(); i++)
		{
			writers.add(new JLabel(writerName.get(i)));
			writers.get(i).setBounds((int)(ArtistChannelCommentFrame.frameWidth * 0.1), (int)(ArtistChannelCommentFrame.frameHeight * 0.05 + 70*i), 140, 35);
			String convertedDate = transFormat.format(dateTime.get(i));
			dates.add(new JLabel(convertedDate));
			dates.get(i).setBounds((int)(ArtistChannelCommentFrame.frameWidth * 0.1)+140, (int)(ArtistChannelCommentFrame.frameHeight * 0.05 + 70*i), 140, 35);
			likes.add(new JLabel(Integer.toString(likeNum.get(i))));
			likes.get(i).setBounds((int)(ArtistChannelCommentFrame.frameWidth * 0.1)+280, (int)(ArtistChannelCommentFrame.frameHeight * 0.05 + 70*i), 20, 35);
			dislikes.add(new JLabel(Integer.toString(dislikeNum.get(i))));
			dislikes.get(i).setBounds((int)(ArtistChannelCommentFrame.frameWidth * 0.1)+300, (int)(ArtistChannelCommentFrame.frameHeight * 0.05 + 70*i), 20, 35);
			comments.add(new JLabel(commentContent.get(i)));
			comments.get(i).setBounds((int)(ArtistChannelCommentFrame.frameWidth * 0.1), (int)(ArtistChannelCommentFrame.frameHeight * 0.05 +20 + 70*i), 150, 40);
		}
	}

	public void addComponents() {
		for(int i=0; i<commentID.size(); i++)
		{
			this.add(writers.get(i));
			this.add(dates.get(i));
			this.add(likes.get(i));
			this.add(dislikes.get(i));
			this.add(comments.get(i));
		}
	}
}
