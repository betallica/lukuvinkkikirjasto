package ohtu.service;

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
		
		bookHintRepository.save(bh);
		
		return bh;
	}

	public BookHint getBookHint(Long id) {
		return bookHintRepository.findOne(id);
	}
        
        public BookHint saveBookHint(BookHint bookHint) {
            return bookHintRepository.save(bookHint);
        }
	
}
