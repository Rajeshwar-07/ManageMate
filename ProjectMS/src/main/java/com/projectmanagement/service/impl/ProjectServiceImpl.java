package com.projectmanagement.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.projectmanagement.dto.ProjectDto;
import com.projectmanagement.events.ProjectCreatedEvent;
import com.projectmanagement.events.ProjectDeletedEvent;
import com.projectmanagement.model.Project;
import com.projectmanagement.repository.ProjectRepository;
import com.projectmanagement.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	private final ProjectRepository repository;
	private final ApplicationEventPublisher applicationEventPublisher;

	public ProjectServiceImpl(ProjectRepository repository, ApplicationEventPublisher applicationEventPublisher) {
		this.repository = repository;
		this.applicationEventPublisher = applicationEventPublisher;
	}

	@Override
	public ProjectDto saveProject(Project project) {
		Project saveProject = repository.save(project);
		applicationEventPublisher.publishEvent(new ProjectCreatedEvent(this, project));
		return mapToDto(saveProject);
	}

	@Override
	public ProjectDto getProjectById(Long projectId) {
		Project findProject = repository.findById(projectId).get();
		return mapToDto(findProject);
	}

	@Override
	public List<ProjectDto> getListOfProject() {
		return repository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
	}

	@Override
	public String deleteProject(Long projectId) {
		Project findProject = repository.findById(projectId)
				.orElseThrow(() -> new IllegalArgumentException("Project not found"));
		if (findProject != null) {
			repository.deleteById(projectId);
			applicationEventPublisher.publishEvent(new ProjectDeletedEvent(this, projectId));
			return "Delete Successfully";
		}
		return null;
	}

	@Override
	public Project updateProject(Long projectId, Project updatedProject) {
		Project existingProject = repository.findById(projectId).get();

		if (existingProject != null) {
			existingProject.setProjectName(updatedProject.getProjectName());
			existingProject.setProjectDescription(updatedProject.getProjectDescription());
			existingProject.setStartDate(updatedProject.getStartDate());
			existingProject.setEndDate(updatedProject.getEndDate());
			repository.save(existingProject);
		}
		return null;
	}

	private ProjectDto mapToDto(Project project) {
		ProjectDto projectDto = new ProjectDto();
		projectDto.setProjectId(project.getProjectId());
		projectDto.setProjectName(project.getProjectName());
		projectDto.setProjectDescription(project.getProjectDescription());
		projectDto.setStartDate(project.getStartDate());
		projectDto.setEndDate(project.getEndDate());
		projectDto.setUser(project.getUser());
		return projectDto;
	}

}
