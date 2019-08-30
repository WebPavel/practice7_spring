<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
	<title>用户列表</title>
</head>
<body>
	<div>
		<s:form id="form1" name="form1" action="listByCondition" namespace="/usr/customer" method="POST" theme="simple">
			<table width="80%" cellspacing="0" cellpadding="0" align="center" border="1">
				<caption>条件查询</caption>
				<tr>
					<s:hidden name="pageIndex" value="1" />
					<s:hidden name="pageSize" value="10" />
					<td>用户名：</td><td><s:textfield id="username" name="username" cssClass="text" maxlength="20" /></td>
				</tr>
				<tr>
					<td>状态：</td><td><s:select id="state" name="state" list="#{0:'未激活',1:'正常',2:'删除',3:'停用'}" headerKey="" headerValue="--请选择状态--" /></td>
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
			<caption>用户列表</caption>
			<tr>
				<th>用户名</th>
				<th>联系电话</th>
				<th>昵称</th>
				<th>电子邮箱</th>
				<th>真实姓名</th>
				<th>性别</th>
				<th>出生日期</th>
				<th>所在地区</th>
				<th>通讯地址</th>
				<th>邮编</th>
				<th>状态</th>
				<th>创建时间</th>
				<th>详情</th>
				<th>删除</th>
			</tr>
			<s:iterator var="customer" value="customerPageBean.list">
				<tr align="center">
					<td><s:property value="#customer.username" /></td>
					<td><s:property value="#customer.telephone" /></td>
					<td><s:property value="#customer.nickname" /></td>
					<td><s:property value="#customer.email" /></td>
					<td><s:property value="#customer.trueName" /></td>
					<td><s:property value="#customer.gender == 0?'男':#customer.gender == 1?'女':'保密'" /></td>
					<td><s:property value="#customer.birthday" /></td>
					<td><s:property value="#customer.region" /></td>
					<td><s:property value="#customer.address" /></td>
					<td><s:property value="#customer.postalCode" /></td>
					<td><s:property value="#customer.state == 0?'未激活':#customer.state == 1?'正常':#customer.state == 2?'删除':'停用'" /></td>
					<td><s:property value="#customer.gmtCreate" /></td>
					<td>
						<s:a action="selected" namespace="/usr/customer">
							<s:param name="id" value="%{#customer.id}" />
							详情
						</s:a>
					</td>
					<td>
						<s:url action="delete" namespace="/usr/customer" var="delete_url">
							<s:param name="id" value="%{#customer.id}" />
						</s:url>
						<s:a href="%{#delete_url}">
							删除
						</s:a>
					</td>
				</tr>
			</s:iterator>
			<tr align="center">
				<td colspan="14">
					第<s:property value="customerPageBean.pageIndex" />页/<s:property value="customerPageBean.totalPage" />页
					<s:if test="customerPageBean.pageIndex > 1">
						<a href="${pageContext.request.contextPath}/usr/customer/list.action?pageIndex=1&pageSize=<s:property value="customerPageBean.pageSize" />"> | 首页</a>
						<a href="${pageContext.request.contextPath}/usr/customer/list.action?pageIndex=<s:property value="customerPageBean.pageIndex-1" />&pageSize=<s:property value="customerPageBean.pageSize" />"> | 上一页</a>
					</s:if>
					<s:if test="customerPageBean.pageIndex < customerPageBean.totalPage">
						<a href="${pageContext.request.contextPath}/usr/customer/list.action?pageIndex=<s:property value="customerPageBean.pageIndex+1" />&pageSize=<s:property value="customerPageBean.pageSize" />"> | 下一页</a>
						<a href="${pageContext.request.contextPath}/usr/customer/list.action?pageIndex=<s:property value="customerPageBean.totalPage" />&pageSize=<s:property value="customerPageBean.pageSize" />"> | 尾页</a>
					</s:if>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>