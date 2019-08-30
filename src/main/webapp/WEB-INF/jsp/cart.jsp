<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
	<title>购物车页面</title>
	<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/cart.css" rel="stylesheet" type="text/css">
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
<div class="container cart">
		<div class="span24">
				<s:if test="#session.cart == null || #session.cart.cartItemCollection.size() == 0">
					亲，您还没有购物，请先去挑选您中意的宝贝！
				</s:if>
				<s:else>
				<div class="step step1">
					<ul>
						<li class="current">购物车列表</li>
						<li>生成订单成功</li>
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
							<th>操作</th>
						</tr>
						<s:iterator var="cartItem" value="#session.cart.cartItemCollection">
							<tr>
								<td width="60">
									<img src="${pageContext.request.contextPath}<s:property value="#cartItem.product.imgthumb" />">
								</td>
								<td>
									<a target="_blank" href="${pageContext.request.contextPath}/biz/product/get.action?id=<s:property value="#cartItem.product.id" />"><s:property value="#cartItem.product.name" /></a>
								</td>
								<td>
									￥<s:property value="#cartItem.product.sellingPrice" />
								</td>
								<td class="quantity" width="60">
									<input type="text" id="quantity" name="quantity" value="<s:property value="#cartItem.quantity" />" maxlength="4" onpaste="return false;">
									<div>
										<span class="increase" onclick="increase()">&nbsp;</span>
										<span class="decrease" onclick="decrease()">&nbsp;</span>
									</div>
								</td>
								<td width="140">
									<span class="subtotal">￥<s:property value="#cartItem.price" /></span>
								</td>
								<td>
									<a href="${pageContext.request.contextPath}/biz/cart/removeCartItem.action?productId=<s:property value="#cartItem.product.id" />" class="delete">删除</a>
								</td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
				<dl id="giftItems" class="hidden" style="display: none;"></dl>
				<div class="total">
					<em id="promotion"></em>
					<em>登录后确认是否享有优惠</em>
					赠送积分: <em id="effectivePoint"><s:property value="#session.cart.price" /></em>
					商品金额: <strong id="effectivePrice">￥<s:property value="#session.cart.price" /></strong>
				</div>
				<div class="bottom">
					<a href="${pageContext.request.contextPath}/biz/cart/clear.action" id="clear" class="clear">清空购物车</a>
					<a href="${pageContext.request.contextPath}/biz/order/create.action" id="submit" class="submit">提交订单</a>
				</div>
				</s:else>
		</div>
</div>
<%@ include file="bottom.jsp" %>
</body>
</html>