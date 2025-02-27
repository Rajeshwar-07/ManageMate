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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projectmanagement.dto.TaskDto;
import com.projectmanagement.model.Task;
import com.projectmanagement.service.TaskService;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

	private final TaskService service;

	public TaskController(TaskService service) {
		this.service = service;
	}

	@PostMapping(name = "post", path = "/save", consumes = "application/json", produces = "application/json")
	public ResponseEntity<TaskDto> createTask(@RequestParam Long projectId, @RequestBody Task task,
			@RequestParam Long userId) {
		TaskDto saveTask = service.createTask(projectId, task, userId);
		if (saveTask != null) {
			return new ResponseEntity<TaskDto>(saveTask, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<TaskDto>(saveTask, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(name = "get", path = "/{taskId}")
	public ResponseEntity<TaskDto> getTaskById(@PathVariable Long taskId) {
		TaskDto getTask = service.getTaskById(taskId);
		return ResponseEntity.ok(getTask);
	}

	@GetMapping(name = "get")
	public ResponseEntity<List<TaskDto>> getTaskList() {
		List<TaskDto> getList = service.getTaskList();
		return ResponseEntity.ok(getList);
	}

	@DeleteMapping(name = "delete", path = "/{taskId}/delete")
	public ResponseEntity<String> deleteTask(@PathVariable Long taskId) {
		String deleteTask = service.deleteTask(taskId);
		return ResponseEntity.ok(deleteTask);
	}

	@PutMapping(name = "put", path = "/{taskId}/update")
	public ResponseEntity<TaskDto> updateTask(@PathVariable Long taskId, @RequestBody Task task) {
		TaskDto updateTask = service.updateTask(taskId, task);
		return new ResponseEntity<TaskDto>(updateTask, HttpStatus.OK);
	}
}
