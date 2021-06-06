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
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }
        .onError{ color: red; }
    </style>
</head>
<body>
<form method="post" id="staff">
    <table class="table table-bordered table-hover  defineWidth">
        <tr>
            <td hidden> <input type="text" name="hostelId" /></td>
            <td width="10%" >名称：</td>
            <td><input type="text" name="name" placeholder="请输入楼层名称"/></td>
        </tr>

        <tr>
            <td >公寓类型</td>
            <td>
                <input type="radio" name="sex" value="0" checked/> 男生公寓
                <input type="radio" name="sex" value="1"/> 女生公寓
            </td>
        </tr>

        <tr>
            <td>楼层：</td>
            <td><input type="text" name="floor"/></td>
        </tr>

        <tr>
            <td >每层宿舍数量：</td>
            <td><input type="text" name="number"/></td>
        </tr>

        <tr>
            <td >每间宿舍可住人数：</td>
            <td><input type="text" name="people"/></td>
        </tr>

        <tr>
            <td >座机号：</td>
            <td><input type="text" name="telephone"/></td>
        </tr>

        <tr>
            <td >地址：</td>
            <td><input type="text" name="address"/></td>
        </tr>
    </table>
    <button type="submit" class="btn btn-primary" >保存</button>&nbsp;&nbsp;
    <button type="button" class="btn btn-success" onclick="staff_back()">取消</button>
</form>
</body>
</html>
<script>
    jQuery.validator.addMethod("isPhone", function(value,element) {
        var length = value.length;
        var phone = /(^(\d{3,4}-)?\d{6,8}$)|(^(\d{3,4}-)?\d{6,8}(-\d{1,5})?$)|(\d{11})/;
        return this.optional(element) || (phone.test(value));
    }, "请正确填写座机号");
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
            floor:{
                required:true,
                isDigits:true
            },
            number:{
                required:true,
                isDigits:true
            },
            people:{
                required:true,
                isDigits:true
            },
            telephone:{
                required:true,
                isPhone:true
            },
            address:{
                required:true
            }
        },
        messages:{
            name:{
                required:"名称不能为空"
            },
            floor:{
                required:"楼层不能为空"
            },
            number:{
                required:"宿舍数量不能为空"
            },
            people:{
                required:"可住人数不能为空"
            },
            telephone:{
                required:"座机号不能为空"
            },
            address:{
                required:"地址不能为空"
            }

        },
        errorPlacement:function(error, element) {
            error.appendTo( element.parent()); },
        submitHandler: function (form) {
            // 将核心的ajax提交代码包含进此函数
            $.ajax({
                url:"hostel/add",
                data:$('#staff').serialize(),
                success:function (data) {
                    if(data.status===200){
                        alert("添加成功")
                        window.location.href="hostel";
                    }
                }
            })
        }
    })})


    //取消
    function staff_back(){
        window.location.href="hostel";
    }
</script>