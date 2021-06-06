<%--
  Created by IntelliJ IDEA.
  User: zp
  Date: 2020/10/17
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../../../js/jquery.js"></script>
    <script type="text/javascript" src="../../../easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../../../easyui/easyui-lang-zh_CN.js"></script>


    <script type="text/javascript" src="../../../js/bootstrap-table.js"></script>
    <script type="text/javascript" src="../../../js/bootstrap-table-zh-CN.js"></script>
    <link href="../../../css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="../../../css/bootstrap-table.css" rel="stylesheet" type="text/css" />
    <link href="../../../easyui/easyui.css"  rel="stylesheet" type="text/css"/>

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
                            <td>
                                <span class="btn btn-primary" style="margin-right: 10px" data-toggle="modal" data-target="#addModal" onclick="btn_add()">添加</span>
                                <span class="btn btn-primary" style="margin-right: 10px" data-toggle="modal" data-target="#addModal" onclick="btn_remove()">删除</span>
                                <span class="btn btn-primary" style="margin-right: 10px" data-toggle="modal" data-target="#addModal" onclick="btn_edit()">修改</span>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="text" class="form-control" id="search-input" placeholder="检索 ..."
                                       style="height: 34px;  margin-right: 10px" size="20" />
                                <button title="查询" id="btnSearch" type="button" style="" class="btn btn-success onclickbtn" >查询
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
</body>
<script>
    $(function() {
        //加载表格
        $('#myTab').bootstrapTable({
            url: 'hostel/list',        // 表格数据来源
            dataType: "json",         //服务器返回的数据类型
            pagination:true,          //显示分页条
            pageNumber:1,//分页首页页码
            pageSize:10,//每页显示条数发啊
            height:454,//表高度
            sidePagination: "client",//客户端分页
            checkboxHeader:true,
            clickToSelect:true,//自动选择rediobox 和 checkbox
            columns: [
                {
                    checkbox:true,
                },{
                field: 'hostelId',
                title: '楼号',
                align: 'center'
            }, {
                field: 'name',
                title: '名称',
                align: 'center'
            }, {
                field: 'sex',
                title: '宿舍类型',
                align: 'center',
                formatter:function (value) {
                    return value==='0'?'男生公寓':'女生公寓';
                }
            },{
                field: 'floor',
                title: '楼层数',
                align: 'center',
            }, {
                field:'number',
                title:'每层宿舍数量',
                align:'center'
             },{
                field: 'people',
                title: '每间宿舍可住人数',
                align: 'center'
            },{
                field: 'telephone',
                title: '公寓电话',
                align: 'center'
            },{
                field: 'address',
                title: '地址',
                align: 'center'
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
    function btn_add(){
        window.location.href="hostel_add";
       }
    //删除
    function btn_remove(){
        var select=$('#myTab').bootstrapTable('getSelections');
        if(select.length===0){
            $.messager.alert('信息提示','至少选择一条数据进行删除！','info');
        }else{
            var ids=[];
            for(var i=0;i<select.length;i++){
                ids.push(select[i].hostelId)
            }
            $.messager.confirm('信息提示',"确定要删除公寓号为"+ids+"的公寓吗？",function(result) {
                if (result) {
                    $.ajax({
                        url: "hostel/remove",
                        data: {
                            ids: ids.toString()
                        },
                        success: function (data) {
                            if (data.status === 200) {
                                alert('删除成功！');
                                $('#myTab').bootstrapTable('refresh');
                            } else {
                                alert('删除失败！info');
                            }
                        }
                    })
                }
            })
        }
    }
    //打开修改界面
    function btn_edit(){
        let select=$('#myTab').bootstrapTable('getSelections');
        if(select.length<1){
            $.messager.alert("信息提示","请选择修改的数据","info");
        }else if(select.length>1){
            $.messager.alert("信息提示","一次只能修改一条信息","error");
        }else{
            window.location.href="hostel/hostel_edit?hostelId="+select[0].hostelId;
        }
    }
    $(function () {
        //查询搜索
        $('#btnSearch').on('click', function () {
            var keyvalue = $("#search-input").val();
            $('#myTab').bootstrapTable("loadAddSearch", keyvalue);
        });
    });
</script>
</html>
