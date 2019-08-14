package com.cashsystem.cmd.impl;

import com.cashsystem.service.AccountService;
import com.cashsystem.service.GoodsService;
import com.cashsystem.service.OrderService;

/**
 * @className AbstractCommand
 * @Description TODO
 * @Author f
 * @Date 2019/8/4 11:53
 * @Version 1.0
 **/
public abstract class AbstractCommand implements Command{

    //启动所有服务
    public AccountService accountService;
    public GoodsService goodsService;
    public OrderService orderService;
    public AbstractCommand(){
        this.accountService = new AccountService();
        this.goodsService = new GoodsService();
        this.orderService = new OrderService();
    }



}
