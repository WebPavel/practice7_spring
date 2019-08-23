<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<div class="container header">
    <div class="span5">
        <div class="logo">
            <a href="${pageContext.request.contextPath}/index.action">
                <img src="${pageContext.request.contextPath}/images/logo.gif" alt="京华亿家">
            </a>
        </div>
    </div>
    <div class="span19 last">
        <div class="topNav clearfix">
            <ul>
                <s:if test="#session.customer != null">
                    <li id="headerUsername" class="headerUsername" style="display: list-item;">
                        <s:property value="#session.customer.username" />&nbsp;|
                    </li>
                    <li id="headerLogout" class="headerLogout" style="display: list-item;">
                        <a href="${pageContext.request.contextPath}/biz/order/listByCustomer.action?pageIndex=1&pageSize=3">我的订单</a>|
                    </li>
                    <li id="headerLogout" class="headerLogout" style="display: list-item;">
                        <a href="${pageContext.request.contextPath}/usr/customer/logout.action">退出</a>|
                    </li>
                </s:if>
                <s:else>
                    <li id="headerLogin" class="headerLogin" style="display: list-item;">
                        <a href="${pageContext.request.contextPath}/usr/customer/goLogin.action">登录</a>|
                    </li>
                    <li id="headerRegister" class="headerRegister" style="display: list-item;">
                        <a href="${pageContext.request.contextPath}/usr/customer/goRegister.action">注册</a>|
                    </li>
                </s:else>
                <li>
                    <a>会员中心</a>|
                </li>
                <li>
                    <a>购物指南</a>|
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/sys/goAbout.action">关于我们</a>
                </li>
            </ul>
        </div>
        <div class="cart">
            <a href="${pageContext.request.contextPath}/biz/cart/goCart.action">购物车</a>
        </div>
        <div class="phone">
            客服热线:<strong>10086/37885248</strong>
        </div>
    </div>
    <div class="span24">
        <ul class="mainNav">
            <li>
                <a href="${pageContext.request.contextPath}/index.action">首页</a>|
            </li>
            <s:iterator var="category" value="categoryList">
                <li>
                    <a href="${pageContext.request.contextPath}/biz/product/listByCategory.action?categoryId=<s:property value="#category.id" />&pageIndex=1&pageSize=10"><s:property value="#category.name" /></a>|
                </li>
            </s:iterator>
        </ul>
    </div>
    <div class="span24">
        <div class="tagWrap">
            <ul class="tag">
                <li class="icon">
                    <a href="${pageContext.request.contextPath}/biz/product/goListHotProduct.action?pageIndex=1&pageSize=10">热销</a>
                </li>
                <li class="icon">
                    <a href="${pageContext.request.contextPath}/biz/product/goListNewProduct.action?pageIndex=1&pageSize=10">最新</a>
                </li>
            </ul>
            <div class="hotSearch">
                热门搜索:
                <a>水蜜桃</a>
                <a>西瓜</a>
                <a>紫薯</a>
                <a>大米</a>
                <a>玉米</a>
                <a>茄子</a>
                <a>辣椒</a>
                <a>圣女果</a>
                <a>鱿鱼丝</a>
            </div>
            <div class="search">
                <form id="productSearchForm" action="${pageContext.request.contextPath}/biz/product/search.action" method="get">
                    <input type="hidden" name="pageIndex" value="1">
                    <input type="hidden" name="pageSize" value="10">
                    <input name="keyword" class="keyword" value="商品搜索" maxlength="30">
                    <button type="submit">搜索</button>
                </form>
            </div>
        </div>
    </div>
</div>