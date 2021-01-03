<%--
  Created by IntelliJ IDEA.
  User: tangyixin
  Date: 2021/1/2
  Time: 0:00
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>医务人员主界面</title>
    <link href="css/userindex.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
</head>
<body>
<div class="page_name">医 务 人 员 主 界 面</div>
<hr>
<div class="container">
    <div class="content1">
        <p>当前在线人数<%=request.getSession().getServletContext().getAttribute("Count")%>></p>

        <form action="/SearchDrugServlet" method="post">
            <input class="text-in" placeholder="  输入关键字" name="flag" type="text"/>
            <input class="button-text" name="sub" type="submit" value="搜  索"/><br/>
            搜索类型：
            <input class="search-type" type="radio" name="type" value="drug_id" checked="checked"/>药品编号&nbsp
            <input class="search-type" type="radio" name="type" value="drug_name"/>药品名称&nbsp
            <input class="search-type" type="radio" name="type" value="drug_degree"/>药品类型&nbsp
            <input class="search-type" type="radio" name="type" value="symptom_type"/>对应症状
            <br/>
        </form>
    </div>
    <br/>

    <form action="/JudgeServlet" method="post">
        <div class="content2">
            <div class="Drugtable">
                <table border="1" align="center" cellspacing="0">
                    <thead>
                    <tr bgcolor="68C336">
                        <td>药品编号</td>
                        <td>药品名称</td>
                        <td>药品种类</td>
                        <td>治疗症状</td>
                        <td>选择药品</td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${requestScope.array}" var="drug">
                        <tr>
                            <td>${drug.drug_id}</td>
                            <td>${drug.drug_name}</td>
                            <td>${drug.drug_degree}</td>
                            <td>${drug.symptom_type}</td>
                            <td>
                                <input name="choose" type="checkbox" class="tn-button-text" value="${drug.drug_id}">
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <br/>
            <input name="" type="submit" class="button-text1" value="提 交">
        </div>
    </form>
    <input onclick='location.href=("login.jsp")' type="button" class="button-text2" value="退 出"/>

</div>
</body>
</html>
