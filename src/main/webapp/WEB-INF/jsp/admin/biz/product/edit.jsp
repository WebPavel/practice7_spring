<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>编辑商品</title>
    <style type="text/css">
        tr{
            text-align:center;
        }
    </style>
</head>
<body>
    <s:form id="form" name="form" action="update" namespace="/biz/product" enctype="multipart/form-data" method="POST" theme="simple">
        <table width="80%" cellspacing="0" cellpadding="0" align="center" border="1">
            <caption>编辑商品</caption>
            <tr align="center">
                <td colspan="2">
                    <s:actionerror />
                    <s:fielderror />
                </td>
            </tr>
            <tr>
                <th>
                    商品名称：
                </th>
                <td>
                    <s:hidden id="id" name="id" value="%{model.id}" />
                    <s:textfield id="name" name="name" value="%{model.name}" cssClass="text" />
                </td>
            </tr>
            <tr>
                <th>
                    所属二级分类：
                </th>
                <td>
                    <select name="subcategoryId">
                        <option value="">--请选择所属二级分类--</option>
                        <s:iterator var="subcategory" value="subcategoryList">
                            <s:if test="#subcategory.id == model.subcategory.id">
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
                <th>商场价：</th>
                <td>
                    <s:textfield id="marketPrice" name="marketPrice" value="%{model.marketPrice}" cssClass="text" />
                </td>
            </tr>
            <tr>
                <th>划线价：</th>
                <td>
                    <s:textfield id="sellingPrice" name="sellingPrice" value="%{model.sellingPrice}" cssClass="text" />
                </td>
            </tr>
            <tr>
                <th>折扣：</th>
                <td>
                    <s:textfield id="discount" name="discount" value="%{model.discount}" cssClass="text" />
                </td>
            </tr>
            <tr>
                <th>商品介绍：</th>
                <td>
                    <s:textarea id="description" name="description" value="%{model.description}" cols="30" rows="3" />
                </td>
            </tr>
            <tr>
                <th>商品图片：</th>
                <td>
                    <img src="${pageContext.request.contextPath}<s:property value="%{model.imgthumb}" />">
                    <s:file id="upload" name="upload" size="30" />
                </td>
            </tr>
            <tr>
                <th>库存：</th>
                <td>
                    <s:textfield id="stock" name="stock" value="%{model.stock}" cssClass="text" />
                </td>
            </tr>
            <tr>
                <th>计量单位：</th>
                <td>
                    <s:textfield id="sku" name="sku" value="%{model.sku}" cssClass="text" />
                </td>
            </tr>
            <tr>
                <th>商品编号：</th>
                <td>
                    <s:textfield id="serialNumber" name="serialNumber" value="%{model.serialNumber}" cssClass="text" />
                </td>
            </tr>
            <tr>
                <th>条形码：</th>
                <td>
                    <s:textfield id="upc" name="upc" value="%{model.upc}" cssClass="text" />
                </td>
            </tr>
            <tr>
                <th>品牌：</th>
                <td>
                    <s:textfield id="brand" name="brand" value="%{model.brand}" cssClass="text" />
                </td>
            </tr>
            <tr>
                <th>产地：</th>
                <td>
                    <s:textfield id="madeIn" name="madeIn" value="%{model.madeIn}" cssClass="text" />
                </td>
            </tr>
            <tr>
                <th>保质期：</th>
                <td>
                    <s:textfield id="shelfLife" name="shelfLife" value="%{model.shelfLife}" cssClass="text" />
                </td>
            </tr>
            <tr>
                <th>重量：</th>
                <td>
                    <s:textfield id="weight" name="weight" value="%{model.weight}" cssClass="text" />
                </td>
            </tr>
            <tr>
                <th>
                    是否热门：
                </th>
                <td>
                    <s:select id="isHot" name="isHot" list="#{'0':'否','1':'是'}" value="%{model.isHot}" />
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
