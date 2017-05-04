<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="page" uri="/WEB-INF/tld/pagetag.tld" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>list Info</title>
		<link type="text/css" rel="stylesheet" href="<%=path%>/css/lib.ui.core.css" />
		<link type="text/css" rel="stylesheet" href="<%=path%>/css/widget/lib.ui.button.css" />
		<link type="text/css" rel="stylesheet" href="<%=path%>/css/widget/lib.ui.toolbar.css" />
		<link type="text/css" rel="stylesheet" href="<%=path%>/css/widget/lib.ui.window.css" />
		<link type="text/css" rel="stylesheet"href="<%=path%>/css/lib.ui.form.css" />
		<link type="text/css" rel="stylesheet" href="<%=path%>/css/widget/lib.ui.grid.css" />
		<link type="text/css" rel="stylesheet" href="<%=path%>/css/search.css" />
		<style type="text/css">
		</style>
	</head>
	<body>
		<form id="listForm" action="<%=path%>/deskTop/viewlandCount.do" method="post">
			<input type="hidden" id="condition" value="${comYearTable.condition}"/>
			<div class="grid" id="grids">
				
			</div>
		</form>
		<div id="sellarea" style="display: none">
			<div class="table-head">
				<table cellspacing="0" cellpadding="0" >
					<thead>
						<tr>
							<td style="width: 55px;height:30px">排名</td>
							<td style="width: 260px;height:30px">单位</td>
							<td style="width: 150px;height: 30px;">地块名称</td>
							<td style="width: 130px;height:30px">面积(平方米)</td>
						</tr>
					</thead>
				</table>
			</div>
			<div class="table-body">
				<table cellspacing="0" cellpadding="0">
					<tbody>
						<c:forEach var="contract" items="${contracts}" varStatus="status">
							<tr>
								<td style="width: 55px;text-align:center;height:30px">${status.index+1}</td>
								<td style="width: 250px;text-align:center;height:30px"><span style="width: 250px;" title="${contract.landLocation}" >${contract.landLocation}</span></td>
								<td style="width: 150px;text-align:center;height:30px">${contract.inforName}</td>
								<td style="width: 130px;height:30px">
									<span style="width: 130px;text-align:center;" title="${contract.sellArea}" >
										${contract.sellArea}
									</span>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div id="contractmoney" style="display: none">
			<div class="table-head">
				<table cellspacing="0" cellpadding="0">
					<thead>
						<tr>
							<td style="width: 55px;height:30px">排名</td>
							<td style="width: 260px;height:30px">单位</td>
							<td style="width: 150px;height: 30px;">地块名称</td>
							<td style="width: 130px;height:30px">合同金额(亿元)</td>
						</tr>
					</thead>
				</table>
			</div>
			<div class="table-body">
				<table cellspacing="0" cellpadding="0">
					<tbody>
						<c:forEach var="contract" items="${contracts}" varStatus="status">
							<tr>
								<td style="width: 55px;text-align:center;height:30px">${status.index+1}</td>
								<td style="width: 250px;text-align:center;height:30px"><span style="width: 250px;" title="${contract.landLocation}" >${contract.landLocation}</span></td>
								<td style="width: 150px;text-align:center;height:30px">${contract.inforName}</td>
								<td style="width: 130px;">
									<span style="width: 130px;text-align:center;height:30px" title="<fmt:formatNumber pattern="#,##0.00" value="${contract.contractMoney}" />" >
										<fmt:formatNumber pattern="#,##0.000" value="${contract.contractMoney}" />
									</span>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div id="unitprice" style="display: none">
			<div class="table-head">
				<table cellspacing="0" cellpadding="0">
					<thead>
						<tr>
							<td style="width: 55px;height:30px">排名</td>
							<td style="width: 260px;height:30px">单位</td>
							<td style="width: 150px;height: 30px;">地块名称</td>
							<td style="width: 130px;height:30px">单位地价(元)</td>
						</tr>
					</thead>
				</table>
			</div>
				<div class="table-body">
					<table cellspacing="0" cellpadding="0">
						<tbody>
							<c:forEach var="contract" items="${contracts}" varStatus="status">
								<tr>
									<td style="width: 55px;text-align:center;height:30px">${status.index+1}</td>
									<td style="width: 250px;text-align:center;height:30px"><span style="width: 250px;" title="${contract.landLocation}" >${contract.landLocation}</span></td>
									<td style="width: 150px;text-align:center;height:30px">${contract.inforName}</td>
									<td style="width: 130px;">
										<span style="width: 130px;text-align:center;height:30px" title="<fmt:formatNumber pattern="#,##0.000" value="${contract.unitPrice}" />" >
											<fmt:formatNumber pattern="#,##0.000" value="${contract.unitPrice}" />
										</span>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<div id="trafRatio" style="display: none">
			<div class="table-head">
				<table cellspacing="0" cellpadding="0">
					<thead>
						<tr>
							<td style="width: 55px;height:30px">排名</td>
							<td style="width: 260px;height:30px">单位</td>
							<td style="width: 150px;height: 30px;">地块名称</td>
							<td style="width: 130px;height:30px">溢价率(%)</td>
						</tr>
					</thead>
				</table>
			</div>
				<div class="table-body">
					<table cellspacing="0" cellpadding="0">
						<tbody>
							<c:forEach var="contract" items="${contracts}" varStatus="status">
								<tr>
									<td style="width: 55px;text-align:center;height:30px">${status.index+1}</td>
									<td style="width: 250px;text-align:center;height:30px"><span style="width: 250px;" title="${contract.landLocation}" >${contract.landLocation}</span></td>
									<td style="width: 150px;text-align:center;height:30px">${contract.inforName}</td>
									<td style="width: 130px;">
										<span style="width: 130px;text-align:center;height:30px" title="<fmt:formatNumber pattern="#,##0.00%" value="${contract.trafRatio}" />" >
											<fmt:formatNumber pattern="#,##0.00%" value="${contract.trafRatio}" />
										</span>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		<script type="text/javascript" src="<%=path%>/js/jquery-1.5.1.js"></script>
		<script type="text/javascript" src="<%=path%>/js/BoxSelect.js"></script>
		<script type="text/javascript" src="<%=path%>/js/lib.ui.core.js"></script>
		<script type="text/javascript" src="<%=path%>/js/widget/lib.ui.button.js"></script>
		<script type="text/javascript" src="<%=path%>/js/widget/lib.ui.toolbar.js"></script>
		<script type="text/javascript" src="<%=path%>/js/widget/lib.ui.window.js"></script>
		<script type="text/javascript" src="<%=path%>/js/widget/lib.ui.drag.js"></script>
		<script type="text/javascript">
		$(document).ready(function(){
			var condition=$("#condition").val();
			 var gridCode=$("#"+condition).html();
			 $("#grids").html(gridCode);
			 setElementHeight('.grid');
			 setElementHeight('.table-body',['.table-head'],'.grid');
			
		});
		</script>
	</body>
</html>