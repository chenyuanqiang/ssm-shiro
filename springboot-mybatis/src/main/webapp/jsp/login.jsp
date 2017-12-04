<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/user/login" method="get">
    name:<input type="text" name="name" ><br>
    password:<input type="password" name="password" ><br>
    <input type="submit" value="提交" >
</form>
<c:forEach items="${user}" var="a">
    ${a.loginName}===${a.username}
</c:forEach>
</body>
</html>
