package com.projectmanagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectmanagement.dto.ProjectDto;
import com.projectmanagement.model.Project;
import com.projectmanagement.service.ProjectService;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {

	private final ProjectService service;

	public ProjectController(ProjectService service) {
		this.service = service;
	}

	@PostMapping(name = "post", path = "/save")
	public ResponseEntity<ProjectDto> createProject(@RequestBody Project project) {
		ProjectDto saveProject = service.saveProject(project);
		return new ResponseEntity<ProjectDto>(saveProject, HttpStatus.CREATED);
	}

	@GetMapping(name = "get", path = "/{projectId}")
	public ResponseEntity<ProjectDto> getProjectById(@PathVariable Long projectId) {
		ProjectDto getProjectById = service.getProjectById(projectId);
		return ResponseEntity.ok(getProjectById);
	}

	@GetMapping(name = " get")
	public ResponseEntity<List<ProjectDto>> getAllProjectList() {
		List<ProjectDto> getListOfProject = service.getListOfProject();
		return ResponseEntity.ok(getListOfProject);
	}

	@DeleteMapping(name = "delete", path = "/{projectId}/delete")
	public ResponseEntity<String> deteleProject(@PathVariable Long projectId) {
		String deleteProject = service.deleteProject(projectId);
		return ResponseEntity.ok(deleteProject);
	}

	@PutMapping(name = "put", path = "/{projectId}/update")
	public ResponseEntity<Project> updateProject(@RequestBody Project project, @PathVariable Long projectId) {
		Project updateProject = service.updateProject(projectId, project);
		return new ResponseEntity<Project>(updateProject, HttpStatus.OK);
	}
}
