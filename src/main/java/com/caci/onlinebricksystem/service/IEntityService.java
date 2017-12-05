package com.caci.onlinebricksystem.service;

import com.caci.onlinebricksystem.domain.Entity;

import java.util.List;

/**
 * Created by Rabia on 04/12/2017.
 */
public interface IEntityService {

    Entity saveEntity(Entity entity);

    List<Entity> retreiveAllEntities();

    Entity retreiveSpecificEntity(Long entityId);

    Entity deleteEntity(Long entityId);

    Entity updateEntity(Long entityId);
}
