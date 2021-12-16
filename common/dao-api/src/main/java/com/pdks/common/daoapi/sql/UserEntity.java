package com.pdks.common.daoapi.sql;

import com.pdks.common.data.id.UserId;
import com.pdks.common.data.model.User;
import com.pdks.common.data.model.UserRole;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class UserEntity extends BaseSqlEntity<User> {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @ElementCollection(targetClass = UserRole.class, fetch = FetchType.EAGER)
    @Column(name = "role", nullable = false)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<UserRole> roles;

    public UserEntity() {
        super();
    }

    public UserEntity(User user) {
        super(user);
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.username = user.getUsername();
        this.password = user.getPassword();
    }

    @Override
    public User toBaseData() {
        User user = new User();
        UserId userId = new UserId(this.id);
        user.setId(userId);
        user.setUsername(this.username);
        user.setPassword(this.password);
        user.setFirstName(this.firstName);
        user.setLastName(this.lastName);
        return user;
    }
}
