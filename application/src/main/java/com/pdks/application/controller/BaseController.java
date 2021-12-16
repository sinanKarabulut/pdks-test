package com.pdks.application.controller;

import com.pdks.application.security.JwtUtils;
import com.pdks.application.service.EmployeeService;
import com.pdks.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

public abstract class BaseController {
    @Autowired
    protected EmployeeService employeeService;

    @Autowired
    protected UserService userService;

    @Autowired
    protected AuthenticationManager authenticationManager;

    @Autowired
    protected PasswordEncoder encoder;

    @Autowired
    protected JwtUtils jwtUtils;
}
