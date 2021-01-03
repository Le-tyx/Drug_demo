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

@WebServlet(urlPatterns = "/SearchDrugServlet")
public class SearchDrugServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/jsp;charset = UTF-8");
        String flag = new String(request.getParameter("flag").getBytes("ISO-8859-1"),"utf-8");
        String type = new String(request.getParameter("type").getBytes("ISO-8859-1"),"utf-8");
        String sub = new String(request.getParameter("sub").getBytes("ISO-8859-1"),"utf-8");
        //得到输出流
        PrintWriter writer = response.getWriter();
        DrugDao drugDao = new DrugDao();

        try{
            //将数据库中数据读取到drugs中
            List<Drug> drugs = drugDao.getSearchDrug(type,flag);

            if(!drugs.isEmpty()){
                request.setAttribute("array",drugs);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        if(sub.equals(" 搜 索")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/SearchDrug.jsp");
            dispatcher.forward(request, response);
        }else{
            RequestDispatcher dispatcher = request.getRequestDispatcher("/uindex.jsp");
            dispatcher.forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
