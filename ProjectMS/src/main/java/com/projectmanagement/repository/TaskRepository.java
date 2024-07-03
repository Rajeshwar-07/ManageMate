package com.projectmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectmanagement.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
