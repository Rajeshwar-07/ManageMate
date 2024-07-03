package com.projectmanagement.dto;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {

	private Long projectId;

	private String projectName;

	private String projectDescription;

	private Date startDate;

	private Date endDate;

	private List<?> user;

}
