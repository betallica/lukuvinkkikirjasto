package ohtu.database.repository;

import ohtu.model.BookHint;
import ohtu.model.Hint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


@Component
public interface HintRepository extends JpaRepository<Hint, Long> {
}
