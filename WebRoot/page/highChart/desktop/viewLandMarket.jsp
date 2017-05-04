<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="page" uri="/WEB-INF/tld/pagetag.tld" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
%>
<html>
<head>
<title>年度综合收支看板</title>
<meta name="decorator" content="default" />
<link type="text/css" rel="stylesheet" href="<%=path%>/css/deskTop/landMarket.css"/>
<link type="text/css" rel="stylesheet" href="<%=path%>/css/lib.ui.core.css" />
<link type="text/css" rel="stylesheet" href="<%=path%>/css/widget/lib.ui.button.css" />
<link type="text/css" rel="stylesheet" href="<%=path%>/css/widget/lib.ui.toolbar.css" />
<link type="text/css" rel="stylesheet" href="<%=path%>/css/widget/lib.ui.window.css" />
<link type="text/css" rel="stylesheet"href="<%=path%>/css/lib.ui.form.css" />
<link type="text/css" rel="stylesheet" href="<%=path%>/css/widget/lib.ui.grid.css" />
<link type="text/css" rel="stylesheet" href="<%=path%>/css/search.css" />
<style type="text/css">
table{ border-collapse:collapse; }
td{ border:1px solid #70C1FF;}
@-moz-document url-prefix(){
	.right-buttom{
		margin-top:3px;
	}
}
.tableList{
	font-size: 9px;
	text-align: center;
	height: 90%;
}
.left-top{
	border: 1px solid lightgray;
}
.pieForm{
	display: block;;width:100%; height:110px;
}
.left_div{
	height:100%;
}
</style>
<!--[if IE 8]>
<style type="text/css">
 /* 针对IE8定义的样式 */
 .tableList{
	font-size: 9px;
	text-align: center;
	height: 30%;
	padding:0px;
	margin:0px;
}
#toptext{
	height:19px;
	margin-top:5px;
}
.left-top{
	height:20px;
	background-color: #d8eeff;
	background-size:20px;
	margin-top: 5px;
	padding:0px;
	maring-bottom:0px;
}
.tableList thead tr td{
	height:39px;
}
.tableList tbody tr td{
	height: 33px;
}

.pieForm{
	display: block;;width:100%; height:0px;
}
.left_bottom{
	height:5%;
}
.grid1{
	height:10%;
}
</style>
<![endif]-->
</head>
<body>
	<div class="left-div">
		<div class="left-top">
			<div id="toptext" style="text-align: center;font-size: 22px;">${year}供地情况一览表</div>
			<div class="grid1" style="margin-top: 15px;">
					<table class="tableList" cellspacing="1px" cellpadding="1px">
						<thead>
							<tr>
								<td style="width: 120px;">供地类型</td>
								<td style="width: 135px;">供地宗数（宗）</td>
								<td style="width: 120px;">供地面积（亩）</td>
								<td style="width: 130px;">合同金额（亿元）</td>
							</tr>
						</thead>
						<tbody>
							<c:set var="totalLandCount" value="0"></c:set>
							<c:set var="totalarea" value="0"></c:set>
							<c:set var="totalcontractMoney" value="0"></c:set>
							<c:forEach var="landMarket" items="${landMarkets}" varStatus="status">
							
								<c:set var="totalLandCount" value="${totalLandCount+landMarket.landCount}"></c:set>
								<c:set var="totalarea" value="${totalarea+landMarket.landArea/666.6666667}"></c:set>
								<c:set var="totalcontractMoney" value="${totalcontractMoney+landMarket.contractMoney}"></c:set>
								<tr>
									<td style="width: 119px;text-align: center;">
										<span style="width: 110px;">${landMarket.landUse}</span>
									</td>
									<td style="width: 121px;text-align: center">
										${landMarket.landCount}
									</td>
									<td style="width: 117px;text-align: right">
										<span style="width: 106px;" title="<fmt:formatNumber pattern="#,##0.000" value="${landMarket.landArea/666.6666667}" />">
											<fmt:formatNumber pattern="#,##0.00" value="${landMarket.landArea/666.6666667}" />
										</span>
									</td>
									<td style="width: 126px;text-align: right">
										<span style="width: 110px;" title="<fmt:formatNumber pattern="#,##0.00" value="${landMarket.contractMoney}" />">
											<fmt:formatNumber pattern="#,##0.00" value="${landMarket.contractMoney}" />
										</span>
									</td>
								</tr>
							</c:forEach>
							    <tr>
									<td style="width: 119px;text-align: center;">
										<span style="width: 110px;">合计</span>
									</td>
									<td style="width: 121px;text-align: center">
										${totalLandCount}
									</td>
									<td style="width: 117px;text-align: right">
										<span style="width: 106px;" title="<fmt:formatNumber pattern="#,##0.000" value="${totalarea}" />">
											<fmt:formatNumber pattern="#,##0.00" value="${totalarea}" />
										</span>
									</td>
									<td style="width: 126px;text-align: right">
										<span style="width: 110px;" title="<fmt:formatNumber pattern="#,##0.000" value="${totalcontractMoney}" />">
											<fmt:formatNumber pattern="#,##0.00" value="${totalcontractMoney}" />
										</span>
									</td>
								</tr>
						</tbody>
					</table>
			</div>
		</div>
		<div class="left-buttom">
			<div id="tab">
	          <div id="tab-div">
	          	  
		          	<div class="tod tclick" >供地宗数<input type="hidden" value="landCount"/></div>
		         
		          	<div class="tod ">供地面积 <input type="hidden" value="sellArea"/></div>
		          
		          
		          	<div class="tod ">合同金额<input type="hidden" value="contractMoney"/></div>
		          
	          </div>
	     </div>
		<div id="landCountForm" method="post" class="pieForm">
			<div id="landCountContainer"></div>
		</div>
		<div id="sellAreaForm" class="pieForm">
			<div id="sellAreaContainer"></div>
		</div>
		<div id="contractMoneyForm" class="pieForm">
			<div id="contractMoneyContainer"></div>
		</div>
		</div>
	</div>
	
	<div class="right-div">
		<div class="right-top">
			<div class="top-second" id="containe">
				<div id="topLeftContrainer" style="width: 100%;height: 100%"></div>
			</div>
			<div class="top-second" id="mPie">
				<div id="topRightContrainer" style="width: 100%;height: 100%"></div>
			</div>			
		</div>
		<div class="right-buttom" id="priceContainer">
			<div id="buttonRightContrainer" style="width: 100%;height: 100%"></div>
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
<script type="text/javascript" src="<%=path%>/js/deskTop/landMarket.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		loadLandCount('<%=path%>');
		$('#landCountForm').show();
		$('#tab div.tod').each(function(){
		  	$(this).bind("click",function(){
	       		 activeOne(this);//修改标题的样式
	       		 addTool($(this).find("input[type='hidden']").val(),'<%=path%>');
		  	});
	 	});
	});
	function activeOne(obj){
		$('#tab .tclick').removeClass('tclick');
		$(obj).addClass('tclick');
	}
	function addTool(value,path){
			//供地宗数
			if(value==='landCount'){
				$('#sellAreaForm').hide();
				$('#contractMoneyForm').hide();
				loadLandCount(path);
				$('#landCountForm').show();
			}	
			//出让面积
			if(value==='sellArea'){
				$('#landCountForm').hide();
				$('#contractMoneyForm').hide();
				loadSellArea(path);
				$('#sellAreaForm').show();
			}
			//合同金额
			if(value==='contractMoney'){
				$('#landCountForm').hide();
				$('#sellAreaForm').hide();
				loadContractMoney(path);
				$('#contractMoneyForm').show();
			}
	}
	</script>
</body>
</html>