package cn.edu.jsu.demo.web.servlet;

import cn.edu.jsu.demo.model.Manager;
import cn.edu.jsu.demo.model.User;
import cn.edu.jsu.demo.repository.ManagerDao;
import cn.edu.jsu.demo.repository.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset = UTF-8");
        //获取提交的Email、密码
        String applicantEmail = request.getParameter("applicatEmail");
        String applicantPwd = request.getParameter("applicatPwd");
        String applicantPer = request.getParameter("person");

        if(applicantPer.equals("manager")){//管理员
            //根据Email和密码查询是否有账号
            ManagerDao managerDao = new ManagerDao();
            Manager manager = managerDao.getManagerByEmailAndPass(applicantEmail,applicantPwd);
            if(manager == null){
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('邮箱错误！或请先进行注册！');");
                writer.write("window.location.href='login.jsp'");
                writer.write("</script>");
                writer.flush();
                writer.close();

            }else{//进入管理员主界面
                //将登陆用户对象保存到session
                request.getSession().setAttribute("SESSION_USER",manager);
                response.sendRedirect("/mindex.html");
            }

        }else{//医务人员
            //根据Email和密码查询是否有账号
            UserDao userDao = new UserDao();
            User user = userDao.getUserByEmailAndPass(applicantEmail,applicantPwd);
            if(user == null){
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('邮箱错误！或请先进行注册！');");
                writer.write("window.location.href='login.jsp'");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }else{//进入医务人员主页
                //将登陆用户对象保存到session
                request.getSession().setAttribute("SESSION_USER",user);
                response.sendRedirect("/uindex.jsp");
            }

        }

    }
}
