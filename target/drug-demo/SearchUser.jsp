<%--
  Created by IntelliJ IDEA.
  User: tangyixin
  Date: 2021/1/2
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>搜索医务人员信息</title>
    <link href="css/search.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
</head>
<body>
<div>
    <form action="/SearchUserServlet" method="post">
        <input class="in-text" placeholder="  输入关键字" name="flag" type="text"/>&nbsp
        <input class="button-text" name="sub" type="submit" value="搜索"/><br/>
        <div class="label-text">
            搜索类型：
            <input type="radio" name="type" value="user_id" checked="checked"/>编号
            <input type="radio" name="type" value="user_name"/>姓名
            <input type="radio" name="type" value="user_email"/>邮箱
            <input type="radio" name="type" value="user_department"/>所属科室
            <input type="radio" name="type" value="user_status"/>身份
            <br/>
        </div>
    </form>
</div>

<div>
    <div class="Drugtable">
        <table border="1" align="center" cellspacing="0">
            <tr bgcolor="68C336">
                <td> 编 号</td>
                <td> 姓 名</td>
                <td width="200px"> 邮 箱</td>
                <td> 科 室</td>
                <td> 身 份</td>
            </tr>
            <c:forEach items="${requestScope.array}" var="user">
                <tr>
                    <td>${user.user_id}</td>
                    <td>${user.user_name}</td>
                    <td width="200px">${user.user_email}</td>
                    <td>${user.user_department}</td>
                    <td>${user.user_status}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <br/>
</div>
</body>
</html>
