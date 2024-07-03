package com.projectmanagement.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.projectmanagement.dto.CommentDto;
import com.projectmanagement.model.Comment;
import com.projectmanagement.model.Project;
import com.projectmanagement.model.Task;
import com.projectmanagement.model.Users;
import com.projectmanagement.repository.CommentRepository;
import com.projectmanagement.repository.ProjectRepository;
import com.projectmanagement.repository.TaskRepository;
import com.projectmanagement.repository.UserRepository;
import com.projectmanagement.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	public static final Logger logger = LoggerFactory.getLogger(CommentServiceImpl.class);

	private final CommentRepository commentRepository;
	private final ProjectRepository projectRepository;
	private final TaskRepository taskRepository;
	private final UserRepository userRepository;

	public CommentServiceImpl(ProjectRepository projectRepository, TaskRepository taskRepository,
			CommentRepository commentRepository, UserRepository userRepository) {
		this.projectRepository = projectRepository;
		this.commentRepository = commentRepository;
		this.taskRepository = taskRepository;
		this.userRepository = userRepository;
	}

	@Override
	public CommentDto createComment(Comment comment, Long projectId, Long taskId, Long userId) {

		logger.info("Creating comment for taskId: {} , userId: {}", taskId, userId);
		Project project = findProjectById(projectId);
		Task task = findTaskById(taskId);
		Users user = findUserById(userId);

		logger.info("Retrieved project: {} , task: {} ,user: {}, ",project, task, user);
		comment.setProject(project);
		comment.setTask(task);
		comment.setUser(user);
		comment.setCreatedAt(new Date());

		Comment savedComment = commentRepository.save(comment);
		logger.info("Saved comment: {}", savedComment);
		return mapToDto(savedComment);
	}

	private Project findProjectById(Long projectId) {
		return projectRepository.findById(projectId)
				.orElseThrow(() -> new IllegalArgumentException("Project not found for ID: " + projectId));
	}

	private Task findTaskById(Long taskId) {
		return taskRepository.findById(taskId)
				.orElseThrow(() -> new IllegalArgumentException("Task not found for ID: " + taskId));
	}

	private Users findUserById(Long userId) {
		return userRepository.findById(userId)
				.orElseThrow(() -> new IllegalArgumentException("User not found for ID: " + userId));
	}

	@Override
	public CommentDto getCommentById(Long commentId) {
		Comment findComment = commentRepository.findById(commentId).get();
		return mapToDto(findComment);
	}

	@Override
	public List<CommentDto> getCommentList() {
		return commentRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
	}

	@Override
	public String deleteComment(Long commentId) {
		Optional<Comment> comment = commentRepository.findById(commentId);
		if (comment.isPresent()) {
			commentRepository.deleteById(commentId);
			return "Delete Successfully";
		}
		return null;
	}

	@Override
	public CommentDto updateComment(Long commentId, Comment updateComment) {
		Optional<Comment> comment = commentRepository.findById(commentId);
		if (comment.isPresent()) {
			Comment existingComment = comment.get();
			existingComment.setContent(updateComment.getContent());
			existingComment.setCreatedAt(updateComment.getCreatedAt());
			return mapToDto(commentRepository.save(existingComment));
		}
		return null;
	}

	private CommentDto mapToDto(Comment comment) {
		CommentDto commentDto = new CommentDto();
		commentDto.setCommentId(comment.getCommentId());
		commentDto.setContent(comment.getContent());
		commentDto.setCreatedAt(comment.getCreatedAt());
		commentDto.setProjectId(comment.getProject().getProjectId());
		commentDto.setTaskId(comment.getTask().getTaskId());
		commentDto.setUserId(comment.getUser().getUserId());
		return commentDto;
	}
}
