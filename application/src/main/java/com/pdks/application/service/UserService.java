package com.pdks.application.service;

import com.pdks.common.data.id.UserId;
import com.pdks.common.data.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findById(UserId id);

    List<User> findAll();

    User save(User data);

    void deleteById(UserId id);

    void delete(User data);
}
