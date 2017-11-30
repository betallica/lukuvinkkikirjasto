package ohtu.service;

import ohtu.database.dto.TagDto;
import ohtu.database.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ohtu.model.Tag;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public Tag createTag(TagDto tagDto) {
        Tag tag = new Tag();
        tag.setName(tagDto.getName());
        return tagRepository.save(tag);
    }

    public boolean tagNameExists(String name) {
        String searchName = Tag.formatName(name);
        return tagRepository.findByName(searchName) != null;
    }

    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

}
