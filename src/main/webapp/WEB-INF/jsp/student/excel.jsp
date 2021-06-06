<%--
  Created by IntelliJ IDEA.
  User: zp
  Date: 2020/10/26
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../../../js/jquery.js"></script>
</head>
<body>
<div style="text-align: center"><h1 style="font-size: 40px">导入<span style="color: red">新生</span>信息</h1>
    <span style="font-size: 20px;color: blue">只能是.xls和.xlsx结尾的excel文件</span>
    <form enctype="multipart/form-data" id="batchUpload" method="post" class="form-horizontal">
        <button class="btn btn-success btn-xs" id="uploadEventBtn" style="height:26px;"  type="button" >选择文件</button>
        <input type="file" name="file"  style="width:0px;height:0px;" id="uploadEventFile">
        <input id="uploadEventPath"  disabled="disabled"  type="text" >
    </form>
    <button type="button" class="btn btn-success btn-sm"  onclick="user.uploadBtn()" >上传</button>
    <button type="button" class="btn btn-success" name="backid" onclick="staff_back()">取消</button>
</div>
</body>
<script>
    var User = function(){
        this.init = function(){
            //模拟上传excel
            $("#uploadEventBtn").unbind("click").bind("click",function(){
                $("#uploadEventFile").click();
            });
            $("#uploadEventFile").bind("change",function(){
                $("#uploadEventPath").attr("value",$("#uploadEventFile").val());
            });
        };
        //点击上传按钮
        this.uploadBtn = function(){
            var uploadEventFile = $("#uploadEventFile").val();
            if(uploadEventFile == ''){
                alert("请选择excel,再上传");
            }else if(uploadEventFile.lastIndexOf(".xls")<0){//可判断以.xls和.xlsx结尾的excel
                alert("只能上传Excel文件");
            }else{
                var url =  '/excel/excel/put/';
                var formData = new FormData($('form')[0]);
                user.sendAjaxRequest(url,'POST',formData);
            }
        };
        this.sendAjaxRequest = function(url,type,data){
            $.ajax({
                url : url,
                type : type,
                data : data,
                success : function(data) {
                    if(data.status===200){
                        alert( "excel上传成功");
                        window.location.href="student";
                    }else{
                        alert( "excel文件格式不对");
                    }
                },
                error : function() {
                    alert( "excel文件格式不对");
                },
                cache : false,
                contentType : false,
                processData : false
            });
        };
    }
    var user;
    $(function() {
        user = new User();
        user.init();
    })
    //取消
    function staff_back(){
        window.location.href="student";
    }
</script>
</html>




<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: zp--%>
<%--  Date: 2020/10/26--%>
<%--  Time: 20:52--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--    <script type="text/javascript" src="../../../js/jquery.js"></script>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>导入<span style="color: red">新生</span>信息</h1>--%>
<%--<span>只能是.xls和.xlsx结尾的excel文件</span>--%>
<%--    <form enctype="multipart/form-data" id="batchUpload" method="post" class="form-horizontal">--%>
<%--        <button class="btn btn-success btn-xs" id="uploadEventBtn" style="height:26px;"  type="button" >选择文件</button>--%>
<%--        <input type="file" name="file"  style="width:0px;height:0px;" id="uploadEventFile">--%>
<%--        <input id="uploadEventPath"  disabled="disabled"  type="text" >--%>
<%--    </form>--%>
<%--    <button type="button" class="btn btn-success btn-sm"  onclick="user.uploadBtn()" >上传</button>--%>
<%--    <button type="button" class="btn btn-success" name="backid" onclick="staff_back()">取消</button>--%>
<%--</body>--%>
<%--<script>--%>
<%--    var User = function(){--%>
<%--        this.init = function(){--%>
<%--            //模拟上传excel--%>
<%--            $("#uploadEventBtn").unbind("click").bind("click",function(){--%>
<%--                $("#uploadEventFile").click();--%>
<%--            });--%>
<%--            $("#uploadEventFile").bind("change",function(){--%>
<%--                $("#uploadEventPath").attr("value",$("#uploadEventFile").val());--%>
<%--            });--%>
<%--        };--%>
<%--        //点击上传按钮--%>
<%--        this.uploadBtn = function(){--%>
<%--            var uploadEventFile = $("#uploadEventFile").val();--%>
<%--            if(uploadEventFile == ''){--%>
<%--                alert("请选择excel,再上传");--%>
<%--            }else if(uploadEventFile.lastIndexOf(".xls")<0){//可判断以.xls和.xlsx结尾的excel--%>
<%--                alert("只能上传Excel文件");--%>
<%--            }else{--%>
<%--                var url =  '/excel/excel/put/';--%>
<%--                var formData = new FormData($('form')[0]);--%>
<%--                user.sendAjaxRequest(url,'POST',formData);--%>
<%--            }--%>
<%--        };--%>
<%--        this.sendAjaxRequest = function(url,type,data){--%>
<%--            $.ajax({--%>
<%--                url : url,--%>
<%--                type : type,--%>
<%--                data : data,--%>
<%--                success : function(data) {--%>
<%--                    if(data.status===200){--%>
<%--                        alert( "excel上传成功");--%>
<%--                        window.location.href="student";--%>
<%--                    }else{--%>
<%--                        alert( "excel上传失败");--%>
<%--                    }--%>
<%--                },--%>
<%--                error : function() {--%>
<%--                    alert( "excel上传失败");--%>
<%--                },--%>
<%--                cache : false,--%>
<%--                contentType : false,--%>
<%--                processData : false--%>
<%--            });--%>
<%--        };--%>
<%--    }--%>
<%--    var user;--%>
<%--    $(function() {--%>
<%--        user = new User();--%>
<%--        user.init();--%>
<%--    })--%>
<%--    //取消--%>
<%--    function staff_back(){--%>
<%--        window.location.href="student";--%>
<%--    }--%>
<%--</script>--%>
<%--</html>--%>
