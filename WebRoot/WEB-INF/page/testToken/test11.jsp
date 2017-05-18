<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/common/inc.jsp"%>
<title>测试防重复提交</title>
</head>
<script type="text/javascript">
	function commits2(){
		$("iframe[name='iframe']").attr('src','testCommits.do?token='+$("#token").val());
	}
</script>
<body>
	<div>
		<input type="hidden" id="token" name="token" value="${token}"/>
		<iframe name="iframe" src=""></iframe>
		<iframe name="iframe" src=""></iframe>
		<input type="button" value="ceshi" onclick="commits2()" />
	</div>
</body>
</html>