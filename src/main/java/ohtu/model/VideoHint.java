package ohtu.model;

import javax.persistence.Entity;

/**
 * Video hint is specific kind of hint. It contains information about the video
 * name, author and url.
 */
@Entity
public class VideoHint extends Hint {
    
    private String author;
    private String url;

    public VideoHint() {
        setType("Video");
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
