package ohtu.database.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import ohtu.validation.IsbnValid;

/**
 * The book hint data transfer object for communication between processes. Has all required data for remote 
 * call.
 */
public class BookHintDto {

    @NotEmpty(message = "Author can not be empty")
    @NotNull
    private String author;

    @NotEmpty(message = "Name can not be empty")
    @NotNull
    private String name;
    
    @IsbnValid
    private String isbn;
    
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
