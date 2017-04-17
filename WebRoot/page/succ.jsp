<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html >
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>home</title>
</head>
<body>
	<h2>登陆</h2>
    <form action="login.do" method="post">
         username:<input type="text" value="${username }" name="username"/></br>
         password:<input type="text" value="${password }" name="password"/></br>
         <input type="submit" value="提交"/>
    </form>
	<p>
</body>
</html>
