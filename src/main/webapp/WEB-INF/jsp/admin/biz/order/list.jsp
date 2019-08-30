<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
	<title>订单列表</title>
	<style type="text/css">
		table td{
			max-width: 500px;
			word-wrap: break-word;
			text-overflow: ellipsis;
			white-space: nowrap;
			overflow: hidden;
			cursor: hand;
		}
		table td:hover{
		white-space: normal;
		overflow: auto;
		}
	</style>
</head>
<body>
	<div>
		<s:form id="form1" name="form1" action="listByCondition" namespace="/biz/order" method="POST" theme="simple">
			<table width="80%" cellspacing="0" cellpadding="0" align="center" border="1">
				<caption>条件查询</caption>
				<tr>
					<s:hidden name="pageIndex" value="1" />
					<s:hidden name="pageSize" value="10" />
					<td>所属用户：</td><td><s:textfield id="customerUsername" name="customerUsername" cssClass="text" maxlength="20" /></td>
				</tr>
				<tr>
					<%--// 1=订单未支付 2=订单支付超时 3=订单已支付 4=已发货 5=订单完成 6=交易关闭--%>
					<td>状态：</td><td><s:select id="status" name="status" list="#{'1':'订单未支付','2':'订单支付超时','3':'订单已支付','4':'已发货','5':'订单完成','6':'交易关闭'}" headerKey="" headerValue="--请选择状态--" /></td>
				</tr>
				<tr align="center">
					<td colspan="4">
						<s:submit id="listByCondition" name="listByCondition" value="查询" cssClass="button" />
						<s:reset id="reset" name="reset" value="重置" cssClass="button" />
					</td>
				</tr>
			</table>
		</s:form>
	</div>
	<div>
		<table width="80%" cellspacing="0" cellpadding="0" align="center" border="1">
			<caption>订单列表</caption>
			<tr>
				<th>订单编号</th>
				<th>创建时间</th>
				<th>收货地址</th>
				<th>联系电话</th>
				<th>收货人</th>
				<th>重量</th>
				<th>运费</th>
				<th>金额</th>
				<th>支付时间</th>
				<th>状态</th>
				<th>所属用户</th>
				<th>编辑</th>
				<th>详情</th>
			</tr>
			<s:iterator var="order" value="orderPageBean.list">
				<tr align="center">
					<td><s:property value="#order.sn" /></td>
					<td><s:property value="#order.gmtCreate" /></td>
					<td><s:property value="#order.address" /></td>
					<td><s:property value="#order.telephone" /></td>
					<td><s:property value="#order.consignee" /></td>
					<td><s:property value="#order.weight" /></td>
					<td><s:property value="#order.freight" /></td>
					<td><s:property value="#order.price" /></td>
					<td><s:property value="#order.gmtPayment" /></td>
					<%--// 1=订单未支付 2=订单支付超时 3=订单已支付 4=已发货 5=订单完成 6=交易关闭--%>
					<td><s:property
							value="#order.status == 1?'订单未支付':#order.status == 2?'支付超时':#order.status == 3?'订单已支付':#order.status == 4?'已发货':#order.status == 5?'订单完成':'交易关闭'" />
					</td>
					<td><s:property value="#order.customer.username" /></td>
					<td>
						<s:a action="selected" namespace="/biz/order">
							<s:param name="id" value="%{#order.id}" />
							编辑
						</s:a>
					</td>
					<td>
						<s:url action="detail" namespace="/biz/order" var="detail_url">
							<s:param name="id" value="%{#order.id}" />
						</s:url>
						<s:a href="%{#detail_url}">
							查看详情
						</s:a>
					</td>
				</tr>
			</s:iterator>
			<tr align="center">
				<td colspan="20">
					第<s:property value="orderPageBean.pageIndex" />页/<s:property value="orderPageBean.totalPage" />页
					<s:if test="orderPageBean.pageIndex > 1">
						<a href="${pageContext.request.contextPath}/biz/order/list.action?pageIndex=1&pageSize=<s:property value="orderPageBean.pageSize" />"> | 首页</a>
						<a href="${pageContext.request.contextPath}/biz/order/list.action?pageIndex=<s:property value="orderPageBean.pageIndex-1" />&pageSize=<s:property value="orderPageBean.pageSize" />"> | 上一页</a>
					</s:if>
					<s:if test="orderPageBean.pageIndex < orderPageBean.totalPage">
						<a href="${pageContext.request.contextPath}/biz/order/list.action?pageIndex=<s:property value="orderPageBean.pageIndex+1" />&pageSize=<s:property value="orderPageBean.pageSize" />"> | 下一页</a>
						<a href="${pageContext.request.contextPath}/biz/order/list.action?pageIndex=<s:property value="orderPageBean.totalPage" />&pageSize=<s:property value="orderPageBean.pageSize" />"> | 尾页</a>
					</s:if>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>