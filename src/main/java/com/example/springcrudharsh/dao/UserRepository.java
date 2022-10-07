package com.example.springcrudharsh.dao;

import com.example.springcrudharsh.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {
}
