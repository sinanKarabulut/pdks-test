package com.pdks.dao;

import com.pdks.common.data.BaseData;
import com.pdks.common.data.id.EntityId;

import java.util.List;
import java.util.Optional;

public interface Dao<T extends BaseData<?>> {
    Optional<T> findById(EntityId id);
    List<T> findAll();
    T save(T data);
    void deleteById(EntityId id);
    void delete(T data);
}
