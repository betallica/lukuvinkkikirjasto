package ohtu.database.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import ohtu.model.Hint;

public class CommentDto {

	@NotNull
	@NotEmpty(message = "Et voi kommentoida tyhjää kommenttia")
	private String text;
	
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
	
}
