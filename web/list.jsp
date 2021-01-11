<%--
  Created by IntelliJ IDEA.
  User: onen
  Date: 2021/1/1
  Time: 7:22 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <script>
        function del(id){
            if(confirm("宁缺点要删除吗？该操作不可撤销！")){
                location.href = "${pageContext.request.contextPath}/delUserServlet?id=" + id;
            }
        }
        window.onload = function (){
            document.getElementById("deleteAll").onclick = function (){
                if(confirm("你确定要提交吗？该操作无不可撤销!")){
                    var uids = document.getElementsByName("uid");
                    for(var i = 0;i < uids.length;i++){
                        if(uids[i].checked){
                            document.getElementById("form").submit();
                        }
                    }
                }
            }
            document.getElementById("checkAll").onclick = function (){
                 var uids = document.getElementsByName("uid");
                 for(var i = 0;i < uids.length;i++){
                     uids[i].checked = this.checked;
                }
            }
        }
    </script>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>
    <div style="float: left;">
        <form class="form-inline" action="${pageContext.request.contextPath}/findUserByPagesServlet">
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <input type="text" name="name" value="${condition.name[0]}" class="form-control" id="exampleInputName2" >
            </div>
            <div class="form-group">
                <label for="exampleInputAddress">籍贯</label>
                <input name="address" value="${condition.address[0]}" type="text " class="form-control" id="exampleInputAddress" >
            </div>
            <div class="form-group">
                <label  for="exampleInputEmail3" >邮箱</label>
                <input name="emile" type="email" value="${condition.emile[0]}" class="form-control" id="exampleInputEmail3" >
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>
    <form id="form" method="post" action="${pageContext.request.contextPath}/delSelectedServlet">
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
        <c:forEach items="${pb.lists}" var="user" varStatus="s">
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
                    <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/changeUserServlet?id=${user.id}">修改</a>
                    <a class="btn btn-default btn-sm" href="javascript:del(${user.id})">删除</a>
                </td>
            </tr>
        </c:forEach>
        <div style="float: right;">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加联系人</a>
            <a class="btn btn-primary" href="javascript:void(0)" id="deleteAll">删除选中</a>
        </div>
    </table>
    </form>
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li class="${pb.currentPages eq 1?'disabled':''}">
                <a href="${pageContext.request.contextPath}/findUserByPagesServlet?currentPage=${pb.currentPages-1}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&emile=${condition.emile[0]}" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <c:forEach begin="1" var = "i" end="${pb.totalPages}">
                    <c:if test="${pb.currentPages == i}">
                        <li class="active"><a class="active" href="${pageContext.request.contextPath}/findUserByPagesServlet?currentPage=${i}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&emile=${condition.emile[0]}" class="active">${i}</a>
                    </c:if>
                    <c:if test="${pb.currentPages != i}">
                        <li><a href="${pageContext.request.contextPath}/findUserByPagesServlet?currentPage=${i}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&emile=${condition.emile[0]}" class="active">${i}</a></li>
                    </c:if>
            </c:forEach>
            <li class="${pb.currentPages eq pb.totalPages?'disabled':''}">
                <a href="${pageContext.request.contextPath}/findUserByPagesServlet?currentPage=${pb.currentPages+1}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&emile=${condition.emile[0]}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
            <span style="font-size: 20px;margin-left: 10px">
                共${pb.countPages}条记录，共${pb.totalPages}页
            </span>
        </ul>
    </nav>
</div>
</body>
</html>

