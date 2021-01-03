<%--
  Created by IntelliJ IDEA.
  User: tangyixin
  Date: 2021/1/1
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="cn.edu.jsu.demo.model.User" %>
<html>
<head>
    <title>所有医务人员</title>
    <link href="css/show.css" type="text/css" rel="stylesheet" />
</head>
<body>
<jsp:useBean id="UserPageBean" class="cn.edu.jsu.demo.repository.BeanDaoUser" scope="request"></jsp:useBean>
<jsp:setProperty property="pageNo" param="pageNo" name="UserPageBean"/>

<div class="container">
    <div class="content">
    <div class="Usertable">
    <table border="1" align="center" cellspacing="0">
        <tr bgcolor="68C336">
            <td>编号</td>
            <td>姓名</td>
            <td>邮箱</td>
            <td>科室</td>
            <td>身份</td>
        </tr>

        <%
            List<User> users=UserPageBean.getPageData();
            for(User user:users){
        %>
            <tr>
                <td><%=user.getUser_id()%></td>
                <td><%=user.getUser_name()%></td>
                <td><%=user.getUser_email()%></td>
                <td><%=user.getUser_department()%></td>
                <td><%=user.getUser_status()%></td>
            </tr>
        <%}%>
    </table>
</div><br/>

    <%
        if(UserPageBean.isHasPreviousPage()){
    %>
    <div class="page-text"><a href="ShowUser.jsp?pageNo=<%=UserPageBean.getPageNo()-1%>">上一页</a></div><%}%> &nbsp
    <div class="page-text text1">当前是第<jsp:getProperty property="pageNo" name="UserPageBean"/>页 &nbsp
        共<jsp:getProperty property="totalPages" name="UserPageBean"/>页
    </div>
    <%
        if(UserPageBean.isHasNextPage()){
    %>
    <div class="page-text"><a href="ShowUser.jsp?pageNo=<%=UserPageBean.getPageNo()+1%>">下一页</a></div><%}%><br />
</div>
</div>
</body>
</html>