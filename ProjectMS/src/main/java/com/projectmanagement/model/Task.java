package com.projectmanagement.model;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long taskId;

	private String taskName;

	private String taskDescription;

	private String status;

	@Temporal(TemporalType.DATE)
	private Date dueDate;

	@ManyToOne
	@JoinColumn(name = "project_id")
	@JsonBackReference(value = "project-task")
	private Project project;

	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonBackReference(value = "user-task")
	private Users assignedTo;
	
	@OneToMany(mappedBy="task")
	@JsonManagedReference(value="task-comment")
	private List<Comment> comment;

}
