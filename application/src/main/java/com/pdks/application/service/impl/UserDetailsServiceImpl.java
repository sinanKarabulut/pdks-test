package com.pdks.application.service.impl;

import com.pdks.application.model.DefaultUserDetails;
import com.pdks.common.data.exception.UserNotFoundException;
import com.pdks.dao.user.UserDao;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) {
        return new DefaultUserDetails(userDao.findByUsername(username).orElseThrow(UserNotFoundException::new));
    }
}
