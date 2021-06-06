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
    <script type="text/javascript" src="/js/jquery.js"></script>
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
                            <td>
                                <span class="btn btn-primary" style="margin-right: 10px" data-toggle="modal" data-target="#addModal" onclick="btn_set()">分配宿舍</span>
                            </td>
                        </tr>
                        <tr>
                            <td>
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
    function find(){
        $('#myTab').bootstrapTable('refresh', {
            query: {
                hostelId:$("#hostelId").combobox('getValue'),
                collegeId:$("#cc1").combobox('getValue'),
                subjectId:$("#cc2").combobox('getValue'),
                offset: 0,
                pageNumber: 10
            }
        });
    }
    $(function() {

        //加载表格
        $('#myTab').bootstrapTable({
            url: 'bedroom/list',        // 表格数据来源
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
                field: 'hostelName',
                title: '公寓名称',
                align: 'center'
            }, {
                field: 'bedroomId',
                title: '寝室号',
                align: 'center'
            },{
                    field: 'sex',
                    title: '宿舍类型',
                    align: 'center',
                    formatter:function (value) {
                        return value==='0'?'男生公寓':'女生公寓';
                    }
                },{
                field: 'collegeName',
                title: '学院',
                align: 'center'
            },{
                field: 'subjectName',
                title: '专业',
                align: 'center'
            }
            // , {
            //     field:'maxNumber',
            //     title:'寝室可住人数',
            //     align:'center'
            //  },{
            //     field: 'number',
            //     title: '寝室已住人数',
            //     align: 'center'
            // },{
            //     field: 'full',
            //     title: '是否住满',
            //     align: 'center',
            //     formatter:function (value) {
            //         return value?'是':'否';
            //     }
            //  }
             ],

        });
    })
    //打开分配宿舍界面
    function btn_set(){
        window.location.href="bedroom_set";
    }
</script>
</html>
