package ohtu.model;

import javax.persistence.Entity;

@Entity
public class BlogHint extends Hint {

	private String author;
	private String url;
	
	public BlogHint() {
		setType("Blog");
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
