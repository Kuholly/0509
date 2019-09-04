package com.bit.blog;

import dao.BaseDao;
import org.junit.Assert;
import org.junit.Test;
import java.sql.Connection;

/**
 * @className BaseDaotest
 * @Description TODO
 * @Author Fu Xin
 * @Date 2019/8/23 12:38
 * @Version 1.0
 **/
public class BaseDaotest {

    @Test
    public void testConnection(){
        Connection connection = BaseDao.getConnection();
        //System.out.println(connection);
        Assert.assertNotNull(connection);

    }
}
//http://localhost:8080/blogdemo