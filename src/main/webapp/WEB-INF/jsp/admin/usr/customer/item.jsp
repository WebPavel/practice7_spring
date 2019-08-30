<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>用户详情</title>
    <style type="text/css">
        tr{
            text-align:center;
        }
    </style>
</head>
<body>
    <s:form id="form" name="form" action="update" namespace="/usr/customer" method="POST" theme="simple">
        <table width="80%" cellspacing="0" cellpadding="0" align="center" border="1">
            <caption>用户详情</caption>
            <tr align="center">
                <td colspan="2">
                    <s:actionerror />
                    <s:fielderror />
                </td>
            </tr>
            <tr>
                <th>
                    用户名：
                </th>
                <td>
                    <s:hidden id="id" name="id" value="%{model.id}" />
                    <s:textfield id="username" name="username" value="%{model.username}" cssClass="text" readonly="true" />
                </td>
            </tr>
            <tr>
                <th>
                    联系电话：
                </th>
                <td>
                    <s:textfield id="telephone" name="telephone" value="%{model.telephone}" cssClass="text" readonly="true" />
                </td>
            </tr>
            <tr>
                <th>昵称：</th>
                <td>
                    <s:textfield id="nickname" name="nickname" value="%{model.nickname}" cssClass="text" readonly="true" />
                </td>
            </tr>
            <tr>
                <th>电子邮箱：</th>
                <td>
                    <s:textfield id="email" name="email" value="%{model.email}" cssClass="text" readonly="true" />
                </td>
            </tr>
            <tr>
                <th>真实姓名：</th>
                <td>
                    <s:textfield id="trueName" name="trueName" value="%{model.trueName}" cssClass="text" readonly="true" />
                </td>
            </tr>
            <tr>
                <th>性别：</th>
                <td>
                    <s:select id="gender" name="gender" list="#{0:'男',1:'女',2:'保密'}" value="%{model.gender}" />
                </td>
            </tr>
            <tr>
                <th>
                    出生日期：
                </th>
                <td>
                    <s:textfield id="birthday" name="birthday" value="%{model.birthday}" cssClass="text" readonly="true" />
                </td>
            </tr>
            <tr>
                <th>所在地区：</th>
                <td>
                    <s:textfield id="region" name="region" value="%{model.region}" cssClass="text" readonly="true" />
                </td>
            </tr>
            <tr>
                <th>通讯地址</th>
                <td>
                    <s:textfield id="address" name="address" value="%{model.address}" cssClass="text" readonly="true" />
                </td>
            </tr>
            <tr>
                <th>邮编</th>
                <td>
                    <s:textfield id="postalCode" name="postalCode" value="%{model.postalCode}" cssClass="text" readonly="true" />
                </td>
            </tr>
            <tr>
                <th>状态：</th>
                <td>
                    <s:select id="state" name="state" list="#{0:'未激活',1:'正常',2:'删除',3:'停用'}" value="%{model.state}" />
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
                <th>
                    修改时间：
                </th>
                <td>
                    <s:textfield id="gmtModified" name="gmtModified" cssClass="text" value="%{model.gmtModified}" readonly="true" />
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
