<%--
  Created by IntelliJ IDEA.
  User: tangyixin
  Date: 2021/1/1
  Time: 8:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="cn.edu.jsu.demo.model.Drug" %>
<html>
<head>
    <title>药品信息展示</title>
    <link href="css/show.css" type="text/css" rel="stylesheet" />
</head>
<body>
    <jsp:useBean id="DrugPageBean" class="cn.edu.jsu.demo.repository.BeanDaoDrug" scope="request"></jsp:useBean>
    <jsp:setProperty property="pageNo" param="pageNo" name="DrugPageBean"/>
<div class="container">
    <div class="content">
    <div class="Drugtable">
        <table border="1" align="center" cellspacing="0">
            <tr bgcolor="68C336">
                <td>药品编号</td>
                <td>药品名称</td>
                <td>药品种类</td>
                <td>治疗症状</td>
            </tr>
            <%
                List<Drug> drugs=DrugPageBean.getPageData();
                for(Drug drug:drugs){
            %>
            <tr>
                <td><%=drug.getDrug_id()%></td>
                <td><%=drug.getDrug_name()%></td>
                <td><%=drug.getDrug_degree()%></td>
                <td><%=drug.getSymptom_type()%></td>
            </tr>
            <%}%>
        </table>
    </div>
    <%
        if(DrugPageBean.isHasPreviousPage()){
    %>
    <div class="page-text"><a href="ShowDrug.jsp?pageNo=<%=DrugPageBean.getPageNo()-1%>">上一页</a></div><%}%> &nbsp
    <div class="page-text text1">当前是第<jsp:getProperty property="pageNo" name="DrugPageBean"/>页 &nbsp
        共<jsp:getProperty property="totalPages" name="DrugPageBean"/>页
    </div>
    <%
        if(DrugPageBean.isHasNextPage()){
    %>
    <div class="page-text"><a href="ShowDrug.jsp?pageNo=<%=DrugPageBean.getPageNo()+1%>">下一页</a></div><%}%><br />
    </div>
</div>
</body>
</html>
