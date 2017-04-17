<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>home</title>
</head>
<body>
	<h2>登陆</h2>
    <form action="/login.do" method="post">
         username:<input type="text" value="${username }" name="username"/></br>
         password:<input type="text" value="${password }" name="password"/></br>
         <input type="submit" value="提交"/>
    </form>
	<p>
</body>
</html>
