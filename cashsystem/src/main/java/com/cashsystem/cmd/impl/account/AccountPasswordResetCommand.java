package com.cashsystem.cmd.impl.account;

import com.cashsystem.cmd.annotation.AdminCommand;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.impl.AbstractCommand;
import com.cashsystem.cmd.impl.Subject;
import com.cashsystem.entity.Account;

/**
 * @className AccountPasswordResetCommand
 * @Description TODO
 * @Author f
 * @Date 2019/8/4 11:40
 * @Version 1.0
 **/
@CommandMeta(
        name = "CZMM",
        desc = "重置密码",
        group = "账号信息"
)
@AdminCommand
public class AccountPasswordResetCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        System.out.println("重置密码");
        System.out.println("请输入重置密码的账号");
        int account_id = Integer.parseInt(scanner.nextLine());
        Account account = this.accountService.quarryAccount(account_id);
        if (account == null){
            System.out.println("没有此账号");
            return;
        }
        System.out.println("账号信息如下：");
        System.out.println(account);
        System.out.println("请输入新密码");
        String password = scanner.nextLine();
        System.out.println("请再次输入密码");
        String password1 = scanner.nextLine();
        while (! password.equals(password1)){
            System.out.println("两次密码不一致，请重新输入：");
            password1 = scanner.nextLine();
        }
        System.out.println("请确认是否重置密码（y/n）");
        String flg = scanner.nextLine();
        if (flg.equalsIgnoreCase("y")){
            account.setPassword(password);
            boolean effect = this.accountService.ModefineAccount(password,account_id);
            if (effect){
                System.out.println("密码重置成功");
            }else{
                System.out.println("密码重置失败");
            }
        }else {
            System.out.println("您选择不重置密码");
        }
    }
}
