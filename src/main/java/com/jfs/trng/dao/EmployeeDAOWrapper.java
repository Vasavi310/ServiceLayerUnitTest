package com.jfs.trng.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jfs.trng.bean.EmployeeBean;
import com.jfs.trng.entity.EmployeeEntity;

@Repository
public class EmployeeDAOWrapper {

	@Autowired
	EmployeeDAO employeeDAO;
 
	public Integer addEmployee(EmployeeBean employeeBean) {
 
		EmployeeEntity employeeEntity = convertBeanToEntity(employeeBean);
 
		employeeEntity = employeeDAO.save(employeeEntity);
 
		return employeeEntity.getId();
	}
 
	public EmployeeBean findEmployeeByid(Integer employeeId) {
		EmployeeEntity employeeEntity = employeeDAO.findById(employeeId).orElse(null);
		if (employeeEntity != null) {
			EmployeeBean employeeBean = convertEntityToBean(employeeEntity);
			return employeeBean;
 
		}
		return null;
	}
 
	public List<EmployeeBean> findAllEmployees() {
		List<EmployeeEntity> employeeEntities = employeeDAO.findAll();
		List<EmployeeBean> employeeBeans = new ArrayList<>();
		for (EmployeeEntity employeeEntity : employeeEntities) {
			EmployeeBean employeeBean = convertEntityToBean(employeeEntity);
			employeeBeans.add(employeeBean);
		}
		return employeeBeans;
	}
 
	public EmployeeBean updateEmployee(EmployeeBean employeeBean) {
 
		EmployeeEntity employeeEntity = employeeDAO.findById(employeeBean.getId()).get();
 
		if (employeeEntity == null) {
			return null;
		}
		employeeEntity.setEmpName(employeeBean.getEmpName());
		employeeEntity.setSalary(employeeBean.getSalary());
		employeeEntity.setDeptcode(employeeBean.getDeptcode());
		employeeEntity = employeeDAO.save(employeeEntity);
		return convertEntityToBean(employeeEntity);
	}
	
	public EmployeeBean deleteEmployee(Integer employeeId) {
		EmployeeEntity employeeEntity = employeeDAO.findById(employeeId).orElse(null);
		if (employeeEntity != null) {
			employeeDAO.delete(employeeEntity);
			return convertEntityToBean(employeeEntity);
		}
		return null;
	}
 
	private EmployeeBean convertEntityToBean(EmployeeEntity employeeEntity) {
 
		EmployeeBean employeeBean = new EmployeeBean();
		BeanUtils.copyProperties(employeeEntity, employeeBean);
		return employeeBean;
	}
 
	private EmployeeEntity convertBeanToEntity(EmployeeBean employeeBean) {
 
		EmployeeEntity employeeEntity = new EmployeeEntity();
 
		BeanUtils.copyProperties(employeeBean, employeeEntity);
		return employeeEntity;
	}
	
	public void test() {
		int x=10;
	}
}
