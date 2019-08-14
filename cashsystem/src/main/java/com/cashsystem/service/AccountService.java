package com.cashsystem.service;

import com.cashsystem.cmd.impl.Command;
import com.cashsystem.dao.AccountDao;
import com.cashsystem.entity.Account;
import com.cashsystem.entity.Goods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @className AccountService
 * @Description TODO
 * @Author f
 * @Date 2019/8/4 16:28
 * @Version 1.0
 **/
public class AccountService {
    private AccountDao accountDao;
    public AccountService(){
        this.accountDao = new AccountDao();
    }
    public Account login(String username, String password){
        return this.accountDao.login(username,password);
    }
   /* public boolean register(Account account){
        return this.accountDao.register(account);
    }*/
    public int register(String username,String password,String name,Integer account_type){
        return this.accountDao.register(username,password,name,account_type);
    }

    public List<Account> quarryAllAccount ()  {
        return this.accountDao.quarryAllAccount();
    }
    public Account quarryAccount(Integer id){
        return  this.accountDao.quarryAccount(id);
    }
    public boolean StatusAccount(Integer id,Integer status){
        return this.accountDao.StatusAccount(id,status);
    }
    public boolean ModefineAccount(String password,Integer account_id){
        return this.accountDao.ModefineAccount(password,account_id);
    }
}
