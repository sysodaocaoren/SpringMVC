<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/common/inc.jsp"%>
<title>Insert title here</title>
</head>
<script type="text/javascript">
$(function(){
	$('.data-table').dataTable({
		//"bProcessing" : true, //DataTables载入数据时，是否显示‘进度’提示
		"bJQueryUI": true,
		//"sScrollY" : 300, //DataTables的高  
        //"sScrollX" : 1000, //DataTables的宽  
        "iDisplayLength" : 12, //默认显示的记录数  
        "bAutoWidth" : false, //是否自适应宽度
		"aLengthMenu" : [20, 40, 60,80,100], //更改显示记录数选项  
		"bScrollCollapse" : false, //是否开启DataTables的高度自适应，当数据条数不够分页数据条数的时候，插件高度是否随数据条数而改变  
		"bPaginate" : true, //是否显示（应用）分页器  
		"sPaginationType": "full_numbers",
		"sDom": '<""li>t<"F"p>',
		//"sDom": '<"top"i>rt<"bottom"flp><"clear">',
         "oLanguage": { //国际化配置  
             "sProcessing" : "正在获取数据，请稍后...",    
             "sLengthMenu" : "显示 _MENU_ 条",    
             "sZeroRecords" : "没有您要搜索的内容",    
             "sInfo" : "从 _START_ 到  _END_ 条记录 总记录数为 _TOTAL_ 条",    
             "sInfoEmpty" : "记录数为0",    
             "sInfoFiltered" : "(全部记录数 _MAX_ 条)",    
             "sInfoPostFix" : "",    
             "sSearch" : "搜索",    
             "oPaginate": {    
                 "sFirst" : "第一页",    
                 "sPrevious" : "上一页",    
                 "sNext" : "下一页",    
                 "sLast" : "最后一页"    
             }  
         }
	});
});
</script>
<body>
	<div class="widget-box">
		<div class="widget-title">
			<h5>Dynamic table</h5>
		</div>
		<!-- <div align="left">
			<table cellpadding="1" cellspacing="1" class="data-table" style="width:100%;height:100%;">
			</table>
		</div> -->
		<div align="left" >
			<table cellpadding="1" cellspacing="1" class="data-table" style="width:100%;height:100%;">
				<thead>
				<tr>
				<th>Rendering engine</th>
				<th>Browser</th>
				<th>Platform(s)</th>
				<th>Engine version</th>
				</tr>
				</thead>
				<tbody>
				<tr class="gradeX">
				<td>Trident</td>
				<td>Internet
				Explorer 4.0</td>
				<td>Win 95+</td>
				<td class="center">4</td>
				</tr>
				<tr class="gradeC">
				<td>Trident</td>
				<td>Internet
				Explorer 5.0</td>
				<td>Win 95+</td>
				<td class="center">5</td>
				</tr>
				<tr class="gradeA">
				<td>Trident</td>
				<td>Internet
				Explorer 5.5</td>
				<td>Win 95+</td>
				<td class="center">5.5</td>
				</tr>
				<tr class="gradeA">
				<td>Trident</td>
				<td>Internet
				Explorer 6</td>
				<td>Win 98+</td>
				<td class="center">6</td>
				</tr>
				<tr class="gradeA">
				<td>Trident</td>
				<td>Internet Explorer 7</td>
				<td>Win XP SP2+</td>
				<td class="center">7</td>
				</tr>
				<tr class="gradeA">
				<td>Trident</td>
				<td>AOL browser (AOL desktop)</td>
				<td>Win XP</td>
				<td class="center">6</td>
				</tr>
				<tr class="gradeA">
				<td>Gecko</td>
				<td>Firefox 1.0</td>
				<td>Win 98+ / OSX.2+</td>
				<td class="center">1.7</td>
				</tr>
				<tr class="gradeA">
				<td>Gecko</td>
				<td>Firefox 1.5</td>
				<td>Win 98+ / OSX.2+</td>
				<td class="center">1.8</td>
				</tr>
				<tr class="gradeA">
				<td>Gecko</td>
				<td>Firefox 2.0</td>
				<td>Win 98+ / OSX.2+</td>
				<td class="center">1.8</td>
				</tr>
				<tr class="gradeA">
				<td>Gecko</td>
				<td>Firefox 3.0</td>
				<td>Win 2k+ / OSX.3+</td>
				<td class="center">1.9</td>
				</tr>
				<tr class="gradeA">
				<td>Gecko</td>
				<td>Camino 1.0</td>
				<td>OSX.2+</td>
				<td class="center">1.8</td>
				</tr>
				<tr class="gradeA">
				<td>Gecko</td>
				<td>Camino 1.5</td>
				<td>OSX.3+</td>
				<td class="center">1.8</td>
				</tr>
				<tr class="gradeA">
				<td>Gecko</td>
				<td>Netscape 7.2</td>
				<td>Win 95+ / Mac OS 8.6-9.2</td>
				<td class="center">1.7</td>
				</tr>
				<tr class="gradeA">
				<td>Gecko</td>
				<td>Netscape Browser 8</td>
				<td>Win 98SE+</td>
				<td class="center">1.7</td>
				</tr>
				<tr class="gradeA">
				<td>Gecko</td>
				<td>Netscape Navigator 9</td>
				<td>Win 98+ / OSX.2+</td>
				<td class="center">1.8</td>
				</tr>
				<tr class="gradeA">
				<td>Gecko</td>
				<td>Mozilla 1.0</td>
				<td>Win 95+ / OSX.1+</td>
				<td class="center">1</td>
				</tr>
				<tr class="gradeA">
				<td>Gecko</td>
				<td>Mozilla 1.1</td>
				<td>Win 95+ / OSX.1+</td>
				<td class="center">1.1</td>
				</tr>
				<tr class="gradeA">
				<td>Gecko</td>
				<td>Mozilla 1.2</td>
				<td>Win 95+ / OSX.1+</td>
				<td class="center">1.2</td>
				</tr>
				<tr class="gradeA">
				<td>Gecko</td>
				<td>Mozilla 1.3</td>
				<td>Win 95+ / OSX.1+</td>
				<td class="center">1.3</td>
				</tr>
				<tr class="gradeA">
				<td>Gecko</td>
				<td>Mozilla 1.4</td>
				<td>Win 95+ / OSX.1+</td>
				<td class="center">1.4</td>
				</tr>
				<tr class="gradeA">
				<td>Gecko</td>
				<td>Mozilla 1.5</td>
				<td>Win 95+ / OSX.1+</td>
				<td class="center">1.5</td>
				</tr>
				<tr class="gradeA">
				<td>Gecko</td>
				<td>Mozilla 1.6</td>
				<td>Win 95+ / OSX.1+</td>
				<td class="center">1.6</td>
				</tr>
				<tr class="gradeA">
				<td>Gecko</td>
				<td>Mozilla 1.7</td>
				<td>Win 98+ / OSX.1+</td>
				<td class="center">1.7</td>
				</tr>
				<tr class="gradeA">
				<td>Gecko</td>
				<td>Mozilla 1.8</td>
				<td>Win 98+ / OSX.1+</td>
				<td class="center">1.8</td>
				</tr>
				<tr class="gradeA">
				<td>Gecko</td>
				<td>Seamonkey 1.1</td>
				<td>Win 98+ / OSX.2+</td>
				<td class="center">1.8</td>
				</tr>
				<tr class="gradeA">
				<td>Gecko</td>
				<td>Epiphany 2.20</td>
				<td>Gnome</td>
				<td class="center">1.8</td>
				</tr>
				<tr class="gradeA">
				<td>Webkit</td>
				<td>Safari 1.2</td>
				<td>OSX.3</td>
				<td class="center">125.5</td>
				</tr>
				<tr class="gradeA">
				<td>Webkit</td>
				<td>Safari 1.3</td>
				<td>OSX.3</td>
				<td class="center">312.8</td>
				</tr>
				<tr class="gradeA">
				<td>Webkit</td>
				<td>Safari 2.0</td>
				<td>OSX.4+</td>
				<td class="center">419.3</td>
				</tr>
				<tr class="gradeA">
				<td>Webkit</td>
				<td>Safari 3.0</td>
				<td>OSX.4+</td>
				<td class="center">522.1</td>
				</tr>
				<tr class="gradeA">
				<td>Webkit</td>
				<td>OmniWeb 5.5</td>
				<td>OSX.4+</td>
				<td class="center">420</td>
				</tr>
				<tr class="gradeA">
				<td>Webkit</td>
				<td>iPod Touch / iPhone</td>
				<td>iPod</td>
				<td class="center">420.1</td>
				</tr>
				<tr class="gradeA">
				<td>Webkit</td>
				<td>S60</td>
				<td>S60</td>
				<td class="center">413</td>
				</tr>
				<tr class="gradeA">
				<td>Presto</td>
				<td>Opera 7.0</td>
				<td>Win 95+ / OSX.1+</td>
				<td class="center">-</td>
				</tr>
				<tr class="gradeA">
				<td>Presto</td>
				<td>Opera 7.5</td>
				<td>Win 95+ / OSX.2+</td>
				<td class="center">-</td>
				</tr>
				<tr class="gradeA">
				<td>Presto</td>
				<td>Opera 8.0</td>
				<td>Win 95+ / OSX.2+</td>
				<td class="center">-</td>
				</tr>
				<tr class="gradeA">
				<td>Presto</td>
				<td>Opera 8.5</td>
				<td>Win 95+ / OSX.2+</td>
				<td class="center">-</td>
				</tr>
				<tr class="gradeA">
				<td>Presto</td>
				<td>Opera 9.0</td>
				<td>Win 95+ / OSX.3+</td>
				<td class="center">-</td>
				</tr>
				<tr class="gradeA">
				<td>Presto</td>
				<td>Opera 9.2</td>
				<td>Win 88+ / OSX.3+</td>
				<td class="center">-</td>
				</tr>
				<tr class="gradeA">
				<td>Presto</td>
				<td>Opera 9.5</td>
				<td>Win 88+ / OSX.3+</td>
				<td class="center">-</td>
				</tr>
				<tr class="gradeA">
				<td>Presto</td>
				<td>Opera for Wii</td>
				<td>Wii</td>
				<td class="center">-</td>
				</tr>
				<tr class="gradeA">
				<td>Presto</td>
				<td>Nokia N800</td>
				<td>N800</td>
				<td class="center">-</td>
				</tr>
				<tr class="gradeA">
				<td>Presto</td>
				<td>Nintendo DS browser</td>
				<td>Nintendo DS</td>
				<td class="center">8.5</td>
				</tr>
				<tr class="gradeC">
				<td>KHTML</td>
				<td>Konqureror 3.1</td>
				<td>KDE 3.1</td>
				<td class="center">3.1</td>
				</tr>
				<tr class="gradeA">
				<td>KHTML</td>
				<td>Konqureror 3.3</td>
				<td>KDE 3.3</td>
				<td class="center">3.3</td>
				</tr>
				<tr class="gradeA">
				<td>KHTML</td>
				<td>Konqureror 3.5</td>
				<td>KDE 3.5</td>
				<td class="center">3.5</td>
				</tr>
				<tr class="gradeX">
				<td>Tasman</td>
				<td>Internet Explorer 4.5</td>
				<td>Mac OS 8-9</td>
				<td class="center">-</td>
				</tr>
				<tr class="gradeC">
				<td>Tasman</td>
				<td>Internet Explorer 5.1</td>
				<td>Mac OS 7.6-9</td>
				<td class="center">1</td>
				</tr>
				<tr class="gradeC">
				<td>Tasman</td>
				<td>Internet Explorer 5.2</td>
				<td>Mac OS 8-X</td>
				<td class="center">1</td>
				</tr>
				<tr class="gradeA">
				<td>Misc</td>
				<td>NetFront 3.1</td>
				<td>Embedded devices</td>
				<td class="center">-</td>
				</tr>
				<tr class="gradeA">
				<td>Misc</td>
				<td>NetFront 3.4</td>
				<td>Embedded devices</td>
				<td class="center">-</td>
				</tr>
				<tr class="gradeX">
				<td>Misc</td>
				<td>Dillo 0.8</td>
				<td>Embedded devices</td>
				<td class="center">-</td>
				</tr>
				<tr class="gradeX">
				<td>Misc</td>
				<td>Links</td>
				<td>Text only</td>
				<td class="center">-</td>
				</tr>
				<tr class="gradeX">
				<td>Misc</td>
				<td>Lynx</td>
				<td>Text only</td>
				<td class="center">-</td>
				</tr>
				<tr class="gradeC">
				<td>Misc</td>
				<td>IE Mobile</td>
				<td>Windows Mobile 6</td>
				<td class="center">-</td>
				</tr>
				<tr class="gradeC">
				<td>Misc</td>
				<td>PSP browser</td>
				<td>PSP</td>
				<td class="center">-</td>
				</tr>
				<tr class="gradeU">
				<td>Other browsers</td>
				<td>All others</td>
				<td>-</td>
				<td class="center">-</td>
				</tr>
				</tbody>
				</table>  
		</div>
	</div>
</body>
</html>