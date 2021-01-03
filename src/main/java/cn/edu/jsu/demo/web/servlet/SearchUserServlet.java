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
import java.util.List;

@WebServlet(urlPatterns = "/SearchUserServlet")
public class SearchUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/jsp;charset = UTF-8");
        String flag = new String(request.getParameter("flag").getBytes("ISO-8859-1"),"utf-8");
        String type = new String(request.getParameter("type").getBytes("ISO-8859-1"),"utf-8");

        UserDao userDao = new UserDao();
        try{
            //将数据库中数据读取到users中
            List<User> users = userDao.getSearchUser(type,flag);

            if(!users.isEmpty()){
                request.setAttribute("array",users);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/SearchUser.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
