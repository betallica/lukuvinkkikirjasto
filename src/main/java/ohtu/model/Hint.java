package ohtu.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.*;

@Entity
@Inheritance(strategy= InheritanceType.JOINED)
public abstract class Hint implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String type;
    
    protected String author;
    
    @ManyToMany
    private Set<Tag> tags;
    
    @OneToMany(mappedBy="hint")
    private List<Comment> comments;

    private boolean isRead;
    
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(boolean isRead) {
        this.isRead = isRead;
    }

    public Set<Tag> getTags() {
        if (this.tags == null) {
            this.tags = new TreeSet<>();
        }
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
