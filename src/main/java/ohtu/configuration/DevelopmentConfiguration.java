package ohtu.configuration;

import ohtu.database.dto.BookHintDto;
import ohtu.service.BookHintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

@Configuration
@Profile("development")
public class DevelopmentConfiguration {

    private final BookHintService bookHintService;

    @Autowired
    public DevelopmentConfiguration(BookHintService bookHintService) {
        this.bookHintService = bookHintService;
    }

    @PostConstruct
    public void createDefaultHints() {
        for (int i=1; i<25; i++) {
            String author = "Author " + i;
            String title = "Title " + i;
            addBook(title, author);
        }
    }

    private void addBook(String name, String author) {
        BookHintDto book = new BookHintDto();
        book.setAuthor(author);
        book.setName(name);
        book.setIsbn("978-951-98548-9-2");
        this.bookHintService.createBookHint(book);
    }

}
