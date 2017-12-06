package ohtu.database.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import ohtu.validation.IsbnValid;

/**
 * The book hint data transfer object for communication between processes. It
 * has all required data for remote call including the book's author and ISBN
 * number.
 */
public class BookHintDto extends HintDto {

    @NotEmpty(message = "Author can not be empty")
    @NotNull
    private String author;

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

}
