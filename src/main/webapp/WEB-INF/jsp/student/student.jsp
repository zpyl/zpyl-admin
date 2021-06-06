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
                        <c:if test="${sessionScope.user==0}">
                                <span class="btn btn-primary" style="margin-right: 10px" data-toggle="modal" data-target="#addModal" onclick="stu_excel()">导入新生信息</span>
                                <span class="btn btn-primary" style="margin-right: 10px" data-toggle="modal" data-target="#addModal" onclick="stu_add()">增加新生信息</span>
                                <span class="btn btn-primary" style="margin-right: 10px" data-toggle="modal" data-target="#addModal" onclick="stu_edit()">学生换专业</span>
                                <span class="btn btn-primary" style="margin-right: 10px" data-toggle="modal" data-target="#addModal" onclick="stu_remove()">学生退学</span>
                        </c:if>
                                <span class="btn btn-primary" style="margin-right: 10px" data-toggle="modal" data-target="#addModal" onclick="stuBed_add()">学生入住</span>
                                <span class="btn btn-primary" style="margin-right: 10px" data-toggle="modal" data-target="#addModal" onclick="stuBed_remove()">学生退宿</span>
                    </tr>
                    <tr>
                        <td>
                            学号：<input type="number" width="50px" id="id">
                            姓名：<input type="text" width="100px" id="name">
                            公寓：<input  class="easyui-combobox" name="hostelId" id="hostelId"
                                       data-options="valueField:'hostelId',textField:'name',url:'/hostel/hostel/info'">
                            学院：<input id="cc1" class="easyui-combobox" data-options="
                                    valueField: 'id', textField: 'name',url: '/college/college/college',
                                    onSelect: function(rec){
                                    var url = '/college/college/subject?collegeId='+rec.id;
                                    $('#cc2').combobox('reload', url);
                                    }">
                            专业：<input id="cc2" class="easyui-combobox" data-options="valueField:'id',textField:'name'">
                            <button title="查询" id="btnSearch" type="button" class="btn btn-success onclickbtn" onclick="find()" >查询
                            </button>

                        </td>
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
    //导入新生信息
    function stu_excel() {
        window.location.href="excel";
    }
    //新增学生信息
    function stu_add() {
        window.location.href="student_add";
    }
    //修改学生信息
    function stu_edit(){
        var select = $('#myTab').bootstrapTable('getSelections');
        if (select.length < 1) {
            $.messager.alert('信息提示','请选择要修改的学生信息！','info');
        } else if (select.length > 1) {
            $.messager.alert('信息提示','一次只能修改一条学生信息！','info');
        } else {
            window.location.href = "student/student_edit?id=" + select[0].id;
        }
    }
    //学生退学
    function stu_remove(){
        var select = $('#myTab').bootstrapTable('getSelections');
        if (select.length === 0) {
            $.messager.alert('信息提示','至少选择一条数据进行操作！','info');
        } else {
            var ids = [];
            for (var i = 0; i < select.length; i++) {
                ids.push(select[i].id)
            }
            $.messager.confirm('信息提示',"确定学号为"+ids+"的学生退学吗？",function(result) {
                if(result){
                    $.ajax({
                        url:"student/remove",
                        data:{
                            stuIds:ids.toString()
                        },
                        success:function (data) {
                            if(data.status===200){
                                $('#myTab').bootstrapTable('refresh');
                                alert('操作成功！');
                            }else{
                                alert('操作失败！');
                            }
                        }
                    })
                }
            });
        }
    }

    //学生入住
    function stuBed_add(){
        var select = $('#myTab').bootstrapTable('getSelections');
        if (select.length < 1) {
            $.messager.alert('信息提示','至少操作一条信息！','info');
        } else if (select.length > 1) {
            $.messager.alert('警告','一次只能分配一个学生！','error') ;
        } else {
            if(select[0].bedroomId!=null){
                $.messager.alert('错误','不能为已有宿舍的学生办理入住！','error') ;
            }else{
                window.location.href = "student/stuBed_add?id=" + select[0].id;
            }
        }
    }
    //学生退宿
    function stuBed_remove() {
        var select = $('#myTab').bootstrapTable('getSelections');
        if (select.length === 0) {
            $.messager.alert('信息提示','至少操作一条信息！','info');
        } else {
            var ids = [];
            for (var i = 0; i < select.length; i++) {
                ids.push(select[i].id)
            }
            $.messager.confirm('信息提示',"确定学号为"+ids+"的学生退宿吗？",function(result) {
                if(result){
                    $.ajax({
                        url:"student/stuBedRemove",
                        data:{
                            stuIds:ids.toString()
                        },
                        success:function (data) {
                            if(data.status===200){
                                $('#myTab').bootstrapTable('refresh');
                                $.messager.alert('信息提示','退宿成功！','info');
                            }else{
                                $.messager.alert('信息提示','退宿失败！','info');
                            }
                        }
                    })
                }
            });
        }
    }
    function find(){
        $('#myTab').bootstrapTable('refresh', {
            query: {
                hostelId:$("#hostelId").combobox('getValue'),
                collegeId:$("#cc1").combobox('getValue'),
                subjectId:$("#cc2").combobox('getValue'),
                id:$("#id").val(),
                name:$("#name").val(),
                 sex:2,
                offset: 0,
                pageNumber: 10
            }
        });
    }
    $(function() {
        //加载表格
        $('#myTab').bootstrapTable({
            url: 'student/list',        // 表格数据来源
            dataType: "json",         //服务器返回的数据类型
            pagination:true,          //显示分页条
            pageNumber:1,//分页首页页码
            pageSize:10,//每页显示条数发啊
            height:454,//表高度
            sidePagination: "server",//客户端分页
            queryParams : function(params) {//上传服务器的参数
                var temp = {
                    hostelId:$("#hostelId").combobox('getValue'),
                    collegeId:$("#cc1").combobox('getValue'),
                    subjectId:$("#cc2").combobox('getValue'),
                    id:$("#id").val(),
                    name:$("#name").val(),
                    sex:2,
                    offset :params.offset + 0,// SQL语句起始索引
                    pageNumber :params.limit  // 每页显示数量
                };
                return temp;
            },
            checkboxHeader:true,
            clickToSelect:true,//自动选择rediobox 和 checkbox
            columns: [
                {
                    checkbox:true,
                },{
                    field: 'id',
                    title: '学号',
                    align: 'center'
                }, {
                    field: 'name',
                    title: '姓名',
                    align: 'center'
                },{
                    field: 'age',
                    title: '年龄',
                    align: 'center'
                },{
                    field: 'sex',
                    title: '性别',
                    align: 'center',
                    formatter:function (value) {
                        return value===0?'男':'女';
                    }
                },{
                    field: 'telephone',
                    title: '电话',
                    align: 'center'
                },{
                    field: 'collegeName',
                    title: '学院',
                    align: 'center'
                },{
                    field: 'subjectName',
                    title: '专业',
                    align: 'center'
                }, {
                    field:'hostelName',
                    title:'公寓名称',
                    align:'center'
                },{
                    field: 'bedroomId',
                    title: '寝室号',
                    align: 'center'
                }],

        });
    })


</script>
</html>
