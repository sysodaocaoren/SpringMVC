<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="page" uri="/WEB-INF/tld/pagetag.tld" %>
<%
	String path = request.getContextPath();
%>
<html>
<head>
<title>缴款提醒看板</title>
<meta name="decorator" content="default" />


<link type="text/css" rel="stylesheet" href="<%=path%>/css/deskTop/PaymentReminder.css"/>
<link type="text/css" rel="stylesheet" href="<%=path%>/css/lib.ui.core.css" />
<link type="text/css" rel="stylesheet" href="<%=path%>/css/lib.ui.form.css" />
<link type="text/css" rel="stylesheet" href="<%=path%>/css/widget/lib.ui.button.css" />
<link type="text/css" rel="stylesheet" href="<%=path%>/css/widget/lib.ui.toolbar.css" />
<link type="text/css" rel="stylesheet" href="<%=path%>/css/widget/lib.ui.tab.css" />
<link type="text/css" rel="stylesheet" href="<%=path%>/css/widget/lib.ui.window.css" />
<link type="text/css" rel="stylesheet" href="<%=path%>/css/widget/lib.ui.grid.css" />
<link type="text/css" rel="stylesheet" href="<%=path%>/css/validate.css" />
<link type="text/css" rel="stylesheet" href="<%=path%>/js/uploadify/uploadify.css" />
<style type="text/css">
.form-line .wide {
	width: 90%;
}

table{ border-collapse:collapse; }
td{ border:1px solid #70C1FF;}

.tableList{
	font-size: 9px;
	text-align: center;
	height: 90%;
}
.grid1{
	margin-top: 13px;
}
@-moz-document url-prefix(){
	.tableList{
		font-size: 9px;
		text-align: center;
		height: 33%;
		margin-top: 18px;
	}
	.tableList thead{
		height:26px;
	}
	.tableList tbody tr td{
		height:26px;
	}
}
</style>
<!--[if IE]>
<style type="text/css">
 /* 针对IE9定义的样式 */
 .tableList{
	font-size: 9px;
	text-align: center;
	height: 25%;
}
.grid1{
	margin-top:30px;
}
</style>
<![endif]-->
<!--[if IE 8]>
<style type="text/css">
 /* 针对IE8定义的样式 */
.left-top-table{
	margin-top:3px;
	height:8%;
}
.tableList{
	height:30%;
	margin:0px;
	padding:0px;
}
.form-line{
	height:5%;
	margin-top:10px;
}
.tableList thead tr td{
	height:26px;
}
.tableList tbody tr td{
	height: 22px;
}
.grid1{
	margin-top:5px;
	padding:0px;
}
.left-bottom-pie{
	height:50%;
}
</style>
<![endif]-->
</head>
<body>
	<div class="left-div">
		<div class="left-top-table">
			<form id="paymentForm" method="post" action="<%=path%>/paymentReminder/YDXpayList.do">
			<div class="form-line" style="width: 95%">
				<div class="form-label" style="width: 30%;font-size: 14px;">
					熟化主体：
				</div>
				<div class="form-input" style="width: 60%;">
					<select id="curMainId" name="curMain" class="select" style="width: 90%">
						  <option value="">---全部---</option>
						<c:forEach  items="${curMainlist }" var="ct">
						  <option value="${ct.id}">${ct.name}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-line" style="width: 95%;margin-top:7px">
				<div class="form-label" class="select" style="width: 30%;font-size: 14px;" id="contractType_div">
					分析类型：
				</div>
				<div class="form-input" style="width: 60%">
					<select name="style" id="style" style="width: 90%">
						<option value="00">已到账</option>
						<option value="01">未到账</option>
					</select>
				</div>
			</div>
			<div class="form-line" style="width: 95%;margin-top:7px">
			<div>
				<div class="form-label" class="select" style="width: 30%;font-size: 14px;" id="contractType_div">
					签订日期：
				</div>
				<div class="form-input" style="width: 60%">
					<input type="text" style="width: 85px" id="timeStart" name="timeStart" class="Wdate" onclick='WdatePicker()' value="${timeStart}"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'timeEnd\')}'})"/>
								到
					<input type="text" style="width: 85px" id="timeEnd" name="timeEnd" value="<fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>" class="Wdate" onclick='WdatePicker()' value="<fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'timeStart\')}'})"/>
				</div>
			</div>
			</div>
			<div class="form-line" style="width: 95%;margin-top:5px" align="center">
				<input type="button" value="开始分析" onclick="startAnay()">
			</div>
			</form>
		</div>
		<div class="left-middle-table" id="middleTable">3</div>
		<div class="left-bottom-pie" id="buttomChart" name="buttomChart"></div>
	</div>
<div class="right-div">
	<iframe  frameborder="0" name="mainFrame" id="mainFrame"></iframe>
	<input type="hidden" id="datapie">
</div>
<div id="ydzTable" style="display: none;">
	<div class="grid1">
			<table cellspacing="1px" cellpadding="1px" class="tableList">
				<thead style="background-color: #D8EEFF;height: 15px">
					<tr>
						<td style="width: 120px;">状态着色</td>
						<td style="width: 120px;">预警规则</td>
						<td style="width: 120px;">笔数</td>
						<td style="width: 130px;">操作</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width: 120px;"><img src="../image/tabPane/5.png" width="15" height="15"></td>
						<td style="width: 120px;">合同额缴清</td>
						<td style="width: 120px;"><span id="finishCount"></span></td>
						<td style="width: 130px; color: blue">
							<a onclick="queryDetail('00')" style="cursor: pointer;">查看明细</a>
						</td>
					</tr>
				    <tr>
						<td style="width: 120px;"><img src="../image/tabPane/6.png" width="15" height="15"></td>
						<td style="width: 120px;">合同额未缴清</td>
						<td style="width: 120px;"><span id="unfinishCount"></span></td>
						<td style="width: 130px;color: blue">
						<a onclick="queryDetail('01')" style="cursor: pointer;">查看明细</a>
						</td>
					</tr>
					<tr>
						<td style="width: 120px;">合计</td>
						<td style="width: 120px;">
						
						</td>
						<td style="width: 120px;">
							<span id="total"></span>
						</td>
						<td style="width: 130px;">
						
						</td>
					</tr>
				</tbody>
			</table>
	</div>
</div>
<div id="wdzTable" style="display: none">
	<div class="grid1">
			<table cellspacing="1px" cellpadding="1px" class="tableList">
				<thead style="background-color: #D8EEFF;height: 15px">
					<tr>
						<td style="width: 120px;">状态着色</td>
						<td style="width: 120px;">预警规则</td>
						<td style="width: 120px;">笔数</td>
						<td style="width: 130px;">操作</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width: 120px;"><img src="../image/tabPane/2.png" width="15" height="15"></td>
						<td style="width: 120px;">逾期未缴</td>
						<td style="width: 120px;"><span id="calt"></span></td>
						<td style="width: 130px; color: blue">
							<a onclick="queryDetailwdz('ic-T')" style="cursor: pointer;">查看明细</a>
						</td>
					</tr>
				    <tr>
						<td style="width: 120px;"><img src="../image/tabPane/3.png" width="15" height="15"></td>
						<td style="width: 120px;">临近缴款</td>
						<td style="width: 120px;"><span id="ret"></span></td>
						<td style="width: 130px;color: blue">
						<a onclick="queryDetailwdz('rm-T')" style="cursor: pointer;">查看明细</a>
						</td>
					</tr>
					<tr>
						<td style="width: 120px;"><img src="../image/tabPane/4.png" width="15" height="15"></td>
						<td style="width: 120px;">缴款未到账</td>
						<td style="width: 120px;"><span id="calc"></span></td>
						<td style="width: 130px;color: blue">
						<a onclick="queryDetailwdz('ic-C')" style="cursor: pointer;">查看明细</a>
						</td>
					</tr>
					<tr>
						<td style="width: 120px;"><img src="../image/tabPane/1.png" width="15" height="15"></td>
						<td style="width: 120px;">未到期</td>
						<td style="width: 120px;"><span id="ref"></span></td>
						<td style="width: 130px;color: blue">
						<a onclick="queryDetailwdz('rm-F')" style="cursor: pointer;">查看明细</a>
						</td>
					</tr>
					<tr>
						<td style="width: 120px;">合计</td>
						<td style="width: 120px;">
						
						</td>
						<td style="width: 120px;">
							<span id="total"></span>
						</td>
						<td style="width: 130px;">
						
						</td>
					</tr>
				</tbody>
			</table>
	</div>
</div>
<script type="text/javascript" src="<%=path%>/js/panel/jquery/jquery-1.8.3.js"></script>
<script type="text/javascript" src="<%=path%>/js/panel/jquery-ui/js/jquery-ui-1.9.2.custom.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/BoxSelect.js"></script>
<script type="text/javascript" src="<%=path%>/js/lib.ui.core.js"></script>
<script type="text/javascript" src="<%=path%>/js/widget/lib.ui.button.js"></script>
<script type="text/javascript" 	src="<%=path%>/js/widget/lib.ui.toolbar.js"></script>
<script type="text/javascript" src="<%=path%>/js/widget/lib.ui.window.js"></script>
<script type="text/javascript" src="<%=path%>/js/widget/lib.ui.drag.js"></script>
<script type="text/javascript" src="<%=path%>/js/panel/highcharts/highcharts.src.js"></script>
<script type="text/javascript" src="<%=path%>/js/panel/highcharts/highcharts-more.src.js"></script>
<script type="text/javascript" src="<%=path%>/js/panel/jquery-jbox/2.3/jquery.jBox-2.3.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/panel/bootstrap/2.3.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/deskTop/paymentReminder.js"></script>
<script type="text/javascript" src="<%=path%>/js/datePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		$(function() {
			var timeStart=$("#timeStart").val();
			var timeEnd=$("#timeEnd").val();
			var code=$("#ydzTable").html();
			$("#middleTable").html(code);
			window.mainFrame.location = '<%=path%>/paymentReminder/YDXpayList.do?timeStart='+timeStart+'&timeEnd='+timeEnd;
			loadPie('<%=path%>','',timeStart,timeEnd);
			countCount();
		})
		
		function startAnay(){
			var curmainId=$("#curMainId").val();
			var timeStart=$("#timeStart").val();
			var timeEnd=$("#timeEnd").val();
			var statu=$("#style").val();
			if("00"==statu){
				 window.mainFrame.location = '<%=path%>/paymentReminder/YDXpayList.do?curMain='+curmainId+'&timeStart='+timeStart+'&timeEnd='+timeEnd;
				 var code=$("#ydzTable").html();
				 $("#middleTable").html(code);
				 var datapie=$("#datapie").val();
				 loadPie('<%=path%>',curmainId,timeStart,timeEnd);
				 countCount();
			}else{
				window.mainFrame.location = '<%=path%>/paymentReminder/WDZPaylist.do?curMain='+curmainId+'&timeStart='+timeStart+'&timeEnd='+timeEnd;
				 var code=$("#wdzTable").html();
				 $("#middleTable").html(code);
				 loadPiewdz('<%=path%>',curmainId);
				 countCountwdz();
			}
		}
		function queryDetail(state){
			var timeStart=$("#timeStart").val();
			var timeEnd=$("#timeEnd").val();
			var curmainId=$("#curMainId").val();
			//传个标志位
			window.mainFrame.location = '<%=path%>/paymentReminder/YDXpayList.do?specialMatters='+state+'&curMain='+curmainId+'&timeStart='+timeStart+'&timeEnd='+timeEnd;
		}
		//查询出已到账各个状态的数量
		function countCount(){
			var curmainId=$("#curMainId").val();
			var timeStart=$("#timeStart").val();
			var timeEnd=$("#timeEnd").val();
			$.ajax({
				type : 'POST',
				url : '<%=path%>/paymentReminder/countCount.do',
				data : 'curMain=' +curmainId+'&timeStart='+timeStart+'&timeEnd='+timeEnd,
				dataType : 'json',
				success : function(data) {
					$("#total").text(data["total"]);
					$("#finishCount").text(data["finish"]);
					$("#unfinishCount").text(data["unfinish"]);
				}
			});
			
		}
		//查询出未到账各个状态的数量
		function countCountwdz(){
			var curmainId=$("#curMainId").val();
			var timeStart=$("#timeStart").val();
			var timeEnd=$("#timeEnd").val();
			$.ajax({
				type : 'POST',
				url : '<%=path%>/paymentReminder/countCountwdz.do',
				data :'curMain=' +curmainId+'&timeStart='+timeStart+'&timeEnd='+timeEnd,
				dataType : 'json',
				success : function(data) {
					$("#calc").text(data["calc"]);
					$("#calt").text(data["calt"]);
					$("#ref").text(data["ref"]);
					$("#ret").text(data["ret"]);
					$("#total").text(data["total"]);
				}
			});
			
		}
		//未到账查看详细
		function queryDetailwdz(state){
			var curmainId=$("#curMainId").val();
			var timeStart=$("#timeStart").val();
			var timeEnd=$("#timeEnd").val();
			window.mainFrame.location = '<%=path%>/paymentReminder/WDZPaylist.do?state='+state+'&curMain='+curmainId+'&timeStart='+timeStart+'&timeEnd='+timeEnd;
		}
	</script>
</body>
</html>