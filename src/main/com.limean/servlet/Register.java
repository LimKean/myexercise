package servlet;

import Bean.User;
import Dao.IUserDao;
import Dao.impl.UserDaoImpl;
import util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 注册
 */
public class Register extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        String sex = req.getParameter("gender");
        String home = req.getParameter("home");
        String info = req.getParameter("info");

        User user = new User();
        user.setName(name);
        user.setPwd(pwd);
        user.setSex(sex);
        user.setHome(home);
        user.setInfo(info);

        IUserDao dao = new UserDaoImpl();
        boolean result = dao.register(user);
        if (result ){
            req.getRequestDispatcher("jsp/success.jsp").forward(req,resp);
        }else {
            resp.sendRedirect("jsp/error.jsp");
        }
    }
}
