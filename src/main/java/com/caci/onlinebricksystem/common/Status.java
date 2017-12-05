package com.caci.onlinebricksystem.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rabia on 04/12/2017.
 */
public class Status {
    public enum OrderStatus{START,AVAILABLE,NOT_AVAILABLE,PACKAGED,DISPATCHED,RECEIVED}
    private final OrderStatus orderStatus;
    private static List<Status> listStatus = new ArrayList<Status>();

    private Status(OrderStatus orderStatus){this.orderStatus = orderStatus;}
    public OrderStatus getOrderStatus(){
        return orderStatus;
    }
    static {
        for (OrderStatus orderStatusValue: OrderStatus.values()){
            listStatus.add(new Status(orderStatusValue));
        }
    }
    public static List<Status> getStatusList(){return listStatus; }
    public String toString(){return orderStatus.toString();}
}
