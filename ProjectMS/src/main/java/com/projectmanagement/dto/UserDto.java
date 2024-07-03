package com.projectmanagement.dto;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	private Long userId;

	private String name;

	private String email;

	private Long projectId;

	private List<?> tasksId;

}
