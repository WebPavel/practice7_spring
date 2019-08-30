<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
	<title>京华亿家</title>
	<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/product.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
        function increase() {
            var quantity = $("#quantity").val();
            document.getElementById("quantity").value=parseInt(quantity)+1;
        }
        function decrease() {
            var quantity = $("#quantity").val();
            if (quantity > 1) {
            	document.getElementById("quantity").value=parseInt(quantity)-1;
			} else {
                alert("客官，不能再减了！");
			}
        }
	</script>
</head>
<body>
<%@ include file="top.jsp" %>
<div class="container productContent">
		<div class="span6">
			<div class="hotProductCategory">
				<s:iterator var="category" value="categoryList">
					<dl>
						<dt>
							<a href="${pageContext.request.contextPath}/biz/product/listByCategory.action?categoryId=<s:property value="#category.id" />&pageIndex=1&pageSize=10"><s:property value="#category.name" /></a>
						</dt>
						<s:iterator var="subcategory" value="#category.subcategorySet">
							<dd>
								<a href="${pageContext.request.contextPath}/biz/product/listBySubcategory.action?subcategoryId=<s:property value="#subcategory.id" />&pageIndex=1&pageSize=10"><s:property value="#subcategory.name" /></a>
							</dd>
						</s:iterator>
					</dl>
				</s:iterator>
			</div>
		</div>
	<form action="${pageContext.request.contextPath}/biz/cart/addCartItem.action" method="post">
		<input type="hidden" name="productId" value="<s:property value="model.id" />" />
		<div class="span18 last">
			<div class="productImage">
					<a title="" style="outline-style: none; text-decoration: none;" id="zoom" href="${pageContext.request.contextPath}<s:property value="model.imgthumb" />" rel="gallery">
						<div class="zoomPad">
							<img style="opacity: 1;" title="<s:property value="model.name" />" class="medium" src="${pageContext.request.contextPath}<s:property value="model.imgthumb" />">
							<div style="visibility: hidden; top: 129.5px; left: 106px; position: absolute;" class="zoomPreload">Loading zoom</div>
						</div>
					</a>
			</div>
			<div class="name"><s:property value="model.name" /></div>
			<div class="sn">
				<div>编号：<s:property value="model.serialNumber" /></div>
			</div>
			<div class="info">
				<dl>
					<dt>亿家价：</dt>
					<dd>
						<strong>￥<s:property value="model.sellingPrice" />/<s:property value="model.sku" /></strong>
						参考价：
						<del>￥<s:property value="model.marketPrice" />/<s:property value="model.sku" /></del>
					</dd>
				</dl>
					<dl>
						<dt>促销：</dt>
						<dd>
							<a target="_blank" title="限时抢购(2014-07-30 ~ 2015-01-01)">限时抢购</a>
						</dd>
					</dl>
			</div>
				<div class="action">
					<dl class="quantity">
						<dt>购买数量：</dt>
						<dd>
							<input id="quantity" name="quantity" value="1" maxlength="4" onpaste="return false;" type="text">
							<div>
								<span id="increase" class="increase" onclick="increase()">&nbsp;</span>
								<span id="decrease" class="decrease" onclick="decrease()">&nbsp;</span>
							</div>
						</dd>
						<dd>
							<s:property value="model.sku" />
						</dd>
					</dl>
					<div class="buy">
						<input id="addCart" class="addCart" value="加入购物车" type="submit">
					</div>
				</div>
			<div id="bar" class="bar">
				<ul>
					<li id="introductionTab">
						<a href="#introduction">商品介绍</a>
					</li>
				</ul>
			</div>
			<div id="introduction" name="introduction" class="introduction">
				<div class="title">
					<strong>商品介绍</strong>
				</div>
				<div>
					<s:property value="model.description" />
				</div>
			</div>
		</div>
	</form>
</div>
<%@ include file="bottom.jsp" %>
</body>
</html>