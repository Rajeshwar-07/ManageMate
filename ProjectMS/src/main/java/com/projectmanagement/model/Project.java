package com.projectmanagement.model;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long projectId;

	private String projectName;

	private String projectDescription;

	@Temporal(TemporalType.DATE)
	private Date startDate;

	@Temporal(TemporalType.DATE)
	private Date endDate;

	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
	@JsonManagedReference(value = "user-project")
	private List<Users> user;

	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
	@JsonManagedReference(value = "project-task")
	private List<Task> tasks;

	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
	@JsonManagedReference(value = "comment-project-task")
	private List<Comment> comment;

}
