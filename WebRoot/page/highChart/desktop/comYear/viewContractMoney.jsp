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
			<div class="grid">
				<div class="table-head">
					<table cellspacing="0" cellpadding="0">
						<thead>
							<tr>
								<td style="width: 30px;"></td>
								<td style="width: 180px;">合同编号</td>
								<td style="width: 120px;">签订时间</td>
								<td style="width: 260px;">用地单位</td>
								<td style="width: 240px;">熟化主体</td>
								<td style="width: 160px;">合同金额</td>
							</tr>
						</thead>
					</table>
				</div>
				<div class="table-body">
					<table cellspacing="0" cellpadding="0">
						<tbody>
							<c:forEach var="comzqs" items="${comYearZQs}" varStatus="status">
								<tr>
									<td style="width: 30px;text-align:center;">${status.index+1}</td>
									<td style="width: 180px;text-align:center;"><span style="width: 170px;" title="${comzqs.contractNum}" >${comzqs.contractNum}</span></td>
									<td style="width: 120px;">
										<span style="width: 110px;text-align:center;" title="${comzqs.datesining}" >
											<fmt:formatDate value="${comzqs.datesining}" pattern="yyyy-MM-dd"/>
										</span>
									</td>
									<td style="width: 260px;">
										<span style="width: 250px;text-align:center;" title="${comzqs.landUserName}" >
											${comzqs.landUserName}
										</span>
									</td>
									<td style="width: 240px;">
										<span style="width: 230px;text-align:center;" title="${comzqs.cormainName}" >
											${comzqs.cormainName}
										</span>
									</td>
									<td style="width: 160px;">
										<span style="width: 150px;text-align:right;" title="${comzqs.contractMoney}">
											<fmt:formatNumber value="${comzqs.contractMoney}" pattern='￥#,##0.00#'/>
										</span>
									</td>
								</tr>
							</c:forEach>
							<div class="table-head">
								<table cellspacing="0" cellpadding="0">
									<thead>
										<tr>
											<td style="width: 30px;"></td>
											<td style="width: 180px;text-align:center;">合计</td>
											<td style="width: 120px;"></td>
											<td style="width: 260px;"></td>
											<td style="width: 240px;"></td>
											<td style="width: 160px;text-align:right;">
												<fmt:formatNumber value="${allContractMoney}" pattern='#,##0.00# 亿元'/>
											</td>
										</tr>
									</thead>
								</table>
							</div>
						</tbody>
					</table>
				</div>
			</div>
		</form>
		<page:page form="lastInsForm" page="${pageobj}"></page:page>
		<div class="search-div"></div>
		<div id="queryDiv" style="display: none">
			<form id="lastInsForm" method="post" action="<%=path%>/deskTop/viewlandCount.do" method="post">
				<!-- 分页的隐藏属性 -->
				<input type="hidden" name ="nowPage" id="nowPage" value="${pageobj.nowPage }" />
				<input type="hidden" name ="pageSize"  id="pageSize" value="${pageobj.pageSize }" />
				<input type="hidden" name ="year"  id="year" value="${queryObject.year}" />
				<input type="hidden" name ="condition"  id="year" value="${queryObject.condition}" />
				<div class="search-condition">
					<table class="search-table" cellspacing="0" cellpadding="0">
						<tr>
							<td class="c-left">合同编号：</td>
							<td>
								<input type="text" id="unitsName" name="contractNum" value="${queryObject.contractNum}"/>
							</td>
						</tr>
					</table>
				</div>
				<div class="search-commit">
					<input type="submit" class="search-button" id="search" value="查询" />
					<input type="button" class="search-button" id="search" value="返回" onclick="quitSearch()" />
					<input type="button" class="search-button" id="clear" value="清空"  onclick="clearSearch()"/>
				</div>
			</form>
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
			tool = $('.tool').toolbar({
				id:'toolbar',
				items: [{
					text: '查询',
					title: '查询批次信息',
					useable: <c:out value="${operateMap['select']}" default="true"/>,
					icon: {
						url: '<%=path%>/image/Button/op_owner.gif',
						position: ['0px','-40px']
					},
					handler: function(){
						var queryCode=$("#queryDiv").html();
						$('.search-div').html(queryCode);
						$('.search-div').slideToggle(100);
					}
				}]
			});
			 setElementHeight('.grid',['.tool','.page']);
			 setElementHeight('.table-body',['.table-head'],'.grid');
		});
		/* 查询点击返回，查询区域消失 */
		function quitSearch(){
			$('.search-div input[type="text"],select').val('');
			$('.search-div').html("");
			$('.search-div').hide();
		}
		function clearSearch(){
			$('.search-div input[type="text"],select').val('');
		}
		</script>
	</body>
</html>