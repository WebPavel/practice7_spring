<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
	<title>商品列表</title>
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
		<s:form id="form1" name="form1" action="listByCondition" namespace="/biz/product" method="POST" theme="simple">
			<table width="80%" cellspacing="0" cellpadding="0" align="center" border="1">
				<caption>条件查询</caption>
				<tr>
					<s:hidden name="pageIndex" value="1" />
					<s:hidden name="pageSize" value="10" />
					<td>名称：</td><td><s:textfield id="name" name="name" cssClass="text" maxlength="20" /></td>
					<td>所属二级分类：</td>
					<td>
						<select name="subcategoryId">
							<option value="">--请选择所属二级分类--</option>
							<s:iterator var="subcategory" value="subcategoryList">
								<s:if test="#subcategory.id == subcategoryId">
									<option value="<s:property value="#subcategory.id" />" selected="selected"><s:property value="#subcategory.name" /></option>
								</s:if>
								<s:else>
									<option value="<s:property value="#subcategory.id" />"><s:property value="#subcategory.name" /></option>
								</s:else>
							</s:iterator>
						</select>
					</td>
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
		<a href="${pageContext.request.contextPath}/biz/product/goAdd.action">添加</a>
	</div>
	<div>
		<table width="80%" cellspacing="0" cellpadding="0" align="center" border="1">
			<caption>商品列表</caption>
			<tr>
				<th>名称</th>
				<th>商场价</th>
				<th>划线价</th>
				<th>折扣</th>
				<th>商品介绍</th>
				<th>商品图片</th>
				<th>库存</th>
				<th>编号</th>
				<th>条形码</th>
				<th>品牌</th>
				<th>产地</th>
				<th>保质期</th>
				<th>重量</th>
				<th>是否热门</th>
				<th>状态</th>
				<th>排序</th>
				<th>创建时间</th>
				<th>所属二级分类</th>
				<th>编辑</th>
				<th>删除</th>
			</tr>
			<s:iterator var="product" value="productPageBean.list">
				<tr align="center">
					<td><s:property value="#product.name" /></td>
					<td><s:property value="#product.marketPrice" /></td>
					<td><s:property value="#product.sellingPrice" /></td>
					<td><s:property value="#product.discount" /></td>
					<td><s:property value="#product.description" /></td>
					<td><img width="35" height="40" src="${pageContext.request.contextPath}<s:property value="#product.imgthumb" />"></td>
					<td><s:property value="#product.stock" /></td>
					<td><s:property value="#product.serialNumber" /></td>
					<td><s:property value="#product.upc" /></td>
					<td><s:property value="#product.brand" /></td>
					<td><s:property value="#product.madeIn" /></td>
					<td><s:property value="#product.shelfLife" /></td>
					<td><s:property value="#product.weight" /></td>
					<td><s:property value="#product.isHot == 0?'否':'是'" /></td>
					<td><s:property value="#product.status == 0?'禁用':'正常'" /></td>
					<td><s:property value="#product.sortNumber" /></td>
					<td><s:property value="#product.gmtCreate" /></td>
					<td><s:property value="#product.subcategory.name" /></td>
					<td>
						<s:a action="selected" namespace="/biz/product">
							<s:param name="id" value="%{#product.id}" />
							编辑
						</s:a>
					</td>
					<td>
						<s:url action="delete" namespace="/biz/product" var="delete_url">
							<s:param name="id" value="%{#product.id}" />
						</s:url>
						<s:a href="%{#delete_url}">
							删除
						</s:a>
					</td>
				</tr>
			</s:iterator>
			<tr align="center">
				<td colspan="20">
					第<s:property value="productPageBean.pageIndex" />页/<s:property value="productPageBean.totalPage" />页
					<s:if test="productPageBean.pageIndex > 1">
						<a href="${pageContext.request.contextPath}/biz/product/list.action?pageIndex=1&pageSize=<s:property value="productPageBean.pageSize" />"> | 首页</a>
						<a href="${pageContext.request.contextPath}/biz/product/list.action?pageIndex=<s:property value="productPageBean.pageIndex-1" />&pageSize=<s:property value="productPageBean.pageSize" />"> | 上一页</a>
					</s:if>
					<s:if test="productPageBean.pageIndex < productPageBean.totalPage">
						<a href="${pageContext.request.contextPath}/biz/product/list.action?pageIndex=<s:property value="productPageBean.pageIndex+1" />&pageSize=<s:property value="productPageBean.pageSize" />"> | 下一页</a>
						<a href="${pageContext.request.contextPath}/biz/product/list.action?pageIndex=<s:property value="productPageBean.totalPage" />&pageSize=<s:property value="productPageBean.pageSize" />"> | 尾页</a>
					</s:if>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>