package com.cashsystem.common;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString

public enum OrderStatus {
    PLAYING(1,"支付"),OK(2,"待支付");

    private  int flg;
    private String desc;
    private OrderStatus(int flg,String desc){
        this.desc = desc;
        this.flg = flg;
    }
    public static OrderStatus valueOf(int flg){
        for(OrderStatus orderStatus:values()){
            if (orderStatus.flg == flg){
                return orderStatus;
            }
        }
        throw new RuntimeException("orderStatus flg" + flg + " not fount!");
    }
}
