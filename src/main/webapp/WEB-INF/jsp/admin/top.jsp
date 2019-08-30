<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
	<head>
		<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
		<style type="text/css">
			body {
				margin: 0px;
				background-color: #ffffff;
				font-size: 12px;
				color: #000000;
			}
			td {
				font-size: 12px;
				color: #000000;
			}
			th {
				font-size: 12px;
				color: #000000;
			}
		</style>
	</head>
	<body>
		<div style="background-color: #278296">
			<img width="155" height="55" src="${pageContext.request.contextPath}/images/top_banner.jpeg">
		</div>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="30" valign="bottom" background="${pageContext.request.contextPath}/images/mis_01.jpg">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="85%" align="left">
								&nbsp;&nbsp;&nbsp;&nbsp;
								<font color="#000000">
									<script type="text/javascript">
										var today = new Date();
										var year = today.getFullYear();
										var month = today.getMonth()+1;
										var date = today.getDate();
										document.write(year+"年"+month+"月"+date+"日");
										var weekArray = new Array(7);
										weekArray[0]="星期日";
                                        weekArray[1]="星期一";
                                        weekArray[2]="星期二";
                                        weekArray[3]="星期三";
                                        weekArray[4]="星期四";
                                        weekArray[5]="星期五";
                                        weekArray[6]="星期六";
                                        var weekday = today.getDay();
                                        document.write(" "+weekArray[weekday]);
									</script>
								</font>
							</td>
							<td width="15%">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="16" background="${pageContext.request.contextPath}/images/mis_05b.jpg">
											<img src="${pageContext.request.contextPath}/images/mis_05a.jpg" width="6" height="18">
										</td>
										<td width="155" valign="bottom" background="${pageContext.request.contextPath}/images/mis_05b.jpg">
											用户名：
											<font color="blue"><s:property value="#session.manager.username"/></font>&nbsp;|&nbsp;
											<a target="_top" href="${pageContext.request.contextPath}/usr/manager/logout.action">退出</a>
										</td>
										<td width="10" align="right" background="${pageContext.request.contextPath}/images/mis_05b.jpg">
											<img src="${pageContext.request.contextPath}/images/mis_05c.jpg" width="6" height="18">
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>
