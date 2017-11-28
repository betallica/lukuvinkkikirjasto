package ohtu.database.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import ohtu.model.Comment;
import ohtu.model.Hint;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	
	public ArrayList<Comment> findByHintOrderByIdDesc(Hint hint);
	
}
