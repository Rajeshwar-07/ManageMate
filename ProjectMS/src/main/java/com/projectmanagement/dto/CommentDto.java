package com.projectmanagement.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

	private Long commentId;

	private String content;

	private Date createdAt;

	private Long projectId;

	private Long taskId;

	private Long userId;
}
