package com.projectmanagement.events;

import org.springframework.context.ApplicationEvent;

@SuppressWarnings("serial")
public class ProjectDeletedEvent extends ApplicationEvent {

	private final Long projectId;

	public ProjectDeletedEvent(Object source, Long projectId) {
		super(source);
		this.projectId = projectId;

	}

	public Long getProjectId() {
		return projectId;
	}
}