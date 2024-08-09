package com.pretSolProject.comment.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pretSolProject.comment.entity.Comment;
import com.pretSolProject.comment.repository.CommentRepository;

/*
 * This is the sevice call which will use all method created in interface.
*/

@Service
public class CommentService {

//	Autowired the repository interface to use it methods. 
	@Autowired
	CommentRepository commentRepository;
	
//	As per first requirement to retrive all the commnets
	public List<Comment> getAllComments() {
		return commentRepository.findAll();
	}
	
//	As per second required to get all the comments done by any specific user
	public List<Comment> getCommentsByBy(String username) {
		return commentRepository.findByBy(username);
	}
	
//	As per third required to get all the comments done on any specific date
	public List<Comment> getCommentsbyDate(LocalDateTime date) {
		return commentRepository.findByDateOfComment(date);
	}
	
//	As per forth requirement this method to save the comment in database
	public Comment addComment(Comment comment) {
		return commentRepository.save(comment);
	}

//	As per fifth requirement this method to update the comment in database
	public Comment updateComment (Long id, Comment newComment) throws Exception {
		Optional<Comment> optional = commentRepository.findById(id);
		
		if(optional.isEmpty()) {
			throw new Exception("Comment not found by id= " + id);
		}
		Comment comment = optional.get();
		comment.setBy(newComment.getBy());
		comment.setDateOfComment(newComment.getDateOfComment());
		comment.setText(comment.getText());
		comment.setId(newComment.getId());
		return commentRepository.save(comment);
	}

//	As per sixth requirement this method to delete the comment in database
	public void deleteComment (Long id) throws Exception {	
		Optional<Comment> optional = commentRepository.findById(id);
		
		if(optional.isEmpty()) {
			throw new Exception("Comment not found by id= " + id);
		}
		
		Comment comment = optional.get();
		
		commentRepository.delete(comment);
	}
}
