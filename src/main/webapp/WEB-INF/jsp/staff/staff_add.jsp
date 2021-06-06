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

    <style type="text/css">
        .onError{ color: red; }
    </style>
</head>
<body>
<form method="post" id="staff">
    <table class="table table-bordered table-hover  defineWidth">
        <tr>
            <td width=10% >姓名：</td>
            <td>
                <input type="text" name="name" placeholder="请输入姓名"/>
            </td>
        </tr>

        <tr>
            <td>性别</td>
            <td>
                <input type="radio" name="sex" value="0"  checked/> 男
                <input type="radio" name="sex" value="1"  /> 女
            </td>
        </tr>

        <tr>
            <td >年龄：</td>
            <td><input type="text" name="age" /></td>
        </tr>

        <tr>
            <td >号码：</td>
            <td><input type="text" name="telephone"/></td>
        </tr>

        <tr>
            <td >管理的公寓：</td>
            <td> <input  class="easyui-combobox" name="hostelId" id="hostelId"
                         data-options="valueField:'hostelId',textField:'name',url:'/hostel/hostel/info'"
                         placeholder="请选择">
                </td>
        </tr>

        <tr>
            <td >入职时间：</td>
            <td><input type="date" name="time" placeholder="请选择"/></td>
        </tr>
    </table>
    <button type="submit" class="btn btn-primary"  >保存</button>&nbsp;&nbsp;
    <button type="button" class="btn btn-success" onclick="staff_back()">取消</button>
</form>
</body>
</html>
<script>
    //自定义电话号码的规则
    jQuery.validator.addMethod("tel",function(value,element){
        //定义一个正则表达式
        var reg=/^1(3|4|5|6|7|8|9)\d{9}$/;
        return reg.test(value);        },"请输入正确的手机号码")
    // 只能输入[0-9]数字
    jQuery.validator.addMethod("isDigits", function(value, element) {
        return this.optional(element) || /^\d+$/.test(value)
    }, "只能输入整数")
    $(function () {$("#staff").validate({
            errorElement : "span",//错误信息的标签
            errorClass:"onError",//错误信息的样式
            rules:{
                name:{
                    required:true
                },
                age:"isDigits",
                telephone:"tel",
                time:"required"
            },
            messages:{
                name:{
                    required:"姓名不能为空",
                },
                time:{
                    required:"入职时间不能为空"
                }
            },
            errorPlacement:function(error, element) {
                error.appendTo( element.parent()); },
        submitHandler: function (form) {
            // 将核心的ajax提交代码包含进此函数
            $.ajax({
                url:"staff/add",
                data:$('#staff').serialize(),
                success:function (data) {
                    if(data.status===200){
                        window.location.href="staff";
                        alert("添加成功")
                    }
                }
            });
        }
        })})
    //取消
    function staff_back(){
        window.location.href="staff";
    }
</script>