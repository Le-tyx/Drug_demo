package cn.edu.jsu.demo.web.servlet;

import cn.edu.jsu.demo.model.Symptom;
import cn.edu.jsu.demo.repository.DrugDao;
import cn.edu.jsu.demo.repository.SymptomDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/AddSymptomServlet")
public class AddSymptomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset = UTF-8");

        //前端中文转换
        String symptom_type = new String(request.getParameter("symptom").getBytes("ISO-8859-1"),"utf-8");
        Symptom symptom = new Symptom(null,symptom_type);
        SymptomDao symptomDao = new SymptomDao();

        //判断症状是否已经存在
        Integer count = SymptomDao.selectSymptomCount(symptom_type);
        if(count>0){
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('该症状已经存在！');");
            writer.write("window.location.href='addSymptom.html'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }else{
            //标记是否保存成功
            boolean flag = symptomDao.saveSymptom(symptom);

            if (flag) { //保存成功、回到主页面
                response.sendRedirect("/addSymptom.html");

            } else {//保存失败，则重新选择

                RequestDispatcher dispatcher = request.getRequestDispatcher("/addSymptom.html");
                dispatcher.forward(request, response);
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
