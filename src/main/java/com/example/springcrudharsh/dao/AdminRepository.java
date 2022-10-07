package com.example.springcrudharsh.dao;

import com.example.springcrudharsh.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
}
