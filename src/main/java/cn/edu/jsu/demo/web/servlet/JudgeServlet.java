package cn.edu.jsu.demo.web.servlet;

import cn.edu.jsu.demo.model.Drug;
import cn.edu.jsu.demo.model.User;
import cn.edu.jsu.demo.repository.DrugDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/JudgeServlet")
public class JudgeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/jsp;charset = UTF-8");
        //将登陆用户取出
        User user = (User) request.getSession().getAttribute("SESSION_USER");
        String[] item = request.getParameterValues("choose");

        DrugDao drugDao = new DrugDao();

        //可选择药品表
        String geted ="您已开出以下药品：";

        //无权限，不可选择药品表
        String unget ="您无权限药品：";

       //读取药品编号、判断当前登录人员权限
        boolean flag1 = false;
        boolean flag2 = false;
        if(item!=null){
        for(int i=0;i<item.length;i++){
            Drug drug = drugDao.getDrugByDrugID(Integer.parseInt(item[i]));
            if(user.getUser_status().equals("护士")&&drug.getDrug_degree().equals("处方药")){
                unget += drug.getDrug_name() + "、";
                //将该药品加入无权限表
                flag1 = drugDao.saveDrug1(drug);
            }else{
                //将药品放入药品清单表
                geted += drug.getDrug_name()+ "、";
                //将该药品加入药品清单表
                flag2 = drugDao.saveDrug2(drug);
            }
        }
        }
        if(flag1 && flag2){ //选药清单和无权限清单
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('已选药品：'+geted+'\n'+'无权限药品：'+unget);");
            writer.write("window.location.href='uindex.jsp'");
            writer.write("</script>");
            writer.flush();
            writer.close();

        }else if(flag1){ //选药清单
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('已选药品：'+geted+'\n');");
            writer.write("window.location.href='uindex.jsp'");
            writer.write("</script>");
            writer.flush();
            writer.close();

        }else if(flag2){ //无权限清单
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('无权限药品：'+unget+'\n');");
            writer.write("window.location.href='uindex.jsp'");
            writer.write("</script>");
            writer.flush();
            writer.close();

        }else{
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('您未选择药品！');");
            writer.write("window.location.href='uindex.jsp'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }
//        System.out.println(unget);
//        System.out.println(geted);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
