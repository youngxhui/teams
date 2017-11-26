<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="dist/css/bootstrap.min.css">
    <%--<script src="jquery/jquery-3.2.1.min.js"></script>--%>
    <script src="dist/js/bootstrap.min.js"></script>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/fileinput.css" media="all" rel="stylesheet" type="text/css"/>
    <%--<script src="jquery/jquery-3.2.1.min.js"></script>--%>
    <script src="js/fileinput.min.js" type="text/javascript"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="jspindex">People</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="jspindex"><s:text name="home"/><span class="sr-only">(current)</span></a></li>
                <li><a href="getfiles"><s:text name="document"/></a></li>
            </ul>
            <form class="navbar-form navbar-left">

                <div class="input-group">
                    <input type="search" class="form-control" placeholder="查询 人名，电话，地址 ……">
                    <span class="input-group-btn">
        <button class="btn btn-default" type="button"><s:text name="search"/></button>
      </span>
                </div>
            </form>

            <c:set var="userInfo" value="${sessionScope.userInfo}"/>

            <c:if test="${userInfo==null}">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="login.jsp"><s:text name="login"/></a></li>
                    <li><a href="register.jsp"><s:text name="register"/></a></li>
                </ul>
            </c:if>


            ${userInfo.nickname}

            <c:if test="${userInfo!=null}">
                <ul class="nav navbar-nav navbar-right center-block">
                    <li class="center-block ">
                        <img class="img-circle" src="head/${sessionScope.userInfo.headPicPath}" width="50px"
                             height="50px">
                    </li>
                    <li></li>
                    <li class="dropdown center-block">
                            <%--<div class="dropdown center-block">--%>
                        <a data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"
                           href="jspuserInfo"> ${userInfo.nickname}</a>
                        <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
                            <li><a href="findOne.action"><s:text name="userInfo"/></a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="queryGroupByUserInfo"><s:text name="group"/></a></li>
                            <li><a href="jspsetting"><s:text name="setting"/></a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="clear">注销</a></li>
                        </ul>
                    </li>
                </ul>
            </c:if>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>


</body>
</html>