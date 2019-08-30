<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>编辑二级分类</title>
    <style type="text/css">
        tr{
            text-align:center;
        }
    </style>
</head>
<body>
    <s:form id="form" name="form" action="update" namespace="/pub/subcategory" method="POST" theme="simple">
        <table width="80%" cellspacing="0" cellpadding="0" align="center" border="1">
            <caption>编辑二级分类</caption>
            <tr align="center">
                <td colspan="2">
                    <s:actionerror />
                    <s:fielderror />
                </td>
            </tr>
            <tr>
                <th>
                    二级分类名称：
                </th>
                <td>
                    <s:hidden id="id" name="id" value="%{model.id}" />
                    <s:textfield id="name" name="name" value="%{model.name}" cssClass="text" />
                </td>
            </tr>
            <tr>
                <th>
                    所属一级分类：
                </th>
                <td>
                    <select name="categoryId">
                        <option value="">--请选择所属一级分类--</option>
                        <s:iterator var="category" value="categoryList">
                            <s:if test="#category.id == model.category.id">
                                <option value="<s:property value="#category.id" />" selected="selected"><s:property value="#category.name" /></option>
                            </s:if>
                            <s:else>
                                <option value="<s:property value="#category.id" />"><s:property value="#category.name" /></option>
                            </s:else>
                        </s:iterator>
                    </select>
                </td>
            </tr>
            <tr>
                <th>
                    是否热门：
                </th>
                <td>
                    <s:radio id="isHot" name="isHot" list="#{'0':'否','1':'是'}" value="%{model.isHot}" />
                </td>
            </tr>
            <tr>
                <th>状态：</th>
                <td>
                    <s:select id="status" name="status" list="#{'0':'禁用','1':'正常'}" value="%{model.status}" />
                </td>
            </tr>
            <tr>
                <th>
                    排序{1,2,3...越小排序越靠前}：
                </th>
                <td>
                    <s:textfield id="sortNumber" name="sortNumber" cssClass="text" value="%{model.sortNumber}" />
                </td>
            </tr>
            <tr>
                <th>
                    创建时间：
                </th>
                <td>
                    <s:textfield id="gmtCreate" name="gmtCreate" cssClass="text" value="%{model.gmtCreate}" readonly="true" />
                </td>
            </tr>
            <tr>
                <th>备注：</th>
                <td>
                    <s:textarea id="remark" name="remark" cols="30" rows="3" value="%{model.remark}" />
                </td>
            </tr>
            <tr align="center">
                <td colspan="2">
                    <s:submit id="submit" value="修改" />
                    <input type="button" value="取消，返回" onclick="history.go(-1)">
                </td>
            </tr>
        </table>
    </s:form>
</body>
</html>
