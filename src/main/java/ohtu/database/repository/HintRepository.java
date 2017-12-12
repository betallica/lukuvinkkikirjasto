package ohtu.database.repository;

import java.util.List;
import java.util.Set;

import ohtu.model.Hint;
import ohtu.model.Tag;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;


@Component
public interface HintRepository extends JpaRepository<Hint, Long> {
	
	@Query(value="SELECT DISTINCT h FROM Hint h LEFT JOIN h.comments c "
			+ "WHERE (h.isRead=:isRead OR :isRead IS NULL) "
			+ "AND ((SELECT t FROM Tag t RIGHT JOIN t.hints th WHERE th=h) IN :tags OR :tags IS NULL) "
			+ "AND (LOWER(h.name) LIKE LOWER(CONCAT('%',:keyword, '%')) "		// Find By Keyword
			+ "OR LOWER(h.author) LIKE LOWER(CONCAT('%',:keyword, '%'))"
			+ "OR LOWER(c.text) LIKE LOWER(CONCAT('%',:keyword, '%'))) GROUP BY h.id ORDER BY h.id DESC")
	public Page<Hint> findByFilters(@Param("isRead") Boolean isRead, @Param("tags") Set<Tag> tags, @Param("keyword") String keyword, Pageable pageable);

	public List<Hint> findAllByOrderByIdDesc();
	
}
