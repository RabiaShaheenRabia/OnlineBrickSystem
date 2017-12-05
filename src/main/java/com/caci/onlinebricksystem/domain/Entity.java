package com.caci.onlinebricksystem.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by Rabia on 03/12/2017.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Entity implements Serializable{

    private Long entityId;
    private String entityName;
    private int quantity;

}
