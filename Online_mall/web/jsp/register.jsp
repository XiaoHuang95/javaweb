
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册页面</title>
    <!--引入jQuery-->
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <style type="text/css">
        span {
            color: red;
            font-size: 12px;
        }
        .register_panel{
            width: 60%;
            height: 350px;
            margin: auto;
        }
    </style>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/shop_panel.css"/>
</head>
<body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ConfirmRegister.js"></script>
<div class="register_panel">
    <fieldset class="register_panel">
        <legend>
            新用户注册
        </legend>
        <form id="userForm" method="post" >
            <table align="center">
                <tr>
                    <td>用户名：</td>
                    <td><input type="text" name="userName" id="username" placeholder="请输入用户名"></td>
                    <td><span id="usernameError">
<!--                                <font color="gray">用户名由[6-14]数字和字母组成</font>-->
                            </span></td>
                </tr>
                <tr>
                    <td>密码：</td>
                    <td><input type="password" name="password" id="password" placeholder="请输入密码"/></td>
                    <td><span id="passwordError">
<!--                                <font color="gray">密码由[8-16]数字和字母组成</font>-->
                            </span></td>
                </tr>
                <tr>
                    <td>确认密码：</td>
                    <td><input type="password" id="password1" placeholder="确认密码"/></td>
                    <td><span id="passwordError2"></span></td>
                </tr>
                <tr>
                    <td>邮箱：</td>
                    <td><input type="text" name="email" id="email" placeholder="请输入邮箱"/></td>
                    <td><span id="emailSpan"></span></td>
                </tr>
                <tr>
                    <td>性别：</td>
                    <td>
                        <input type="radio" name="gender" value="male"/>男
                        <input type="radio" name="gender" value="female" checked/>女
                    </td>
                </tr>
                <tr>
                    <td>手机号码：</td>
                    <td>
                        <input type="text" name="phoneNum" id="phoneNum" placeholder="请输入手机号码"/>
                    </td>
                    <td><span id="phoneNumSpan"></span></td>
                </tr>
                <tr align="center">
                    <td colspan="2">
                        <input type="button" value="注册" id="userFormBtn"/>
                    </td>
                </tr>
            </table>
        </form>
    </fieldset>
</div>
</body>
</html>
