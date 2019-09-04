package dao;


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @className BaseDao
 * @Description TODO
 * @Author Fu Xin
 * @Date 2019/8/23 11:56
 * @Version 1.0
 **/
public class BaseDao {
    private static final String URL = "jdbc:mysql://localhost:3306/" +
            "blogdemo?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "333";
    private static volatile DataSource dataSource;

    private BaseDao(){

    }
    public static DataSource getDataSource(){
        if (dataSource == null){
            synchronized (BaseDao.class){
            //synchronized (dataSource){
            //synchronized (dataSource.getClass()){
                if (dataSource == null){
                    dataSource = new MysqlDataSource();
                    ((MysqlDataSource) dataSource).setUrl(URL);
                    ((MysqlDataSource) dataSource).setUser(USER_NAME);
                    ((MysqlDataSource) dataSource).setPassword(PASSWORD);
                }
            }
        }
        return dataSource;
    }
    public static Connection getConnection()  {
        try {
            return (Connection) getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet){
        try{
            if (resultSet != null){
                resultSet.close();
            }
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (connection != null){
                connection.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }




}
