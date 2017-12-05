package com.caci.onlinebricksystem.domain;

import com.caci.onlinebricksystem.common.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by Rabia on 03/12/2017.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order implements Serializable {
    private Long orderId;
    private Entity entity;
    private LocalDate orderDate;
    private LocalTime orderTime;
    private Customer customer;
    private Status.OrderStatus orderStatus;

}
