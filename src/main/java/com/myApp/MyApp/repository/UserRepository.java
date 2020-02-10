package com.myApp.MyApp.repository;

import org.springframework.stereotype.Repository;
import com.myApp.MyApp.Model.UserEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long>{
	
	@Query("select u from UserEntity u where u.email = :email")
	public UserEntity findUserByEmail(@Param("email") String email);
}
