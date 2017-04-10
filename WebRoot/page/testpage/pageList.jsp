<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="page" uri="/WEB-INF/tld/pagetag.tld" %>
<%
	String path = request.getContextPath();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form id="pageTest" action="listPageTest.do" method="post">
	<input type="hidden" name ="nowPage" id="nowPage" value="${pageobj.nowPage }" />
	<input type="hidden" name ="pageSize"  id="pageSize" value="${pageobj.pageSize }" />
		<table>
			<tr>
				<td>id</td>
				<td>name</td>
				<td>hobby</td>
				<td>telPhone</td>
			</tr>
			<c:forEach items="${testList}" var="test">
				<tr/>
				<td>${test.id}</td>
				<td>${test.name}</td>
				<td>${test.hobby}</td>
				<td>${test.telPhone}</td>
				<tr/>
			</c:forEach>
		</table>
		<page:page form="pageTest" page="${pageobj}"></page:page>
	</form>
	<button autofocus="true"  onclick="alert(213)">
		备份一下吧
	</button>
</body>
</html>