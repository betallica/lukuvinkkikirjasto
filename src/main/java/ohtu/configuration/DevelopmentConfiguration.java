package ohtu.configuration;

import ohtu.database.dto.VideoHintDto;
import ohtu.database.dto.BlogHintDto;
import ohtu.database.dto.BookHintDto;
import ohtu.database.dto.HintDto;
import ohtu.database.dto.TagDto;
import ohtu.model.Tag;
import ohtu.service.HintService;
import ohtu.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Configuration
@Profile("development")
public class DevelopmentConfiguration {

    private final HintService hintService;
    private final TagService tagService;
    private final int NUM_OF_HINTS = 25;
    private final int NUM_OF_TAGS = 40;

    @Autowired
    public DevelopmentConfiguration(HintService hintService, TagService tagService) {
        this.hintService = hintService;
        this.tagService = tagService;
    }

    @PostConstruct
    public void populateDatabase() {
        createDefaultTags(NUM_OF_TAGS);
        createDefaultHints(NUM_OF_HINTS, new HashSet<>(tagService.getAllTags()));
    }

    private void createDefaultTags(int howMany) {
        for (int i = 1; i < howMany; i++) {
            TagDto tagDto = new TagDto();
            tagDto.setName("tag " + i);
            tagService.createTag(tagDto);
        }
    }

    private void createDefaultHints(int howMany, Set<Tag> tags) {
        for (int i = 1; i < howMany; i++) {
            hintService.createHint(createBook(i, tags));
            hintService.createHint(createBlog(i, tags));
            hintService.createHint(createVideo(i, tags));
        }
    }

    private HintDto createBook(int index, Set<Tag> tags) {
        BookHintDto book = new BookHintDto();
        book.setAuthor("Author " + index);
        book.setName("Book title " + index);
        book.setIsbn("978-951-98548-9-2");
        book.setTags(tags);
        return book;
    }

    private HintDto createBlog(int index, Set<Tag> tags) {
        BlogHintDto blog = new BlogHintDto();
        blog.setAuthor("Blogger " + index);
        blog.setName("Blog title " + index);
        blog.setUrl("https://www.google.com");
        blog.setTags(tags);
        return blog;
    }

    private HintDto createVideo(int index, Set<Tag> tags) {
        VideoHintDto video = new VideoHintDto();
        video.setName("Video title " + index);
        video.setAuthor("Video maker " + index);
        video.setUrl("https://www.youtube.com");
        return video;
    }

}
