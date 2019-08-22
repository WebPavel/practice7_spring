<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>京华亿家</title>
    <link href="${pageContext.request.contextPath}/css/slider.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<%@ include file="top.jsp" %>
<div class="container index">
    <div class="span24">
        <div id="hotProduct" class="hotProduct clearfix">
            <div class="title">
                <strong>热门商品</strong>
            </div>
            <ul class="tab">
                <li class="current">
                    <a href="./category_product_list.jsp?tagIds=2" target="_blank"></a>
                </li>
                <li>
                    <a target="_blank"></a>
                </li>
                <li>
                    <a target="_blank"></a>
                </li>
            </ul>
            <ul class="tabContent" style="display: block;">
                <s:iterator var="hotProduct" value="hotProductList">
                    <li>
                        <a target="_blank" href="${pageContext.request.contextPath}/biz/product/get.action?id=<s:property value="#hotProduct.id" />">
                            <img src="${pageContext.request.contextPath}<s:property value="#hotProduct.imgthumb" />" style="display: block;">
                        </a>
                    </li>
                </s:iterator>
            </ul>
        </div>
    </div>
    <div class="span24">
        <div id="newProduct" class="newProduct clearfix">
            <div class="title">
                <strong>最新商品</strong>
            </div>
            <ul class="tab">
                <li class="current">
                    <a href="./category_product_list.jsp?tagIds=2" target="_blank"></a>
                </li>
                <li>
                    <a target="_blank"></a>
                </li>
                <li>
                    <a target="_blank"></a>
                </li>
            </ul>
            <ul class="tabContent" style="display: block;">
                <s:iterator var="newProduct" value="newProductList">
                    <li>
                        <a target="_blank" href="${pageContext.request.contextPath}/biz/product/get.action?id=<s:property value="#newProduct.id" />">
                            <img src="${pageContext.request.contextPath}<s:property value="#newProduct.imgthumb" />" style="display: block;"/>
                        </a>
                    </li>
                </s:iterator>
            </ul>
            </ul>
        </div>
    </div>
    <div class="span24">
        <div class="friendLink">
            <dl>
                <dt>新手指南</dt>
                <dd>
                    <a target="_blank">支付方式</a>|
                </dd>
                <dd>
                    <a target="_blank">配送方式</a>|
                </dd>
                <dd>
                    <a target="_blank">售后服务</a>|
                </dd>
                <dd>
                    <a target="_blank">购物帮助</a>|
                </dd>
                <dd>
                    <a target="_blank">蔬菜卡</a>|
                </dd>
                <dd>
                    <a target="_blank">礼品卡</a>|
                </dd>
                <dd>
                    <a target="_blank">银联卡</a>|
                </dd>
                <dd>
                    <a target="_blank">亿家卡</a>|
                </dd>
                <dd class="more">
                    <a>更多</a>
                </dd>
            </dl>
        </div>
    </div>
</div>
<%@ include file="bottom.jsp" %>
</body>
</html>
