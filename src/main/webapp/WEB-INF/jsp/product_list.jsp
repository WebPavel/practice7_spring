<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
	<title>琳琅满目</title>
	<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/product.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@ include file="top.jsp" %>
<div class="container productList">
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
		<div class="span18 last">
				<div id="result" class="result table clearfix">
						<ul>
							<s:iterator var="product" value="productPageBean.list">
								<li>
									<a href="${pageContext.request.contextPath}/biz/product/get.action?id=<s:property value="#product.id" />">
										<img src="${pageContext.request.contextPath}<s:property value="#product.imgthumb" />" width="170" height="170"  style="display: inline-block;">
										<span style='color:green'>
											<s:property value="#product.name" />
										</span>
										<span class="price">
											亿家价：￥<s:property value="#product.marketPrice" />/<s:property value="#product.sku" />
										</span>
									</a>
								</li>
							</s:iterator>
						</ul>
				</div>
		</div>
</div>
<%@ include file="bottom.jsp" %>
</body>
</html>