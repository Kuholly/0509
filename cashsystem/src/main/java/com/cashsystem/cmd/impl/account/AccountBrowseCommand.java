package com.cashsystem.cmd.impl.account;

import com.cashsystem.cmd.annotation.AdminCommand;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.impl.AbstractCommand;
import com.cashsystem.cmd.impl.Command;
import com.cashsystem.cmd.impl.Subject;
import com.cashsystem.entity.Account;
import com.cashsystem.entity.Goods;

import java.util.List;

/**
 * @className AccountBrowseCommand
 * @Description TODO
 * @Author f
 * @Date 2019/8/4 11:40
 * @Version 1.0
 **/
@CommandMeta(
        name = "CKZH",
        desc = "查看账户",
        group = "账号信息"
)
@AdminCommand
public class AccountBrowseCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        System.out.println("查看账户");
        List<Account> accountList = this.accountService.quarryAllAccount();
        if (accountList.isEmpty()){
            System.out.println("账户为空");
        }else {
            System.out.println(accountList);
        }

    }
}
