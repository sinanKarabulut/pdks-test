package com.pdks.common.data.model;

import com.pdks.common.data.BaseData;
import com.pdks.common.data.id.UserId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Valid
public class User extends BaseData<UserId> {
    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String email;

    private Set<UserRole> roles;
}
