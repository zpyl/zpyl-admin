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
        .info{ color: #0f1957; }
        .onError{ color: red; }
    </style>
</head>
<body>
<form method="post" id="staff">
    <table class="table table-bordered table-hover  defineWidth">
        <tr>
            <td  width="10%">公寓：</td>
            <td>
                <input  class="easyui-combobox" name="hostelId" id="hostelId"
                           data-options="valueField:'hostelId',textField:'name',url:'/hostel/hostel/info',
                                          onSelect:function(rec){
                                             $.ajax({
                                                url: url = '/hostel/hostel/findByHostelId?hostelId='+rec.hostelId,
                                                success:function (data) {
                                                    $('#info').text('该公寓共有'+data.floor+'层,每层有'+data.number+'间宿舍，宿舍号从101到'+data.floor+(data.number>9?data.number:'0'+data.number))
                                                }
                                             })
                                          }
                            ">
            </td>
        </tr>

        <tr>
            <td >学院：</td>
            <td>
                <input id="cc1" class="easyui-combobox"  name="collegeId" data-options="
                                        valueField: 'id', textField: 'name',url: '/college/college/college',
                                        onSelect: function(rec){
                                        var url = '/college/college/subject?collegeId='+rec.id;
                                        $('#cc2').combobox('reload', url);
                                        }">
            </td>
        </tr>
        <tr>
            <td >专业：</td>
            <td>
                <input id="cc2" class="easyui-combobox" name="subjectId" data-options="valueField:'id',textField:'name'">
            </td>
        </tr>
        <tr>
            <td >宿舍号：</td>
            <td>
                <span id="info" class="info"></span><br>
                <input type="text" name="number1" style="width: 50px"/>---
                <input type="text" name="number2" style="width: 50px"/>

            </td>

        </tr>
    </table>
    <button type="submit" class="btn btn-primary" >保存</button>
    <button type="button" class="btn btn-success" onclick="staff_back()">取消</button>
</form>
</body>
</html>
<script>
    // 只能输入[0-9]数字
    jQuery.validator.addMethod("isDigits", function(value, element) {
        return this.optional(element) || /^\d+$/.test(value)
    }, "只能输入整数")
    $(function () {
        $("#staff").validate({
            errorElement : "span",//错误信息的标签
            errorClass:"onError",//错误信息的样式
            rules:{
                hostelId: "required" ,
                collegeId:"required",
                subjectId:"required",
                number1:{
                    required:'true',
                    isDigits:'true'
                },
                number2:{
                    required:'true',
                    isDigits:'true'
                }
            },
            messages:{
                hostelId:{
                    required:"公寓不能为空",
                },
                collegeId:{
                    required:"学院不能为空"
                },
                subjectId:{
                    required:"专业不能为空"
                },
                number1:{
                    required:"宿舍号不能为空"
                },
                number2:{
                    required:"宿舍号不能为空"
                }
            },
            errorPlacement:function(error, element) {
                error.appendTo( element.parent()); },
            submitHandler: function (form) {
                // 将核心的ajax提交代码包含进此函数
                $.ajax({
                    url:"bedroom/set",
                    data:$('#staff').serialize(),
                    success:function (data) {
                        if(data.status===200){
                            window.location.href="bedroom";
                            alert("分配成功！")
                        }
                    }
                });
            }
        })
    })
    //取消
    function staff_back(){
        window.location.href="bedroom";
    }
</script>