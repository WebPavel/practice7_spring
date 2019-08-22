<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <title>我的订单</title>
    <link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/css/cart.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<%@ include file="top.jsp" %>
<div class="container cart">
    <div class="span24">
        <div>
            订单列表
        </div>
        <table>
            <tbody>
            <s:iterator var="order" value="orderPageBean.list">
                <tr>
                    <th colspan="5">订单号：<s:property value="#order.sn"/> 金额：￥<s:property value="#order.price"/></th>
                </tr>
                <tr>
                    <th>图片</th>
                    <th>商品</th>
                    <th>价格</th>
                    <th>数量</th>
                    <th>小计</th>
                </tr>
                <s:iterator var="orderItem" value="#order.orderItemSet">
                    <tr>
                        <td width="60">
                            <img src="${pageContext.request.contextPath}<s:property value="#orderItem.product.imgthumb" />"/>
                        </td>
                        <td>
                            <a target="_blank" href="${pageContext.request.contextPath}/biz/product/get.action?id=<s:property value="#orderItem.product.id" />"><s:property value="#orderItem.product.name"/></a>
                        </td>
                        <td>
                            ￥<s:property value="#orderItem.product.sellingPrice"/>
                        </td>
                        <td class="quantity" width="60">
                            <s:property value="#orderItem.quantity"/>
                        </td>
                        <td width="140">
                            <span class="subtotal">￥<s:property value="#orderItem.price"/></span>
                        </td>
                    </tr>
                </s:iterator>
            </s:iterator>
            </tbody>
        </table>
    </div>
</div>
<%@ include file="bottom.jsp" %>
</body>
</html>