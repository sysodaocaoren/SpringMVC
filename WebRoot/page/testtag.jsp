<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="add" tagdir="/WEB-INF/tags/" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <add:testEmpty x="3" y="4"/>
   <add:testScriptless>
   <label>contextPath:<label/> ${pageContext.request.contextPath}
   </add:testScriptless>
</body>
</html>