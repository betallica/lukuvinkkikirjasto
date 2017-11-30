package ohtu.database.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import ohtu.model.Hint;

public class CommentDto {

	@NotNull
	@NotEmpty(message = "Et voi kommentoida tyhjää kommenttia")
	private String text;
	
	private Date publishDate;
	
	private Hint hint;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Hint getHint() {
		return hint;
	}

	public void setHint(Hint hint) {
		this.hint = hint;
	}
	
}
