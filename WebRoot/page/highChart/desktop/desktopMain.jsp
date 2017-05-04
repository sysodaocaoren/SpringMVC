<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="page" uri="/WEB-INF/tld/pagetag.tld" %>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>contract list</title>
		<link type="text/css" rel="stylesheet"href="<%=path%>/css/lib.ui.core.css" />
		<link type="text/css" rel="stylesheet"href="<%=path%>/css/widget/lib.ui.button.css" />
		<link type="text/css" rel="stylesheet"href="<%=path%>/css/widget/lib.ui.toolbar.css" />
		<link type="text/css" rel="stylesheet"href="<%=path%>/css/widget/lib.ui.window.css" />
		<link type="text/css" rel="stylesheet"href="<%=path%>/css/widget/lib.ui.grid.css" />
		<link type="text/css" rel="stylesheet" href="<%=path%>/css/tab/tabPane.css"/>
		<link type="text/css" rel="stylesheet" href="<%=path%>/css/search.css" />
		<style type="text/css">
			
		</style>
	</head>
<body>
	<div id="two">
          <div id="two-div">
          	  <c:if test="${operateMap['viewComYear']}">
	          	<div class="tod tclick" >年度综合收支看板<input type="hidden" value="comYear"/></div>
	          </c:if>
	          <c:if test="${operateMap['viewLandMarket']}">
	          	<div class="tod ">土地市场看板 <input type="hidden" value="landMarket"/></div>
	          </c:if>
	          <c:if test="${operateMap['viewPaymentReminder']}">
	          	<div class="tod ">缴款提醒看板 <input type="hidden" value="PaymentReminder"/></div>
	          </c:if>
	          <a href="<%=path %>/view/desktop/viewComYear2.jsp">测试</a>
	          <%--<a href="<%=path %>/view/desktop/viewComYear2.jsp">测试</a> --%>
          </div>
     </div>
	<div id="comYearForm" method="post" style="display: block;width:100%; height:100% ">
		<iframe id="comYearIframe" frameborder="0" width="100%" height="100%"></iframe>
	</div>
	<div id="landMarketForm" style="display: block;;width:100%; height:100%">
		<iframe id="landMarketIframe" frameborder="0" width="100%" height="100%"></iframe>
	</div>
	<div id="PaymentReminderForm" style="display: block;;width:100%; height:100%">
		<iframe id="PaymentReminderIframe" frameborder="0" width="100%" height="100%"></iframe>
	</div>
	<script type="text/javascript" src="<%=path%>/js/jquery-1.5.1.js"></script>
	<script type="text/javascript" src="<%=path%>/js/BoxSelect.js"></script>
	<script type="text/javascript" src="<%=path%>/js/lib.ui.core.js"></script>
	<script type="text/javascript" src="<%=path%>/js/widget/lib.ui.button.js"></script>
	<script type="text/javascript" 	src="<%=path%>/js/widget/lib.ui.toolbar.js"></script>
	<script type="text/javascript" src="<%=path%>/js/widget/lib.ui.window.js"></script>
	<script type="text/javascript" src="<%=path%>/js/widget/lib.ui.drag.js"></script>
	<script type="text/javascript">
			$(document).ready(function(){
				//初始化页面时，判断用户拥有的权限显示看板
				if(${operateMap['viewComYear']==true}){
					$('#comYearIframe').attr('src','<%=path%>/deskTop/comYear.do');	
				}else if(${operateMap['viewLandMarket']==true}){
					$('#comYearForm').hide();
					$('#landMarketIframe').attr('src','<%=path%>/deskTop/landMarket.do');	
				}else if(${operateMap['viewPaymentReminder']==true}){
					$('#comYearForm').hide();
					$('#landMarketForm').hide();
					$('#PaymentReminderIframe').attr('src','<%=path%>/deskTop/PaymentReminder.do');	
				}
				$('#two div.tod').each(function(){
				  	$(this).bind("click",function(){
			       		 activeOne(this);//修改标题的样式
			       		 addTool($(this).find("input[type='hidden']").val(),'<%=path%>');
				  	});
			 	});
				setElementHeight('#uncompleteForm',['#two']);
				setElementHeight('#listForm',['#two']);
			});
			function activeOne(obj){
				$('#two .tclick').removeClass('tclick');
				$(obj).addClass('tclick');
			}
			function addTool(value,path){
					//年度综合看板
					if(value==='comYear'){
						$('#landMarketForm').hide();
						$('#PaymentReminderForm').hide();
						$('#comYearIframe').attr('src',path+'/deskTop/comYear.do');
						$('#comYearForm').show();
					}	
					//土地市场看板
					if(value==='landMarket'){
						$('#PaymentReminderForm').hide();
						$('#comYearForm').hide();
						$('#landMarketIframe').attr('src',path+'/deskTop/landMarket.do');
						$('#landMarketForm').show();
					}
					//缴款提醒看板
					if(value==='PaymentReminder'){
						$('#comYearForm').hide();
						$('#landMarketForm').hide();
						$('#PaymentReminderIframe').attr('src',path+'/deskTop/PaymentReminder.do');
						$('#PaymentReminderForm').show();
					}
			}
		
	</script>
</body>
</html>