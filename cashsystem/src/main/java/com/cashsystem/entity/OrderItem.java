package com.cashsystem.entity;
import lombok.Data;
/**
 * @className OrderItem
 * @Description TODO
 * @Author f
 * @Date 2019/8/4 10:40
 * @Version 1.0
 **/
@Data
public class OrderItem {
    private Integer id;
    private String order_id;
    private Integer goods_id;
    private String goods_name;
    private String goods_introduce;
    private Integer goods_num;
    private String goods_unit;
    private Integer goods_price;
    private Integer goods_discount;
}
