package com.pdks.dao;

import com.pdks.common.data.EntityType;
import com.pdks.common.data.id.EmployeeId;
import com.pdks.common.data.id.EntityId;
import com.pdks.common.data.id.UserId;

import java.util.UUID;

public class DaoUtil {
    public static EntityId getEntityId(UUID id, EntityType type) {
        switch (type) {
            case EMPLOYEE:
                return new EmployeeId(id);
            case USER:
                return new UserId(id);
        }
        throw new RuntimeException("Entity type not valid");
    }
}
