<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: young
  Date: 2017/11/20
  Time: 10:22
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>showPage</title>
    <style type="text/css">
        .text {
            border: 1px solid #ccc;
            height: auto;
        }
    </style>
</head>
<body>
<jsp:include page="common/nav.jsp"/>

<div id="content" class="row-fluid center-block">
    <div class="col-md-3">
    </div>
    <div class="col-md-6">
        <div id="title"><h2> ${requestScope.pages.title}</h2></div>

        <div id="div2" class="text"></div>

        <div id="contents" hidden>${requestScope.pages.htmlText}</div>

        <script type="text/javascript" src="js/wangEditor.min.js"></script>
        <script type="text/javascript">
            var contents = document.getElementById("contents");
            var contentHtml = contents.innerHTML;
            var E = window.wangEditor;
            var editor = new E('#div1', '#div2');  // 两个参数也可以传入 elem 对象，class 选择器
            editor.create();
            editor.txt.html(contentHtml.toString());
            editor.$textElem.attr('contenteditable', false);
        </script>
    </div>

    <div class="col-md-3">

    </div>
</div>

</body>
</html>
