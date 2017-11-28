<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: young
  Date: 2017/11/11
  Time: 10:07
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>设置</title>
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
        <ul class="nav nav-pills nav-stacked">
            <li class="active"><a href="jspsetting">基本设置</a></li>
        </ul>
    </div>
    <div class="col-md-6">
        <s:text name="select_language"/>
        <table class="table table-bordered">
            <tr>
                <td><a href="http://localhost:8080/locale?request_locale=zh_CN"><img src="icon/chinese.png"><s:text
                        name="chinese"/></a>
                </td>
                <td><a href="http://localhost:8080/locale?request_locale=en_US"><img src="icon/us.png"><s:text
                        name="english"/></a></td>
            </tr>
        </table>

        面部识别
        <tr><a href="FaceId.jsp">添加面部数据</a></tr>

    </div>
    <div class="col-md-3">
    </div>
</div>

<div class="col-md-12">
    <jsp:include page="common/copyright.jsp"/>
</div>


</body>
</html>
