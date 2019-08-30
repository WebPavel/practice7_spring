<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
    <head>
        <link href="${pageContext.request.contextPath}/css/left.css" rel="stylesheet" type="text/css">
        <link href="${pageContext.request.contextPath}/css/dtree.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <table width="100%" border="0">
          <tr>
            <td>
                <div class="dtree">
                    <a href="javascript: d.openAll();">展开所有</a> | <a href="javascript: d.closeAll();">关闭所有</a>
                    <script type="text/javascript" src="${pageContext.request.contextPath}/js/dtree.js"></script>
                    <script type="text/javascript">
                        d = new dTree('d');
                        d.add('01',-1,'系统菜单树');
                        d.add('0101','01','用户管理','${pageContext.request.contextPath}/goDisplay.action', '', 'displayFrame');
                        d.add('010101','0101','用户列表','${pageContext.request.contextPath}/usr/customer/list.action?pageIndex=1&pageSize=10', '', 'displayFrame');
                        d.add('0102','01','商品管理','${pageContext.request.contextPath}/goDisplay.action', '', 'displayFrame');
                        d.add('010201','0102','商品列表','${pageContext.request.contextPath}/biz/product/list.action?pageIndex=1&pageSize=10', '', 'displayFrame');
                        d.add('0103','01','订单管理','${pageContext.request.contextPath}/goDisplay.action', '', 'displayFrame');
                        d.add('010301','0103','订单列表','${pageContext.request.contextPath}/biz/order/list.action?pageIndex=1&pageSize=10', '', 'displayFrame');
                        d.add('0104','01','一级分类管理','${pageContext.request.contextPath}/goDisplay.action', '', 'displayFrame');
                        d.add('010401','0104','一级分类列表','${pageContext.request.contextPath}/pub/category/list.action?pageIndex=1&pageSize=10', '', 'displayFrame');
                        d.add('0105','01','二级分类管理','${pageContext.request.contextPath}/goDisplay.action', '', 'displayFrame');
                        d.add('010501','0105','二级分类列表','${pageContext.request.contextPath}/pub/subcategory/list.action?pageIndex=1&pageSize=10', '', 'displayFrame');
                        document.write(d);
                    </script>
                </div>
            </td>
          </tr>
        </table>
    </body>
</html>
