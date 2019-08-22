<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div id="divcontent">
    <table width="850px" border="0" cellspacing="0">
        <tr>
            <td style="padding:30px; text-align:center">
                <table width="60%" border="0" cellspacing="0" style="margin-top:70px">
                    <tr>
                        <td style="width:98%"><img src="${pageContext.request.contextPath}/images/IconText_WebDev_009.jpg" width="128" height="128" /></td>
                        <td style="padding-top:30px">
                            <font style="font-weight:bold; color:#FF0000"><s:actionmessage/></font><br/><br/>
                            <hr />
                            <a href="${ pageContext.request.contextPath }/index.action">首页</a>
                            <a href="${ pageContext.request.contextPath }/usr/customer/goRegister.action">注册</a>
                            <a href="${ pageContext.request.contextPath }/usr/customer/goLogin.action">登录</a>
                        </td>
                    </tr>
                </table>
                <h1>&nbsp;</h1>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
