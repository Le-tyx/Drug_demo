package cn.edu.jsu.demo.web.servlet;

import cn.edu.jsu.demo.model.Drug;
import cn.edu.jsu.demo.model.Symptom;
import cn.edu.jsu.demo.repository.SymptomDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/ShowSymptomServlet")
public class ShowSymptomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/jsp;charset = UTF-8");
        //得到输出流
        PrintWriter writer = response.getWriter();
        SymptomDao symptomDao = new SymptomDao();
        try{
            //将数据库中数据读取到symptoms中
            List<Symptom> symptoms = symptomDao.getAllDrug();

            if(!symptoms.isEmpty()){
                request.setAttribute("array",symptoms);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ShowSymptom.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
