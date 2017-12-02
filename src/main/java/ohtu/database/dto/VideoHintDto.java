package ohtu.database.dto;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;


public class VideoHintDto extends HintDto {
    
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
