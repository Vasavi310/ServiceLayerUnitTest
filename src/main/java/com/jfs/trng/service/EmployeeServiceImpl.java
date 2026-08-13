package com.jfs.trng.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfs.trng.bean.EmployeeBean;
import com.jfs.trng.dao.EmployeeDAOWrapper;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDAOWrapper employeeDAOWrapper;

    @Override
    public Integer addEmployee(EmployeeBean employeeBean) {
        return employeeDAOWrapper.addEmployee(employeeBean);
    }

    @Override
    public EmployeeBean findEmployeeByid(Integer employeeId) {
        return employeeDAOWrapper.findEmployeeByid(employeeId);
    }

    @Override
    public List<EmployeeBean> findAllEmployees() {
        return employeeDAOWrapper.findAllEmployees();
    }

    @Override
    public EmployeeBean updateEmployee(EmployeeBean employeeBean) {
        return employeeDAOWrapper.updateEmployee(employeeBean);
    }
}