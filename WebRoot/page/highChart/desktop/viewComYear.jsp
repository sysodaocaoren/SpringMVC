<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="page" uri="/WEB-INF/tld/pagetag.tld" %>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet" href="<%=path%>/css/common/bootstarp/bootstrap.min.css"/>
<link type="text/css" rel="stylesheet" href="<%=path%>/css/deskTop/comYear.css"/>
<link type="text/css" rel="stylesheet" href="<%=path%>/js/panel/jquery-jbox/2.3/Skins/Bootstrap/jbox.min.css"/>
<link type="text/css" rel="stylesheet" href="<%=path%>/css/lib.ui.core.css"/>
<link type="text/css" rel="stylesheet" href="<%=path%>/css/widget/lib.ui.button.css"/>
<link type="text/css" rel="stylesheet" href="<%=path%>/css/widget/lib.ui.toolbar.css"/>			
<link type="text/css" rel="stylesheet" href="<%=path%>/css/widget/lib.ui.window.css"/>

<style type="text/css">

</style>

</head>
<body>
	<div class="container-div">
		<div class="item-top-div">
			<div class="param-div" id="yearIncomeDiv" style="height:58px;text-align:center;font-size:20px;  line-height:58px; border:1px solid green; background-color:#D8EEFF;">
				年度综合收支比较
			</div>
			
			<div class="param-div" style="height:80%;">
				<table id="demoTable" class="fenxi_table" style="height:90%;" >
					<thead style="width: 100%">
						<tr >
							<th>序号</th>
							<th>年度</th>
							<th>宗数</th>
							<th>合同金额 <br>(亿元)</th>
							<th>出让总收入<br>(亿元)</th>
							<th>已返成本<br>(亿元)</th>
							<th>分配资金<br>(亿元)</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="comYearTable" items="${comYearTables}" varStatus="status">
							<tr>
								<th>${status.index+1}</th>
								<td style="text-align: center">${comYearTable.year}</td>
								<td style="text-align: center;color:blue;"><a onclick="viewlandCount('${comYearTable.year}')">${comYearTable.landCount}</a></td>
								<td class="text-right" style="text-align: right;color:blue;"><a  onclick="viewContractMoney('${comYearTable.year}')"><fmt:formatNumber pattern="#,##0.00"
										value="${comYearTable.totalContractMoney}" /></a></td>
								<td class="text-right" style="text-align: right;color:blue;"><a onclick="viewIncomeMoney('${comYearTable.year}')"><fmt:formatNumber pattern="#,##0.00"
										value="${comYearTable.totalIncomeMoney}" /></a></td>
								<td class="text-right" style="text-align: right;color:blue;"><a onclick="viewBackMoney('${comYearTable.year}')"><fmt:formatNumber pattern="#,##0.00"
										value="${comYearTable.backMoney}" /></a></td>
								<td class="text-right" style="text-align: right;color:blue;"><a onclick="viewAllocationMoney('${comYearTable.year}')"><fmt:formatNumber pattern="#,##0.00"
										value="${comYearTable.guessMoney}" /></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="item-top-div" style="margin-left:8px;">
			<div id="container"></div>
		</div>
		<div class="item-top-div" style="margin-left:8px;">
			<div id="containerIncome"></div>
			<div id="seeinfo">
				<a id="incomeList">>>查看明细</a>
			</div>
		</div>
	</div>
	<div class="container-div">
		<div class="item-bottom-div" style="width:19%;">
			<div id="totalContainer"></div>
		</div>
		<div class="item-bottom-div" style="width:40%;">
			<div id="myCarousel" class="carousel slide" style="width: 100%;height: 100%;">
				<!-- Carousel items -->
				<div class="carousel-inner" style="width: 100%;height: 100%;">
					<div class="carousel-inner" style="width: 100%;height: 100%;">
					<div class="active item" id="containerPlanDiv1" style="width: 100%;height: 100%;">
						<div id="containerPlan1" style="width: 100%; height: 100%;padding-left: 50px;"></div>
					</div>
				</div>
				</div>
				<!-- Carousel nav -->
				<a class="carousel-control left" href="#myCarousel" data-slide="prev" data-interval="100000" onclick="prevOrNext('prev')">&lsaquo;</a>
				<a class="carousel-control right"href="#myCarousel" data-slide="next" data-interval="100000" onclick="prevOrNext('next')">&rsaquo;</a>
			</div>
			<div id="seeinfo">
				<a id="planList">>>查看明细</a>
			</div>
		</div>
		<div class="item-bottom-div" style="width: 40%;">
			<div id="searchLandKing"></div>
			<div id="seeinfo">
				<a id="searchList">>>查看明细</a><br><a id="change">>>转换口径</a>
			</div>
		</div>
	</div>
</body>
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
<script type="text/javascript" src="<%=path%>/js/deskTop/deskTop.js"></script>
<script type="text/javascript">
$(function() {
	var fullYear = new Date().getFullYear();
	currentNum=1;
			var base='<%=path%>';
			loadAnnualSummary(base);
			loadIncome(base);
			loadPlan(base);
			setTimeout(function(){$(".pageTwo").removeClass('active');},1000); 
			setTimeout(function(){$(".pageTwo1").removeClass('active');},1000); 
			setTimeout(function(){$(".pageTwo2").removeClass('active');},1000); 
			setTimeout(function(){$(".pageTwo3").removeClass('active');},1000); 
			//地王查询报表
			var count = 1;
			var condition = "contractmoney";
			loadSearchLandKing(base,condition);
			$("#change").bind("click", function() {
				if (count % 4 == 1) {
					condition = "sellarea";
				}
				if (count % 4 == 2) {
					condition = "contractmoney";
				}
				if (count % 4 == 3) {
					condition = "trafRatio";
				}
				if (count % 4 == 0) {
					condition = "unitprice";
				}
				count += 1;
				loadSearchLandKing(base,condition);
			});

			//收支分析列表
			$("#incomeList").bind("click",function() {
				viewInoutDetail=$('body').window({
					title:fullYear+'年度月度收支详细列表',
					content: '<iframe id="viewInoutDetail" frameborder="0" src="<%=path%>/deskTop/viewInoutDetail.do"></iframe>',
					width: "1050px",
					height: "152px",
					draggable: false,
					isModal: true,
					minimizable: false,
					confirmClose:false,
					maximizable: false
				});
			});

			//应收尽收进度分析列表
			$("#planList").bind("click", function() {
				viewPlanDetail=$('body').window({
					title:fullYear+'年度应收尽收进度分析列表',
					content: '<iframe id="viewPlanDetail" frameborder="0" src="<%=path%>/deskTop/viewPlanDetail.do"></iframe>',
					width: "1136px",
					height: "252px",
					draggable: false,
					isModal: true,
					minimizable: false,
					confirmClose:false,
					maximizable: false
				});
			});
			//楼王分析列表
			$("#searchList").bind("click",function() {
				viewlandKingDetail=$('body').window({
					title:fullYear+'年度地王详细列表',
					content: '<iframe id="viewlandKingDetail" frameborder="0" src="<%=path%>/deskTop/viewlandKingDetail.do?condition='+condition+'"></iframe>',
					width: "600px",
					height: "252px",
					draggable: false,
					isModal: true,
					minimizable: false,
					confirmClose:false,
					maximizable: false
				});
			});
		});
	/**
	 * 点击宗地数钻取
	 */
	function viewlandCount(year){
		var condition='viewlandCount';
		toaddSpecial=$('body').window({
			title:fullYear+'年度宗地数详情',
			content: '<iframe id="viewlandCount" frameborder="0" src="<%=path%>/deskTop/viewlandCount.do?year='+year+'&condition='+condition+'"></iframe>',
			width: "1000px",
			height: "382px",
			draggable: false,
			isModal: true,
			minimizable: false,
			confirmClose:false,
			maximizable: false
		});
	}
	/**
	 * 点击收入钻取
	 */
	function viewIncomeMoney(year){
		var condition='viewIncomeMoney';
		toaddSpecial=$('body').window({
			title:'总收入详情',
			content: '<iframe id="viewIncomeMoney" frameborder="0" src="<%=path%>/deskTop/viewlandCount.do?year='+year+'&condition='+condition+'"></iframe>',
			width: "1000px",
			height: "382px",
			draggable: false,
			isModal: true,
			minimizable: false,
			confirmClose:false,
			maximizable: false
		});
	}
	/**
	 * 点击合同价款钻取
	 */
	function viewContractMoney(year){
		var condition='viewContractMoney';
		toaddSpecial=$('body').window({
			title:'合同价款详情',
			content: '<iframe id="viewContractMoney" frameborder="0" src="<%=path%>/deskTop/viewlandCount.do?year='+year+'&condition='+condition+'"></iframe>',
			width: "1000px",
			height: "382px",
			draggable: false,
			isModal: true,
			minimizable: false,
			confirmClose:false,
			maximizable: false
		});
	}
	/**
	 * 点击返回成本钻取
	 */
	function viewBackMoney(year){
		var condition='viewBackMoney';
		toaddSpecial=$('body').window({
			title:'返回成本钻取',
			content: '<iframe id="viewBackMoney" frameborder="0" src="<%=path%>/deskTop/viewlandCount.do?year='+year+'&condition='+condition+'"></iframe>',
			width: "1000px",
			height: "382px",
			draggable: false,
			isModal: true,
			minimizable: false,
			confirmClose:false,
			maximizable: false
		});
	}
	/**
	 * 点击分配金额钻取
	 */
	function viewAllocationMoney(year){
		var condition='viewAllocationMoney';
		toaddSpecial=$('body').window({
			title:'分配金额详情',
			content: '<iframe id="viewAllocationMoney" frameborder="0" src="<%=path%>/deskTop/viewlandCount.do?year='+year+'&condition='+condition+'"></iframe>',
			width: "1000px",
			height: "382px",
			draggable: false,
			isModal: true,
			minimizable: false,
			confirmClose:false,
			maximizable: false
		});
	}
	//前进或后退显示仪表盘信息
	function prevOrNext(operate){
		var base='<%=path%>';
		if(operate=="prev"){		//向前
			if(currentNum>1){       //当前页码大于1时后退操作
				loadPlan(base,--currentNum);
			}else{
				if(currentNum==1){  //重新赋值
					currentNum=8;
				}
				loadPlan(base,--currentNum);
			}
		}
		if(operate=="next"){		//向后
			if(currentNum<7){		//当前页码小于7时，前进操作
				loadPlan(base,++currentNum);
			}else{
				if(currentNum==7){   //重新赋值
					currentNum=0;
				}
				loadPlan(base,++currentNum);
			}
		}
	}
</script>
</html>