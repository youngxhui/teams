<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: young
  Date: 2017/10/24
  Time: 21:25
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="dist/css/bootstrap.min.css">
    <script src="jquery/jquery-3.2.1.min.js"></script>
    <script src="dist/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="common/nav.jsp"/>


<div id="content" class="row-fluid center-block">
    <div class="col-md-3">

    </div>
    <div class="col-md-6">
        <h2 class="text-center">注册</h2>
        <form action="userRegister" class="form-group" method="post">
            E-mail：
            <input type="email" class="form-control" name="email">
            密码：
            <input type="password" class="form-control" name="password">
            再次输入密码：
            <input type="password" class="form-control" name="rePassword">
            <br>
            <input type="checkbox"> <a href="">同意软件服务条款</a>
            <br>
            <button class="btn btn-success form-control" type="submit">注册</button>
        </form>
    </div>
    <div class="col-md-3">
    </div>
</div>

</body>
</html>
