package servlet;

import dao.JSONUtil;
import entity.JSON;
import exception.ParemterException;
import exception.SystemException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @className BaseServlet
 * @Description TODO
 * @Author Fu Xin
 * @Date 2019/8/23 17:08
 * @Version 1.0
 **/
public abstract class BaseServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=UTF-8");
        JSON result = new JSON();
        try {
            Object  data = process(req,resp);
            result.setSuccess(true);
            result.setCode("200");
            result.setMessage("操作成功");
            result.setData(data);

        } catch (Exception e) {
            if (e instanceof ParemterException){
                result.setCode(((ParemterException)e).getCode());
                result.setMessage(((ParemterException)e).getMessage());
            }else if (e instanceof SystemException){
                result.setCode(((ParemterException)e).getCode());
                result.setMessage(((ParemterException)e).getMessage());
            }else {
                result.setCode("500");
                result.setMessage("服务器错误");
            }
        }
        resp.getWriter().write(JSONUtil.format(result));
    }
    public abstract Object process(HttpServletRequest req,
                                 HttpServletResponse resp)throws Exception;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
