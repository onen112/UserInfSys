<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
    <head>
<%--    	<base href="<%=basePath%>"/>--%>
        <!-- 指定字符集 -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>修改用户</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/jquery-2.1.0.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        
    </head>
    <body>
        <div class="container" style="width: 400px;">
        <h3 style="text-align: center;">修改联系人</h3>
        <form action="${pageContext.request.contextPath}/updateServlet" method="post">
            <input type="hidden" value="${pageContext.request.getParameter("index")}" name="index">
          <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" value="${pageContext.request.getParameter("name")}" readonly="readonly" placeholder="请输入姓名" />
          </div>
            <input type="hidden" name="id" value="${pageContext.request.getParameter("id")}">
          <div class="form-group">
            <label>性别：</label>
              <input type="radio" checked name="gender" value="男"  />男
                <input type="radio" name="gender" value="女"  />女
          </div>

          <div class="form-group">
            <label for="age">年龄：</label>
            <input value="${pageContext.request.getParameter("age")}" type="text" class="form-control" id="age"  name="age" placeholder="请输入年龄" />
          </div>

          <div class="form-group">
            <label for="address">籍贯：</label>
             <select name="address" class="form-control" >
                <option value="广东">广东</option>
                <option value="广西">广西</option>
                <option value="湖南">湖南</option>
            </select>
          </div>

          <div class="form-group">
            <label for="qq">QQ：</label>
            <input value="${pageContext.request.getParameter("qq")}" type="text" class="form-control" name="qq" placeholder="请输入QQ号码"/>
          </div>

          <div class="form-group">
            <label for="emile">Email：</label>
            <input value="${pageContext.request.getParameter("emile")}" type="text" class="form-control" name="emile" placeholder="请输入邮箱地址"/>
          </div>

             <div class="form-group" style="text-align: center">
                <input class="btn btn-primary" type="submit" value="提交" />
                <input class="btn btn-default" type="reset" value="重置" />
                <input class="btn btn-default"  type="button" value="返回"/>
             </div>
        </form>
        </div>
    </body>
</html>