package com.cashsystem.dao;

import com.cashsystem.cmd.impl.Command;
import com.cashsystem.common.AccountStatus;
import com.cashsystem.common.AccountType;
import com.cashsystem.entity.Account;
import com.cashsystem.entity.Goods;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @className AccountDao
 * @Description TODO
 * @Author f
 * @Date 2019/8/4 16:30
 * @Version 1.0
 **/
public class AccountDao extends BaseDao{
    //操作数据库
    public Account login(String username, String password){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Account account = null;
        try{
            //拿到一个连接
            connection = this.getConnection(true);
            String sql = "select id, username, password, name, account_type, account_status " +
                    "from account where username = ? and password = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2, DigestUtils.md5Hex(password));
            resultSet = preparedStatement.executeQuery();
            //返回结果集到resultSet
            if (resultSet.next()){
                //解析resultSet，拿到对应的account
                account = this.extractAccount(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }
    /*public boolean register(Account account){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Boolean effect = false;
        try{
            connection = this.getConnection(true);
            String sql = "insert into account(username,password,name," +
                    "account_type,account_status) values(?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, DigestUtils.md5Hex(account.getPassword()));
            preparedStatement.setString(3, account.getName());
            preparedStatement.setInt(4,account.getAccountType().getFlg());
            preparedStatement.setInt(5,account.getAccountStatus().getFlg());
            effect = (preparedStatement.executeUpdate() == 1);
            //获取自增的主键
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
                Integer id = resultSet.getInt(1);
                account.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeResource(resultSet,preparedStatement,connection);
        }
       return effect;
    }*/

    public Integer register(String username,String password,String name,Integer account_type){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int resultSet = -1;
        Account account = null;

        try{
            //拿到一个连接
            connection = this.getConnection(true);
            String sql = "insert into account(username,password,name,account_type) " +
                    "values(?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2, DigestUtils.md5Hex(password));
            preparedStatement.setString(3, name);
            preparedStatement.setInt(4, account_type);
            resultSet= preparedStatement.executeUpdate();
            //返回结果集到resultSet

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return resultSet;

    }

    private  Account extractAccount(ResultSet resultSet){
        Account account = new Account();
        try {
            account.setId(resultSet.getInt("id"));
            account.setUsername(resultSet.getString("username"));
            account.setPassword(resultSet.getString("password"));
            account.setName(resultSet.getString("name"));
            account.setAccountType(AccountType.valueOf(resultSet.getInt("account_type")));
            account.setAccountStatus(AccountStatus.valueOf(resultSet.getInt("account_status")));
            //account = this.extractAccount(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }
    public List<Account> quarryAllAccount(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Account> accountList = new ArrayList<>();
        try{
            connection = this.getConnection(true);
            String sql = "select *  from account ";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Account account = this.extractAccount(resultSet);
                if (account != null){
                    accountList.add(account);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accountList;
    }

    public Account quarryAccount(Integer id){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Account account = null;
        try{
            connection = this.getConnection(true);
            String sql = " select * from account where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            resultSet =preparedStatement.executeQuery();
            if (resultSet.next()){
                account = this.extractAccount(resultSet);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return account;
    }
    public boolean StatusAccount (Integer id,Integer status){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Account account = null;
        boolean effect = false;
        try{
            connection = this.getConnection(true);
            String sql = "update account set account_status = ? where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,status);
            preparedStatement.setInt(2,id);
            effect = preparedStatement.executeUpdate()==1;


        }catch (Exception e){
            e.printStackTrace();
        }
        return effect;
    }

    public boolean ModefineAccount(String password, Integer account_id){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Account account = null;
        boolean effect = false;
        try{
            connection = this.getConnection(true);
            String sql = "update account set  password = ? where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,password);
            preparedStatement.setInt(2,account_id);
            effect = preparedStatement.executeUpdate()==1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return effect;
    }
}
