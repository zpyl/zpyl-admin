<%--
  Created by IntelliJ IDEA.
  User: zp
  Date: 2020/10/17
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
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
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                <%--查询--%>
                <div id="toolbar">
                    <table>
                        <tr>
                            <span class="btn btn-primary" style="margin-right: 10px" data-toggle="modal" data-target="#addModal" onclick="btn_remove()">删除</span>
                            <c:if test="${sessionScope.user==1}">
                                 <span class="btn btn-primary" style="margin-right: 10px" data-toggle="modal" data-target="#addModal" onclick="btn_edit()">完结</span>
                            </c:if>
                            <c:if test="${sessionScope.user==2}">
                                <span class="btn btn-primary" style="margin-right: 10px" data-toggle="modal" data-target="#addModal" onclick="repaid_add()">新增</span>
                            </c:if>
                        </tr>
                    </table>
                </div>
                <%--数据展示--%>
                <table id="myTab" class="table table-striped"></table>
            </div>
         </div>
    </div>
<script>
    
</script>
</body>
<script>
    $(function() {
        //加载表格
        $('#myTab').bootstrapTable({
            url: 'repair/list',        // 表格数据来源
            dataType: "json",         //服务器返回的数据类型
            pagination:true,          //显示分页条
            pageNumber:1,//分页首页页码
            pageSize:10,//每页显示条数发啊
            height:500,//表高度
            sidePagination: "client",//客户端分页
            checkboxHeader:true,
            clickToSelect:true,//自动选择rediobox 和 checkbox
            columns: [
                {
                    checkbox:true,
                },
                {
                    field: 'id',
                    visible: false
                },{
                field: 'stuId',
                title: '学号',
                align: 'center'
            }, {
                field: 'name',
                title: '姓名',
                align: 'center'
            }, {
                field: 'hostelName',
                title: '公寓',
                align: 'center'
            },{
                field: 'bedroomId',
                title: '宿舍号',
                align: 'center'
            }, {
                field:'telephone',
                title:'电话号码',
                align:'center'
             },{
                field: 'time',
                title: '申请时间',
                align: 'center',
                formatter: function (value, row, index) {
                    return changeDateFormat(value)
                }
            },{
                field: 'reason',
                title: '原因',
                align: 'center'
            },{
                field: 'status',
                title: '是否完结',
                align: 'center',
                formatter: function (value) {
                    return value?'完结':'未完结'
                }
             }],

        });
    })
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
    //打开增加界面
    function repaid_add() {
        window.location.href = "/repair/repair_add";
    }

    //删除
    function btn_remove() {
        var select = $('#myTab').bootstrapTable('getSelections');
        if (select.length === 0) {
            $.messager.alert('信息提示','至少选择一条数据进行删除！','info');
        } else {
            var ids = [];
            for (var i = 0; i < select.length; i++) {
                ids.push(select[i].id)
            }
            $.messager.confirm('信息提示',"确定要删除这些记录吗？",function(result) {
                if(result){
                    $.ajax({
                        url:"repair/remove",
                        data:{
                            ids:ids.toString()
                        },
                        success:function (data) {
                            if(data.status===200){
                                $('#myTab').bootstrapTable('refresh');
                                $.messager.alert('信息提示','删除成功！','info');
                            }else{
                                $.messager.alert('信息提示','删除失败！','info');
                            }
                        }
                    })
                }
            });
        }
    }

    //打开完结界面
    function btn_edit() {
        var select = $('#myTab').bootstrapTable('getSelections');
        if (select.length === 0) {
            $.messager.alert('信息提示','至少选择一条进行完结处理！','info');
        } else {
            var ids = [];
            for (var i = 0; i < select.length; i++) {
                ids.push(select[i].id)
            }
            $.messager.confirm('信息提示',"确定要完结这些记录吗？",function(result) {
                if(result){
                    $.ajax({
                        url:"repair/edit",
                        data:{
                            ids:ids.toString()
                        },
                        success:function (data) {
                            if(data.status===200){
                                $('#myTab').bootstrapTable('refresh');
                                $.messager.alert('信息提示','成功！','info');
                            }else{
                                $.messager.alert('信息提示','失败！','info');
                            }
                        }
                    })
                }
            });
        }
    }
</script>
</html>
