package com.pdks.common.data;

import com.pdks.common.data.id.EntityId;
import lombok.Data;

import java.util.Date;

@Data
public abstract class BaseData<T extends EntityId> {
    private T id;
    private Boolean active;
    private Date createdDate;
}
