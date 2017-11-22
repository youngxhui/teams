<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: young
  Date: 2017/11/19
  Time: 15:15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>小组</title>
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

        <form action="registerGroup" class="form-group">
            组织名字
            <input type="text" class="form-control" name="groupName">
            介绍
            <textarea class="form-control" maxlength="140" placeholder="最多140字" name="summary"></textarea>
            <%--添加成员--%>
            <%--<div class="input-group">--%>
                <%--<form action="" class="form-control">--%>
                    <%--<input type="search" class="form-control" placeholder="用户邮箱">--%>
                    <%--<span class="input-group-btn">--%>
        <%--<button class="btn btn-default" type="button"><s:text name="search"/></button>--%>
                <%--</span>--%>
                <%--</form>--%>
                <%--<div id="result"></div>--%>
            <%--</div>--%>
            <input type="submit" value="确认的">
            <button type="submit" class="btn btn-success btn-block">确认</button>
        </form>

    </div>
    <div class="col-md-3">

    </div>
</div>

</body>
</html>
