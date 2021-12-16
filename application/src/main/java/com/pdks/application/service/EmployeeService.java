package com.pdks.application.service;

import com.pdks.common.data.id.EntityId;
import com.pdks.common.data.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Optional<Employee> findById(EntityId id);

    List<Employee> findAll();

    Employee save(Employee data);

    void deleteById(EntityId id);

    void delete(Employee data);
}
