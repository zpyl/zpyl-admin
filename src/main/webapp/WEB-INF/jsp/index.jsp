<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>后台管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="../../assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="../../assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="../../assets/css/main-min.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="../../assets/js/jquery-1.8.1.min.js"></script>
    <script type="text/javascript" src="../../assets/js/bui-min.js"></script>
    <script type="text/javascript" src="../../assets/js/common/main-min.js"></script>
    <script type="text/javascript" src="../../assets/js/config-min.js"></script>
    <style>
        #hbd {
            position: relative;
            text-align: left;
            margin: 0px auto;
            width: 1440px;
            height: 220px;
            overflow: hidden;
            background: url(../../images/1.png) no-repeat 0px 0px;
        }
        #dh_search {
            MARGIN-TOP: 132px;
            WIDTH: 600px;
            FLOAT: right;
            HEIGHT: 60px;
            OVERFLOW: hidden;
            font-size: 30px;
        }
        #dna {
            text-align: left;
            margin: 0px auto;
            width: 1440px;
            height: 71px;
            overflow: hidden;
        }
        ol, ul{
            list-style: none;
        }
        #dn_main{
            padding-bottom: 0px;
            padding-left: 20px;
            padding-right: 0px;
            height: 45px;
            overflow: hidden;
            padding-top: 0px;
        }
        #dn_main li{
            border-bottom: 0px;
            text-align: center;
            border-left: #3d6dad 0px solid;
            float: left;
            margin-left: -1px;
            border-top: #3d6dad 0px solid;
            border-right: #3d6dad 0px solid;
        }
        #dn_main li a{
            color: #20dfed;
            text-decoration: none;
            font-size: 18px;
            width: 118px;
            float: left;
            height: 45px;
            padding-top: 10px;
        }
    </style>
</head>
<body>
<div class="header">

    <div class="navbar navbar-inverse navbar-fixed-top">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tbody>
                <tr>
                    <td height="200" background="../../images/2.png">
                        <div id="hbd">
                            <div id="dh_search">
                                <div class="dl-log">欢迎您
                                    <span class="dl-log-user" >${sessionScope.user==1?'宿舍管理员：':sessionScope.user==2?'学生：':'超级管理员：'}${name}</span>
                                    <a href="/login/logout" class="dl-log-quit">[退出]    </a>
                                </div>
                            </div>
                        </div>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</div>



<div class="content">
    <div class="dl-main-nav">
        <div class="dl-inform"><div class="dl-inform-title"><s class="dl-inform-icon dl-up"></s></div></div>
        <ul id="J_Nav"  class="nav-list ks-clear">
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-home">系统管理</div></li>
        </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">

    </ul>

</div>

<script>
    var app = [{
        id: '1',
        menu: [{
            text: '宿舍管理',
            items: [
                {id: '6', text: '学生管理', href: '/student/student'},
                {id: '12', text:'职工管理', href: '/staff/staff'},
                {id: '3', text: '公寓管理', href: '/hostel/hostel'},
                {id: '4', text: '宿舍管理', href: '/bedroom/bedroom'},
                {id: '7', text: '报修管理', href: '/repair/repair'},
                {id: '13', text: '修改密码', href: '/info/info'}]
        }]
    },{
        id: '1',
        menu: [{
            text: '宿舍管理',
            items: [
                {id: '4', text: '宿舍管理', href: '/bedroom/bedroom/bedroomStaff'},
                {id: '6', text: '学生管理', href: '/student/student'},
                {id: '7', text: '报修管理', href: '/repair/repair'},
                {id: '8', text: '个人信息', href: '/info/stuff'},
                {id: '13', text: '修改密码', href: '/info/info'}]
        }]
    },{
        id: '1',
        menu: [{
            text: '宿舍管理',
            items: [
                {id: '4', text: '宿舍详情', href: "/bedroom/bedroom/studentInfo?bedroomId=${student.bedroomId}&hostelId=${student.hostelId}"},
                {id: '7', text: '报修', href: '/repair/repair'},
                {id: '8', text: '个人信息', href: '/info/student'},
                {id: '13', text: '修改密码', href: '/info/info'}]
        }]
    }];
    BUI.use('common/main',function(){
        var config=[app[${sessionScope.user}]]
        console.log(config)
        new PageUtil.MainPage({
            modulesConfig : config
        });
    });
</script>
</body>
</html>