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

/***
 * 更新
 */
public class UpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        String sex = req.getParameter("");
        String home = req.getParameter("home");
        String info = req.getParameter("info");
        IUserDao dao = new UserDaoImpl();
        boolean flag = dao.update(Integer.valueOf(id),name,pwd,sex,home,info);
        if (flag){
            List<User> list = dao.getUserAll();
            req.setAttribute("userAll",list);
            req.setAttribute("xiaoxi","更新成功");
            req.getRequestDispatcher("jsp/viewAll.jsp").forward(req,resp);
        }else{
            resp.sendRedirect("jsp/error");
        }
    }
}
