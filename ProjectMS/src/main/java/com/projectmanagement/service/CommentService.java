package com.projectmanagement.service;

import java.util.List;

import com.projectmanagement.dto.CommentDto;
import com.projectmanagement.model.Comment;

public interface CommentService {
	public CommentDto createComment(Comment comment, Long projectId, Long taskId, Long userId);

	public CommentDto getCommentById(Long commentId);

	public List<CommentDto> getCommentList();

	public String deleteComment(Long commentId);

	public CommentDto updateComment(Long commentId, Comment updateComment);
}
