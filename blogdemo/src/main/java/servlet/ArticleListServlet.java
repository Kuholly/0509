package servlet;
import dao.BaseDao;
import dao.JSONUtil;
import entity.ARticle;
import exception.ParemterException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @className ArticleListServlet
 * @Description TODO
 * @Author Fu Xin
 * @Date 2019/8/23 14:11
 * @Version 1.0
 **/


public class ArticleListServlet extends BaseServlet {

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
       ResultSet resultSet = null;
        List<ARticle> aRticles = new ArrayList<>();
        String sid = req.getParameter("id");
        Integer id = null;
        try {
            id = Integer.parseInt(sid);
        }catch (Exception e){
            throw new ParemterException("id错误（"+sid+"）");
        }
        //处理业务及数据库操作
        try {
           connection = BaseDao.getConnection();
            String sql = "select a.id, a.title, a.user_id,a.content, a.create_time from article a" +
                    " join user u on a.user_id=u.id where u.id=?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            resultSet = ps.executeQuery();
        //    List<ARticle> aRticleList = new ArrayList<>();
            while (resultSet.next()) {
                ARticle aRticle = new ARticle();
                aRticle.setId(resultSet.getInt("id"));
                aRticle.setTitle(resultSet.getString("title"));
                aRticle.setContent(resultSet.getString("content"));
                //aRticle.setUserId(rs.getInt("user_id"));
                aRticle.setCreateTime(resultSet.getTimestamp("create_time"));
               aRticles.add(aRticle);
            }
        }finally {
            if (resultSet != null){
                resultSet.close();
            }
            if (connection != null){
                connection.close();
            }

        }

        return aRticles;
    }
}
