package com.cashsystem.service;

import com.cashsystem.dao.OrderDao;
import com.cashsystem.entity.Order;

import java.util.List;

/**
 * @className OrderService
 * @Description TODO
 * @Author Fu Xin
 * @Date 2019/8/10 15:42
 * @Version 1.0
 **/
public class OrderService  {

    public OrderDao orderDao;
    public OrderService(){
        this.orderDao = new OrderDao();
    }

    public boolean commitOrder(Order order){
        return this.orderDao.commitOrder(order);
    }
    public List<Order> queryOrderByAccount(Integer accountId) throws Exception {
        return this.orderDao.queryOrderByAccount(accountId);
    }
}
