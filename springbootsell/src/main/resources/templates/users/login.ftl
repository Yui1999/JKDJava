
<html>
<head>
    <#include "../common/header.ftl">
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <style>
        body{
            background: #A1A5D4;
            background-size: 100%;
        }
        .div{
            width: 600px;
            height: 360px;
            background: rgba(0,0,0,0.5);
            margin: 0 auto;
            margin-top: 100px;
            margin-radius: 50px;
        }
        .form-horizontal{
            padding-top: 20%;
            padding-left: 10%;
        }
        .form-control{
            width: 300px;
        }
        .btn{
            width: 300px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="div">
        <form role="form" class="form-horizontal" action="/seller/users/login" method="post">
            <div class="form-group">
                <label for="inputEmail" class="col-sm-2 control-label">账号</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="userPhone" id="inputEmail" placeholder="请输入账号...">
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword" class="col-sm-2 control-label">密码</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" name="password" id="inputPassword" placeholder="请输入密码...">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                      <input type="submit" class="btn btn-primary" value="登录">
                </div>
            </div>
        </form>
    </div>
</div>

</body>
</html>