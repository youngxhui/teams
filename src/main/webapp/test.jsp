<%--
  Created by IntelliJ IDEA.
  User: young
  Date: 2017/11/26
  Time: 17:26
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="dist/css/bootstrap.min.css">
    <script src="js/jquery-2.0.3.min.js"></script>
    <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
    <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
    <script>
        $.validator.setDefaults({
            submitHandler: function () {
                alert("提交事件!");
            }
        });
        $().ready(function () {
// 在键盘按下并释放及提交后验证提交表单
            $("#signupForm").validate({
                rules: {
                    firstname: "required",
                    lastname: "required",
                    username: {
                        required: true,
                        minlength: 2
                    },
                    password: {
                        required: true,
                        minlength: 5
                    },
                    confirm_password: {
                        required: true,
                        minlength: 5,
                        equalTo: "#password"
                    },
                    email: {
                        required: true,
                        email: true
                    },
                    "topic[]": {
                        required: "#newsletter:checked",
                        minlength: 2
                    },
                    agree: "required"
                },
                messages: {
                    firstname: "请输入您的名字",
                    lastname: "请输入您的姓氏",
                    username: {
                        required: "请输入用户名",
                        minlength: "用户名必需由两个字母组成"
                    },
                    password: {
                        required: "请输入密码",
                        minlength: "密码长度不能小于 5 个字母"
                    },
                    confirm_password: {
                        required: "请输入密码",
                        minlength: "密码长度不能小于 5 个字母",
                        equalTo: "两次密码输入不一致"
                    },
                    email: "请输入一个正确的邮箱",
                    agree: "请接受我们的声明",
                    topic: "请选择两个主题"
                }
            });
        });
    </script>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<form class="cmxform" id="signupForm" method="get" action="">

    <legend>验证完整的表单</legend>
    <p>
        <label for="firstname">名字</label>
        <input id="firstname" name="firstname" type="text" class="">
    </p>
    <p>
        <label for="lastname">姓氏</label>
        <input id="lastname" name="lastname" type="text">
    </p>
    <p>
        <label for="username">用户名</label>
        <input id="username" name="username" type="text">
    </p>
    <p>
        <label for="password">密码</label>
        <input id="password" name="password" type="password">
    </p>
    <input type="submit" value="登录"/>
</form>

</body>
</html>
