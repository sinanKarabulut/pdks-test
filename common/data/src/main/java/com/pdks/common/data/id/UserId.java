package com.pdks.common.data.id;

import com.pdks.common.data.EntityType;

import java.util.UUID;

public class UserId extends EntityId {
    public UserId() {
        super(EntityType.USER);
    }

    public UserId(UUID id) {
        super(id, EntityType.USER);
    }
}
