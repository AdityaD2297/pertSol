package com.pretSolProject.comment.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pretSolProject.comment.entity.Comment;
import com.pretSolProject.comment.service.CommentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



/*
 * This is Controller class which will help to perform CURD opertion on data using Api's and CommentServices
 */

//As per isnstructions mapping /api/v2/comments
@RestController
@RequestMapping("/api/v2/comments")

public class CommetController {
	
	@Autowired 
	CommentService commentService;
	
//	As per fist requirement retrieving all comments
	@GetMapping
	public List<Comment> gerAllComments(){
		return commentService.getAllComments();
	}
	
//	As per second and third requirement retrieving comments by username.
	@GetMapping("/search/username")
	public List<Comment> searchComments(@RequestParam String by){
		if(by != null) {
			return commentService.getCommentsByBy(by);
		}
		return commentService.getAllComments();
	}

//	As per third requirement retrieving comments by date.
	@GetMapping("/search/date")
	public List<Comment> searchComments(@RequestParam LocalDateTime date){
		if(date != null) {
			return commentService.getCommentsbyDate(date);
		}
		return commentService.getAllComments();
	}
	
//	As per forth requirement adding a comment into database.
	@PostMapping
	public Comment createComment(@RequestBody Comment comment) {
		return commentService.addComment(comment);
	}
	
//	As per fifth requirement updating a comment into database.
	@PutMapping("/{id}")
	public Comment putMethodName(@PathVariable Long id, @RequestBody Comment comment) throws Exception {
				
		return commentService.updateComment(id, comment);
	}

//	As per sixth requirement deleting a comment into database.	
	@DeleteMapping("/{id}")
	public  ResponseEntity<?> deleteComment(@PathVariable Long id) throws Exception{
		commentService.deleteComment(id);
		return ResponseEntity.ok().build();
	}
	
}
