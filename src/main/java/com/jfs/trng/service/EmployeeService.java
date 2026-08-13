package com.jfs.trng.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jfs.trng.bean.EmployeeBean;

public interface EmployeeService {

public Integer addEmployee(EmployeeBean employeeBean);
	
	
	public EmployeeBean findEmployeeByid(Integer employeeId);
	
	
	public List<EmployeeBean> findAllEmployees();
	
	public EmployeeBean updateEmployee(EmployeeBean employeeBean);
}
