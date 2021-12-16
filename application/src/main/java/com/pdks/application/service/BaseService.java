package com.pdks.application.service;

import com.pdks.dao.employee.EmployeeDao;
import com.pdks.dao.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseService {
    @Autowired
    protected EmployeeDao employeeDao;

    @Autowired
    protected UserDao userDao;
}
