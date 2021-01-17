<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
    <script type="text/javascript">
        window.onload = function (){
            //全选或全部取消
            var all = document.getElementById("checkAll");
            all.onclick = function () {
                var check = document.getElementsByName("uid");
                for (var i = 0; i < check.length; i++) {
                    check[i].checked = this.checked;
                }
            }


        }
        function del (id){
            if(confirm("你确定要删除嘛？该操作不可撤销？")){
                window.location.href = id;
            }
        }
        function delSelect(){
            var check = document.getElementsByName("uid");
            if(confirm("你确定要删除选中嘛？该操作不可撤销？")) {
                for (var i = 0; i < check.length; i++) {
                    if (check[i].checked == true) {
                        console.log(check[i].value);
                        document.getElementById("form").submit();
                    }
                }
            }
        }
    </script>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>

    <form class="form-inline" action="${pageContext.request.contextPath}/searchUserServlet" method="post" style="float: left">
        <div class="form-group">
            <label for="exampleInputName2">姓名</label>
            <input type="text" name="name" value="${pageContext.request.getParameter('name')}" class="form-control" id="exampleInputName2">
        </div>
        <button type="submit" class="btn btn-default">搜索</button>
    </form>

    <form id="form" action="${pageContext.request.contextPath}/removeSelectServlet" method="post">
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th><input id="checkAll" type="checkbox"></th>
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>籍贯</th>
            <th>QQ</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>
        <c:forEach items='${pageContext.request.getAttribute("user")}' var="user" varStatus="s">
            <tr>
                <th><input id="check" value="${user.id}" name="uid" type="checkbox"></th>
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.gender}</td>
                <td>${user.age}</td>
                <td>${user.address}</td>
                <td>${user.qq}</td>
                <td>${user.emile}</td>
                <td>
                    <a class="btn btn-primary btn-sm" href="${pageContext.request.contextPath}/update.jsp?id=${user.id}&name=${user.name}&age=${user.age}&qq=${user.qq}.qq&emile=${user.emile}">修改</a>
                    &nbsp;<a class="btn btn-warning btn-sm" id="del" onclick="del('${pageContext.request.contextPath}/deleteInfServlet?id=${user.id}')">删除</a>
                    </td>
            </tr>
        </c:forEach>
        <div style="float: right">
            <a class="btn btn-primary" href="add.jsp">添加用户</a>
            <a  class="btn btn-danger" href="javascript:void(0)" onclick="delSelect()">删除选中</a>
        </div>
    </table>
    </form>
</div>
</body>
</html>
