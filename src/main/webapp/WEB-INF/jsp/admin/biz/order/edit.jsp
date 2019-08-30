<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>编辑订单</title>
    <style type="text/css">
        tr{
            text-align:center;
        }
    </style>
</head>
<body>
    <s:form id="form" name="form" action="update" namespace="/biz/order" method="POST" theme="simple">
        <table width="80%" cellspacing="0" cellpadding="0" align="center" border="1">
            <caption>编辑订单</caption>
            <tr align="center">
                <td colspan="2">
                    <s:actionerror />
                    <s:fielderror />
                </td>
            </tr>
            <tr>
                <th>
                    订单编号：
                </th>
                <td>
                    <s:hidden id="id" name="id" value="%{model.id}" />
                    <s:textfield id="sn" name="sn" value="%{model.sn}" cssClass="text" readonly="true" />
                </td>
            </tr>
            <tr>
                <th>
                    所属用户：
                </th>
                <td>
                    <s:hidden id="customerId" name="customerId" value="%{model.customer.id}" />
                    <s:textfield id="customerUsername" name="customerUsername" value="%{model.customer.username}" cssClass="text" readonly="true" />
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
                <th>收货地址：</th>
                <td>
                    <s:textfield id="address" name="address" value="%{model.address}" cssClass="text" readonly="true" />
                </td>
            </tr>
            <tr>
                <th>联系电话：</th>
                <td>
                    <s:textfield id="telephone" name="telephone" value="%{model.telephone}" cssClass="text" readonly="true" />
                </td>
            </tr>
            <tr>
                <th>收货人：</th>
                <td>
                    <s:textfield id="consignee" name="consignee" value="%{model.consignee}" cssClass="text" readonly="true" />
                </td>
            </tr>
            <tr>
                <th>重量：</th>
                <td>
                    <s:textfield id="weight" name="weight" value="%{model.weight}" cssClass="text" readonly="true" />
                </td>
            </tr>
            <tr>
                <th>
                    运费：
                </th>
                <td>
                    <s:textfield id="freight" name="freight" value="%{model.freight}" cssClass="text" readonly="true" />
                </td>
            </tr>
            <tr>
                <th>金额：</th>
                <td>
                    <s:textfield id="price" name="price" value="%{model.price}" cssClass="text" readonly="true" />
                </td>
            </tr>
            <tr>
                <th>支付时间</th>
                <td>
                    <s:textfield id="gmtPayment" name="gmtPayment" value="%{model.gmtPayment}" cssClass="text" readonly="true" />
                </td>
            </tr>
            <tr>
                <th>状态：</th>
                <td>
                    <s:select id="status" name="status" list="#{1:'订单未支付',2:'订单支付超时',3:'订单已支付',4:'已发货',5:'订单完成',6:'交易关闭'}" value="%{model.status}" />
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
