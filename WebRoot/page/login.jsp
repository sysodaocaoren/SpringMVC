<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="regist/123.do" method="post">
	        ID      ：<input type="text" name="id" />
	    <p>
		    username:<input type="text" name="username" />
		<p>
			password:<input type="password" name="password" />
		<p>
			<input type="submit" value="submit" />
		<div>
		   <iframe src="forward.do?page=succ" style="width:500px;height:500px"></iframe>
		</div>	
	</form>
</body>
</html>