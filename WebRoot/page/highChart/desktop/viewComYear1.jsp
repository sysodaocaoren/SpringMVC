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
<div id="container" style="min-width: 310px; max-width: 400px; height: 300px; margin: 0 auto"></div>
	<div class="item-bottom-div" style="width:40%;">
			<div id="myCarousel" class="carousel slide" style="width: 100%;height: 100%;">
				<!-- Carousel items -->
				<div class="carousel-inner" style="width: 100%;height: 100%;">
					<div class="active item" style="width: 100%;height: 100%;">
						<div id="containerPlan1" style="width: 100%; height: 100%;"></div>
					</div>
					<div class="active item pageTwo" style="width: 100%;height: 100%;">
						<div id="containerPlan2" style="width: 100%;height: 100%;"></div>
					</div>
					<div class="active item pageTwo1" style="width: 100%;height: 100%;">
						<div id="containerPlan3" style="width: 100%;height: 100%;"></div>
					</div>
					<div class="active item pageTwo2" style="width: 100%;height: 100%;">
						<div id="containerPlan4" style="width: 100%;height: 100%;"></div>
					</div>
					<div class="active item pageTwo3" style="width: 100%;height: 100%;">
						<div id="containerPlan5" style="width: 100%;height: 100%;"></div>
					</div>
				</div>
				<!-- Carousel nav -->
				<a class="carousel-control left" href="#myCarousel"data-slide="prev" data-interval="100000">&lsaquo;</a>
				<a class="carousel-control right"href="#myCarousel" data-slide="next" data-interval="100000">&rsaquo;</a>
			</div>
			<div id="seeinfo">
				<a id="planList">>>查看明细</a>
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
<script type="text/javascript" src="<%=path%>/js/deskTop/deskTop1.js"></script>
<script type="text/javascript">
$(function() {
			var base='<%=path%>';
			//alert(base);
			loadPlan(base);
});
</script>
</html>