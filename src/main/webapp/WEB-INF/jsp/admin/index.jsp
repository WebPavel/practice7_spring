<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>后台登录</title>
    <script type="text/javascript">
        document.getElementById("username").focus();
        function validateForm() {
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
    </script>
</head>
<body style="color: white;background: #278296">
        <table cellspacing="0" cellpadding="0" style="margin-top: 100px;padding: 10px" align="center">
            <caption>欢迎回来</caption>
            <tr>
                <td>
                    <form name="loginForm" action="${pageContext.request.contextPath}/usr/manager/login.action" method="post" onsubmit="return validateForm();">
                        <table cellpadding="10">
                            <tr>
                                <td>用户名：</td>
                                <td>
                                    <input id="username" type="text" name="username"/>
                                    <font color="red"><span><s:fielderror fieldName="username" /></span></font>
                                </td>
                            </tr>
                            <tr>
                                <td>密码：</td>
                                <td>
                                    <input id="password" type="password" name="password"/>
                                    <font color="red"><span><s:fielderror fieldName="password" /></span></font>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" align="center">
                                    <input type="submit" value="登录" class="button"/>
                                    &raquo;<a href="${pageContext.request.contextPath}/usr/manager/goIndex.action">返回首页</a>&raquo;
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" align="center">
                                    <font color="red"><s:actionerror /></font>
                                </td>
                            </tr>
                        </table>
                    </form>
                </td>
            </tr>
            <tr>
                <td>
                    <p>
                        忘记密码？<br />
                        联系admin@gwwind.cn重置
                    </p>
                </td>
            </tr>
        </table>
</body>
</html>