package com.jfs.trng.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jfs.trng.entity.EmployeeEntity;

public interface EmployeeDAO extends JpaRepository<EmployeeEntity, Integer> {
	 
}
