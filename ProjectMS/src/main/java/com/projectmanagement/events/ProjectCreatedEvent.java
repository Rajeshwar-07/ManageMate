package com.projectmanagement.events;

import org.springframework.context.ApplicationEvent;

import com.projectmanagement.model.Project;

@SuppressWarnings("serial")
public class ProjectCreatedEvent extends ApplicationEvent {

	private final Project project;

	public ProjectCreatedEvent(Object source, Project project) {
		super(source);
		this.project = project;

	}


	public Project getProject() {
		return project;
	}

}
