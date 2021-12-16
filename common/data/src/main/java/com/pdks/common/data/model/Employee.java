package com.pdks.common.data.model;

import com.pdks.common.data.BaseData;
import com.pdks.common.data.id.EmployeeId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Valid
public class Employee extends BaseData<EmployeeId> {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private Date birthDate;
}
