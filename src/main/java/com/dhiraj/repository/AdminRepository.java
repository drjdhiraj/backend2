package com.dhiraj.repository;

import com.dhiraj.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findAdminByUsername(String u);
}
