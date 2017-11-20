package ohtu.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import ohtu.model.BookHint;

@Component
public interface BookHintRepository extends JpaRepository<BookHint, Long>{
	
}
