package ohtu.database.dto;

import ohtu.validation.TagNameUnique;

public class TagDto {

    @TagNameUnique
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
