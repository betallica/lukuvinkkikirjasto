package ohtu.configuration;

import ohtu.database.dto.BlogHintDto;
import ohtu.database.dto.BookHintDto;
import ohtu.database.dto.HintDto;
import ohtu.model.Hint;
import ohtu.service.HintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

@Configuration
@Profile("development")
public class DevelopmentConfiguration {

    private final HintService hintService;

    @Autowired
    public DevelopmentConfiguration(HintService hintService) {
        this.hintService = hintService;
    }

    @PostConstruct
    public void createDefaultHints() {
        for (int i=1; i<25; i++) {
            hintService.createHint(createBook(i));
            hintService.createHint(createBlog(i));
        }
    }

    private HintDto createBook(int index) {
        BookHintDto book = new BookHintDto();
        book.setAuthor("Author " + index);
        book.setName("Book title " + index);
        book.setIsbn("978-951-98548-9-2");
        return book;
    }

    private HintDto createBlog(int index) {
        BlogHintDto blog = new BlogHintDto();
        blog.setAuthor("Blogger " + index);
        blog.setName("Blog title " + index);
        blog.setUrl("https://www.google.com");
        return blog;
    }

}
