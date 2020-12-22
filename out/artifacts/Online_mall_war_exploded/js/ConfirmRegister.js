window.onload = function () {
    //验证用户名
    var usernameErrorSpan = document.getElementById("usernameError");
    var usernameElt = document.getElementById("username");
    //绑定blur事件
    usernameElt.onblur = function () {
        var username = usernameElt.value;
        //去除空白
        username = username.trim();
        if (username.length == 0) {
            //如果为空字符串
            usernameErrorSpan.innerText = "用户名不能为空！"
        } else {
            //不为空字符串
            //判断长度
            if (username.length < 6 || username.length > 14) {
                //用户名长度非法
                usernameErrorSpan.innerText = "用户名的长度为6-14位！"
            } else {
                //用户名长度合法
                //判断是否包含特殊字符
                var RegExp = /^[A-Za-z0-9]+$/;
                var ok = RegExp.test(username);
                if (!ok) {
                    //用户名不合法
                    usernameErrorSpan.innerText = "用户名只能由数字和字母组成！"
                }
            }
        }
    }
    //清空
    usernameElt.onfocus = function () {
        //清空不合法信息
        if (usernameErrorSpan.innerText != "") {
            usernameElt.value = " ";
        }
        //清空错误信息
        usernameErrorSpan.innerText = " ";
    }

    //验证密码
    //绑定onblur事件
    var psdElt = document.getElementById("password");
    var passwordErrorSpan = document.getElementById("passwordError");
    psdElt.onblur = function () {
        var password = psdElt.value;
        if (password.length == 0) {
            //密码为空
            passwordErrorSpan.innerText = "密码不能为空！"
        } else {
            //密码合法
            //判断密码长度是否合法
            if (password.length < 8 || password.length > 16) {
                //密码长度不合法
                passwordErrorSpan.innerText = "密码长度在[8-16]之间！"
            } else {
                //长度合法
                //判断密码是否符合规范
                var RegExp2 = /^[A-Za-z0-9]+$/;
                var ok = RegExp2.test(password);
                if (!ok) {
                    //密码不符合规范
                    passwordErrorSpan.innerText = "密码只能由数字和字母组成！"
                }
            }
        }

    }
    //清空密码框内容和提示信息
    //绑定focus事件
    psdElt.onfocus = function () {
        if (passwordErrorSpan.innerText != "") {
            psdElt.value = "";
        }
        passwordErrorSpan.innerText = "";
    }

    //验证确认密码
    var psdElt2 = document.getElementById("password1");
    var passwordErrorSpan2 = document.getElementById("passwordError2");
    psdElt2.onblur = function () {
        var password2 = psdElt2.value;
        if (password2.length == 0) {
            //密码为空
            passwordErrorSpan2.innerText = "密码不能为空！"
        } else {
            //密码不为空，判断是否与第一次输入的密码一致
            if (psdElt2.value != psdElt.value) {
                passwordErrorSpan2.innerText = "密码不一致！"
            }
        }
    }
    //清空确认密码框内容和提示信息
    //绑定focus事件
    psdElt2.onfocus = function () {
        if (passwordErrorSpan2.innerText != "") {
            psdElt2.value = "";
        }
        passwordErrorSpan2.innerText = " ";
    }

    //验证邮箱
    var emailSpan = document.getElementById("emailSpan");
    var emailElt = document.getElementById("email");
    //绑定blur事件
    emailElt.onblur = function () {
        var email = emailElt.value;
        if (email.length == 0) {
            //邮箱为空
            emailSpan.innerText = "邮箱不能为空！";
        } else {
            //邮箱不为空
            //正则表达式验证邮箱是否合法
            var RegExp3 = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
            var ok = RegExp3.test(email);
            if (!ok) {
                emailSpan.innerText = "邮箱不合法！";
            }
        }
    }
    //绑定onfocus事件
    emailElt.onfocus = function () {
        if (emailSpan.innerText != "") {
            emailElt.value = "";
        }
        emailSpan.innerText = "";
    }

    //验证手机号码
    var phoneNumSpan = document.getElementById("phoneNumSpan");
    var phoneNumElt = document.getElementById("phoneNum");
    //绑定blur事件
    phoneNumElt.onblur = function () {
        var phoneNum = phoneNumElt.value;
        if (phoneNum.length == 0) {
            //手机号码为空的情况
            phoneNumSpan.innerText = "手机号码不能为空！"
        } else {
            //手机号码不为空
            //验证手机号码的合法性
            var regExp4 = /^1[3-9]\d{9}$/;
            var ok = regExp4.test(phoneNum);
            if (!ok) {
                phoneNumSpan.innerText = "手机号码有误请重新输入！"
            }
        }
    }
    //绑定onfocus事件
    phoneNumElt.onfocus = function () {
        if (phoneNumSpan.innerText != "") {
            phoneNumElt.value = "";
        }
        phoneNumSpan.innerText = "";
    }
    //给提交按钮绑定鼠标单击事件
    var submitElt = document.getElementById("userFormBtn");
    submitElt.onclick = function () {
        //触发username的blur password的blur password1的blur email的blur
        //不需要人工操作使用纯JS代码触发事件
        usernameElt.focus();
        usernameElt.blur();

        psdElt.focus();
        psdElt.blur();

        psdElt2.focus();
        psdElt2.blur();

        emailElt.focus();
        emailElt.blur();

        phoneNumElt.focus();
        phoneNumElt.blur();
        //当所有表单都是合法的时候提交表单
        if (usernameErrorSpan.innerText == "" && passwordErrorSpan.innerText == ""
            && passwordErrorSpan2.innerText == "" && emailSpan.innerText == ""
            && phoneNumSpan.innerText == ""
        ) {
            //获取表单对象
            var userFormElt = document.getElementById("userForm");
            userFormElt.action = "../register"
            //提交表单
            userFormElt.submit();
        }
    }
}