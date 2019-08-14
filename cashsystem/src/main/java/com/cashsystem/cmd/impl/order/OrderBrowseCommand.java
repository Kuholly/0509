package com.cashsystem.cmd.impl.order;

import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.annotation.CustomerCommand;
import com.cashsystem.cmd.impl.AbstractCommand;
import com.cashsystem.cmd.impl.Subject;
import com.cashsystem.entity.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * @className OrderBrowseCommand
 * @Description TODO
 * @Author f
 * @Date 2019/8/4 11:43
 * @Version 1.0
 **/
@CommandMeta(
        name = "LLDD",
        desc = "浏览订单",
        group = "订单信息"
)
@CustomerCommand
public class OrderBrowseCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) throws Exception {
        System.out.println("我的订单列表");
        List<Order> orderList = this.orderService.queryOrderByAccount(subject.getAccount().getId());
        if (orderList.isEmpty()){
            System.out.println("没有订单");
        }else {
            for (Order order: orderList) {
                System.out.println("-------------start------------");
                System.out.println(order);
                System.out.println("-------------end--------------");
            }
        }

    }
}
