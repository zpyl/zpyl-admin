<%--
  Created by IntelliJ IDEA.
  User: zp
  Date: 2020/10/17
  Time: 9:22
  管理员查看宿舍信息
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">

    <link rel="stylesheet" type="text/css" href="../../../css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="../../../easyui/easyui.css" />

    <link rel="stylesheet" type="text/css" href="../../../css/wu.css" />
    <link rel="stylesheet" type="text/css" href="../../../css/icon.css" />
</head>
<body>
    <table class="table table-bordered table-hover definewidth m10">
        <c:forEach items="${list}" var="student">
            <tr>
                <td width="80px" >学号：</td>
                <td width="100px"><input  type="text" readonly value="${student.id}"/></td>
                <td width="80px" >姓名：</td>
                <td width="100px"> <input type="text" readonly value="${student.name}"/></td>
                <td width="80px">手机号：</td>
                <td width="100px"><input type="text" value="${student.telephone}" readonly/></td>
                <td width="80px">入住时间：</td>
                <td><input type="text" value="<fmt:formatDate value='${sessionScope.admin.time}' type='date'/>" readonly></td>
            </tr>
        </c:forEach>
    </table>
    <c:if test="${sessionScope.user==1}">
    </c:if>
</body>
</html>