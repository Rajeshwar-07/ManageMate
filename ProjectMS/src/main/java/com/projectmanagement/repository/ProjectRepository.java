package com.projectmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectmanagement.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{

}
