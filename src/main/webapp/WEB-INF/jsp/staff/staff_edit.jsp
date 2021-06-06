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


    <script type="text/javascript" src="../../../js/bootstrap-table.js"></script>
    <script type="text/javascript" src="../../../js/bootstrap-table-zh-CN.js"></script>
    <link rel="stylesheet" type="text/css" href="../../../css/bootstrap.css" />
    <link href="../../../css/bootstrap-table.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="../../../easyui/easyui.css" />

    <link rel="stylesheet" type="text/css" href="../../../css/wu.css" />
    <link rel="stylesheet" type="text/css" href="../../../css/icon.css" />
</head>
<body>
    <form method="post" id="staff">
        <table class="table table-bordered table-hover  defineWidth">
            <tr>
                <td>工号</td>
                <td> <input type="text" name="id" readonly value="${staff.id}"/></td>
            </tr>

            <tr>
                <td width="10%">姓名：</td>
                <td><input type="text" name="name" value="${staff.name}"/></td>
            </tr>

            <tr>
                <td >性别</td>
                <td>
                    <input type="radio" name="sex" value="0"/> 男
                    <input type="radio" name="sex" value="1"/> 女
                </td>
            </tr>

            <tr>
                <td >年龄：</td>
                <td><input type="number" name="age" value="${staff.age}"/></td>
            </tr>

            <tr>
                <td>号码：</td>
                <td><input type="number" name="telephone" value="${staff.telephone}"/></td>
            </tr>

            <tr>
                <td>管理的公寓：</td>
                <td> <input  class="easyui-combobox" name="hostelId" id="hostelId"
                             data-options="valueField:'hostelId',textField:'name',url:'/hostel/hostel/info'"
                             placeholder="请选择"></td>
            </tr>

            <tr>
                <td>入职时间：</td>
                <td><input type="date" name="time" placeholder="请选择" id="time"/></td>
            </tr>
        </table>
        <button type="button" class="btn btn-primary" onclick="staff_submit()">确定</button>
        <button type="button" class="btn btn-success" onclick="staff_back()">取消</button>
    </form>
</body>
</html>
<script>
    $(function() {
      $("input[name='sex'][value='${staff.sex}']").attr("checked",true)
    })

    //保存
    function staff_submit() {
        $.ajax({
            url:'edit',
            data:$('#staff').serialize(),
            success:function (data) {
                if(data.status===200){
                    alert("修改成功")
                    window.location.href="/staff/staff";
                }
            }
        })
    }
    //取消
    function staff_back(){
        window.location.href="/staff/staff";
    }
</script>