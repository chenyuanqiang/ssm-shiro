<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<body>
<head>
<base href="<%=basePath%>">

<title>My JSP 'login.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript"
	src="<%=basePath%>js/jquery-1.11.3.min.js"></script>
</head>
<form action="user/login.do" method="post">
	username:<input name="loginName" id="loginName" type="text"><br>
	password:<input name="password" id="pasword" type="password"><label>${ex.message}</label><br>
	<td><input type="checkbox" name="rememberMe" />自动登陆 <input
		type="submit" value="submit"></td>
</form>
</body>