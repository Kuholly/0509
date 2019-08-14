package com.cashsystem.cmd.impl.entrance;

import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.annotation.CustomerCommand;
import com.cashsystem.cmd.annotation.EntranceCommand;
import com.cashsystem.cmd.impl.AbstractCommand;
import com.cashsystem.cmd.impl.Subject;
import com.cashsystem.common.AccountStatus;
import com.cashsystem.common.AccountType;
import com.cashsystem.entity.Account;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * @className RegisterCommand
 * @Description TODO
 * @Author f
 * @Date 2019/8/4 11:42
 * @Version 1.0
 **/
@CommandMeta(
        name = "ZC",
        desc = "注册",
        group = "入口命令"
)
@EntranceCommand
public class RegisterCommand extends AbstractCommand {


    @Override
    public void execute(Subject subject) {
        /*System.out.println("请输入用户名：");
        String username = scanner.nextLine();
        System.out.println("请输入密码：");
        String password1 = scanner.nextLine();
        System.out.println("请再次输入密码：");
        String password2 = scanner.nextLine();
        if (!password1.equals(password2)){
            System.out.println("两次密码不一致！");
            return;
        }
        System.out.println("请输入姓名：");
        String name = scanner.nextLine();
        System.out.println("请输入账号类型，1代表管理员，2代表普通用户");
        int accountType = scanner.nextInt();
        AccountType accountType2 = AccountType.valueOf(accountType);
        System.out.println("请输入用户的状态，1代表启用，2代表启停");
        int accountStatus1 = scanner.nextInt();
        AccountStatus accountStatus = AccountStatus.valueOf(accountStatus1);

        final Account account = new Account();
        account.setUsername(username);
        account.setPassword(DigestUtils.md5Hex(password1));
        account.setName(name);
        account.setAccountStatus(accountStatus);
        account.setAccountType(accountType2);
        boolean effect = this.accountService.register(account);
        if (effect){
            System.out.println("注册成功");
        }else {
            System.out.println("注册失败");
        }*/

        Account account = subject.getAccount();
        System.out.println("请输入新的用户名：");
        String username = scanner.nextLine();
        System.out.println("请输入密码：");
        String password = scanner.nextLine();
        System.out.println("请再次输入密码：");
        String password1 = scanner.nextLine();
        while (!password.equals(password1)){
            System.out.println("两次密码不一致，请重新输入密码：");
            password1 = scanner.nextLine();
        }
        System.out.println("请输入真是姓名");
        String name = scanner.nextLine();
        System.out.println("请输入用户类型（1代表管理员，2代表顾客）");
        Integer account_type = scanner.nextInt();
        int result = this.accountService.register(username,password,name,account_type);
        if (result == 1){
            System.out.println("注册成功");
        }else {
            System.out.println("注册失败，请重新输入");
        }
    }
}
