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
<link type="text/css" rel="stylesheet" href="<%=path%>/css/search.css" />
<link type="text/css" rel="stylesheet"href="<%=path%>/css/deskTop/daozhang.css" />
<object  id="LODOP" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0> 
	<embed id="LODOP_EM" type="application/x-print-lodop" width=0 height=0></embed>
</object>
</head>
<body>
<script type="text/javascript" src="<%=path%>/js/jquery-1.5.1.js"></script>
<script type="text/javascript" src="<%=path%>/js/BoxSelect.js"></script>
<script type="text/javascript" src="<%=path%>/js/lib.ui.core.js"></script>
<script type="text/javascript" src="<%=path%>/js/widget/lib.ui.button.js"></script>
<script type="text/javascript" 	src="<%=path%>/js/widget/lib.ui.toolbar.js"></script>
<script type="text/javascript" src="<%=path%>/js/widget/lib.ui.window.js"></script>
<script type="text/javascript" src="<%=path%>/js/widget/lib.ui.drag.js"></script>
<script type="text/javascript" src="<%=path%>/js/LodopFuncs.js"></script>
<script type="text/javascript" src="<%=path%>/js/datePicker/WdatePicker.js"></script>
<script type="text/javascript">
			$(document).ready(function(){
				var tool = $('.tool').toolbar({
	    			id:'toolbar',
	    			items: [{	
								text: '查询',
								title: '查询合同信息',
								icon: {
									url: '<%=path%>/image/Button/op_owner.gif',
									position: ['0px','-40px']
								},
								handler: function(){
									 $('.search-div').slideToggle(100);
								}
							}
	    				]
	    			});	
				setElementHeight('.grid',['.tool','.page']);
				setElementHeight('.table-body',['.table-head','.table-head1'],'.grid');
				loadGrid();
				//合计宽度
				$('.table-head1').width($('.table-head').width());
				$('.grid.total').width($('.grid').width());
				$('.grid.total').height(50);
				$('.grid').find('.table-body').find('tr').hover(
					function(){
						$(this).addClass('tr-over');
					},
					function(){
						$(this).removeClass('tr-over');
					}
				);
				
			});
			//向父页面传送饼状图的值
</script>
	<div class="tool"></div>
	<form id="uncompleteForm" style="display: block;">
	<input  type="hidden" id="datapie" value="${datapie}"/>
		<div class="grid listGrid">
			<div class="table-head">
				<table cellspacing="0" cellpadding="0">
					<thead>
						<tr>
							<td class="num" style="width: 25px;">&nbsp;</td>
							<td style="width: 60px;">状态</td>
							<td style="width: 140px;">合同编号</td>
							<td style="width: 110px;">宗地编号</td>
							<td style="width: 170px;">宗地位置</td>
							<td style="width: 230px;">用地单位</td>
							<td style="width: 145px;">合同金额</td>
							<td style="width: 80px;">付款总期数</td>
							<td style="width: 120px;">签订日期</td>
							<td style="width: 145px;">已到账金额</td>
							<td style="width: 145px;">应缴利息</td>
							<td style="width: 145px;">已缴利息</td>
							<td style="width: 145px;">待缴利息</td>
							<td style="width: 145px;">应缴滞纳金</td>
							<td style="width: 145px;">已缴滞纳金</td>
							<td style="width: 145px;">待缴滞纳金</td>
						</tr>
					</thead>
				</table>
			</div>
			
			
		<div class="table-head1">
				<table  cellspacing="0" cellpadding="0">
						<tr align="center">
						<td class="num" style="width: 25px;"></td>
						<td style="width: 60px;"></td>
							<td width="653px;">
								本页合计
							</td>
							<td width="145px">
								<span id="bhtjehj"><fmt:formatNumber  value="${map['bhtjehj']}" pattern='#,##0.00#'/></span>
							</td>
							<td style="width: 201px;"></td>
							
							<td width="145px">
								<span id="bdzjehj"><fmt:formatNumber  value="${map['bdzjehj']}" pattern='#,##0.00#'/></span>
							</td>
							<td width="145px">
								<span id="byjlxhj"><fmt:formatNumber  value="${map['byjlxhj']}" pattern='#,##0.00#'/></span>
							</td>
							<td width="145px">
								<span id="byijlxhj"><fmt:formatNumber  value="${map['byijlxhj']}" pattern='#,##0.00#'/></span>
							</td>
							<td width="145px">
								<span id="bdjlxhj"><fmt:formatNumber  value="${map['bdjlxhj']}" pattern='#,##0.00#'/></span>
							</td>
							<td width="145px">
								<span id="byjznjhj"><fmt:formatNumber  value="${map['byjznjhj']}" pattern='#,##0.00#'/></span>
							</td>
							<td width="145px">
								<span id="byijznjhj"><fmt:formatNumber  value="${map['byijznjhj']}" pattern='#,##0.00#'/></span>
							</td>
							<td width="145px">
								<span id="bdjznjhj"><fmt:formatNumber  value="${map['bdjznjhj']}" pattern='#,##0.00#'/></span>
							</td>
						</tr>
						<tr align="center">
						<td class="num" style="width: 25px;"></td>
						<td style="width: 60px;"></td>
							<td width="653px;">
								总合计
							</td>
							<td width="120px;">
								<span id="zhtjehj"><fmt:formatNumber  value="${map['zhtjehj']}" pattern='#,##0.00#'/></span>
							</td>
							<td style="width: 201px;"></td>
							
							<td width="120px;">
								<span id="zdzjehj"><fmt:formatNumber  value="${map['zdzjehj']}" pattern='#,##0.00#'/></span>
							</td>
							<td width="110px;">
								<span id="zyjlxhj"><fmt:formatNumber  value="${map['zyjlxhj']}" pattern='#,##0.00#'/></span>
							</td>
							<td width="110px;">
								<span id="zyijlxhj"><fmt:formatNumber  value="${map['zyijlxhj']}" pattern='#,##0.00#'/></span>
							</td>
							<td width="110px;">
								<span id="zdjlxhj"><fmt:formatNumber  value="${map['zdjlxhj']}" pattern='#,##0.00#'/></span>
							</td>
							<td width="120px;">
								<span id="zyjznjhj"><fmt:formatNumber  value="${map['zyjznjhj']}" pattern='#,##0.00#'/></span>
							</td>
							<td width="120px;">
								<span id="zyijznjhj"><fmt:formatNumber  value="${map['zyijznjhj']}" pattern='#,##0.00#'/></span>
							</td>
							<td width="119px;">
								<span id="zdjznjhj"><fmt:formatNumber  value="${map['zdjznjhj']}" pattern='#,##0.00#'/></span>
							</td>
						</tr>
					
				</table>
			
		</div>
			<div class="table-body">
				<table cellspacing="0" cellpadding="0">
					<tbody>
					<input type="hidden" id="curMain" name="curMain" value="${lastIns.contract.curMain }"/>
						<c:forEach items="${map['list']}" var="lastIns" varStatus="status">
							<tr ondblclick="viewContract('${lastIns.contract.id}')">
								<td class="num">${status.index+1}</td>
								<c:if test="${lastIns.contract.contractMoney ==lastIns.compMoney}">
									<td style="width: 60px; text-align: center;"><img src="../image/tabPane/5.png" width="15" height="15"></td>
								</c:if>
								<c:if test="${lastIns.contract.contractMoney != lastIns.compMoney}">
									<td style="width: 60px; text-align: center;"><img src="../image/tabPane/6.png" width="15" height="15"></td>
								</c:if>
								<td><span style="width: 130px;">${lastIns.contract.contractNum}</span></td>
								<td><span style="width: 100px;">${lastIns.contract.parcelNum}</span></td>
								<td><span style="width: 160px;">${lastIns.contract.landLocation}</span></td>
								<td><span style="width: 220px;">${lastIns.landUnitInfo.unitsName}</span></td>
								<td align="right"><span style="width: 135px;"><fmt:formatNumber  value="${lastIns.contract.contractMoney}" pattern='#,##0.00#'/></span></td>
								<td><span style="width: 70px;">${lastIns.contract.payments}</span></td>
								<td><span style="width: 110px;text-align: center;">${lastIns.contract.dateSigning}</span></td>
								<td align="right"><span style="width: 135px;"><fmt:formatNumber  value="${lastIns.compMoney}" pattern='#,##0.00#'/></span></td>
								<td align="right"><span style="width: 135px;"><fmt:formatNumber  value="${lastIns.insMoney}" pattern='#,##0.00#'/></span></td>
								<td align="right"><span style="width: 135px;"><fmt:formatNumber  value="${lastIns.compInsMoney}" pattern='#,##0.00#'/></span></td>
								<td align="right"><span style="width: 135px;"><fmt:formatNumber  value="${lastIns.notCompInsMoney}" pattern='#,##0.00#'/></span></td>
								<td align="right"><span style="width: 135px;"><fmt:formatNumber  value="${lastIns.lastMoney}" pattern='#,##0.00#'/></span></td>
								<td align="right"><span style="width: 135px;"><fmt:formatNumber  value="${lastIns.compLastMoney}" pattern='#,##0.00#'/></span></td>
								<td align="right"><span style="width: 135px;"><fmt:formatNumber  value="${lastIns.notCompLastMoney}" pattern='#,##0.00#'/></span></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>		
		
	</form>
	<page:page form="lastInsForm" page="${pageobj}"></page:page>
	<div class="search-div" id="search-div">
		<form id="lastInsForm" method="post" action="<%=path%>/paymentReminder/YDXpayList.do">
			<!-- 分页的隐藏属性 -->
			<input type="hidden" name ="nowPage" id="nowPage" value="${pageobj.nowPage }" />
			<input type="hidden" name ="pageSize"  id="pageSize" value="${pageobj.pageSize }" />
			<input type="hidden" id="curMain" name="curMain" value="${queryobj.curMain }"/>
			<input type="hidden" id="specialMatters" name="specialMatters" value="${queryobj.specialMatters }"/>
				<div class="search-condition">
					<table class="search-table" cellspacing="0" cellpadding="0">
					<tr>
							<td class="c-left">合同编号：</td>
							<td>
							<input type="text" id="contractNum" name="contractNum" value="${queryobj.contractNum }"/>
							</td>
							<td class="c-left">宗地编号：</td>
							<td>
							<input type="text" id="parcelNum" name="parcelNum" value="${queryobj.parcelNum }"/>
							</td>
							<td class="c-left">用地单位：</td>
							<td>
								<input type="text" id="landUnitInfo" name="landUnitInfo.unitsName"  value="${queryobj.landUnitInfo.unitsName}"/>
							</td>
						</tr>
						<tr>
							<td class="c-left">付款期数：</td>
							<td>
								<input type="text" id="payments" name="payments" value="${queryobj.payments}"/>
							</td>
							<td class="c-left">合同金额区间：</td>
							<td>
							<input type="text" name="contractMoneystart" class="text"  value="${queryobj.contractMoneystart}"/>
							~<input type="text" name="contractMoneyend" class="text"  value="${queryobj.contractMoneyend}"/>
							</td>
						</tr>
						<tr>
							<td class="c-left">签订日期：</td>
							<td>
							<input type="text" id="dateStart" name="dateStart" class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',skin:'whyGreen',maxDate:'%y-%M-%d'})"  value="${queryobj.dateStart}"/>
							~<input type="text" id="dateEnd" name="dateEnd" class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',skin:'whyGreen',maxDate:'%y-%M-%d'})"  value="${queryobj.dateEnd}"/>
							</td>
						</tr>
					</table>
				</div>
				<div class="search-commit">
					<input type="submit" class="search-button" id="search" value="查询" />
				</div>
			</form>
		</div>
</body>
</html>