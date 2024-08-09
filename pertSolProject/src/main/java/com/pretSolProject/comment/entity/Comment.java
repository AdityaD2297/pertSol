package com.pretSolProject.comment.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/* 
 * This is entity class Comment which will create the table in DataBase
 */

@Entity
@Table(name = "Comment")
public class Comment {

//	We have used long instead of int cause in database schema is bigint
//	And also generating it automatically as per requirement and mapped with id to make is primary key.
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

//	Second column "by" with nullable = false to always have some string value 
	@Column(name = "by", nullable = false)
	private String by;
	
//	Third column "text" with nullable = false to always have some string value 
	@Column(name = "text", nullable = false)
	private String text;
	
//	Forth column "dateOfComment" with nullable = false to always have some string value 
	@Column(name = "dateOfComment", nullable = false)
	private LocalDateTime dateOfComment;

	
//For Variable Getter and Setters present downbelow
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBy() {
		return by;
	}

	public void setBy(String by) {
		this.by = by;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDateTime getDateOfComment() {
		return dateOfComment;
	}

	public void setDateOfComment(LocalDateTime dateOfComment) {
		this.dateOfComment = dateOfComment;
	}
	
}
