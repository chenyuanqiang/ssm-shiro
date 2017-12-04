<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<
<form action="user/login" method="get">
    name:<input type="text" name="name" value="${name}"><<br>>
    password:<input type="password" name="password" value="${password}"><br>
    <input type="submit" value="提交" >
</form>
<c:if test="${user.password} !=null">
    登录的密码是${user.password}，用户名${user.name}
</c:if>

</body>
</html>
