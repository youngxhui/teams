<%--
  Created by IntelliJ IDEA.
  User: young
  Date: 2017/11/19
  Time: 19:39
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>编辑文章</title>
    <style type="text/css">
        .toolbar {
            border: 1px solid #ccc;
        }

        .text {
            border: 1px solid #ccc;
            height: 400px;
        }
    </style>
</head>
<body>
<jsp:include page="common/nav.jsp"/>


<div id="content" class="row-fluid center-block">
    <div class="col-md-1">
    </div>
    <div class="col-md-10">
        <div style="padding: 5px 0; color: #ccc">
            标题 <input type="text" class="form-control" name="title" id="tit" placeholder="请输入标题">

        </div>
        <div id="div1" class="toolbar">
        </div>


        <div id="div2" class="text"> <!--可使用 min-height 实现编辑区域自动增加高度-->
            <p>请输入内容</p>
        </div>

        <form action="subPage" class="form-group" method="post">
            <input hidden name="title" id="title">
            <input type="text" id="textHtml" hidden name="htmlText">
            <div>
                <hr>
            </div>
            <button id="submit" class="form-control btn btn-info">提交</button>
        </form>
        <script type="text/javascript" src="js/wangEditor.min.js"></script>
        <script type="text/javascript">
            var E = window.wangEditor;
            var editor = new E('#div1', '#div2');// 两个参数也可以传入 elem 对象，class 选择器
            editor.create();
            document.getElementById('submit').addEventListener('click', function () {
                var input = document.getElementById('textHtml');
                input.value = editor.txt.html();

                var tit = document.getElementById('tit');
                var title = document.getElementById('title');
                var t = tit.value;
                title.value = t;
            }, false);
        </script>
    </div>
    <div class="col-md-1">
    </div>
</div>


</body>
</html>


