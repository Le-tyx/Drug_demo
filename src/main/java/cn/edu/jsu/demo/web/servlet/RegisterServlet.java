package cn.edu.jsu.demo.web.servlet;

import cn.edu.jsu.demo.model.Manager;
import cn.edu.jsu.demo.model.User;
import cn.edu.jsu.demo.repository.ManagerDao;
import cn.edu.jsu.demo.repository.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset = UTF-8");
        //获取提交的Email、用户名、密码
        String applicantEmail = request.getParameter("applicatEmail");
        String applicantName = request.getParameter("applicatName");
        String applicantPwd = request.getParameter("applicatPwd");
        String applicantPer = request.getParameter("person");

        if(applicantPer.equals("manager")){
            //插入到数据库中,对数据进行封装
            Manager manager = new Manager(null, applicantName, applicantEmail, applicantPwd);

            //保存manager到数据库 ManagerDao
            ManagerDao managerDao = new ManagerDao();

            //判断邮箱号是否相同
            Integer count = ManagerDao.selectManagerCount(applicantEmail);
            if(count > 0){ //数据库已经存在该用户邮箱，给出错误提示

                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('申请注册的email已经被占用！');");
                writer.write("window.location.href='register.html'");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }else {

                //标记是否注册成功
                boolean flag = managerDao.saveManager(manager);

                if (flag) { //注册成功跳转至登陆页面、重定向
                    response.sendRedirect("/login.jsp");

                } else {//注册失败返回注册页面、请求转发

                    RequestDispatcher dispatcher = request.getRequestDispatcher("/register.html");
                    dispatcher.forward(request, response);
                }
            }
        } else{//医务人员注册
            //插入到数据库中,对数据进行封装
            User user = new User(null,applicantName,applicantEmail,applicantPwd,null,null);

            //保存manager到数据库 ManagerDao
            UserDao userDao = new UserDao();

            //判断邮箱号是否相同
            Integer count = UserDao.selectUserCount(applicantEmail);
            if(count > 0){ //数据库已经存在该用户邮箱，给出错误提示

                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('申请注册的email已经被占用！');");
                writer.write("window.location.href='register.html'");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }else {

                //标记是否注册成功
                boolean flag = userDao.saveUser(user);

                if (flag) { //注册成功跳转至身份完善页面、完善后跳转至登陆页面、重定向
                    //将注册用户对象保存到session
                    request.getSession().setAttribute("SESSION_USER",user);
                    response.sendRedirect("/Consummate.html");

                } else {//注册失败返回注册页面、请求转发

                    RequestDispatcher dispatcher = request.getRequestDispatcher("/register.html");
                    dispatcher.forward(request, response);
                }
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
