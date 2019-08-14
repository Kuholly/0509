package com.cashsystem.entity;
import com.cashsystem.common.AccountStatus;
import com.cashsystem.common.AccountType;
import lombok.Data;
/**
 * @className Account
 * @Description TODO
 * @Author fu
 * @Date 2019/8/4 10:15
 * @Version 1.0
 **/
@Data
public class Account {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private AccountType accountType;
    private AccountStatus accountStatus;
@Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("【账户信息】").append("\n")
                .append("【账户id】").append(this.getId()).append("\n")
                .append("【账号名称】").append(this.getUsername()).append("\n")
                .append("【账户密码】").append(this.getPassword()).append("\n")
                .append("【真实姓名】").append(this.getName()).append("\n")
                .append("【账号类型】") .append(this.getAccountType()).append("\n")
                .append("【账号状态】").append(this.getAccountStatus()).append("\n");
        sb.append("======================================================").append("\n");
        return sb.toString();
    }
}
