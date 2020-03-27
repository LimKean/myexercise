package servlet;

import Bean.User;
import Dao.IUserDao;
import Dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 根据id删除用户
 */
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        IUserDao dao = new UserDaoImpl();
        boolean flag = dao.delete(Integer.valueOf(id));
        if (flag) {
            //删除成功，查询所有用户并返回
            List<User> list = dao.getUserAll();
            req.setAttribute("userAll",list);
            req.getRequestDispatcher("jsp/viewAll.jsp").forward(req,resp);
        } else{
            //失败直接跳转至error.jsp页面
            resp.sendRedirect("jsp/error.jsp");
        }
    }
}
