package com.vitoresser.todolist.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IUserRepository extends JpaRepository<UserModel, UUID>{

  UserModel findByUsername(String username);

  @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM tb_users u WHERE u.username = :username")
  boolean existsByUsername(@Param("username") String username);
  
}
