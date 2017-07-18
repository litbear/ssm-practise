<%@page isELIgnored="false" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet"/>
    <title>添加用户</title>
</head>
<body>
<div id="context">
    <div class="page-header">
        <h1>添加用户<small>以传统POST方式</small></h1>
    </div>
    <form action="${pageContext.request.contextPath}/users/add" method="post">
        <div class="form-group">
            <label for="username">姓名</label>
            <input name="username" type="text" class="form-control" id="username" placeholder="用户姓名">
        </div>
        <div class="form-group">
            <label for="gender1">性别</label>
            <div class="radio">
                <label>
                    <input type="radio" name="gender" id="gender1" value="0" checked>
                    女
                </label>
            </div>
            <div class="radio">
                <label>
                    <input type="radio" name="gender" id="gender2" value="1">
                    男
                </label>
            </div>
        </div>
        <div class="form-group">
            <label for="birthdate">出生日期</label>
            <input name="birthdate" type="date" class="form-control" id="birthdate" placeholder="出生日期">
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input name="email" type="email" class="form-control" id="email" placeholder="电子邮箱地址">
        </div>
        <div class="form-group">
            <label for="address">地址</label>
            <input name="address" type="text" class="form-control" id="address" placeholder="用户地址">
        </div>
        <div class="form-group">
            <input class="btn btn-default pull-right" type="submit" value="Submit">
        </div>
    </form>
</div>

</body>
</html>