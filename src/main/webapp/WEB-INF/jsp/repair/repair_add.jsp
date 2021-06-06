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
    <table class="table table-bordered table-hover defineWidth m10">
        <tr>
            <td width="80px" >学号：</td>
            <td width="100px">
                <input  type="text" readonly value="${sessionScope.admin.id}"/>
            </td>
            <td width="80px" >姓名：</td>
            <td width="100px">
                <input type="text" readonly value="${sessionScope.admin.name}"/>
            </td>
            <td  width="80px">公寓：</td>
            <td  width="100px"><input type="text" value="${sessionScope.admin.hostelName}" readonly/></td>
            <td  width="80px">宿舍号：</td>
            <td  width="100px"><input type="text" value="${sessionScope.admin.bedroomId}" readonly/></td>
            <td  width="80px">手机号：</td>
            <td><input type="text" value="${sessionScope.admin.telephone}" readonly/></td>
        </tr>
    </table>
    <div colspan="4" style="text-align: center" width="500px">
        <span style="text-align: center">原因</span><br>
        <textarea name="reason" id="reason" cols="50" rows="6" style="width: 600px"></textarea>
        <h6 style="margin: auto">您可以输入<span>50</span>个字，现在剩余<span id="word">50</span>个字</h6>
        <button type="submit" class="btn btn-primary"  onclick="repair_send()" >保存</button>&nbsp;&nbsp;
        <button type="button" class="btn btn-success"  onclick="repair_back()">取消</button>
    </div>
</body>
</html>
<script>

    $(function(){
        $("#reason").keyup(function(){
            var len = $(this).val().length;
            if(len > 49){
                $(this).val($(this).val().substring(0,50));
            }
            var num = 50 - len;
            $("#word").text(num);
        });
    });
    //保存
    function repair_send() {
        $.ajax({
            url: "/repair/repair/add",
            type:'post',
            async: false,
            data: {
                reason: $("#reason").val()
            },
            success: function (data) {
                if (data.status === 200) {
                    alert("提交成功")
                }else{
                    alert("提交失败")
                }
                window.location.href="/repair/repair";
            }
        })
    }
    //取消
    function repair_back(){
        window.location.href="/repair/repair";
    }
</script>