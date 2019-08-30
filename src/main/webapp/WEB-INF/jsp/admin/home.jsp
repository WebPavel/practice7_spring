<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
	<head>
        <title>后台管理</title>
    </head>
    <frameset rows="85,*,64" frameborder=0 border="0" framespacing="0">
      <frame src="${pageContext.request.contextPath}/goTop.action" name="topFrame" scrolling="no" noresize="noresize">
      <frameset cols="200,*" frameborder="0" border="0" framespacing="0">
            <frame src="${pageContext.request.contextPath}/goLeft.action" name="leftFrame" scrolling="yes" noresize="noresize">
            <frame src="${pageContext.request.contextPath}/goDisplay.action" name="displayFrame" noresize="noresize">
      </frameset>
      <frame src="${pageContext.request.contextPath}/goBottom.action" name="bottomFrame" scrolling="no" noresize="noresize">
    </frameset>
</html>
