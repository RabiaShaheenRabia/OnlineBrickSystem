package com.caci.onlinebricksystem.domain;

import com.sun.javafx.beans.IDProperty;
import lombok.*;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rabia on 03/12/2017.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer implements Serializable{


    private Long customerId;
    private String customerName;
    private String customerAddress;
    private String phoneNumber;
    private String email;
    private List<Order> orders=new ArrayList<>();

}
