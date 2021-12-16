package com.pdks.application.service.impl;

import com.pdks.application.service.BaseService;
import com.pdks.application.service.EmployeeService;
import com.pdks.common.data.id.EntityId;
import com.pdks.common.data.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl extends BaseService implements EmployeeService {
    @Override
    public Optional<Employee> findById(EntityId id) {
        return this.employeeDao.findById(id);
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeDao.findAll();
    }

    @Override
    public Employee save(Employee data) {
        return this.employeeDao.save(data);
    }

    @Override
    public void deleteById(EntityId id) {
        this.employeeDao.deleteById(id);
    }

    @Override
    public void delete(Employee data) {
        this.employeeDao.delete(data);
    }
}
