package com.cashsystem.cmd.impl.account;

import com.cashsystem.cmd.annotation.AdminCommand;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.impl.AbstractCommand;
import com.cashsystem.cmd.impl.Subject;
import com.cashsystem.common.AccountStatus;
import com.cashsystem.entity.Account;

/**
 * @className AccountStatusSetCommand
 * @Description TODO
 * @Author f
 * @Date 2019/8/4 11:40
 * @Version 1.0
 **/
@CommandMeta(
        name = "QTZH",
        desc = "启停账号",
        group = "账号信息"
)
@AdminCommand
public class AccountStatusSetCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        Account account = subject.getAccount();
        System.out.println("启停账号");
        System.out.println("请输入需要启停账号的编号");
        int id = Integer.parseInt(scanner.nextLine());
        account = this.accountService.quarryAccount(id);
        System.out.println("账号信息如下");
        System.out.println(account);
        System.out.println("请输入变更后的状态：（1、启停，2、启用）");
        int  status = Integer.parseInt(scanner.nextLine());
        AccountStatus accountStatus = AccountStatus.valueOf(status);
        System.out.println("请选择是否要变更此账号（y/n)");
        String str = scanner.nextLine();
        if ("y".equalsIgnoreCase(str)){
            account.setAccountStatus(accountStatus);
            boolean effect = this.accountService.StatusAccount(id,status);
            if (effect){
                System.out.println("状态变更成功");
            }else {
                System.out.println("状态变更失败");
            }

        }else {
            System.out.println("您选择了不变更");
        }

    }
}
