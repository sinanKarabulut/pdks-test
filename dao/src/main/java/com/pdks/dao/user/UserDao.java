package com.pdks.dao.user;

import com.pdks.common.daoapi.sql.UserEntity;
import com.pdks.common.data.model.User;
import com.pdks.dao.Dao;
import com.pdks.dao.JpaAbstractDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class UserDao extends JpaAbstractDao<UserEntity, User> implements Dao<User> {

    @Autowired
    private JpaUserDao repository;

    public Optional<User> findByUsername(String username){
        return repository.findByUsername(username);
    }

    @Override
    public CrudRepository<UserEntity, UUID> getCrudRepository() {
        return repository;
    }

    @Override
    public Class<UserEntity> getEntityClass() {
        return UserEntity.class;
    }
}
