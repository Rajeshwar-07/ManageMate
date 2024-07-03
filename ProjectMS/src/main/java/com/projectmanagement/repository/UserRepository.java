package com.projectmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectmanagement.model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

}
