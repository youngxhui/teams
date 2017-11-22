<%--
  Created by IntelliJ IDEA.
  User: young
  Date: 2017/11/20
  Time: 14:31
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
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
            <li class="active">基本设置</li>
        </ul>
    </div>
    <div class="col-md-6">

        签到地理位置
        <small><a href="http://api.map.baidu.com/lbsapi/getpoint/index.html" target="_blank">经纬度查询</a></small>
        <c:out value="${requestScope.updateError}"/>
        <form action="updateLoc" method="post" class="form-group">
            <table class="table ">
                <tr class="form-group">
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon" id="lngSpan">经度</span>
                            <input id="lng" class="form-control" type="text" placeholder="经度"
                                   aria-describedby="lngSpan" name="lng">
                        </div>
                    </td>
                </tr>
                <tr class="form-group">
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon" id="latSpan">纬度</span>
                            <input id="lat" class="form-control" type="text" placeholder="纬度"
                                   aria-describedby="latSpan" name="lat">
                        </div>
                    </td>
                </tr>
                <tr class="form-group">
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon" id="locErrorSpan">定位误差</span>
                            <input id="locError" class="form-control" type="text" placeholder="大于1"
                                   aria-describedby="locErrorSpan" name="locError">
                        </div>
                    </td>
                </tr>
            </table>
            <button class="btn btn-success btn-block">提交</button>
        </form>

    </div>
    <div class="col-md-3">

    </div>
</div>


</body>
</html>
