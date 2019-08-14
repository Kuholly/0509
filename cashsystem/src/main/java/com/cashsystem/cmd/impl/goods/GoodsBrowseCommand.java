package com.cashsystem.cmd.impl.goods;

import com.cashsystem.cmd.annotation.AdminCommand;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.annotation.CustomerCommand;
import com.cashsystem.cmd.impl.AbstractCommand;
import com.cashsystem.cmd.impl.Subject;
import com.cashsystem.entity.Goods;

import java.util.List;

/**
 * @className GoodsBrowseCommand
 * @Description TODO
 * @Author f
 * @Date 2019/8/4 11:42
 * @Version 1.0
 **/
@CommandMeta(
        name = "LLSP",
        desc = "浏览商品",
        group = "商品信息"
)
@AdminCommand
@CustomerCommand
public class GoodsBrowseCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        System.out.println("浏览商品");
        List<Goods> goodsList = this.goodsService.quarryAllGoods();
        if (goodsList.isEmpty()){
            System.out.println("商品为空");
        }else {
                System.out.println(goodsList);
        }
    }
}
