package com.projectmanagement.config;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@Configuration
public class AsyncConfig {
	
	public Executor taskExecutor() {
		return new SimpleAsyncTaskExecutor();
	}
}
