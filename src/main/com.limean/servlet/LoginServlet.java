package servlet;

import Dao.IUserDao;
import Dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String pwd = req.getParameter("pwd");

        IUserDao dao = new UserDaoImpl();
        boolean result = dao.login(name,pwd);
        if (result){
            req.setAttribute("xiaoxi","欢迎用户"+name);
            req.getRequestDispatcher("jsp/success.jsp").forward(req,resp);
        } else {
            resp.sendRedirect("jsp/error.jsp");
        }
    }
}
