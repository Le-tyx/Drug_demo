package cn.edu.jsu.demo.web.servlet;

import cn.edu.jsu.demo.model.Symptom;
import cn.edu.jsu.demo.model.User;
import cn.edu.jsu.demo.repository.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/ShowUserServlet")
public class ShowUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/jsp;charset = UTF-8");
        //得到输出流
        PrintWriter writer = response.getWriter();
        UserDao userDao = new UserDao();
        try{
            //将数据库中数据读取到symptoms中
            List<User> users = userDao.getAllUser();

            if(!users.isEmpty()){
                request.setAttribute("array",users);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ShowUser.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
