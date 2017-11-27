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
    <script src="js/jquery-2.0.3.min.js"></script>
    <script src="dist/js/bootstrap.min.js"></script>
    <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
    <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>

    <script src="js/login.js"></script>
    <script>
        $.validator.setDefaults({
            submitHandler: function () {
                alert("提交事件!");
            }
        });
        $().ready(function () {
// 在键盘按下并释放及提交后验证提交表单
            $("#login").validate({
                rules: {

                    username: {
                        required: true,
                        minlength: 2
                    },
                    password: {
                        required: true,
                        minlength: 5
                    },

                },
                messages: {

                    username: {
                        required: "请输入用户名",
                        minlength: "用户名必需由两个字母组成"
                    },
                    password: {
                        required: "请输入密码",
                        minlength: "密码长度不能小于 5 个字母"
                    }
                }
            })
        });
    </script>

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

        .error {
            color: red;
        }

    </style>
</head>
<body>
<jsp:include page="common/nav.jsp"/>

<div class="container ">

    <div class="form-center center-block ">
        <h3 class="text-center"><s:text name="login"/></h3>
        <form action="userLogin.action" method="post" class="form-group center-block" id="login" name="login">
            <table class="table ">
                <tr class="form-group">
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon" id="emailSpan">E-Mail</span>
                            <input id="email" class=" form-control" type="email"
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
                            <s:fielderror/>
                            ${requestScope.usererror} <s:actionerror/>
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
        <a type="button" class="btn btn-info" href="FaceId.jsp">脸部识别</a>
    </div>
</div>

<jsp:include page="common/copyright.jsp"/>
</body>
</html>
