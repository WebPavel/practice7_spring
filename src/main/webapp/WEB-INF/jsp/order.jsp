<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
	<title>订单页面</title>
	<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
	<link href="${pageContext.request.contextPath}/css/cart.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<%@ include file="top.jsp" %>
<div class="container cart">
		<div class="span24">
			<div class="step step2">
				<ul>
					<li>购物车列表</li>
					<li class="current">生成订单成功</li>
					<li>支付成功</li>
				</ul>
			</div>
				<table>
					<tbody>
						<tr>
							<th>图片</th>
							<th>商品</th>
							<th>价格</th>
							<th>数量</th>
							<th>小计</th>
						</tr>
						<s:iterator var="orderItem" value="model.orderItemSet">
							<tr>
								<td width="60">
									<img src="${pageContext.request.contextPath}<s:property value="#orderItem.product.imgthumb" />"/>
								</td>
								<td>
									<a target="_blank" href="${pageContext.request.contextPath}/biz/product/get.action?id=<s:property value="#orderItem.product.id" />"><s:property value="#orderItem.product.name"/></a>
								</td>
								<td>
									￥<s:property value="#orderItem.product.sellingPrice" />
								</td>
								<td class="quantity" width="60">
									<s:property value="#orderItem.quantity" />
								</td>
								<td width="140">
									<span class="subtotal">￥<s:property value="#orderItem.price" /></span>
								</td>
							</tr>
						</s:iterator>
				</tbody>
			</table>
				<dl id="giftItems" class="hidden" style="display: none;"></dl>
				<div class="total">
					<em id="promotion">您的订单号：<s:property value="model.sn" /></em>
					商品金额：<strong id="effectivePrice">￥<s:property value="model.price" /></strong>
				</div>
			<form id="orderForm" action="${pageContext.request.contextPath}/biz/order/goPay.action" method="post">
				<input type="hidden" name="id" value="<s:property value="model.id" />" />
				<div class="span24">
					<p>
						收货地址：<input name="address" type="text" value="<s:property value="model.address" />" style="width:350px" /><br />
						收货人：<input name="consignee" type="text" value="<s:property value="model.consignee" />" style="width:150px" /><br />
						联系方式：<input name="telephone" type="text" value="<s:property value="model.telephone" />" style="width:150px" />
					</p>
					<hr />
					<p>
						选择支付方式：<br />
						<input type="radio" name="payChannel" value="alipay" checked="checked"/>支付宝付款-推荐使用
						<img src="${pageContext.request.contextPath}/images/alipay.png" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
					</p>
					<hr />
					<p style="text-align:right">
						<a href="javascript:document.getElementById('orderForm').submit();">
							<img src="${pageContext.request.contextPath}/images/final_button.gif" width="204" height="51" border="0" />
						</a>
					</p>
				</div>
			</form>
		</div>
	</div>
<%@ include file="bottom.jsp" %>
</body>
</html>