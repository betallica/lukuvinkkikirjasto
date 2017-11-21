package ohtu.database.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import ohtu.validation.IsbnValid;

public class BookHintDto {

    @NotEmpty
    @NotNull
    private long id;

    @NotEmpty
    @NotNull
    private String author;

    @NotEmpty
    @NotNull
    private String name;
    
    @IsbnValid
    @NotEmpty
    @NotNull
    private String isbn;
    
    public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
