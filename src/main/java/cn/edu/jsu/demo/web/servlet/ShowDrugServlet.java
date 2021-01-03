package cn.edu.jsu.demo.web.servlet;

import cn.edu.jsu.demo.model.Drug;
import cn.edu.jsu.demo.repository.DrugDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/ShowDrugServlet")
public class ShowDrugServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/jsp;charset = UTF-8");
        //得到输出流
        PrintWriter writer = response.getWriter();
        DrugDao drugDao = new DrugDao();

        try{
            //将数据库中数据读取到drugs中
        List<Drug> drugs = drugDao.getAllDrug();

            if(!drugs.isEmpty()){
                request.setAttribute("array",drugs);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ShowDrug.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
