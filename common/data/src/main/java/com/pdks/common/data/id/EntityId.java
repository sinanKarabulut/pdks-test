package com.pdks.common.data.id;

import com.pdks.common.data.EntityType;
import lombok.Getter;

import java.util.UUID;

@Getter
public class EntityId {
    private final UUID id;
    private final EntityType entityType;

    public EntityId(EntityType entityType) {
        this.id = UUID.randomUUID();
        this.entityType = entityType;
    }

    public EntityId(UUID id, EntityType entityType) {
        this.id = id;
        this.entityType = entityType;
    }
}
