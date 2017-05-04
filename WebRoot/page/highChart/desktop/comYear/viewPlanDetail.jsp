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
	</head>
	<body>
		<div class="tool"></div>
		<form id="listForm" action="<%=path%>/deskTop/viewlandCount.do" method="post">
		<div id="detailedList" style="width: 100%;height: 30px;text-align: center;font-size: 20px">${fullYear}应收尽收进度分析详细列表</div>
			<div class="grid">
				<div class="table-head">
					<table cellspacing="0" cellpadding="0">
						<thead>
							<tr>
								<td style="width: 80px;height:30px;text-align: center;">熟化主体名称</td>
								<c:forEach items="${curmains}" var="curmain">
									<td style="width: 60px;height:30px;text-align: center;">
										<span style="width: 70px" title="${curmain }">
											${curmain }
										</span>
									</td>
								</c:forEach>
							</tr>
						</thead>
					</table>
				</div>
				<div class="table-body">
					<table cellspacing="0" cellpadding="0">
						<tbody>
						<tr>
							<td style="width: 80px;height:30px;text-align: center;">应收（亿元）</td>
							<c:forEach var="total" items="${totalMoney}" varStatus="status">
								<td style="width: 60px;text-align: right;height:30px">
									<span style="width: 70px">
										<fmt:formatNumber pattern="#,##0.000" value="${total/100000000}" />
									</span>
								</td>
							</c:forEach>
						</tr>
						<tr>
							<td style="width: 80px;height:30px;text-align: center;">实收（亿元）</td>
							<c:forEach var="finish" items="${finishMoney}" varStatus="status">
								<td style="width: 60px;text-align: right;height:30px">
									<span style="width: 70px">
										<fmt:formatNumber pattern="#,##0.000" value="${finish/100000000}" />
									</span>
								</td>
							</c:forEach>
						</tr>
						<tr>
							<td style="width: 80px;height:30px;text-align: center;">欠缴（亿元）</td>
							<c:forEach var="unfinishm" items="${unfinish}" varStatus="status">
								<td style="width: 60px;text-align: right;height:30px">
									<span style="width: 70px">
										<fmt:formatNumber pattern="#,##0.000" value="${unfinishm/100000000}" />
									</span>
								</td>
							</c:forEach>
						</tr>
						<tr>
							<td style="width: 80px;height:30px;text-align: center;">完成率</td>
							<c:forEach var="ratio" items="${ratios}" varStatus="status">
								<td style="width: 60px;text-align: right;height:30px">
									<span style="width: 70px">
										<fmt:formatNumber pattern="#,##0.00%" value="${ratio/100}" />
									</span>
								</td>
							</c:forEach>
						</tr>
						</tbody>
					</table>
				</div>
			</div>
		</form>
		<script type="text/javascript" src="<%=path%>/js/jquery-1.5.1.js"></script>
		<script type="text/javascript" src="<%=path%>/js/BoxSelect.js"></script>
		<script type="text/javascript" src="<%=path%>/js/lib.ui.core.js"></script>
		<script type="text/javascript" src="<%=path%>/js/widget/lib.ui.button.js"></script>
		<script type="text/javascript" src="<%=path%>/js/widget/lib.ui.toolbar.js"></script>
		<script type="text/javascript" src="<%=path%>/js/widget/lib.ui.window.js"></script>
		<script type="text/javascript" src="<%=path%>/js/widget/lib.ui.drag.js"></script>
		<script type="text/javascript">
		$(document).ready(function(){
			 setElementHeight('.grid');
			 setElementHeight('.table-body',['.table-head'],'.grid');
			
		});
		
		</script>
	</body>
</html>