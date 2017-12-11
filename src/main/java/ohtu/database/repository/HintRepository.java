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
	
	public Page<Hint> findAllByOrderByIdDesc(Pageable pageable);

	public Page<Hint> findByIsReadOrderByIdDesc(Boolean isRead, Pageable pageable);
	
	public Page<Hint> findDistinctByTagsInOrderByIdDesc(Set<Tag> tags, Pageable pageable);
	
	public Page<Hint> findDistinctByIsReadAndTagsInOrderByIdDesc(Boolean isRead, Set<Tag> tags, Pageable pageable);
	
	@Query(value="SELECT DISTINCT h FROM Hint h LEFT JOIN h.comments c "
			+ "WHERE LOWER(h.name) LIKE LOWER(CONCAT('%',:keyword, '%')) "
			+ "OR LOWER(c.text) LIKE LOWER(CONCAT('%',:keyword, '%'))")
    public Page<Hint> findByKeyword(@Param("keyword") String keyword, Pageable pageable);
	
	@Query(value="SELECT DISTINCT h FROM Hint h LEFT JOIN h.comments c "
			+ "WHERE (h.isRead=:isRead OR :isRead IS NULL) "
			+ "AND (:tags IS NULL OR (SELECT t FROM Tag t RIGHT JOIN t.hints th WHERE th=h) IN :tags) "
			+ "AND (LOWER(h.name) LIKE LOWER(CONCAT('%',:keyword, '%')) "		// Find By Keyword
			+ "OR LOWER(c.text) LIKE LOWER(CONCAT('%',:keyword, '%')))")			
	public Page<Hint> findByFilters(@Param("isRead") Boolean isRead, @Param("tags") Set<Tag> tags, @Param("keyword") String keyword, Pageable pageable);
	
	//public Page<Hint> findByIsReadAndTagsInAnd(boolean isRead, Set<Tag> tags, String keyword, Pageable pageable);

	public List<Hint> findByIsRead(Boolean isRead);

	
}
