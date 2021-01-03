<%--
  Created by IntelliJ IDEA.
  User: tangyixin
  Date: 2021/1/1
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>症状信息展示</title>
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <link href="css/show.css" type="text/css" rel="stylesheet" />
</head>
<body>
<div class="container">
<div class="symptomTable content">
    <table border="1" align="center" cellspacing="0">
        <tr bgcolor="68C336">
            <td>症状编号</td>
            <td>症状描述</td>
        </tr>
        <c:forEach items = "${requestScope.array}" var="symptom">
            <tr>
                <td>${symptom.symptom_id}</td>
                <td>${symptom.symptom_type}</td>
            </tr>
        </c:forEach>
    </table><br/>
</div>
</div>
</body>
</html>
