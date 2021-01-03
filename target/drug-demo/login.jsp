<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<html>
<head>
    <meta charset="utf-8">
    <title>登录 - 医药产品信息管理系统</title>
    <link href="css/login.css" type="text/css" rel="stylesheet" />
    <meta content="医药" name="keywords">
    <meta content="医药产品信息管理系统是为了用户可查看症状对应产品的系统" name="description">
</head>

<body>
<form action="/LoginServlet" method="get">
    <div class="container">
    <div class="content">
        <div class="page_name">登&nbsp  &nbsp      &nbsp  &nbsp陆</div><br/>
        <div class="lis">当前在线人数: <%=request.getSession().getServletContext().getAttribute("Count")%></div>
        <div class="login_content">
            <div class="login_l">
                <div class="span1">
                    <label class="tn-form-label">邮箱：</label>
                    <input  class="tn-textbox" type="text" name="applicatEmail">
                </div>
                <div class="span1">
                    <label class="tn-form-label">密码：</label>
                    <input class="tn-textbox"  type="password" name="applicatPwd">
                </div>
                <div class="span1">
                    <input class="tn-choose" checked type="radio" name="person" value="user" />医务人员
                    &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
                    <input class="tn-choose" type="radio" name="person" value="manager"/>管理员<br />
                </div>
                <div class="tn-form-row-button">
                    <div class="span1">
                        <input name="" type="submit" class="tn-button-text" value="登   录">
                    </div>
                </div>
                <div class="clear"></div>
            </div>
            <br/>
            <div class="login_r">
                <p align="center"> <b>还没有帐号？</b><a  href="register.html">10秒钟快速注册</a></p>

                <div class="clear"></div>
            </div>
            <div class="clear"></div>
        </div>
    </div>
    </div>
</form>
</body>
</html>
