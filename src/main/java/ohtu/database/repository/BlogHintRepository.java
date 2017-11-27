package ohtu.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import ohtu.model.BlogHint;

@Component
public interface BlogHintRepository extends JpaRepository<BlogHint, Long> {

}
