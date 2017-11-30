package ohtu.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Tag implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique=true)
    private String name;

    @ManyToMany(mappedBy = "tags")
    private Set<Hint> hints;

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
        this.name = formatName(name);
    }

    public Set<Hint> getHints() {
        if (hints == null) {
            this.hints = new HashSet<>();
        }
        return hints;
    }

    public void setHints(Set<Hint> hints) {
        this.hints = hints;
    }

    public static String formatName(String name) {
        return name.toLowerCase().replace(" ", "");
    }

}
