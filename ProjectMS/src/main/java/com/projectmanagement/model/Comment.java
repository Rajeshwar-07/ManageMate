package com.projectmanagement.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long commentId;

	private String content;

	private Date createdAt;

	@ManyToOne
	@JoinColumn(name = "project_id")
	@JsonBackReference(value = "comment-project-task")
	private Project project;

	@ManyToOne
	@JoinColumn(name = "task_id")
	@JsonBackReference(value = "task-comment")
	private Task task;

	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonBackReference(value = "user-comment")
	private Users user;
}
