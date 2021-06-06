<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>宿舍管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <style  >
        body {
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #f5f5f5;
        }
        .form-signin {
            height: 50%;
            max-width: 50%;
            padding: 19px 29px 29px;
            margin: auto auto 20px;
            background-color: #fff;
            border: 1px solid #e5e5e5;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
            -webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            -moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
        }

        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
        }

        .form-signin input[type="text"],
        .form-signin input[type="password"] {
            font-size: 24px;
            height: auto;
            margin-bottom: 15px;
            padding: 7px 9px;
        }
        .form-signin-heading{
            color: red;
            text-align: center;
        }
        .form-signin-mar{
            color: #31d056;
            text-align: center;
            margin-top: 25px;
        }
        .container{
            margin-top: auto;
        }
        form{
            margin: 0 0 5px;
        }
        .input-block-level {
            display: block;
            width: 100%;
            min-height: 60px;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
            font-size: 140px;
        }
        p {
            margin: 0 0 10px;
        }
        h1, h3, h6 {
            margin: 10px 0;
            font-family: inherit;
            font-weight: bold;
            line-height: 20px;
            color: inherit;
            text-rendering: optimizelegibility;
        }

        h1 small,
        h2 small,
        h3 small,
        h4 small,
        h5 small,
        h6 small {
            font-weight: normal;
            line-height: 1;
            color: #999999;
        }

        h1,
        h2,
        h3 {
            line-height: 40px;
        }

        h1 {
            font-size: 38.5px;
        }

        h2 {
            font-size: 31.5px;
        }

        h3 {
            font-size: 24.5px;
        }

        h4 {
            font-size: 17.5px;
        }

        h5 {
            font-size: 14px;
        }

        h6 {
            font-size: 11.9px;
        }

        h1 small {
            font-size: 24.5px;
        }

        h2 small {
            font-size: 17.5px;
        }

        h3 small {
            font-size: 14px;
        }

        h4 small {
            font-size: 14px;
        }


        input,
        textarea,
        .uneditable-input {
            width: 206px;
        }

        textarea {
            height: auto;
        }

        textarea,
        input[type="text"],
        input[type="password"],
        input[type="datetime"],
        input[type="datetime-local"],
        input[type="date"],
        input[type="month"],
        input[type="time"],
        input[type="week"],
        input[type="number"],
        input[type="email"],
        input[type="url"],
        input[type="search"],
        input[type="tel"],
        input[type="color"],
        .uneditable-input {
            background-color: #ffffff;
            border: 1px solid #cccccc;
            -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
            -moz-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
            box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
            -webkit-transition: border linear 0.2s, box-shadow linear 0.2s;
            -moz-transition: border linear 0.2s, box-shadow linear 0.2s;
            -o-transition: border linear 0.2s, box-shadow linear 0.2s;
            transition: border linear 0.2s, box-shadow linear 0.2s;
        }
        .btn {
            display: inline-block;
            *display: inline;
            padding: 4px 12px;
            margin-bottom: 0;
            *margin-left: .3em;
            font-size: 14px;
            line-height: 20px;
            color: #333333;
            text-align: center;
            text-shadow: 0 1px 1px rgba(255, 255, 255, 0.75);
            vertical-align: middle;
            cursor: pointer;
            background-color: #f5f5f5;
            *background-color: #e6e6e6;
            background-image: -moz-linear-gradient(top, #ffffff, #e6e6e6);
            background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#ffffff), to(#e6e6e6));
            background-image: -webkit-linear-gradient(top, #ffffff, #e6e6e6);
            background-image: -o-linear-gradient(top, #ffffff, #e6e6e6);
            background-image: linear-gradient(to bottom, #ffffff, #e6e6e6);
            background-repeat: repeat-x;
            border: 1px solid #cccccc;
            *border: 0;
            border-color: #e6e6e6 #e6e6e6 #bfbfbf;
            border-color: rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.25);
            border-bottom-color: #b3b3b3;
            -webkit-border-radius: 4px;
            -moz-border-radius: 4px;
            border-radius: 4px;
            filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffffffff', endColorstr='#ffe6e6e6', GradientType=0);
            filter: progid:DXImageTransform.Microsoft.gradient(enabled=false);
            *zoom: 1;
            -webkit-box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.05);
            -moz-box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.05);
            box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.05);
        }

        .btn:hover,
        .btn:focus,
        .btn:active,
        .btn.active,
        .btn.disabled,
        .btn[disabled] {
            color: #333333;
            background-color: #e6e6e6;
            *background-color: #d9d9d9;
        }

        .btn:active,
        .btn.active {
            background-color: #cccccc \9;
        }

        .btn:first-child {
            *margin-left: 0;
        }

        .btn:hover,
        .btn:focus {
            color: #333333;
            text-decoration: none;
            background-position: 0 -15px;
            -webkit-transition: background-position 0.1s linear;
            -moz-transition: background-position 0.1s linear;
            -o-transition: background-position 0.1s linear;
            transition: background-position 0.1s linear;
        }

        .btn:focus {
            outline: thin dotted #333;
            outline: 5px auto -webkit-focus-ring-color;
            outline-offset: -2px;
        }

        .btn.active,
        .btn:active {
            background-image: none;
            outline: 0;
            -webkit-box-shadow: inset 0 2px 4px rgba(0, 0, 0, 0.15), 0 1px 2px rgba(0, 0, 0, 0.05);
            -moz-box-shadow: inset 0 2px 4px rgba(0, 0, 0, 0.15), 0 1px 2px rgba(0, 0, 0, 0.05);
            box-shadow: inset 0 2px 4px rgba(0, 0, 0, 0.15), 0 1px 2px rgba(0, 0, 0, 0.05);
        }

        .btn.disabled,
        .btn[disabled] {
            cursor: default;
            background-image: none;
            opacity: 0.65;
            filter: alpha(opacity=65);
            -webkit-box-shadow: none;
            -moz-box-shadow: none;
            box-shadow: none;
        }

        .btn-large {
            padding: 11px 19px;
            font-size: 17.5px;
            -webkit-border-radius: 6px;
            -moz-border-radius: 6px;
            border-radius: 6px;
        }

        .btn-large [class^="icon-"],
        .btn-large [class*=" icon-"] {
            margin-top: 4px;
        }

        input[type="submit"].btn-block,
        input[type="reset"].btn-block,
        input[type="button"].btn-block {
            width: 100%;
        }
        .btn-primary.active,
        .btn-warning.active,
        .btn-danger.active,
        .btn-success.active,
        .btn-info.active,
        .btn-inverse.active {
            color: rgba(255, 255, 255, 0.75);
        }

        .btn-primary {
            color: #ffffff;
            text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.25);
            background-color: #006dcc;
            *background-color: #0044cc;
            background-image: -moz-linear-gradient(top, #0088cc, #0044cc);
            background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#0088cc), to(#0044cc));
            background-image: -webkit-linear-gradient(top, #0088cc, #0044cc);
            background-image: -o-linear-gradient(top, #0088cc, #0044cc);
            background-image: linear-gradient(to bottom, #0088cc, #0044cc);
            background-repeat: repeat-x;
            border-color: #0044cc #0044cc #002a80;
            border-color: rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.25);
            filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ff0088cc', endColorstr='#ff0044cc', GradientType=0);
            filter: progid:DXImageTransform.Microsoft.gradient(enabled=false);
        }

        .btn-primary:hover,
        .btn-primary:focus,
        .btn-primary:active,
        .btn-primary.active,
        .btn-primary.disabled,
        .btn-primary[disabled] {
            color: #ffffff;
            background-color: #0044cc;
            *background-color: #003bb3;
        }

        .btn-primary:active,
        .btn-primary.active {
            background-color: #003399 \9;
        }
        .btn .label,
        .btn .badge {
            position: relative;
            top: -1px;
        }
        .back img{
            position: fixed;
            top: 0px;
            left: 0px;
            width: 100%;
            height: 100%;
            z-index: -1;
        }
        .login{
            margin-top: 0%;
        }
    </style>
</head>
<body>
    <div class="back">
        <img src="/images/back.png" alt>
    </div>
    <div class="login">
        <div style="width: 50%;float: right;">
            <form class="form-signin" method="post" action="/login/login" style="line-height: 40px">
                <h1 class="form-signin-heading" style="font-size: 60px">阜阳师范大学</h1>
                <h3 class="form-signin-mar" style="font-size: 40px">宿舍管理系统</h3>
                <input type="text" name="id" class="input-block-level" placeholder="账号">
                <input type="password" name="password" class="input-block-level" placeholder="密码">

                <p style="text-align: center"><button class="btn btn-large btn-primary" type="submit">登录</button></p>
                <p style="text-align: center"><span style="color: red; font-size: 20px; font-weight: bold;">${msg}</span></p>
                <p>
                    <h6 style="color: red;font-size: 25px">登录提示： </h6>
                    <span style="font-size: 20px;">
                        请使用学号、工号作为登录账号。未修改过密码的用户请尝试使用登录账号进行登录，
                        为保障账号安全，请及时修改密码，并尽量使用强密码。
                    </span>
                </p>
            </form>
        </div>
    </div>
</body>
</html>