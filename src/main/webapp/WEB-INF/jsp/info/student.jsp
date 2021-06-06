<%--
  Created by IntelliJ IDEA.
  User: zp
  Date: 2020/10/17
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <script type="text/javascript" src="../../../js/jquery.js"></script>
    <script type="text/javascript" src="../../../easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../../../easyui/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="../../../js/jquery.validate.js"></script>


    <script type="text/javascript" src="../../../js/bootstrap-table.js"></script>
    <script type="text/javascript" src="../../../js/bootstrap-table-zh-CN.js"></script>
    <link rel="stylesheet" type="text/css" href="../../../css/bootstrap.css" />
    <link href="../../../css/bootstrap-table.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="../../../easyui/easyui.css" />

    <link rel="stylesheet" type="text/css" href="../../../css/wu.css" />
    <link rel="stylesheet" type="text/css" href="../../../css/icon.css" />

</head>
<body>

    <table class="table table-bordered table-hover defineWidth m10">
        <tr>
            <td width="80px">学号：</td>
            <td width="80px">
                <input  type="text" value="${sessionScope.admin.id}" readonly/>
            </td>
            <td width="80px">性别：</td>
            <td >
                <input type="text"  value="${sessionScope.admin.sex==0?'男':'女'}" readonly/>
            </td>
        </tr>

        <tr>
            <td >姓名：</td>
            <td >
                <input type="text" value="${sessionScope.admin.name}" readonly/>
            </td>

            <td>年龄：</td>
            <td><input type="text"  value="${sessionScope.admin.age}" readonly/></td>
        </tr>

        <tr>
            <td>学院：</td>
            <td><input type="text" value="${sessionScope.admin.collegeName}"readonly></td>
            <td>公寓：</td>
            <td><input type="text" value="${sessionScope.admin.hostelName}"readonly></td>

        </tr>

        <tr>
            <td >专业：</td>
            <td><input type="text" value="${sessionScope.admin.subjectName}"readonly></td>
            <td >宿舍号：</td>
            <td><input type="text" value="${sessionScope.admin.bedroomId}"readonly></td>
        </tr>
        <tr>
            <td>本人手机号：</td>
            <td><input type="text" value="${sessionScope.admin.telephone}"readonly></td>
            <td>公寓座机号：</td>
            <td><input type="text" value="${sessionScope.admin.tel}"readonly></td>
        </tr>
    </table>
</body>
</html>