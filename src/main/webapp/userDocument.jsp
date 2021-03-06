<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: young
  Date: 2017/11/5
  Time: 13:09
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${sessionScope.userInfo.nickname}的个人信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="dist/css/bootstrap.min.css">
    <script src="jquery/jquery-3.2.1.min.js"></script>
    <script src="dist/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="common/nav.jsp"/>


<div class="col-md-12">
    <div class="col-md-3">
        <img src="pic/testpic.jpeg" width="100px" height="100px" alt="没有头像"
             class="img-circle center-block">
    </div>
    <div class="col-md-9">
        <h2>${sessionScope.userInfo.nickname}</h2>
        <small><span class="glyphicon glyphicon-pencil"></span> <a href="">修改资料</a></small>
    </div>
</div>


<div id="content" class="row-fluid center-block">
    <div class="col-md-3">
        <h2>个人资料</h2>
        <ul class="nav nav-pills nav-stacked">
            <li><a href="jspuserInfo">基本资料</a></li>
            <li class="active"><a href="">文件资料</a></li>
            <li><a href="">签到历史</a></li>
        </ul>
    </div>
    <div class="col-md-9">
        <table class="table table-hover">

            <tr>
                <td>
                    <input type="checkbox" name="attachmentPath" id="all" onchange="checkFile()">全选
                </td>
                <td>序号</td>
                <td>文件名</td>
                <td>操作</td>
            </tr>
            <form action="${pageContext.request.contextPath}/downloadMultiFile" method="post">
                <c:forEach var="file" items="${requestScope.files}">
                    <tr>
                        <td>
                            <input type="checkbox" name="attachmentPath" value="${file.path}">
                        </td>
                        <td><c:out value="${file.fid}"/></td>
                        <td><img src="${file.icon}" alt="无法加载" width="20px" height="20px">
                            <c:out value="${file.name}"/></td>
                        <td>
                            <a href="download.action?downFileName=${file.name}&contentType=${file.contentType}&inputPath=${file.path}">
                                下载</a>
                            <a href="deletefile?fileId=${file.fid}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="4">
                        <button type="submit" class="btn btn-success" id="submit">下载文件</button>
                    </td>
                </tr>
            </form>
        </table>
    </div>

</div>


<jsp:include page="common/copyright.jsp"/>
</body>
</html>
