package com.dhiraj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dhiraj.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByEmail(String email);
	
	@Query("SELECT DISTINCT u FROM User u WHERE u.fullName LIKE %:query% OR u.email LIKE %:query%")
	 List<User> searchUser(@Param("query") String query);


	void deleteById(long id);


	@Query("SELECT u.location, COUNT(u) FROM User u GROUP BY u.location")
	List<Object> findLocationCounts();

	User getFirstByEmailContainingIgnoreCase(String email);




}
