package com.pdks.dao;

import com.pdks.common.daoapi.sql.BaseSqlEntity;
import com.pdks.common.daoapi.sql.ToData;
import com.pdks.common.data.BaseData;
import com.pdks.common.data.id.EntityId;
import org.springframework.data.repository.CrudRepository;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public abstract class JpaAbstractDao<E extends BaseSqlEntity<D>, D extends BaseData<?>> {

    public abstract CrudRepository<E, UUID> getCrudRepository();

    public abstract Class<E> getEntityClass();

    public D save(D data) {
        E entity;
        try {
            entity = getEntityClass().getConstructor(data.getClass()).newInstance(data);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
        if(data.getId() == null){
            entity.setId(UUID.randomUUID());
            entity.setCreatedDate(new Date());
            entity.setActive(true);
        }else{
            E current = getCrudRepository().findById(data.getId().getId())
                    .orElseThrow(()->new RuntimeException("Not Found"));
            entity.setActive(current.getActive());
            entity.setCreatedDate(current.getCreatedDate());
        }
        return getCrudRepository().save(entity).toData();
    }

    public Optional<D> findById(EntityId id) {
        return getCrudRepository().findById(id.getId()).map(ToData::toData);
    }

    public List<D> findAll() {
        return StreamSupport.stream(getCrudRepository().findAll().spliterator(), true)
                .map(ToData::toData)
                .collect(Collectors.toList());
    }

    public void deleteById(EntityId id) {
        getCrudRepository().findById(id.getId()).ifPresent(e->e.setActive(false));
    }

    public void delete(D data) {
        this.deleteById(data.getId());
        getCrudRepository().deleteById(data.getId().getId());
    }
}
