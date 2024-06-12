package com.dhiraj.repository;

import com.dhiraj.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findTopByUsername(String u);


}



