package com.pdks.dao.employee;

import com.pdks.common.daoapi.sql.EmployeeEntity;
import com.pdks.common.data.model.Employee;
import com.pdks.dao.Dao;
import com.pdks.dao.JpaAbstractDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EmployeeDao extends JpaAbstractDao<EmployeeEntity, Employee> implements Dao<Employee> {

    @Autowired
    private JpaEmployeeDao repository;

    @Override
    public CrudRepository<EmployeeEntity, UUID> getCrudRepository() {
        return repository;
    }

    @Override
    public Class<EmployeeEntity> getEntityClass() {
        return EmployeeEntity.class;
    }

}
