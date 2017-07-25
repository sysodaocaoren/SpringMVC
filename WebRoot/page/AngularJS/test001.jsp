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
<%@include file="/common/inc.jsp"%>
<title>Insert title here</title>
</head>
<script src="http://cdn.static.runoob.com/libs/angular.js/1.4.6/angular.min.js"></script>
<body>
	<div ng-app>
		<p>姓名：<input type="text" ng-model="name"></p>
		<h1>hello {{name}}</h1>
	</div>
</body>
</html>