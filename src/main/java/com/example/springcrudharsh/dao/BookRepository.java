package com.example.springcrudharsh.dao;

import com.example.springcrudharsh.entity.EmpEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<EmpEntity, Integer> {
}
