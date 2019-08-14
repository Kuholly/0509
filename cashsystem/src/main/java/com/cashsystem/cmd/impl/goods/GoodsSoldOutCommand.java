package com.cashsystem.cmd.impl.goods;

import com.cashsystem.cmd.annotation.AdminCommand;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.impl.AbstractCommand;
import com.cashsystem.cmd.impl.Subject;
import com.cashsystem.entity.Goods;

/**
 * @className GoodsSoldOutCommand
 * @Description TODO
 * @Author f
 * @Date 2019/8/4 11:43
 * @Version 1.0
 **/
@CommandMeta(
        name = "XJSP",
        desc = "下架商品",
        group = "商品信息"
)
@AdminCommand
public class GoodsSoldOutCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        System.out.println("下架商品");
        System.out.println("请输入下架商品的编号：");
        int goodsId = Integer.parseInt(scanner.nextLine());
        Goods goods = this.goodsService.getGoods(goodsId);
        if (goods == null) {
            System.out.println("没有此货物");
            return;
        } else {
            boolean effect = this.goodsService.deleteGoods(goodsId);
            if (effect) {
                System.out.println("商品下架成功");
            } else {
                System.out.println("商品下架失败");
            }
        }
    }
}






