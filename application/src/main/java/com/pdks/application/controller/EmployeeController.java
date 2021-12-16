package com.pdks.application.controller;

import com.pdks.common.data.EntityType;
import com.pdks.common.data.model.Employee;
import com.pdks.dao.DaoUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api")
public class EmployeeController extends BaseController {

    @GetMapping(path = "/employees")
    public ResponseEntity<List<Employee>> employees() {
        return new ResponseEntity<>(this.employeeService.findAll(), HttpStatus.OK);
    }

    @PostMapping(path = "/employees")
    public ResponseEntity<Employee> postEmployee(@RequestBody @Validated Employee employee) {
        if (employee.getId() != null) {
            return new ResponseEntity<>(this.employeeService.save(employee), HttpStatus.OK);
        } else {
            employee.setActive(true);
            return new ResponseEntity<>(this.employeeService.save(employee), HttpStatus.CREATED);
        }
    }

    @DeleteMapping(path = "/employees/:id")
    public ResponseEntity<Void> deleteEmployee(@PathVariable UUID id) {
        this.employeeService.deleteById(DaoUtil.getEntityId(id, EntityType.EMPLOYEE));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
