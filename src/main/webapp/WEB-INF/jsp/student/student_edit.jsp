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
<form method="post" id="student">
    <table class="table table-bordered table-hover defineWidth m10">
        <tr>
            <td width="80px" class="tableLeft">学号：</td>
            <td width="100px">
                <input  type="text" name="id" id="id" value="${student.id}" readonly/>
            </td>
            <td width="80px" >姓名：</td>
            <td width="100px">
                <input type="text" name="name" id="name" value="${student.name}" readonly/>
            </td>
        </tr>

        <tr>
            <td >性别</td>
            <td>
                <input type="radio" name="sex" value="0" >男
                <input type="radio" name="sex" value="1" >女
            </td>
            <td>年龄：</td>
            <td><input type="text" name="age" value="${student.age}" /></td>
        </tr>

        <tr>
            <td>学院</td>
            <td> <input id="cc1" class="easyui-combobox" name="collegeId" data-options="
                                    valueField: 'id', textField: 'name',url: '/college/college/college',
                                    onLoadSuccess:function(){
                                     $('#cc1').combobox('select',${student.collegeId});
                                     $('#college').val(${student.collegeId});
                                    },
                                    onSelect: function(rec){
                                    var url = '/college/college/subject?collegeId='+rec.id;
                                    $('#college').val(rec.id);
                                    $('#cc2').combobox('reload', url);
                                    }">
                <input type="hidden" name="college" id="college" value="0">
            </td>
            <td >电话</td>
            <td><input type="number" name="telephone" value="${student.telephone}"></td>
        </tr>
        <tr>
            <td >专业</td>
            <td>
                <input id="cc2" class="easyui-combobox" name="subjectId" data-options="
                                                valueField:'id',textField:'name',
                                                onLoadSuccess:function(){
                                                    $('#cc2').combobox('select',${student.subjectId});
                                                    $('#subject').val(${student.subjectId});
                                                },
                                                onSelect: function(rec){
                                                  $('#subject').val(rec.id);
                                                }">
                <input type="hidden" name="subject" id="subject" value="0">
            </td>
            <td colspan="2">
                <button type="submit" class="btn btn-primary"  >保存</button>&nbsp;&nbsp;
                <button type="button" class="btn btn-success" onclick="student_back()">取消</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
<script>
    //验证学院
    jQuery.validator.addMethod("college", function(value, element) {
        if(value===''||value==='0')
            return false;
        else
            return true
    }, "学院不能为空");
    //验证专业
    jQuery.validator.addMethod("subject", function(value, element) {
        if(value===''||value==='0')
            return false;
        else
            return true
    }, "专业不能为空");
    //自定义电话号码的规则
    jQuery.validator.addMethod("tel",function(value,element){
        //定义一个正则表达式
        var reg=/^1(3|4|5|6|7|8|9)\d{9}$/;
        return reg.test(value);},"请输入正确的手机号码")
    // 只能输入[0-9]数字
    jQuery.validator.addMethod("isDigits", function(value, element) {
        return this.optional(element) || /^\d+$/.test(value)
    }, "只能输入整数")
    $(function () {
        $("input[name='sex'][value='${student.sex}']").attr("checked",true)
        $("#student").validate({
                errorElement : "span",//错误信息的标签
                errorClass:"onError",//错误信息的样式、
                ignore: '',//验证隐藏的信息
                rules:{
                    age:'isDigits',
                    name:"required",
                    telephone:"tel",
                    bedroomId:"required",
                    hostelId:"required",
                    college:"college",
                    subject:"subject"
                },
                messages:{
                    bedroomId:{
                        required:"宿舍号不能为空"
                    },
                    hostelId:{
                        required:"公寓不能为空"
                    },
                    name:{
                        required:"姓名不能为空"
                    },

                },
                errorPlacement:function(error, element) {
                    error.appendTo( element.parent()); },
                submitHandler: function (form) {
                // 将核心的ajax提交代码包含进此函数
                $.ajax({
                    url:"edit",
                    data:$('#student').serialize(),
                    success:function (data) {
                        if(data.status===200){
                            window.location.href="/student/student";
                            alert("操作成功")
                        }
                    }
                });
            }
        })
    })
    //取消
    function student_back(){
        window.location.href="/student/student";
    }
</script>