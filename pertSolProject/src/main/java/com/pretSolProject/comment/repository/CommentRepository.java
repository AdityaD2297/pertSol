package com.pretSolProject.comment.repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pretSolProject.comment.entity.Comment;

/*
 * This is repository call with will hold all the required method signature for serice call
 */

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{

//	As per second requirement this is the find all the comments by username/by.
	List<Comment> findByBy(String by);
//	As per third requirement this is the find all the comments by date of comment.
	List<Comment> findByDateOfComment(LocalDateTime dateOfComment);
}
