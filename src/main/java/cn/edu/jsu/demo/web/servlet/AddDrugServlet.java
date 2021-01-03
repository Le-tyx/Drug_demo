package cn.edu.jsu.demo.web.servlet;

import cn.edu.jsu.demo.model.Drug;
import cn.edu.jsu.demo.repository.DrugDao;
import cn.edu.jsu.demo.repository.ManagerDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/AddDrugServlet")
public class AddDrugServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset = UTF-8");
        //前端中文转换
        String degree = new String(request.getParameter("Ddegree").getBytes("ISO-8859-1"),"utf-8");
        String stype = new String(request.getParameter("Stype").getBytes("ISO-8859-1"),"utf-8");
        String dname1 = new String(request.getParameter("DrugName").getBytes("ISO-8859-1"),"utf-8");


        Drug drug = new Drug(null,dname1,degree,stype);
        DrugDao drugDao = new DrugDao();

        //判断药物是否已经存在
        Integer count = DrugDao.selectDrugCount(dname1);
        if(count > 0){//该药物已经存在
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('该药物已经存在！');");
            writer.write("window.location.href='addDrug.html'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }else{//将药品保存进数据库中

            //标记是否保存成功
            boolean flag = drugDao.saveDrug(drug);

            if (flag) { //保存成功、回到主页面
                response.sendRedirect("/addDrug.html");

            } else {//保存失败，则重新选择
                RequestDispatcher dispatcher = request.getRequestDispatcher("/addDrug.html");
                dispatcher.forward(request, response);
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
