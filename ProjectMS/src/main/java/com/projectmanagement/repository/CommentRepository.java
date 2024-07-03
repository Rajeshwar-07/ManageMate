package com.projectmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectmanagement.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{

}
