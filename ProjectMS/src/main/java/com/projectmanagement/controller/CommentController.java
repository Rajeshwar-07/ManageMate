package com.projectmanagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projectmanagement.dto.CommentDto;
import com.projectmanagement.model.Comment;
import com.projectmanagement.service.CommentService;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {

	private final CommentService service;

	public CommentController(CommentService service) {
		this.service = service;
	}

	@PostMapping(name = "post", path = "/save", consumes = "application/json", produces = "application/json")
	public ResponseEntity<CommentDto> createComment(@RequestBody Comment comment, @RequestParam Long projectId,
			@RequestParam Long taskId, @RequestParam Long userId) {
		CommentDto saveComment = service.createComment(comment, projectId, taskId, userId);
		return new ResponseEntity<>(saveComment, HttpStatus.CREATED);
	}

	@GetMapping(name = "get", path = "/{commentId}")
	public ResponseEntity<CommentDto> getCommentById(@PathVariable Long commentId) {
		CommentDto getComment = service.getCommentById(commentId);
		return ResponseEntity.ok(getComment);
	}

	@GetMapping(name = "get")
	public ResponseEntity<List<CommentDto>> getCommentList() {
		List<CommentDto> commentList = service.getCommentList();
		return ResponseEntity.ok(commentList);
	}

	@DeleteMapping(name = "delete", path = "/{commentId}/delete")
	public ResponseEntity<String> deleteComment(@PathVariable Long commentId) {
		String deleteComment = service.deleteComment(commentId);
		return ResponseEntity.ok(deleteComment);
	}

	public ResponseEntity<CommentDto> updateComment(@PathVariable Long commentId, @RequestBody Comment comment) {
		CommentDto updateComment = service.updateComment(commentId, comment);
		return new ResponseEntity<CommentDto>(updateComment, HttpStatus.OK);
	}

}
