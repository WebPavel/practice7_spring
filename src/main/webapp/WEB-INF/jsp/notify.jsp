<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>支付结果通知</title>
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
                            <s:if test="payResponse.isSuccess == true">
                                亲，付款成功，我们会尽快给您发货！
                                <p>
                                    交易金额：￥<s:property value="payResponse.total_amount" /><br/>
                                    您的订单号：<s:property value="payResponse.out_trade_no" /><br/>
                                    支付宝交易号：<s:property value="payResponse.trade_no" /><br/><br/>
                                </p>
                            </s:if>
                            <s:else>
                                <font style="font-weight:bold; color:#FF0000">付款失败</font>，失败原因：<s:property value="payResponse.ext_desc" /><br/><br/>
                            </s:else>
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
