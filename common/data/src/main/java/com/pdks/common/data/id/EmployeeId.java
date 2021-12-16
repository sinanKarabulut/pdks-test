package com.pdks.common.data.id;

import com.pdks.common.data.EntityType;

import java.util.UUID;

public class EmployeeId extends EntityId {
    public EmployeeId() {
        super(EntityType.EMPLOYEE);
    }

    public EmployeeId(UUID id) {
        super(id, EntityType.EMPLOYEE);
    }
}
