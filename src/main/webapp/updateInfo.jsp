<%--
  Created by IntelliJ IDEA.
  User: young
  Date: 2017/11/22
  Time: 20:06
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改个人信息</title>
</head>
<body>
<jsp:include page="common/nav.jsp"/>

<s:fielderror/>

<div class="container">
    <div class="jumbotron">
        <div>

            <form action="updateUser" method="post" class="form-group" enctype="multipart/form-data">
                <table class="table ">
                    <tr class="form-group">
                        <td>
                            <small>账号信息</small>
                        </td>
                    </tr>
                    <tr class="form-group">
                        <td>
                            <div class="input-group">
                                <span class="input-group-addon">头像</span>
                                <input type="file" name="headPic">
                            </div>
                        </td>
                    </tr>

                    <tr class="form-group">
                        <td>
                            <small>账号信息</small>
                        </td>
                    </tr>
                    <tr class="form-group">
                        <td>
                            <div class="input-group">
                                <span class="input-group-addon" id="nicknameSpan">昵称</span>
                                <input id="nickname" class="form-control" type="text" placeholder="长度为3~8字符"
                                       aria-describedby="nicknameSpan" name="nickname"
                                       value="${sessionScope.userInfo.nickname}">
                            </div>
                        </td>
                    </tr>
                    <tr class="form-group">
                        <td>
                            <div class="input-group">
                                <span class="input-group-addon" id="emailSpan">E-Mail</span>
                                <input id="email" class="form-control" type="email"
                                       aria-describedby="emailSpan" name="email" value="${sessionScope.userInfo.email}">
                            </div>
                        </td>
                    </tr>
                    <tr class="form-group">
                        <td>
                            <div class="input-group">
                                <span class="input-group-addon" id="passwordSpan">密码</span>
                                <input id="password" class="form-control" type="password" placeholder="长度为3~8字符"
                                       aria-describedby="passwordSpan" name="password"
                                       value="${sessionScope.userInfo.password}">
                            </div>
                        </td>
                    </tr>
                    <tr class="form-group">
                        <td>
                            <div class="input-group">
                                <span class="input-group-addon" id="rePasswordSpan">再次输入</span>
                                <input id="rePassword" class="form-control" type="password" placeholder="长度为3~8字符"
                                       aria-describedby="rePasswordSpan" name="rePassword">
                            </div>
                        </td>
                    </tr>

                    <tr class="form-group">
                        <td>
                            <small>基本信息</small>
                        </td>
                    </tr>
                    <tr class="form-group">
                        <td>
                            <div class="input-group">
                                <span class="input-group-addon" id="usernameSpan">真实姓名</span>
                                <input id="userName" class="form-control" type="text" placeholder="2-5个字符"
                                       aria-describedby="usernameSpan" name="username">
                            </div>
                        </td>
                    </tr>
                    <tr class="form-group">
                        <td>
                            <div class="input-group">
                                <span class="input-group-addon" id="sexSpan">性别</span>
                                <select id="sex" class="form-control" aria-describedby="sexSpan" name="sex">
                                    <option value="男">男</option>
                                    <option value="女">女</option>
                                </select>
                            </div>
                        </td>
                    </tr>

                    <tr class="form-group">
                        <td>
                            <div class="input-group">
                                <span class="input-group-addon" id="ageSpan">年龄</span>
                                <input class="form-control" type="number" id="age" aria-describedby="ageSpan"
                                       name="age">
                            </div>
                        </td>
                    </tr>

                    <tr class="form-group">
                        <td>
                            <div class="input-group">
                                <span class="input-group-addon" id="birthdaySpan">生日</span>
                                <input size="16" type="date" value="1999/12/30" id="birthday"
                                       aria-describedby="birthdaySpan" class="form-control" name="birthday">
                            </div>
                        </td>
                    </tr>

                    <tr class="form-group">
                        <td>
                            <div class="input-group">
                                <span class="input-group-addon" id="telSpan">电话</span>
                                <input class="form-control" id="tel" type="tel" name="tel">
                            </div>
                        </td>
                    </tr>

                    <tr class="form-group">
                        <td>
                            <small>地址信息</small>
                        </td>
                    </tr>
                    <tr class="form-group">
                        <td>
                            <div class="input-group">
                                <span class="input-group-addon" id="provinceSpan">省份</span>
                                <input class="form-control" name="province" type="text" aria-describedby="provinceSpan">
                            </div>
                        </td>
                    </tr>
                    <tr class="form-group">
                        <td>
                            <div class="input-group">
                                <span class="input-group-addon" id="citySpan">城市</span>
                                <input class="form-control" name="city" type="text" aria-describedby="citySpan">
                            </div>
                        </td>
                    </tr>
                    <tr class="form-group">
                        <td>
                            <div class="input-group">
                                <span class="input-group-addon" id="areaSpan">地区</span>
                                <input class="form-control" name="area" type="text" aria-describedby="areaSpan">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="input-group">
                                <button type="submit" class="btn btn-default btn-block">提交</button>
                            </div>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
<jsp:include page="common/copyright.jsp"/>
</body>
</html>
