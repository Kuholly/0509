package com.cashsystem.cmd.impl;

import com.cashsystem.entity.Account;

/**
 * @className Subject
 * @Description TODO
 * @Author f
 * @Date 2019/8/4 11:49
 * @Version 1.0
 **/
public class Subject {
    private Account account;
    public void setAccount(Account account){
        this.account = account;
    }
    public Account getAccount(){
        return this.account;
    }
}
