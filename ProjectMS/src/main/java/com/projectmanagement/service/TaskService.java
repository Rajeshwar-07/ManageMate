package com.projectmanagement.service;

import java.util.List;

import com.projectmanagement.dto.TaskDto;
import com.projectmanagement.model.Task;

public interface TaskService {

	public TaskDto createTask(Long projectId, Task task, Long userId);

	public TaskDto getTaskById(Long taskId);

	public List<TaskDto> getTaskList();

	public String deleteTask(Long taskId);

	public TaskDto updateTask(Long taskId, Task updatedTask);
}