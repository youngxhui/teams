<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: young
  Date: 2017/10/24
  Time: 21:18
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="dist/css/bootstrap.min.css">
    <script src="jquery/jquery-3.2.1.min.js"></script>
    <script src="dist/js/bootstrap.min.js"></script>

    <style>
        .form-center {
            width: 70%;
            height: auto;
        }

        body {
            min-height: 100%;
            margin: 0;
            padding: 0;
            position: relative;
        }
    </style>
</head>
<body>
<jsp:include page="common/nav.jsp"/>

<div class="container ">

    <div class="form-center center-block ">
        <h3 class="text-center"><s:text name="login"/></h3>
        <form action="userLogin.action" method="post" class="form-group center-block">
            <table class="table ">
                <tr class="form-group">
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon" id="emailSpan">E-Mail</span>
                            <input id="email" class="form-control" type="email"
                                   aria-describedby="emailSpan" name="email">
                        </div>
                    </td>
                </tr>
                <tr class="form-group">
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon" id="passwordSpan"><s:text name="password"/></span>
                            <input id="password" class="form-control" type="password" placeholder="长度为3~8字符"
                                   aria-describedby="passwordSpan" name="password">
                        </div>
                    </td>

                </tr>
                <tr class="form-group">
                    <td class="text-center">
                        <div>
                            ${requestScope.loginError} <s:actionerror/>
                        </div>
                    </td>
                </tr>
                <tr class="form-group">
                    <td>
                        <div>
                            <button type="submit" class="btn btn-success btn-block"><s:text name="login"/></button>
                        </div>
                    </td>

                </tr>
            </table>
        </form>
    </div>
</div>
<jsp:include page="common/copyright.jsp"/>
</body>
</html>
