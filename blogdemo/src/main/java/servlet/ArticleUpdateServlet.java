package servlet;

import dao.BaseDao;
import dao.JSONUtil;
import entity.ARticle;
import exception.BusinessException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @className ArticleUpdataServlet
 * @Description TODO
 * @Author Fu Xin
 * @Date 2019/8/29 17:37
 * @Version 1.0
 **/
@WebServlet("/articleUpdate")
public class ArticleUpdateServlet extends BaseServlet {

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Connection connection= null;
        PreparedStatement preparedStatement= null;
        ARticle article = JSONUtil.get(req,ARticle.class);
        System.out.println(article);
        try{

            connection  = BaseDao.getConnection();
            String sql = "update article set title=?,content=? where id=?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,article.getTitle());
            preparedStatement.setString(2,article.getContent());
            preparedStatement.setInt(3,article.getId());

            int r = preparedStatement.executeUpdate();
            if(r > 0){
                return r;
            }else{
                throw new BusinessException("没有该用户");

            }
        }finally {

            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
    }

}
