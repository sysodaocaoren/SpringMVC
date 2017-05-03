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
<%@include file="/common/inc.jsp"%>
<title>Insert title here</title>
<script type="text/javascript">
    //步骤2：写一个获取id的方法，获取到的是一个数组，这样在更新和删除都可以用
    //不过要在更新的时候自己判断只能勾选一条
    function getChecked(){
    	var ids=[];
    	//jquery选择器， $(".keyPairCheckbox:checked") 
    	//意思是获取所有class 是keyPairCheckbox 并且选中的checkbox
    	$(".keyPairCheckbox:checked").each(function(){
    		//所有选中的值push进ids数组
    		ids.push(this.value);
    	});
    	if(ids==""){
    		alert("请至少选择一条");
    		return ids;
    	}else{
    		alert(ids);
    	}
    	return ids;
    }
    //更新的方法
    function updateDialog (){
    	var ids=[];//先生成一个数组，放选中的id
       	//jquery选择器， $(".keyPairCheckbox:checked") 
       	//意思是获取所有class 是keyPairCheckbox 并且选中的checkbox
       	$(".keyPairCheckbox:checked").each(function(){//循环所有的选中的checkbox，把id放进数组
       		ids.push(this.value);//把id放进数组
       	});
       	if(ids.length==0){//如果没有勾选
       		alert("请至少选择一条");
       		return false;
       	}
       	if(ids.length>1){//如果勾选了多条
       		alert("只能选择一条信息修改");
       		return false;
       	}
        var url="toUpdate.do?id="+ids[0];//拼装后台请求路径，给iframe的src赋值
       	
    }
    //删除的方法
    function delete(){
    	var id=getChecked();
    	var url="delete.do?id="+id;
		window.href=url;
    }
</script>
</head>
<body>
	<form id="pageTest" action="listPageTest.do" method="post">
	<input type="hidden" name ="nowPage" id="nowPage" value="${pageobj.nowPage }" />
	<input type="hidden" name ="pageSize"  id="pageSize" value="${pageobj.pageSize }" />
		<table>
			<tr>
			    <td><td
				<td>id</td>
				<td>name</td>
				<td>hobby</td>
				<td>telPhone</td>
			</tr>
			<c:forEach items="${testList}" var="test">
				<tr>
				<!-- 步骤1：先给你的check设置class（方便找到），value（value的值就等于你要传过去的id） -->
				<td><input type="checkbox" class="keyPairCheckbox" value="${test.id}"/></td>
				<td>${test.id}</td>
				<td>${test.name}</td>
				<td>${test.hobby}</td>
				<td>${test.telPhone}</td>
				<tr/>
			</c:forEach>
		</table>
		<input type="button" value="ceshi" onclick="getChecked()"/>
		<page:page form="pageTest" page="${pageobj}"></page:page>
	</form>
	<button autofocus="true"  onclick="alert(213)">
		备份一下吧
	</button>
</body>
</html>