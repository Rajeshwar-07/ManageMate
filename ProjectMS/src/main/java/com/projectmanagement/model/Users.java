package com.projectmanagement.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	private String name;

	private String email;

	@OneToMany(mappedBy = "assignedTo",cascade=CascadeType.ALL)
	@JsonManagedReference(value = "user-task")
	private List<Task> tasks; 

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonManagedReference(value="user-comment")
	@JsonIgnore
	private List<Comment> comment;
	
	@ManyToOne
	@JoinColumn(name="project_id")
	@JsonBackReference(value="user-project")
	private Project project;
}
