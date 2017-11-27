package ohtu.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ohtu.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
