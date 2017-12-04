	package ohtu.database.dto;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * The blog hint data transfer object for communication between processes. It
 * has all required data for remote call including the blog's author and url.
 */
public class BlogHintDto extends HintDto {

    @NotEmpty(message = "Author can not be empty")
    @NotNull
    private String author;

    @NotEmpty(message = "url can not be empty")
    @NotNull
    private String url;

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
