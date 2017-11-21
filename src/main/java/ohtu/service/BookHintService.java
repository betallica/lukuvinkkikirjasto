package ohtu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ohtu.database.dto.BookHintDto;
import ohtu.database.repository.BookHintRepository;
import ohtu.model.BookHint;

@Component
public class BookHintService {
	
	@Autowired
	private BookHintRepository bhRep;

	public BookHint createBookHint(BookHintDto bookHintDto) {
		BookHint bh = new BookHint();
		bh.setAuthor(bookHintDto.getAuthor());
		bh.setName(bookHintDto.getName());
		
		bhRep.save(bh);
		
		return bh;
	}
}
