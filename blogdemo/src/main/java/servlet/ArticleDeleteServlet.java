package servlet;
import dao.BaseDao;
import dao.JSONUtil;
import entity.ARticle;
import exception.BusinessException;
import exception.ParemterException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @className ArticleListServlet
 * @Description TODO
 * @Author Fu Xin
 * @Date 2019/8/23 14:11
 * @Version 1.0
 **/
@WebServlet("/articleDelete")
public class ArticleDeleteServlet extends BaseServlet {

    @Override
    public Object process(HttpServletRequest request,
                          HttpServletResponse response) throws Exception {

        String ids = request.getParameter("ids");
        int[] intIds = null;
        try {
            String[] idArray = ids.split(",");
             intIds = new int[idArray.length];
            for (int i = 0; i < idArray.length; i++) {
                intIds[i] = Integer.parseInt(idArray[i]);
            }
        }catch (Exception e){
            throw new ParemterException("请求参数错误"+ids);
        }
        Connection connection =null;
        PreparedStatement preparedStatement= null;
            //处理数据库操作
        try {
            connection = BaseDao.getConnection();
            StringBuilder sql = new StringBuilder(
                    "delete from article where id in (");
            for (int i =0;i<intIds.length;i++){
                if (i == 0) {
                    sql.append("?");
                }else {
                    sql.append(",?");
                }
            }
            sql.append(")");

            preparedStatement = connection.prepareStatement(sql.toString());
            for (int i =0;i<intIds.length;i++){
                preparedStatement.setInt(i+1,intIds[i]);
            }
            int r =  preparedStatement.executeUpdate();
            if(r>0){
                return r;
            }else {
                throw new BusinessException("没有该用户");
            }
        } finally {
            BaseDao.close(connection, preparedStatement,null);
        }
    }
}
