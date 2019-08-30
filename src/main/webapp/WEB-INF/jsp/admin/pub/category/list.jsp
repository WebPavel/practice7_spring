<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
	<title>一级分类列表</title>
</head>
<body>
	<div>
		<s:form id="form1" name="form1" action="listByCondition" namespace="/pub/category" method="POST" theme="simple">
			<table width="80%" cellspacing="0" cellpadding="0" align="center" border="1">
				<caption>条件查询</caption>
				<tr>
					<s:hidden name="pageIndex" value="1" />
					<s:hidden name="pageSize" value="10" />
					<td>名称：</td><td><s:textfield id="name" name="name" cssClass="text" maxlength="20" /></td>
					<td colspan="2">tip：优先进行前缀模糊搜索</td>
				</tr>
				<tr>
					<td>是否热门：</td><td><s:select id="isHot" name="isHot" list="#{'0':'否','1':'是'}" headerKey="" headerValue="--请选择是否热门--" /></td>
					<td>状态：</td><td><s:select id="status" name="status" list="#{'0':'禁用','1':'正常'}" headerKey="" headerValue="--请选择状态--" /></td>
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
	<div style="margin-left: 10%">
		<a href="${pageContext.request.contextPath}/pub/category/goAdd.action">添加</a>
	</div>
	<div>
		<table width="80%" cellspacing="0" cellpadding="0" align="center" border="1">
			<caption>一级分类列表</caption>
			<tr>
				<th>一级分类名称</th>
				<th>是否热门</th>
				<th>状态</th>
				<th>创建时间</th>
				<th>编辑</th>
				<th>删除</th>
			</tr>
			<s:iterator var="category" value="categoryPageBean.list">
				<tr align="center">
					<td><s:property value="#category.name" /></td>
					<td><s:property value="#category.isHot == 0?'否':'是'" /></td>
					<td><s:property value="#category.status == 0?'禁用':'正常'" /></td>
					<td><s:property value="#category.gmtCreate" /></td>
					<td>
						<s:a action="selected" namespace="/pub/category">
							<s:param name="id" value="%{#category.id}" />
							编辑
						</s:a>
					</td>
					<td>
						<s:url action="delete" namespace="/pub/category" var="delete_url">
							<s:param name="id" value="%{#category.id}" />
						</s:url>
						<s:a href="%{#delete_url}">
							删除
						</s:a>
					</td>
				</tr>
			</s:iterator>
			<tr align="center">
				<td colspan="6">
					第<s:property value="categoryPageBean.pageIndex" />页/<s:property value="categoryPageBean.totalPage" />页
					<s:if test="categoryPageBean.pageIndex > 1">
						<a href="${pageContext.request.contextPath}/pub/category/list.action?pageIndex=1&pageSize=<s:property value="categoryPageBean.pageSize" />"> | 首页</a>
						<a href="${pageContext.request.contextPath}/pub/category/list.action?pageIndex=<s:property value="categoryPageBean.pageIndex-1" />&pageSize=<s:property value="categoryPageBean.pageSize" />"> | 上一页</a>
					</s:if>
					<s:if test="categoryPageBean.pageIndex < categoryPageBean.totalPage">
						<a href="${pageContext.request.contextPath}/pub/category/list.action?pageIndex=<s:property value="categoryPageBean.pageIndex+1" />&pageSize=<s:property value="categoryPageBean.pageSize" />"> | 下一页</a>
						<a href="${pageContext.request.contextPath}/pub/category/list.action?pageIndex=<s:property value="categoryPageBean.totalPage" />&pageSize=<s:property value="categoryPageBean.pageSize" />"> | 尾页</a>
					</s:if>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>