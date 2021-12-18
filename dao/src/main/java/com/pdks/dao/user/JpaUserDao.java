package com.pdks.dao.user;

import com.pdks.common.daoapi.sql.UserEntity;
import com.pdks.common.data.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface JpaUserDao extends CrudRepository<UserEntity, UUID> {
    Optional<User> findByUsername(String username);
}
