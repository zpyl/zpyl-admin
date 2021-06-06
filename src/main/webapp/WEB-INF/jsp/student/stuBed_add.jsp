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
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td  width="80px" class="tableleft">学号：</td>
            <td width="100px">
                <input  type="text" name="id" id="id" readonly value="${student.id}"/>
            </td>
            <td width="80px" >姓名：</td>
            <td width="100px">
                <input type="text" name="name" id="name" readonly value="${student.name}"/>
            </td>
        </tr>

        <tr>
            <td class="tableleft">性别</td>
            <td>
                <input type="text"value=${student.sex==0?'男':'女'} readonly>
            </td>
            <td class="tableleft">年龄：</td>
            <td><input type="text" value="${student.age}" readonly/></td>
        </tr>

        <tr>
            <td class="tableleft">学院：</td>
            <td>
                <input type="text" name="collegeName" id="collegeName" readonly value="${student.collegeName}"/>
            </td>
            <td class="tableleft">号码：</td>
            <td><input type="text" name="telephone" id="telephone" value="${student.telephone}"/></td>
        </tr>

        <tr>
            <td class="tableleft">专业：</td>
            <td>
                <input type="text" name="subjectName" id="subjectName" readonly value="${student.subjectName}"/>
            </td>
        </tr>
        <tr>
            <td class="tableleft">公寓：</td>
            <td> <input id="hostelId" class="easyui-combobox" name="hostelId" data-options="
                        valueField: 'hostelId', textField: 'name',url: '/hostel/hostel/infoHostel?sex=${student.sex}&collegeId=${student.collegeId}&subjectId=${student.subjectId}',
                        onSelect: function(rec){
                            var url = '/bedroom/bedroom/infoLook?hostelId='+rec.hostelId+'&subjectId=${student.subjectId}&collegeId=${student.collegeId}';
                            $('#bedroomId').combobox('reload', url);
                            $('#hostel').val(rec.hostelId);
                        }">
                <input type="hidden" name="hostel" id="hostel" value="0">
            </td>
        </tr>

        <tr>
            <td class="tableleft">宿舍号：</td>
            <td> <input id="bedroomId" class="easyui-combobox" name="bedroomId" data-options="valueField:'bedroomId',textField:'bedroomId'
                                                ,onSelect: function(rec){
                                                  $('#bedroom').val(rec.bedroomId);
                                                }">
                <input type="hidden" name="bedroom" id="bedroom" value="0">
            </td>
        </tr>

        <tr>
            <td class="tableleft">入住时间：</td>
            <td><input type="date" name="time"  id="time" placeholder="请选择"/>
                </td>
        </tr>

        <tr>
            <td class="tableleft"></td>
            <td>
                <button type="submit" class="btn btn-primary"  >保存</button>&nbsp;&nbsp;
                <button type="button" class="btn btn-success" name="backid" onclick="student_back()">取消</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
<script>
    //日期转换
    function changeDateFormat(cellval) {
        var dateVal = cellval + "";
        if (cellval != null) {
            var date = new Date(parseInt(dateVal.replace("/Date(", "").replace(")/", ""), 10));
            var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
            var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
            return date.getFullYear() + "-" + month + "-" + currentDate ;
        }
    }
    //验证宿舍号
    jQuery.validator.addMethod("bedroom", function(value, element) {
        console.log(value)
        if(value===''||value==='0')
            return false;
        else
            return true
    }, "寝室不能为空");
    //验证宿舍楼
    jQuery.validator.addMethod("hostel", function(value, element) {
        console.log(value)
        if(value===''||value==='0')
            return false;
        else
            return true
    }, "宿舍楼不能为空");
    //自定义电话号码的规则
    jQuery.validator.addMethod("tel",function(value,element){
        //定义一个正则表达式
        var reg=/^1(3|4|5|6|7|8|9)\d{9}$/;
        return reg.test(value);        },"请输入正确的手机号码")
    // 只能输入[0-9]数字
    jQuery.validator.addMethod("isDigits", function(value, element) {
        return this.optional(element) || /^\d+$/.test(value)
    }, "只能输入整数")
    $(function () {
        $("#student").validate({
                errorElement : "span",//错误信息的标签
                errorClass:"onError",//错误信息的样式
                ignore: '',//验证隐藏的信息
                rules:{
                    telephone:"tel",
                    time:"required",
                    bedroom:"bedroom",
                    hostel:"hostel"
                },
                messages:{
                    time:{
                        required:"入住时间不能为空"
                    }
                },
                errorPlacement:function(error, element) {
                    error.appendTo( element.parent()); },
            submitHandler: function (form) {
                // 将核心的ajax提交代码包含进此函数
                $.ajax({
                    url:"addBed",
                    data:$('#student').serialize(),
                    success:function (data) {
                        if(data.status===200){
                            window.location.href="/student/student";
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