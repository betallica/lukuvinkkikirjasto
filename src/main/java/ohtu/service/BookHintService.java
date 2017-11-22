package ohtu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import ohtu.database.dto.BookHintDto;
import ohtu.database.repository.BookHintRepository;
import ohtu.model.BookHint;

import java.util.List;

@Component
public class BookHintService {
	
	@Autowired
	private BookHintRepository bhRep;

	public BookHint createBookHint(BookHintDto bookHintDto) {
		BookHint bh = new BookHint();
		bh.setAuthor(bookHintDto.getAuthor());
		bh.setName(bookHintDto.getName());
		bh.setIsbn(bookHintDto.getIsbn());
		
		bhRep.save(bh);
		
		return bh;
	}

	public List<BookHint> getBookHintsInPage(int pageNumber, int numberOfHints) {
		Pageable pageable = new PageRequest(pageNumber, numberOfHints);
		Page<BookHint> pages = bhRep.findAll(pageable);
		return pages.getContent();
	}
	
}
