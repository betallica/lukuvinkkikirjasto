package ohtu.database.dto;

import javax.validation.constraints.NotNull;

import ohtu.model.Tag;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Set;
import java.util.TreeSet;

public abstract class HintDto {

	@NotNull
	@NotEmpty(message = "Name can not be empty")
	private String name;

	private String type;

	private Set<Tag> tags;

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

	public Set<Tag> getTags() {
		if (tags == null) {
			tags = new TreeSet<>();
		}
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
	
}
