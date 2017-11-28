<%--
  Created by IntelliJ IDEA.
  User: young
  Date: 2017/11/19
  Time: 19:07
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GroupInfo</title>
    <link rel="stylesheet" href="dist/css/bootstrap.min.css">
    <script src="jquery/jquery-3.2.1.min.js"></script>
    <script src="dist/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="common/nav.jsp"/>
<div class="page-header text-center">

    <h1>${sessionScope.group.groupName}</h1>
    <small>${sessionScope.group.summary}</small>

</div>

<div id="content" class="row-fluid center-block">

    <div class="col-md-3">
        <h3>小组成员&nbsp;<span class="badge">${fn:length(sessionScope.menber) }</span></h3>

        <table>
            <c:forEach var="user" items="${sessionScope.menber}">
                <tr>
                    <td><img class="img-circle" src="head/${user.headPicPath}" alt="" width="30" height="30"></td>
                    &nbsp;
                    <td class="nickname" id="nickname">${user.nickname}</td>
                </tr>
                <tr>
                    <td colspan="2"><br></td>
                </tr>
            </c:forEach>
        </table>


        <p>邀请链接</p>
        <div class="panel panel-default">
            <div class="panel-body">
                http://localhost:8080/addGroup?adminId=${sessionScope.group.adminId}
            </div>
        </div>
    </div>
    <div class="col-md-6">
        <h1>文章列表</h1>
        <a href="createPage.jsp" class="btn btn-success">创作文章</a>
        <table class="table table-hover">
            <tr>
                <td>标题</td>
            </tr>
            <c:forEach var="page" items="${requestScope.pageList}">
                <tr>
                    <td><a href="getOnePage?pid=${page.pid}">${page.title}</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div class="col-md-2">
        <h2>公告信息</h2>
        <div id="notes" hidden>${sessionScope.group.note}</div>
        <form action="updateNote" class="form-group">
            <textarea class="form-control" maxlength="140" placeholder="最多140字" id="note" name="note"></textarea>
            <hr>
            <tr>
                <td>
                    <button class="btn btn-success form-group admin" id="update">更新</button>
                </td>
                <td><a class="btn btn-info admin" href="jspgroupSetting">设置</a></td>
            </tr>

        </form>


    </div>
</div>

<script>
    var notes = document.getElementById("notes");
    var text = notes.innerHTML;
    $('#note').val(text);
    if (${sessionScope.userInfo.uid==sessionScope.group.adminId}) {
        $('#note').removeAttr("readonly")
    } else {
        $('#note').attr("readonly", "readonly")
        $('.admin').hide()
    }
</script>
</body>
</html>
