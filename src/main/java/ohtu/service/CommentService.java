package ohtu.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ohtu.database.dto.CommentDto;
import ohtu.database.repository.CommentRepository;
import ohtu.database.repository.HintRepository;
import ohtu.model.Comment;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private HintRepository hintRepository;
	
	public Comment createComment(CommentDto commentDto) {
		Comment comment = new Comment();
		comment.setHint(commentDto.getHint());
		comment.setText(commentDto.getText());
		comment.setPublishDate(commentDto.getPublishDate());
		
		commentRepository.save(comment);
		
		return comment;
	}
	
	public ArrayList<Comment> getCommentsForHint(long hintId) {
		return commentRepository.findByHintOrderByIdDesc(hintRepository.findOne(hintId));
	}
	
}
