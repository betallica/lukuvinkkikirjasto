package ohtu.model;

import java.io.Serializable;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Book hint is specific kind of hint for books. It contains information about the book name, author, and ISBN
 * number.
 */
@Entity
public class BookHint extends Hint {

    private String author;
    private String isbn;

    public BookHint() {
        setType("Book");
    }

    public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
