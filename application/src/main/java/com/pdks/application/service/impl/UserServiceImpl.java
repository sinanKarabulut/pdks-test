package com.pdks.application.service.impl;

import com.pdks.application.service.BaseService;
import com.pdks.application.service.UserService;
import com.pdks.common.data.id.UserId;
import com.pdks.common.data.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl extends BaseService implements UserService {
    @Override
    public Optional<User> findById(UserId id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User save(User data) {
        return userDao.save(data);
    }

    @Override
    public void deleteById(UserId id) {
        userDao.deleteById(id);
    }

    @Override
    public void delete(User data) {
        userDao.delete(data);
    }
}
