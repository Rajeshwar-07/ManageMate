package com.projectmanagement.eventListener;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import com.projectmanagement.events.ProjectCreatedEvent;
import com.projectmanagement.events.ProjectDeletedEvent;

@Component
public class ProjectEventListener {

	private Logger logger = LoggerFactory.getLogger(ProjectEventListener.class);

	@Async
//	@TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
	@EventListener
	public void handleProjectCreatedEvents(ProjectCreatedEvent event) {

		logger.info("Project Created {} ", event.getProject().getProjectName());
		logger.info("Project StartDate {} ", event.getProject().getStartDate());
		logger.info("Project EndDate {} ", event.getProject().getEndDate());

	}

	@Async
	@EventListener
	public void handleProjectedDeleted(ProjectDeletedEvent event) {
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
		String formattedTime = LocalTime.now().format(timeFormatter);
		logger.info("Deleted Project ID : {}", event.getProjectId());
		logger.info("Deleted on Date : {} and Time : {}", LocalDate.now().toString(), formattedTime);
	}
}
