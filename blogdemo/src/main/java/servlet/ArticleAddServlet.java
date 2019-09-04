package servlet;
import dao.BaseDao;
import dao.JSONUtil;
import entity.ARticle;
import exception.BusinessException;
import exception.ParemterException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @className ArticleListServlet
 * @Description TODO
 * @Author Fu Xin
 * @Date 2019/8/23 14:11
 * @Version 1.0
 **/
public class ArticleAddServlet extends BaseServlet {

    @Override
    public Object process(HttpServletRequest request,
                          HttpServletResponse response) throws Exception {
        Connection connection =null;
        PreparedStatement preparedStatement= null;
        //application/ json 数据，需要inputstream 获取

//        String userAccount = request.getParameter("userAccount");
//        String title = request.getParameter("title");
//        String content = request.getParameter("content");

        ARticle article = JSONUtil.get(request,ARticle.class);
        //处理数据库操作
        try {
            connection = BaseDao.getConnection();
            String sql = "insert into article( title, content, user_id,create_time) select  ?,?,1,now() from user where  user.name=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,article.getTitle());
            preparedStatement.setString(2,article.getContent());
            preparedStatement.setString(3,article.getUserAccout());
            int r =  preparedStatement.executeUpdate();
            if(r>0){
                return r;
            }else {
                throw new BusinessException("没有该用户"+article.getUserAccout());
            }
        } finally {
            BaseDao.close(connection, preparedStatement,null);
        }
    }


}
