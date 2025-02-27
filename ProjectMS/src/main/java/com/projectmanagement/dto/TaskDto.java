package com.projectmanagement.dto;

import java.sql.Date;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {

	private Long taskId;
	
	private String taskName;

	private String taskDescription;

	private String status;

	private Date dueDate;

	private Long projectId;
	
	private Long assignedUser;
	
	private List<?> comment;

}
