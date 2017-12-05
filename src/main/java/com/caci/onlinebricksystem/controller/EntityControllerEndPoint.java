package com.caci.onlinebricksystem.controller;

import com.caci.onlinebricksystem.domain.Customer;
import com.caci.onlinebricksystem.domain.Entity;
import com.caci.onlinebricksystem.service.EntityService;
import com.caci.onlinebricksystem.service.IEntityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Created by Rabia on 03/12/2017.
 */
@Slf4j
@RestController
@RequestMapping(value="/bricks", produces = MediaType.APPLICATION_JSON_VALUE)
public class EntityControllerEndPoint {

    @Autowired
    private static final IEntityService entityService = new EntityService();

    @PostMapping(path="/entities")
    public ResponseEntity<Void> saveEntity(@RequestBody Entity newEntity){
        Entity entity = entityService.saveEntity(newEntity);
        if(entity==null)
            return ResponseEntity.noContent().build();
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
               // "/{id}").buildAndExpand(entity.getEntityId()).toUri();
                "/{id}").buildAndExpand(entity.getEntityId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping(path="/entities")
    public List<Entity> retreiveAllEntities(){
        return entityService.retreiveAllEntities();
    }

    @GetMapping(path="/entities/{entityId}")
    public Entity retreiveSpecificEntity(@PathVariable Long entityId){
        return entityService.retreiveSpecificEntity(entityId);
    }

    @DeleteMapping(path="/entries/{entryId}")
    public Entity deleteEntity(@PathVariable Long entityId){
        return entityService.deleteEntity(entityId);
    }
}
