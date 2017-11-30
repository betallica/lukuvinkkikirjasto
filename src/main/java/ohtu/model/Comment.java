package ohtu.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String text;
	
	private Date publishDate;
	
	@ManyToOne
	private Hint hint;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Hint getHint() {
		return hint;
	}

	public void setHint(Hint hint) {
		this.hint = hint;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	
	public String getFormattedDate() {
		if(publishDate == null) {
			return "N/A";
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm");
		
		return sdf.format(publishDate);
	}
	
}
