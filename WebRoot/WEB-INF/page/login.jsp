<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/WEB-INF/tld/testName.tld" prefix="zym"%>  
<%@ taglib tagdir="/WEB-INF/tags/" prefix="nameTest"%>  
<%@taglib uri="/WEB-INF/tld/testVeloCity.tld" prefix="tvc"%>  
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@include file="/common/inc.jsp"%>

<title>我在WEB-INF下面</title>
</head>
<script type="text/javascript">
   $(function(){
	   /* 弹窗3：在页面初始化的时候先初始化 刚才定义弹窗id的div，可以在这里修改弹窗的大小，样式，显示，关闭事件*/
	   $("#testDialog").dialog({
		   autoOpen: false,
		   width: 600,
		   modal:true,
		   buttons: {
			   "Ok": function () {
		           $(this).dialog("close");
			   },
			   "Cancel": function () {
				   $(this).dialog("close");
			   }
		   },
		   show: {
		       effect: "fade",
			   duration: 500
		   },
		   hide: {
			   effect: "fade",
			   duration: 500
		   } 
	   });
   });
   function showIframe(){
	   $("#iframe2").attr("src","forward.do?page=succ");
   }
   /* 弹窗4：定义弹窗弹出的触发事件，比如你要修改信息，就是点击table一行调用的方法 */
   function testDialog(){
	   $("#testDialog").dialog("open");
   }
</script>
<body>
	<form action="login.do" method="post">
	        ID   ：<input type="text" name="id" />
	    <p>
		    username:<input type="text" name="username" />
		<p>
			password:<input type="password" name="password" />
		<p>
			createdDate: <input type="text" name="createdDate" onfocus="WdatePicker({skin:'default',dateFmt:'yyyy-MM-dd'})" class="Wdate" />
			<input type="submit" value="submit" />
			<input type="button" value="显示" onclick="showIframe()"/>
		<div>
		   <iframe src="" id="iframe2" style="width:500px;height:500px"></iframe>
		</div>
		<input type="button" onclick="testDialog()" value="dialog"></br>
		<zym:zym nameTest="朱玉猛"></zym:zym>		
		<zym:limin nameTest="lidamin"></zym:limin>		
		<zym:zym nameTest="naonao"></zym:zym>
		
		<nameTest:nameTest name="朱玉猛"></nameTest:nameTest>		
		<tvc:velocity name="zhuyumeng success"></tvc:velocity>
	</form>
	<!-- 弹窗1：先声明一个div，写上自定义的id和要弹出窗口的title -->
	<div id="testDialog" title="测试页面">
	    <!-- 弹窗2：在div里面定义一个iframe，src指向你要跳转的页面 -->
	    <iframe id="dialogIframe" src="forward.do?page=succ"></iframe>
	</div>
</body>
</html>