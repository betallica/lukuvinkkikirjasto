package ohtu.model;

import javax.persistence.Entity;

/**
 * Blog hint is specific kind of hint. It contains information about the blog
 * name, author, and url.
 */
@Entity
public class BlogHint extends Hint {

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
