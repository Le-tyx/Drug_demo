package cn.edu.jsu.demo.web.servlet;

import cn.edu.jsu.demo.model.User;
import cn.edu.jsu.demo.repository.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/ComsummateServlet")
public class ComsummateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset = UTF-8");

        //前端中文转换
        String status = new String(request.getParameter("status").getBytes("ISO-8859-1"),"utf-8");
        String department = new String(request.getParameter("department").getBytes("ISO-8859-1"),"utf-8");

        //从Session中取出登录用户
        User user = (User) request.getSession().getAttribute("SESSION_USER");
        user.setUser_department(department);
        user.setUser_status(status);

        request.getSession().setAttribute("SESSION_USER",user);

        //保存manager到数据库 UserDao
        UserDao userDao = new UserDao();

        //标记是否完善成功
        boolean flag = userDao.saveUserSF(user);

        if(flag){ //身份填写成功跳转至登陆页面
            response.sendRedirect("/login.jsp");
        }else{ //填写失败则重新填写
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Consummate.html");
            dispatcher.forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
