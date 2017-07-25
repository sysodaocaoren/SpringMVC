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
<script type="text/javascript">
	var app=angular.module('myapp',[]);
	
	//控制器
	app.controller('mycrl',function($scope){
		$scope.firstName='';
		$scope.lastName='';
	});
	//自定义属性
	app.directive("test1111",function(){
		return {
			template:"<h1>42452534</h1>"
		};
	});
	//自定义下拉框
	app.controller("ctrl33",function($scope){
		$scope.names=['2343','4131','42435','5757'];
	});
	
</script>
<body>
	<div ng-app="myapp" ng-init="name='2222'">
		<p>姓名：<input type="text" ng-model="name"></p>
		<h1>hello {{name}}</h1>
		<span ng-bind="name"></span>
		<div  ng-controller="mycrl">
		            姓：<input type="text" ng-model="firstName" /><br/>
		            名：<input type="text" ng-model="lastName" /><br/>
		    
		        姓名：{{firstName+" "+lastName}}
		</div>
		<!-- 循环 -->
		<div ng-init="names=['234','111','321','222']">
			<ul>
				<li ng-repeat="i in names">
					{{i}}
				</li>
			</ul>
		</div>
		<!-- 自定义属性 -->
		<test1111></test1111>
		
		<!-- 自定义下拉框 -->
		<div ng-controller="ctrl33">
			<select ng-init="selectedName=names[0]" ng-model="selectedName" ng-options="x for x in names"></select>
		</div>
	</div>
</body>
</html>