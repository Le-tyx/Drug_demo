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
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/AddUserServlet")
public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset = UTF-8");
        //获取提交的Email、用户名、密码
        String applicantEmail = request.getParameter("applicatEmail");
        String applicantName = request.getParameter("applicatName");
        String applicantPwd = request.getParameter("applicatPwd");
        String applicantDepartment = new String(request.getParameter("department").getBytes("ISO-8859-1"),"utf-8");
        String applicantStatus = new String(request.getParameter("person").getBytes("ISO-8859-1"),"utf-8");

        //创建医务人员对象
        User user = new User(null,applicantName,applicantEmail,applicantPwd,applicantDepartment,applicantStatus);
        UserDao userDao = new UserDao();
        //判断邮箱号是否相同
        Integer count = UserDao.selectUserCount(applicantEmail);
        if(count > 0){ //数据库已经存在该用户邮箱，给出错误提示

            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('email已经被占用,请更换邮箱！');");
            writer.write("window.location.href='addUser.html'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }else{
            //标记是否添加成功
            boolean flag = userDao.saveUserFromManager(user);
            if(flag){
                response.sendRedirect("/addUser.html");
            }else{
                RequestDispatcher dispatcher = request.getRequestDispatcher("/addUser.html");
                dispatcher.forward(request, response);
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
