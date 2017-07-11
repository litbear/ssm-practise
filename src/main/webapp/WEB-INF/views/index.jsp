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
    <link href="${pageContext.request.contextPath}/static/css/bootstrap-datetimepicker.min.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet"/>
    <script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap-datetimepicker.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
    <script>
        const userlist = '${pageContext.request.contextPath}/users';
    </script>
    <script src="${pageContext.request.contextPath}/static/js/user.js"></script>
    <title>主页</title>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Brand</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
                <li><a href="#">Link</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">Dropdown <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">One more separated link</a></li>
                    </ul>
                </li>
            </ul>
            <form class="navbar-form navbar-left">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
            <div class="navbar-form navbar-right">
                <button type="submit" class="btn btn-default"  data-toggle="modal" data-target="#addUserModal">新增用户</button>
            </div>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">Dropdown <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<!-- Modal -->
<div class="modal fade" id="addUserModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">新增用户</h4>
            </div>
            <div class="modal-body">
                <form id="userInfo">
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
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">放弃</button>
                <button type="button" class="btn btn-primary" id="addUserBtn">保存</button>
            </div>
        </div>
    </div>
</div>
<div id="context">
    <div class="table-responsive">
        <table class="table table-striped">
            <tr>
                <th>姓名</th>
                <th>性别</th>
                <th>出生日期</th>
                <th>电子邮箱</th>
                <th>地址</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${requestScope.userList}" var="user">
                <tr>
                    <td>${user.username}</td>
                    <td>${user.gender}</td>
                    <td><fmt:formatDate value="${user.birthdate}" pattern="yyyy-MM-dd" /></td>
                    <td>${user.email}</td>
                    <td>${user.address}</td>
                    <td>
                        <button type="button" class="btn btn-default">查看</button>
                        <button type="button" class="btn btn-danger">删除</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

</body>
</html>