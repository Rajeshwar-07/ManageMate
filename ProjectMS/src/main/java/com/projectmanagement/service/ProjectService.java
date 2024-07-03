package com.projectmanagement.service;

import java.util.List;

import com.projectmanagement.dto.ProjectDto;
import com.projectmanagement.model.Project;

public interface ProjectService {

	public ProjectDto saveProject(Project project);

	public ProjectDto getProjectById(Long projectId);

	public List<ProjectDto> getListOfProject();

	public String deleteProject(Long projectId);

	public Project updateProject(Long projectId, Project updatedProject);

}
