package com.pdks.common.daoapi.sql;

import com.pdks.common.data.BaseData;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;
import java.util.UUID;

@Data
@MappedSuperclass
public abstract class BaseSqlEntity<T extends BaseData<?>> implements ToData<T> {
    @Id
    @Column(name = "id", columnDefinition = "uuid")
    protected UUID id;

    @Column(name = "active")
    protected Boolean active;

    @Column(name = "created_date", updatable = false)
    protected Date createdDate;

    public BaseSqlEntity() {
        this.id = UUID.randomUUID();
    }

    public BaseSqlEntity(T data) {
        if (data.getId() != null) {
            this.id = data.getId().getId();
        }
        this.active = data.getActive();
        this.createdDate = data.getCreatedDate();
    }

    public abstract T toBaseData();

    public T toData() {
        T data = this.toBaseData();
        data.setActive(this.active);
        data.setCreatedDate(this.createdDate);
        return data;
    }
}
