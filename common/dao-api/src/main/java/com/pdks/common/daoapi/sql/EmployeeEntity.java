package com.pdks.common.daoapi.sql;

import com.pdks.common.data.id.EmployeeId;
import com.pdks.common.data.model.Employee;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "employees")
@Data
public class EmployeeEntity extends BaseSqlEntity<Employee> {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date")
    private Date birthDate;

    public EmployeeEntity() {
        super();
    }

    public EmployeeEntity(Employee employee) {
        super(employee);
        this.birthDate = employee.getBirthDate();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
    }

    @Override
    public Employee toBaseData() {
        Employee employee = new Employee();
        EmployeeId employeeId = new EmployeeId(this.id);
        employee.setId(employeeId);
        employee.setFirstName(this.firstName);
        employee.setLastName(this.lastName);
        employee.setBirthDate(this.birthDate);
        return employee;
    }
}
