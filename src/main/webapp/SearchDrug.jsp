<%--
  Created by IntelliJ IDEA.
  User: tangyixin
  Date: 2021/1/1
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="cn.edu.jsu.demo.model.Drug" %>
<html>
<head>
    <title>搜索药品信息</title>
    <link href="css/search.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
</head>
<body>
<div>
    <form action="/SearchDrugServlet" method="post">
        <input class="in-text" placeholder="  输入关键字" name="flag" type="text"/>&nbsp
        <input class="button-text" name="sub" type="submit" value=" 搜 索"/><br/>
        <div class="label-text">
            搜索类型：
            <input type="radio" name="type" value="drug_id" checked="checked"/>药品编号
            <input type="radio" name="type" value="drug_name"/>药品名称
            <input type="radio" name="type" value="drug_degree"/>药品类型
            <input type="radio" name="type" value="symptom_type"/>对应症状
            <br/>
        </div>
    </form>
</div>

<div>
    <div class="Drugtable">
        <table border="1" align="center" cellspacing="0">
            <thead>
            <tr bgcolor="68C336">
                <td>药品编号</td>
                <td>药品名称</td>
                <td>药品种类</td>
                <td>治疗症状</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.array}" var="drug">
                <tr>
                    <td>${drug.drug_id}</td>
                    <td>${drug.drug_name}</td>
                    <td>${drug.drug_degree}</td>
                    <td>${drug.symptom_type}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <br/>
</div>
</body>
</html>
