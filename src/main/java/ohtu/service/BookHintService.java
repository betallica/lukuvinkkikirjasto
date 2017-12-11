package ohtu.service;

import ohtu.database.dto.BlogHintDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ohtu.database.dto.BookHintDto;
import ohtu.database.repository.BookHintRepository;
import ohtu.model.BlogHint;
import ohtu.model.BookHint;

@Service
public class BookHintService {
	
	@Autowired
	private BookHintRepository bookHintRepository;

	public BookHint createBookHint(BookHintDto bookHintDto) {
		BookHint bh = new BookHint();
		bh.setAuthor(bookHintDto.getAuthor());
		bh.setName(bookHintDto.getName());
		bh.setIsbn(bookHintDto.getIsbn());
		bh.setType("Book");
		bh.setIsRead(false);
		bh.setTags(bookHintDto.getTags());
		bookHintRepository.save(bh);
		
		return bh;
	}
        
        public BookHint editBookHint(Long id, BookHintDto bookHintDto) {
        BookHint bh = this.getBookHint(id);
        bh.setName(bookHintDto.getName());
        bh.setAuthor(bookHintDto.getAuthor());
        bh.setIsbn(bookHintDto.getIsbn());
        bh.setTags(bookHintDto.getTags());
        bookHintRepository.save(bh);
        
        return bh;
}

	public BookHint getBookHint(Long id) {
		return bookHintRepository.findOne(id);
	}
        
	public BookHint saveBookHint(BookHint bookHint) {
            return bookHintRepository.save(bookHint);
        }
        
        public BookHintDto getBookHintDto(BookHint bookHint) {
        BookHintDto bookHintDto = new BookHintDto();
        bookHintDto.setAuthor(bookHint.getAuthor());
        bookHintDto.setIsbn(bookHint.getIsbn());
        bookHintDto.setName(bookHint.getName());
        bookHintDto.setTags(bookHint.getTags());
        return bookHintDto;
    }
	
}
