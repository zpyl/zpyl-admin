<%--
  Created by IntelliJ IDEA.
  User: zp
  Date: 2020/10/17
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <form method="post" id="student">
        <table class="table table-bordered table-hover  defineWidth">
            <tr>
                <c:if test="${sessionScope.user!=2}">
                    <td width="100px">工号：</td>
                </c:if>
                <c:if test="${sessionScope.user==2}">
                    <td width="100px">学号：</td>
                </c:if>
                <td >
                    <input  type="text" id = 'id' readonly value="${sessionScope.admin.id}"/>
                </td>
            </tr>
            <tr>
                <td width="80px">姓名：</td>
                <td >
                    <input type="text" readonly value="${sessionScope.admin.name}"/>
                </td>
            </tr>
            <tr>
                <td  >请验证密码：</td>
                <td ><input  type="password" name="pass"/></td>
            </tr>
            <tr>
                <td >请输入新密码：</td>
                <td ><input  type="password" name="password" id="password"/></td>
            </tr>
            <tr>
                <td >确认密码：</td>
                <td ><input  type="password" name="confirm_password"/></td>
            </tr>
        </table>
        <button type="submit" class="btn btn-primary">提交</button>
   </form>
</body>
</html>
<script>
    $(function () {
        $("#student").validate({
                errorElement : "span",//错误信息的标签
                errorClass:"onError",//错误信息的样式
                rules:{
                    pass:{
                        required: true,
                        remote:{
                            url: "/info/info/modify",     //后台处理程序
                            type: "post",            //数据发送方式
                            dataType: "json",        //接受数据格式
                            data: {                  //要传递的数据 他自己默认传递本身
                                id:  $("#id").val()
                            }
                        }
                    },
                    password: {
                        required: true,
                        minlength: 5
                    },
                    confirm_password: {
                        required: true,
                        minlength: 5,
                        equalTo: "#password"
                    }

                },
                messages:{
                    pass:{
                        required:"请输入密码",
                        remote:"密码验证失败"
                    },
                    password: {
                        required: "请输入密码",
                        minlength: "密码长度不能小于 5 个字母"
                    },
                    confirm_password: {
                        required: "请输入密码",
                        minlength: "密码长度不能小于 5 个字母",
                        equalTo: "两次密码输入不一致"
                    }

                },
                errorPlacement:function(error, element) {
                    error.appendTo( element.parent()); },
                submitHandler: function (form) {
                // 将核心的ajax提交代码包含进此函数
                $.ajax({
                    url:"info/infoModify",
                    data:{
                        id:$("#id").val(),
                        password:$("#password").val()
                    },
                    success:function (data) {
                        if(data.status===200){
                           alert("修改成功")
                        }
                    }
                });
            }
        })
    })
</script>