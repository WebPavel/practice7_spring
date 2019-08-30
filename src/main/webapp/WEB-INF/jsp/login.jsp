<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>会员登录</title>
    <link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css">
    <script type="text/javascript">
        function checkForm() {
            var username = document.getElementById("username").value;
            if (username == '') {
                alert("用户名不能为空！");
                return false;
            }
            var password = document.getElementById("password").value;
            if (password == '' || password.length < 6) {
                alert("密码不能为空！且长度不能少于6位！");
                return false;
            }
            return true;
        }
        function redrawCaptcha() {
            var captchaImage = document.getElementById("captchaImage");
            captchaImage.src = "${pageContext.request.contextPath}/usr/customer/captcha.action?"+new Date().getTime();
        }
    </script>
</head>
<body>
    <%@ include file="top.jsp" %>
    <div class="container login">
        <div class="span12">
            <div class="ad">
                <img src="${pageContext.request.contextPath}/images/login.jpg" width="500" height="330" alt="会员登录" title="会员登录">
            </div>
        </div>
        <div class="span12 last">
            <div class="wrap">
                <div class="main">
                    <div class="title">
                        <strong>会员登录</strong>USER LOGIN
                    </div>
                    <form id="loginForm" action="${pageContext.request.contextPath}/usr/customer/login.action" method="post" novalidate="novalidate" onsubmit="return checkForm();">
                        <table>
                            <tbody>
                            <tr>
                                <th>
                                    用户名:
                                </th>
                                <td>
                                    <input type="text" id="username" name="username" class="text" maxlength="20" />
                                    <span><s:fielderror fieldName="username" /></span>
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    密码:
                                </th>
                                <td>
                                    <input type="password" id="password" name="password" class="text" maxlength="20" autocomplete="off" />
                                    <span><s:fielderror fieldName="password" /></span>
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    验证码:
                                </th>
                                <td>
                                    <span class="fieldSet">
                                        <input type="text" id="captcha" name="captcha" class="text captcha" maxlength="4" autocomplete="off" />
                                        <img id="captchaImage" class="captchaImage" src="${pageContext.request.contextPath}/usr/customer/captcha.action" title="看不清，换一张" onclick="redrawCaptcha()">
                                    </span>
                                </td>
                            </tr>
                            <tr>
                                <th>&nbsp;</th>
                                <td>
                                    <label>
                                        <input type="checkbox" id="isRememberUsername" name="isRememberUsername" value="true" />记住用户名
                                    </label>
                                    <label>&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/usr/customer/goResetPassword.action">找回密码</a></label>
                                </td>
                            </tr>
                            <tr>
                                <th>&nbsp;</th>
                                <td>
                                    <input type="submit" class="submit" value="登 录" />
                                    &nbsp;&nbsp;<font style="color: red"><s:actionerror /></font>
                                </td>
                            </tr>
                            <tr class="register">
                                <th>&nbsp;</th>
                                <td>
                                    <dl>
                                        <dt>还没有注册账号？</dt>
                                        <dd>
                                            立即注册即可体验在线购物！
                                            <a href="${pageContext.request.contextPath}/usr/customer/goRegister.action">立即注册</a>
                                        </dd>
                                    </dl>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="bottom.jsp" %>
</body>
</html>
