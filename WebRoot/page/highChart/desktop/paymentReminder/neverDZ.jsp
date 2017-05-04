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
		<link type="text/css" rel="stylesheet" href="<%=path%>/css/deskTop/weidaozhang.css" />
	</head>
<body>
	<div class="tool"></div>
	<form id="listForm">
		<div class="grid listGrid">
			<div class="table-head">
				<table cellspacing="0" cellpadding="0">
					<thead>
						<tr>
							<td class="num" style="width: 25px;">&nbsp;</td>
							<td style="width: 30px;"></td>
						<td style="width: 30px;"><input type="checkbox" id="chkAll" />
							</td>
							<td style="width: 140px;">合同编号</td>
							<!-- <td style="width: 110px;">宗地编号</td>
							<td style="width: 170px;">宗地位置</td> -->
							<td style="width: 170px;">用地单位</td>
							<td style="width: 140px;">合同金额</td>
							<td style="width: 80px;">付款总期数</td>
							<td style="width: 120px;">签订日期</td>
							<td style="width: 80px;">第几期</td>
							<td style="width: 140px;">分期缴款金额</td>
							<td style="width: 140px;">未缴金额</td>
							<td style="width: 120px;">应缴日期</td>
							<td style="width: 110px;">应缴利息</td>
							<td style="width: 140px;">应缴滞纳金</td>
						</tr>
						
						
					</thead>
				</table>
			
			</div>
				<div class="table-head1">
				<table cellspacing="0" cellpadding="0">
				
						<tr align="center">
							<td class="num" style="width: 25px;">&nbsp;</td>
							<td style="width: 30px;"></td>
							<td style="width: 30px;"><input type="checkbox" id="chkAll" />
							</td>
							<td width="311px;">
								本页合计
							</td>
							<td width="140px;">
								<span id="bhtjehj"></span>
							</td>
							<td width="282px;">
								
							</td>
							<td width="140px;">
								<span id="bfqjkjehj"></span>
							</td>
							<td width="140px;">
								<span id="bwjjehj"></span>
							</td>
							<td width="120px;">
								
							</td>
							<td width="110px;">
								<span id="byjlxhj"></span>
							</td>
							<td width="140px;">
								<span id="byjznjhj"></span>
							</td>
						</tr>
						<tr align="center">
							<td class="num" style="width: 25px;">&nbsp;</td>
							<td style="width: 30px;"></td>
							<td style="width: 30px;"><input type="checkbox" id="chkAll" />
							</td>
							<td width="311px;">
								总合计
							</td>
							<td width="140px;">
								<span id="zhtjehj"></span>
							</td>
							<td width="282px;">
								
							</td>
							<td width="120px;">
								<span id="zfqjkjehj"></span>
							</td>
							<td width="120px;">
								<span id="zwjjehj"></span>
							</td>
							<td width="120px;">
								
							</td>
							<td width="110px;">
								<span id="zyjlxhj"></span>
							</td>
							<td width="120px;">
								<span id="zyjznjhj"></span>
							</td>
				
						
						</tr>
				
				</table>
			</div>
			<div class="table-body">
			
				<table cellspacing="0" cellpadding="0">
					<tbody>
						
						<c:forEach items="${paymentRemList}" var="payment" varStatus="status">
							
							<tr class="hid"   ondblclick="viewContract('${payment.contract.id}')">
								<td class="num"  style="width: 25px;">${status.index+1}</td>
									
								<td style="width: 30px; text-align: center;">
								<c:choose>
										<c:when test="${ payment.isCalls=='T'}"><img src="../image/tabPane/2.png" width="15" height="15"></c:when>
										<c:when test="${ payment.isRemind=='T'}"><img src="../image/tabPane/3.png" width="15" height="15"></c:when>
										<c:when test="${ payment.isCalls=='C'}"><img src="../image/tabPane/4.png" width="15" height="15"></c:when>
										<c:otherwise>
										  	<img src="../image/tabPane/1.png" width="15" height="15">
										</c:otherwise>
									</c:choose>
								
								</td>
								<td style="width: 30px; text-align: center;">
								<input type="hidden"  value="<c:out value='${ payment.isCalls}'/>" name="isCalls"/>
								<input type="hidden"  value="<c:out value='${ payment.isRemind}'/>" name="isRemend"/>
								<input type="hidden" name="contractNum" value="${payment.contract.contractNum}"/>	
								<input type="hidden" name="unitsName" 	value="${payment.contract.landUnitInfo.unitsName}" />
								<input type="hidden" name="paid" value="<fmt:formatNumber value='${payment.willpaid}'   pattern='#,##0.00#'/>"/>	
									<input type="hidden" name="payNum" value="${payment.payNum}"/>	
									<input type="hidden" name="unpaid" value="<fmt:formatNumber value='${payment.unpaid}'   pattern='#,##0.00#'/>"/>	
									<input type="hidden" name="breachContract" value="<fmt:formatNumber value='${payment.breachContract}'   pattern='#,##0.00#'/>"/>
									<input type="hidden" name="payableDate" value="<fmt:formatDate value="${payment.payableDate}" type="date" dateStyle="medium"/>"/>		
								<input
									type="checkbox" name="idList"
									id="chk_<c:out value='${payment.contract.id}' />"
									value="<c:out value='${payment.contract.id}' />" />
								</td>
								<td style="width: 140px;">
									<span style="width: 130px;" ><c:out
											value="${payment.contract.contractNum}" />&nbsp;
									</span>
								</td>
								<%-- <td style="width: 110px;">
									<span style="width: 100px;" ><c:out
											value="${payment.contract.parcelNum}" />&nbsp;
									</span>
								</td>
								<td style="width: 170px;">
									<span style="width: 160px;" ><c:out
											value="${payment.contract.landLocation}" />&nbsp;
									</span>
								</td> --%>
								<td style="width: 170px;">
									
									<span style="width: 160px;" ><c:out
											value="${payment.contract.landUnitInfo.unitsName}" />&nbsp;
									</span>
								</td>
								<td style="width: 140px;" align="right">
									<span style="width: 130px;"  ><fmt:formatNumber  value="${payment.contract.contractMoney}"   pattern='#,##0.00#'/>&nbsp;
									</span>
									<span  style="display:none"  name="htje"><fmt:formatNumber  value="${payment.contract.contractMoney}"   pattern='0.00'/>&nbsp;
									</span>
								</td>
								<td style="width: 80px;">
									<span style="width: 70px;" >${payment.contract.payments}&nbsp;
									</span>
								</td>
								<td style="width: 120px;">
									<span style="width: 110px;"><c:out
											value="${payment.contract.dateSigning}" />&nbsp;
									</span>
								</td>
								<td style="width: 80px;">
								
									<span style="width: 70px;" ><c:out
											value="${payment.payNum}" />&nbsp;
									</span>
								</td>
								<td style="width: 140px;" align="right">
								
									<span style="width: 130px;" ><fmt:formatNumber value="${payment.willpaid}"  pattern='#,##0.00#'/>&nbsp;
									</span>
									<span style="display:none"  name="fqjkje"><fmt:formatNumber value="${payment.willpaid}"  pattern='0.00'/>&nbsp;
									</span>
								</td>
								<td style="width: 140px;" align="right">
									<span style="width: 130px;" >
										<fmt:formatNumber value="${payment.unpaid}"   pattern='#,##0.00#'/>&nbsp;
									</span>
									<span style="display:none"  name="wjje"><fmt:formatNumber value="${payment.unpaid}"  pattern='0.00'/>&nbsp;
									</span>
								</td>
								<td style="width: 120px;">
									<fmt:formatDate value="${payment.payableDate}" type="date" dateStyle="medium"/>&nbsp;
								</td>
								<td style="width: 110px;" align="right">
									<span style="width: 100px;" ><fmt:formatNumber value="${payment.interest}"   pattern='#,##0.00#'/>&nbsp;</span>
									<span style="display:none"  name="yjlx"><fmt:formatNumber value="${payment.interest}"  pattern='0.00'/>&nbsp;
									</span>
								</td>
								<td style="width: 140px;" align="right">
										<span style="width: 130px;" ><fmt:formatNumber value="${payment.breachContract}"  pattern='#,##0.00#'/>&nbsp;
									</span>
									<span style="display:none"  name="yjznj"><fmt:formatNumber value="${payment.breachContract}"  pattern='0.00'/>&nbsp;
									</span>
								</td>
							</tr>
						</c:forEach> 
					</tbody>
				</table>
			</div>
		</div>
		
		<div class="page">
		<div class="pgToolbar">
		<div class="pgPanel">
			<div>每页显示<input class="pgPerSize" type="text" value="18" size="2" id="viewPageColSize" readonly="readonly"/> 条记录&nbsp;
			</div> 
				<div class="separator" ></div> 
				<div class="pgBtn pgFirst" id="pgFirst" title="首页" onclick="pageAction(1);">
			 		 	<img src="/webLand/image/page/first.gif"/>	 	</div><!-- first_disabled -->
			
			 <div class="pgBtn pgPrev" id="pgPrev" title="上页" onclick="pageAction('pre');">
			 		 	<img src="/webLand/image/page/prev.gif"/>	 </div>
			 <div class="separator" ></div>
			 
			 <div>第 <select id="gotoPage" onchange="pageAction(this.value)" style="width:40px" >
						<option value="1" selected="selected">1</option>
					</select> 页 / 共 <span class="pgTotalPage" id="pgTotalPage">${pageNum}</span> 页</div>
			 <div class="separator" ></div>
			 <div class="pgBtn pgNext" id="pgNext" title="下页" >
			 		 	<img src="/webLand/image/page/next.gif" onclick="pageAction('next');"/>
			 		 </div>
			 <div class="pgBtn pgLast" id="pgLast" title="尾页" >
			 		 	<img src="/webLand/image/page/last.gif" onclick="pageAction(${pageNum});"/>
			 		 </div>	
			  <div class="separator"></div>
				 <div class="pgSearchInfo">检索到&nbsp;${listSize}&nbsp;条记录,显示第&nbsp;<span class="pgStartRecord" >1</span>&nbsp;条&nbsp;-&nbsp;
			 第&nbsp;<span class="pgEndRecord">18
			 </span>&nbsp;条记录</div><hr class="cleanFloat" />
			</div>
		</div>
		</div>
		<input type="hidden" id="pageNum" name="pageNum" value="${pageNum}" />
		<input type="hidden" id="listSize" name="listSize" value="${listSize}" />
		<input type="hidden" id="nowPage" name="nowPage" value="1" />
	</form>	
	<div class="search-div">
			<form id="lastInsForm" method="post" action="<%=path%>/paymentReminder/WDZPaylist.do">
			<input type="hidden" id="curMain" name="curMain" value="${queryobj.curMain }"/>
			<!-- 分页的隐藏属性 -->
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
							<td class="c-left">合同状态：</td>
							<td>
								<select id="state" name="state">
									<option value="">--请选择合同状态--</option>
									<option>正常</option>
									<option value="rm-T">--已预警</option>
									<option value="rm-F">--未预警</option>
									<option>延期</option>
									<option value="ic-T">--未缴款</option>
									<option value="ic-C">--未到账</option>
								</select>
								
							</td>
						</tr>
					</table>
				</div>
				<div class="search-commit">
					<input type="submit" class="search-button" id="search" value="查询" />
				</div>
			</form>
		</div>
	<div style="display: none; width: 90%"  id="print">
	</div>
	<object  id="LODOP" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0> 
			<embed id="LODOP_EM" type="application/x-print-lodop" width=0 height=0></embed>
		</object>
	<script type="text/javascript" src="<%=path%>/js/jquery-1.5.1.js"></script>
	<script type="text/javascript" src="<%=path%>/js/BoxSelect.js"></script>
	<script type="text/javascript" src="<%=path%>/js/lib.ui.core.js"></script>
	<script type="text/javascript" src="<%=path%>/js/widget/lib.ui.button.js"></script>
	<script type="text/javascript" 	src="<%=path%>/js/widget/lib.ui.toolbar.js"></script>
	<script type="text/javascript" src="<%=path%>/js/widget/lib.ui.window.js"></script>
	<script type="text/javascript" src="<%=path%>/js/LodopFuncs.js"></script>
	<script type="text/javascript" src="<%=path%>/js/widget/lib.ui.drag.js"></script>
	<script type="text/javascript" src="<%=path%>/js/datePicker/WdatePicker.js"></script>
	<script type="text/javascript">
			$(document).ready(function(){
				var tool = $('.tool').toolbar({
					id:'toolbar',
					items: [ {	
							id:'',
							text: '催缴打印',
							title: '催缴打印',
							icon: {
								url: '<%=path%>/image/Button/op_owner.gif',
								position: ['0px','0px']
							},
							handler: function(){
								calls();
							}
							},{
								id:'',
								text: '提醒打印',
								title: '提醒打印',
								icon: {
									url: '<%=path%>/image/Button/op_owner.gif',
									position: ['0px','0px']
								},
								handler: function(){
									remind();
								}
							},{
								text: '查询',
								title: '查询合同信息',
								icon: {
									url: '<%=path%>/image/Button/op_owner.gif',
									position: ['0px','-40px']
								},
								handler: function(){
								 $('.search-div').slideToggle(100);
								}
							}]
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
				setOption();
				
			});
			
			function calls(){
				var checkboxList = $('.grid').find('.table-body').find(':checkbox');
				if(checkboxList 
						&& checkboxList.filter(':checked').size() > 0){
				if(checkboxList.filter(':checked').size() ==1){
					if(checkboxList.filter(':checked').parent().find("input[name='isCalls']").val()=='T'){
							var contractNum=	checkboxList.filter(':checked').parent().find("input[name='contractNum']").val();
							var unitsName=	checkboxList.filter(':checked').parent().find("input[name='unitsName']").val();
							var paid=checkboxList.filter(':checked').parent().find("input[name='paid']").val();
							var payNum=	checkboxList.filter(':checked').parent().find("input[name='payNum']").val();
							var unpaid=	checkboxList.filter(':checked').parent().find("input[name='unpaid']").val();
							var payableDate = checkboxList.filter(':checked').parent().find("input[name='payableDate']").val();
							var breachContract=	checkboxList.filter(':checked').parent().find("input[name='breachContract']").val();
							
					$("#print").empty();
					
					var html="<blockquote><blockquote><blockquote><p>"+
					"土地出让金催缴通知书</p></blockquote></blockquote></blockquote>"+
					"<p>"+unitsName+"</p><blockquote><p>贵单位签订了编号为"+contractNum+"的合同。其中,第"+payNum+"期应缴"+paid+"</p>"+
					"</blockquote><p>的出让金.截止到欠缴"+unpaid+"。并产生违约金"+breachContract+"</p><p>&nbsp;"+
					"</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><blockquote><blockquote><blockquote>"+
					"<blockquote><blockquote><blockquote><p>济南国土局</p><p>"+clock()+"</p></blockquote></blockquote>"+
					"</blockquote></blockquote></blockquote></blockquote>";
					$("#print").html(html);
					var LODOP=getLodop(document.getElementById('LODOP'),document.getElementById('LODOP_EM'));
					LODOP.PRINT_INIT("打印控件功能演示_Lodop功能_表单一");
					LODOP.SET_PRINT_STYLE("FontSize",10);
					LODOP.SET_PRINT_STYLE("Bold",1);
					LODOP.ADD_PRINT_HTM(0,0,'100%','100%',document.getElementById("print").innerHTML);
					LODOP.PRINT_DESIGN();

						}else{
							alert("该信息不需要催缴");
						}
					}else{
						alert("只能选择一条记录");
					}
				}else{
					alert("请选择合同记录");
				}
			}
			function remind(){
				var checkboxList = $('.listGrid').find('.table-body').find(':checkbox');
				if(checkboxList 
						&& checkboxList.filter(':checked').size() > 0){
				if(checkboxList.filter(':checked').size() ==1){
					if(checkboxList.filter(':checked').parent().find("input[name='isRemend']").val()=='T'){
						var contractNum=	checkboxList.filter(':checked').parent().find("input[name='contractNum']").val();
						var unitsName=	checkboxList.filter(':checked').parent().find("input[name='unitsName']").val();
						var paid=	checkboxList.filter(':checked').parent().find("input[name='paid']").val();
						var payNum=	checkboxList.filter(':checked').parent().find("input[name='payNum']").val();
						var unpaid=	checkboxList.filter(':checked').parent().find("input[name='unpaid']").val();
						var payableDate=	checkboxList.filter(':checked').parent().find("input[name='payableDate']").val();
				$("#print").empty();
				
				var html="<blockquote><blockquote><blockquote><p>"+
				"土地出让金提醒通知书</p></blockquote></blockquote></blockquote>"+
				"<p>"+unitsName+"</p><blockquote><p>贵单位签订了编号为"+contractNum+"的合同。其中,第"+payNum+"期款"+paid+"</p>"+
				"</blockquote><p>至今未缴"+unpaid+".按照合同要求.贵单位应在"+payableDate+"前交付全额</p><p>&nbsp;"+
				"</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><blockquote><blockquote><blockquote>"+
				"<blockquote><blockquote><blockquote><p>济南国土局</p><p>"+clock()+"</p></blockquote></blockquote>"+
				"</blockquote></blockquote></blockquote></blockquote>";
				$("#print").html(html);
				var LODOP=getLodop(document.getElementById('LODOP'),document.getElementById('LODOP_EM'));
				LODOP.PRINT_INIT("打印控件功能演示_Lodop功能_表单一");
				LODOP.SET_PRINT_STYLE("FontSize",10);
				LODOP.SET_PRINT_STYLE("Bold",1);
				LODOP.ADD_PRINT_HTM(0,0,'100%','100%',document.getElementById("print").innerHTML);
				LODOP.PRINT_DESIGN();
						}else{
							alert("该信息不需要缴款提醒");
						}
					}else{
						alert("只能选择一条记录");
					}
				}else{
					alert("请选择合同记录");
				}
				
			}
			function clock() {
				var date = new Date();
				var year = date.getFullYear(); //年
				var month = date.getMonth() + 1; //月
				var day = date.getDate(); //日
				var clock = year;
				clock += "-";
				if (month < 10)
					clock += "0";
				clock += month;
				clock += "-";
				if (day < 10)
					clock += "0";
				clock += day;
				return clock;
			}
			
			function setOption(){
				var bhtjehj = 0 ; //本页合同金额合计
				var bfqjkjehj = 0;//本页分期缴款金额合计
				var bwjjehj = 0;//本页未缴金额合计
				var byjlxhj = 0;//本页应缴利息合计
				var byjznjhj = 0;//本页应缴滞纳金合计
				var zhtjehj = 0 ; //总合同金额合计
				var zfqjkjehj = 0;//总分期缴款金额合计
				var zwjjehj = 0;//总未缴金额合计
				var zyjlxhj = 0;//总应缴利息合计
				var zyjznjhj = 0;//总应缴滞纳金合计
				
				$(".table-body :first tr").hide();
				var atr = $(".table-body :first tr");
				for(var i=0;i<atr.size();i++){
					zhtjehj += parseInt($(atr[i]).find('span[name="htje"]').text());
				     zfqjkjehj += parseInt($(atr[i]).find('span[name="fqjkje"]').text());
				     zwjjehj += parseInt($(atr[i]).find('span[name="wjje"]').text());
				     //利息
				     var lx = $(atr[i]).find('span[name="yjlx"]').text();
				     //滞纳金
				     var znj = $(atr[i]).find('span[name="yjznj"]').text();
				     //如果利息为空，则看做0
				     if($.trim($(atr[i]).find('span[name="yjlx"]').text()) == '' ){
				    	lx = 0;
				     }
				     zyjlxhj += parseInt(lx);
				     //如果滞纳金为空，则看做0
				     if($.trim($(atr[i]).find('span[name="yjznj"]').text()) == '' ){
				    	znj = 0;
				     }
				     zyjznjhj += parseInt(znj);
				}
				var len="18";
				//获得总信息条数 并与10比较大小  若大于或等于则不修改len
				if($("#listSize").val()<18) {
					len=$("#listSize").val();
					$(".pgEndRecord").text(len);
				}
				var trs = $("tr[class='hid']"); 
				for(i = 0; i <parseInt(len) ; i++){      
				     trs[i].style.display = ""; //这里获取的trs[i]是DOM对象而不是jQuery对象，因此不能直接使用hide()方法    
				     bhtjehj += parseInt($(trs[i]).find('span[name="htje"]').text());
				     bfqjkjehj += parseInt($(trs[i]).find('span[name="fqjkje"]').text());
				     bwjjehj += parseInt($(trs[i]).find('span[name="wjje"]').text());
				     //利息
				     var lx = $(trs[i]).find('span[name="yjlx"]').text();
				     //滞纳金
				     var znj = $(trs[i]).find('span[name="yjznj"]').text();
				     //如果利息为空，则看做0
				     if($.trim($(trs[i]).find('span[name="yjlx"]').text()) == '' ){
				    	lx = 0;
				     }
				     byjlxhj += parseInt(lx);
				     //如果滞纳金为空，则看做0
				     if($.trim($(trs[i]).find('span[name="yjznj"]').text()) == '' ){
				    	znj = 0;
				     }
				     byjznjhj += parseInt(znj);
				     
				} 
				var pageNum=$("#pageNum").val();
				var string="";
				if($("#pageNum").val()){
					for(var i=2;i<parseInt(pageNum)+1;i++){
						string +="<option value='"+i+"'>"+i+"</option>";
					}
				}
				$("#gotoPage").append(string);
				if($("#nowPage").val()=='1'&&$("#nowPage").val()==$("#pageNum").val()){
					$("#pgFirst img").attr("src","/webLand/image/page/first_disabled.gif");
					$("#pgPrev img").attr("src","/webLand/image/page/prev_disabled.gif");
					$("#pgNext img").attr("src","/webLand/image/page/next_disabled.gif");
					$("#pgLast img").attr("src","/webLand/image/page/last_disabled.gif");
				}else if($("#nowPage").val()=='1'&&$("#nowPage").val()!=$("#pageNum").val()){
					$("#pgFirst img").attr("src","/webLand/image/page/first_disabled.gif");
					$("#pgPrev img").attr("src","/webLand/image/page/prev_disabled.gif");
					$("#pgNext img").attr("src","/webLand/image/page/next.gif");
					$("#pgLast img").attr("src","/webLand/image/page/last.gif");
				}else if($("#nowPage").val()!='1'&&$("#nowPage").val()==$("#pageNum").val()){
					$("#pgFirst img").attr("src","/webLand/image/page/first.gif");
					$("#pgPrev img").attr("src","/webLand/image/page/prev.gif");
					$("#pgNext img").attr("src","/webLand/image/page/next_disabled.gif");
					$("#pgLast img").attr("src","/webLand/image/page/last_disabled.gif");
				}
				
				//style.display="";
				$('.total').show();
				$('#bhtjehj').text(milliFormat(Number(bhtjehj).toFixed(2)));
				$('#bfqjkjehj').text(milliFormat(Number(bfqjkjehj).toFixed(2)));
				$('#bwjjehj').text(milliFormat(Number(bwjjehj).toFixed(2)));
				$('#byjlxhj').text(milliFormat(Number(byjlxhj).toFixed(2)));
				$('#byjznjhj').text(milliFormat(Number(byjznjhj).toFixed(2)));
				$('#zhtjehj').text(milliFormat(Number(zhtjehj).toFixed(2)));
				$('#zfqjkjehj').text(milliFormat(Number(zfqjkjehj).toFixed(2)));
				$('#zwjjehj').text(milliFormat(Number(zwjjehj).toFixed(2)));
				$('#zyjlxhj').text(milliFormat(Number(zyjlxhj).toFixed(2)));
				$('#zyjznjhj').text(milliFormat(Number(zyjznjhj).toFixed(2)));
			}
			function milliFormat(s){//添加千位符
				if(/[^0-9\.]/.test(s)) return "invalid value";
				s=s.replace(/^(\d*)$/,"$1.");
				s=(s+"00").replace(/(\d*\.\d\d)\d*/,"$1");
				s=s.replace(".",",");
				var re=/(\d)(\d{3},)/;
				while(re.test(s)){
					s=s.replace(re,"$1,$2");
				}
				s=s.replace(/,(\d\d)$/,".$1");
				return s.replace(/^\./,"0.")
			}
			
			//page
			function pageAction(nowPage){
				var bhtjehj = 0 ; //本页合同金额合计
				var bfqjkjehj = 0;//本页分期缴款金额合计
				var bwjjehj = 0;//本页未缴金额合计
				var byjlxhj = 0;//本页应缴利息合计
				var byjznjhj = 0;//本页应缴滞纳金合计
				
				//判断点击的那个按钮  nowPage：next下一个；pre上一个；如果nowPage为数字则直接不需判断
				if(nowPage=='next'){
					//判断是否为末页   如果是则不处理；如果否则处理
					if(parseInt($("#nowPage").val())==parseInt($("#pageNum").val())){
						nowPage=parseInt($("#nowPage").val());
						return;
					}else nowPage=parseInt($("#nowPage").val())+1;
				}else if(nowPage=='pre'){
					//判断是否为首页   如果是则不处理；如果否则处理
					if(parseInt($("#nowPage").val())=='1'){
						nowPage=parseInt($("#nowPage").val());
						return;
					}else nowPage=parseInt($("#nowPage").val())-1;
				}
				$(".pgStartRecord").text((parseInt(nowPage)-1)*18+1);
				if(parseInt(nowPage)*18-parseInt($("#listSize").val())>=0){
					$(".pgEndRecord").text(parseInt($("#listSize").val()));
				}else  {
					$(".pgEndRecord").text(parseInt(nowPage)*18);
				}
				$("#gotoPage").val(nowPage);
				$("#nowPage").val(nowPage); 
				$("#listForm .table-body :first tr").hide();
				//$("#pgFirst img").attr("src","/webLand/image/page/first_disabled.gif");
				//$("#pgPrev img").attr("src","/webLand/image/page/prev_disabled.gif");
				//是否为首页和末页 添加背景图片
				if($("#nowPage").val()=='1'&&$("#nowPage").val()==$("#pageNum").val()){
					$("#pgFirst img").attr("src","/webLand/image/page/first_disabled.gif");
					$("#pgPrev img").attr("src","/webLand/image/page/prev_disabled.gif");
					$("#pgNext img").attr("src","/webLand/image/page/next_disabled.gif");
					$("#pgLast img").attr("src","/webLand/image/page/last_disabled.gif");
				}else if($("#nowPage").val()=='1'&&$("#nowPage").val()!=$("#pageNum").val()){
					$("#pgFirst img").attr("src","/webLand/image/page/first_disabled.gif");
					$("#pgPrev img").attr("src","/webLand/image/page/prev_disabled.gif");
					$("#pgNext img").attr("src","/webLand/image/page/next.gif");
					$("#pgLast img").attr("src","/webLand/image/page/last.gif");
				}else if($("#nowPage").val()!='1'&&$("#nowPage").val()==$("#pageNum").val()){
					$("#pgFirst img").attr("src","/webLand/image/page/first.gif");
					$("#pgPrev img").attr("src","/webLand/image/page/prev.gif");
					$("#pgNext img").attr("src","/webLand/image/page/next_disabled.gif");
					$("#pgLast img").attr("src","/webLand/image/page/last_disabled.gif");
				}
				else if($("#nowPage").val()!='1'&&$("#nowPage").val()!=$("#pageNum").val()){
					$("#pgFirst img").attr("src","/webLand/image/page/first.gif");
					$("#pgPrev img").attr("src","/webLand/image/page/prev.gif");
					$("#pgNext img").attr("src","/webLand/image/page/next.gif");
					$("#pgLast img").attr("src","/webLand/image/page/last.gif");
				}
				var trs = $("tr[class='hid']"); 
				//判断最后的页数
				var len=parseInt(nowPage)*18;
				if($("#listSize").val()<parseInt(nowPage)*18) {
					len=$("#listSize").val();
				}
				for(i = (parseInt(nowPage)-1)*18; i < len; i++){      
				     trs[i].style.display = ""; 
				     
				     bhtjehj += parseInt($(trs[i]).find('span[name="htje"]').text());
				     bfqjkjehj += parseInt($(trs[i]).find('span[name="fqjkje"]').text());
				     bwjjehj += parseInt($(trs[i]).find('span[name="wjje"]').text());
				     //利息
				     var lx = $(trs[i]).find('span[name="yjlx"]').text();
				     //滞纳金
				     var znj = $(trs[i]).find('span[name="yjznj"]').text();
				     //如果利息为空，则看做0
				     if($.trim($(trs[i]).find('span[name="yjlx"]').text()) == '' ){
				    	lx = 0;
				     }
				     byjlxhj += parseInt(lx);
				     //如果滞纳金为空，则看做0
				     if($.trim($(trs[i]).find('span[name="yjznj"]').text()) == '' ){
				    	znj = 0;
				     }
				     byjznjhj += parseInt(znj);
				} 
				$('#bhtjehj').text(Number(bhtjehj).toFixed(2));
				$('#bfqjkjehj').text(Number(bfqjkjehj).toFixed(2));
				$('#bwjjehj').text(Number(bwjjehj).toFixed(2));
				$('#byjlxhj').text(Number(byjlxhj).toFixed(2));
				$('#byjznjhj').text(Number(byjznjhj).toFixed(2));
			}
			

			
			function viewContract(value){
				$('body').window({
					id: 'window_viewContract',
					title: '文件详细信息',
					content: '<iframe id="viewContractFrame" frameborder="0" src="<%=path%>/PaymentRem/findContractById.do?id='+value+'"></iframe>',
					width:$('body').width(),
					height: $('body').height(),
					draggable: true,
					isModal: true
				});
			}
			
	</script>
</body>
</html>