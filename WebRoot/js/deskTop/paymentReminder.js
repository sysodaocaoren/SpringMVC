/*
 * 饼状图后台逻辑
 */
var landMarketPie;
function loadPie (path,curMain,timeStart,timeEnd){
	debugger;
	var color=[ '#00FF9D','#E6FB04', '#FF9655', '#417CBD','#89A54E', '#4572A7'];
	var color1; 
	var color2;
	var text;
	
		color1=color[0];
		color2=color[1];
		text='缴款情况';
	
	$.post(path + '/paymentReminder/loadpie.do?timeStart='+timeStart+'&timeEnd='+timeEnd, 'curMain='+curMain, function(data){ 
		landMarketPie = new Highcharts.Chart({
			chart: {
	            type: 'pie',
	            renderTo : 'buttomChart',
	            options3d: {
	                enabled: false,
	                alpha:60,
	                beta: 0
	            }
	        },
	        colors: [color1, color2],
	        title: {
	            text: text
	        },
	        tooltip: {
	        	formatter:function(){
	        		var point = this.point,
	        		s = point.name + ':<b>' +  Highcharts.numberFormat(this.y*100, 2) + '%</b><br/>';
		        	return s;
	        	}
//	            pointFormat: '{series.name}:<b>{point.percentage:.1f}%</b>'
	        },
	        plotOptions: {
	            pie: {
	                allowPointSelect: false,
	                cursor: 'pointer',
	                depth: 15,
	                dataLabels: {
	                    enabled: true,
	                    format: '{point.name}:'
	                   
	                },
	                showInLegend : true,
	                size:'50%'
	            }
	           
	        },
	        credits : {
				enabled : false
			},
			
			legend: {
	            layout: 'vertical',
	            y:20,
	            verticalAlign: 'buttom',
	            backgroundColor: '#FFFFFF'
	        },
	        series: [{
	            type: 'pie',
	            name: '比例',
	            data: data
	        }]
		});
	}, 'json');
}
var landMarketPiewdz;//未到账饼状图
function loadPiewdz (path,curMain){
	var color=[ '#FF0000','#FFFF00', '#FF9900', '#0ec617','#89A54E', '#4572A7'];
	var color1; 
	var color2;
	var text;
	
		color1=color[0];
		color2=color[1];
		color3=color[2];
		color4=color[3];
		text='缴款情况';
	
	$.post(path + '/paymentReminder/loadpiewdz.do', 'curMain='+curMain, function(data){ 
		landMarketPiewdz = new Highcharts.Chart({
			chart: {
	            type: 'pie',
	            renderTo : 'buttomChart',
	            options3d: {
	                enabled: false,
	                alpha:60,
	                beta: 0
	            }
	        },
	        colors: [color1, color2,color3, color4],
	        title: {
	            text: text
	        },
	        tooltip: {
	        	formatter:function(){
	        		var point = this.point,
	        		s = point.name + ':<b>' +  Highcharts.numberFormat(this.y*100, 2) + '%</b><br/>';
		        	return s;
	        	}
//	            pointFormat: '{series.name}:<b>{point.percentage:.1f}%</b>'
	        },
	        plotOptions: {
	            pie: {
	                allowPointSelect: false,
	                cursor: 'pointer',
	                depth: 15,
	                dataLabels: {
	                    enabled: true,
	                    format: '{point.name}:'
	                   
	                },
	                showInLegend : false,
	                size:'50%'
	            }
	           
	        },
	        credits : {
				enabled : false
			},
			legend: {
				enabled: false
			},
			/*legend: {
	            layout: 'horizontal',
	            y:5,
	            verticalAlign: 'buttom',
	            backgroundColor: '#FFFFFF'
	        },*/
	        series: [{
	            type: 'pie',
	            name: '比例',
	            data: data
	        }]
		});
	}, 'json');
}