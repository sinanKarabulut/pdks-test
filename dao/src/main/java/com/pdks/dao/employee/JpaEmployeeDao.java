package com.pdks.dao.employee;

import com.pdks.common.daoapi.sql.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaEmployeeDao extends CrudRepository<EmployeeEntity, UUID> {

}
