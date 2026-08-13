package com.jfs.trng.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jfs.trng.bean.EmployeeBean;
import com.jfs.trng.service.EmployeeService;

@CrossOrigin(origins="http://localhost:5173")
@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
 
	@PostMapping("/addEmployee")
	public ResponseEntity<String> addEmployee(@RequestBody EmployeeBean employeeBean,Errors errors) {
		if(errors.hasErrors())
		{
			return new ResponseEntity<String>(errors.getAllErrors()+" ",HttpStatus.BAD_REQUEST);
		}
		Integer employeeId = employeeService.addEmployee(employeeBean);
		return new ResponseEntity<String>("Employee added with ID: " + employeeId, HttpStatus.CREATED);
 
	}
 
	@GetMapping("/findEmployeeById/{employeeId}")
	public ResponseEntity<EmployeeBean> findEmployeeById(@PathVariable Integer employeeId) {
		EmployeeBean employeeBean = employeeService.findEmployeeByid(employeeId);
		if (employeeBean != null) {
			return new ResponseEntity<EmployeeBean>(employeeBean, HttpStatus.OK);
		} else {
			return new ResponseEntity<EmployeeBean>(HttpStatus.NOT_FOUND);
		}
	}
 
	@GetMapping("/findAllEmployees")
	public ResponseEntity<List<EmployeeBean>> findAllEmployees() {
 
		List<EmployeeBean> beanList = employeeService.findAllEmployees();
 
		return new ResponseEntity<List<EmployeeBean>>(beanList, HttpStatus.OK);
	}
	
	//update emplyee--PUT
	
	@PutMapping("/updateEmployee")
	public ResponseEntity<EmployeeBean> updateEmployee(@RequestBody EmployeeBean employeeBean) {
		EmployeeBean updatedEmployeeBean = employeeService.updateEmployee(employeeBean);
		if (updatedEmployeeBean != null) {
			return new ResponseEntity<EmployeeBean>(updatedEmployeeBean, HttpStatus.OK);
		} else {
			return new ResponseEntity<EmployeeBean>(HttpStatus.NOT_FOUND);
		}
	}
}
