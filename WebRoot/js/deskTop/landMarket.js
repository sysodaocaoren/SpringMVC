/*
 * 土地市场看板 js
 */
//供地宗数 饼图
var searchCharts;
function loadLandCount(path){
	loadPie(path,'landCount');
    loadLeftTop(path,'landCount','供地宗数年度比较');
    loadRightTop(path,'landCount','供地宗数季度分析');
    loadButtom(path,'landCount','供地宗数按熟化主体分析');
	
}
//出让面积 饼图
function loadSellArea(path){
	loadPie(path,'sellArea');
	loadLeftTop(path,'sellArea','供地面积年度比较');
	loadRightTop(path,'sellArea','供地面积季度分析');
	loadButtom(path,'sellArea','供地面积按熟化主体分析');
}
//合同金额  饼图
function loadContractMoney(path){
	loadPie(path,'contractMoney');
	loadLeftTop(path,'contractMoney','合同金额年度比较');
	loadRightTop(path,'contractMoney','合同金额季度分析');
	loadButtom(path,'contractMoney','合同金额按熟化主体分析');
}


/*
 * 饼状图后台逻辑
 */
var landMarketPie;
function loadPie (path,condition){
	var color=['#14f5a2','#ed6e29', '#762963', '#417CBD','#89A54E', '#cd0a94', '#9e13d1', '#11a53b', '#2c17c8'];
	var color1; 
	var color2;
	var color3;
	var text;
	if(condition=='landCount'){
		color1=color[0];
		color2=color[1];
		color3=color[2];
		text='供地宗数占比';
	}
	if(condition=='sellArea'){
		color1=color[3];
		color2=color[4];
		color3=color[5];
		text='出让面积占比';
	}
	if(condition=='contractMoney'){
		color1=color[6];
		color2=color[7];
		color3=color[8];
		text='合同金额占比';
	}
	function setChart(data) {
		//移除之前序列 如果有多个可以用for逐个移除
		landMarketPie.series[0].remove(false);
		//添加新的序列
		landMarketPie.addSeries({
		name: '比例',
		data: data
		}, false);
		//重绘图表
		landMarketPie.redraw();
		}
	$.post(path + '/landMarket/landMarketPie.do', 'condition='+condition, function(data){ 
		landMarketPie = new Highcharts.Chart({
			chart: {
	            type: 'pie',
	            renderTo : condition+'Container',
	            options3d: {
	                enabled: false,
	                alpha:60,
	                beta: 0
	            }
	        },
	        colors: [color1, color2, color3],
	        title: {
	            text: text
	        },
	        tooltip: {
	        	formatter:function(){
	        		var point = this.point,
	        		s = point.name + ':<b>' +  Highcharts.numberFormat(this.y*100, 2) + '%</b><br/>';
		        	if (point.drilldown) {
		        	s += '点击查看 ' + point.name + ' 详情';
		        	} else {
		        	s += '点击返回上层';
		        	}
		        	return s;
	        	}
//	            pointFormat: '{series.name}:<b>{point.percentage:.1f}%</b>'
	        },
	        plotOptions: {
	            pie: {
	                allowPointSelect: false,
	                cursor: 'pointer',
	                point: {
		                		events: {
		                			click: function () {
		                				//根据是否进入钻取的状态重绘不同的图表
		                				var drilldown = this.drilldown;
		                				if (drilldown) { // drill down
		                					setChart(drilldown);
		                				} else { // restore                                    
		                					setChart(data);
		                				}
		                			}
		                		}
	                		},
	                depth: 15,
	                dataLabels: {
	                    enabled: true,
	                    format: '{point.name}:'
	                   
	                },
	                showInLegend : true,
	                size:'60%'
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
/*
 * 上面 左边柱状图
 */
 var loadLeftTopColumn;
 function loadLeftTop(path,condition,text){
	 //debugger;
	 var color=[ '#14f5a2','#ed6e29', '#b72cea', '#417CBD','#89A54E', '#cd0a94', '#9e13d1', '#11a53b', '#2c17c8'];
		var color1; 
		var color2;
		var text;
		var name;
		var index;
		var decimals;
		if(condition=='landCount'){
			color1=color[0];
			color2=color[1];
			text=text;
			name='宗数';
			index='宗';
			decimals=0;
		}
		if(condition=='sellArea'){
			color1=color[3];
			color2=color[4];
			text=text;
			name='面积';
			index='亩';
			decimals=0;
		}
		if(condition=='contractMoney'){
			color1=color[2];
			color2=color[7];
			text=text;
			name='金额';
			index='亿元';
			decimals=2;
		}
	 $.post(path + '/landMarket/loadLeftTop.do', 'condition='+condition, function(data){ 
		 var year = new Date().getFullYear();
		 loadLeftTopColumn = new Highcharts.Chart({
				chart: {
		            type: 'column',
		            renderTo : 'topLeftContrainer',
		            options3d: {
		                enabled: false,
		                alpha:60,
		                beta: 0
		            }
		        },
		        colors: [color1,color2],
		        title: {
		            text: text
		        },
		        tooltip: { //鼠标滑向数据区显示的提示框 
//		        	shared: false, //是否共享提示，也就是X一样的所有点都显示出来
//		        	useHTML: true, //是否使用HTML编辑提示信息
//		        	headerFormat: '<small>{point.key}</small><table>',
//		        	pointFormat: '<tr><td style="color: {series.color};">{series.name}: &nbsp;</td>' +
//		        	       '<td style="text-align: right"><b>{point.y}</b>'+index+'&nbsp;</td></tr>',
//		        	footerFormat: '</table>',
//		        	valueDecimals: decimals //数据值保留小数位数
		        	formatter : function() {	//标签格式化
		        		return '<font style="font-size: 11px;">'+this.x +'</font><br/>● '+ this.series.name +':'+ this.y + index;
		        	}
		        }, 
		        plotOptions: {
		        	column : {
		        		pointPadding: 0.2,
		        	    borderWidth: 0,
		        	    pointWidth: 20,
						borderWidth : 1,
						events : {
							legendItemClick : function(event) {
								return false;
							}
						}
					}
		        },
		        credits : {
					enabled : false
				},
				xAxis : {
					categories : data.years
				},
				yAxis : [
						{ // Primary yAxis
							title : {
								text : null,
								style : {
									color : '#89A54E'
								}
							},
							labels : {
								formatter : function() {
									return Highcharts.numberFormat(
											this.value, 2)+index;
								},
								style : {
									color : '#89A54E'
								}
							}
						}],
				/*legend: {
		            layout: 'vertical',
		            y:40,
		            verticalAlign: 'buttom',
		            backgroundColor: '#FFFFFF'
		        },*/
		        series: data.series
			});
		}, 'json');
  }
 /*
  * 上面 右边柱状图
  */
 var loadLeftTopSpile;
 function loadRightTop(path,condition,text){
	// debugger;
	 var color=[ '#14f5a2','#ed6e29', '#b72cea', '#417CBD','#89A54E', '#cd0a94', '#9e13d1', '#11a53b', '#2c17c8'];
		var color1; 
		var color2;
		var text;
		var name;
		var index;
		var decimals;
		if(condition=='landCount'){
			color1=color[0];
			color2=color[1];
			text=text;
			name='宗数';
			index='宗';
			decimals=0;
		}
		if(condition=='sellArea'){
			color1=color[3];
			color2=color[4];
			text=text;
			name='面积';
			index='亩';
			decimals=0;
		}
		if(condition=='contractMoney'){
			color1=color[2];
			color2=color[7];
			text=text;
			name='金额';
			index='亿元';
			decimals=2;
		}
	 $.post(path + '/landMarket/loadRightTop.do', 'condition='+condition, function(data){ 
		 var year = new Date().getFullYear();
		 loadLeftTopSpile = new Highcharts.Chart({
				chart: {
		            type: 'spline',
		            renderTo : 'topRightContrainer',
		            options3d: {
		                enabled: false,
		                alpha:60,
		                beta: 0
		            }
		        },
		        colors: [color1,color2],
		        title: {
		            text: text
		        },
		        tooltip: {
//		        	shared: false, //是否共享提示，也就是X一样的所有点都显示出来
//		        	useHTML: true, //是否使用HTML编辑提示信息
//		        	headerFormat: '<small>{point.key}</small><table>',
//		        	pointFormat: '<tr><td style="color: {series.color};">{series.name}: &nbsp;</td>' +
//		        	       '<td style="text-align: right"><b>{point.y}</b>'+index+'&nbsp;</td></tr>',
//		        	footerFormat: '</table>',
//		        	valueDecimals: decimals //数据值保留小数位数
		        	formatter : function() {	//标签格式化
		        		return '<font style="font-size: 11px;">'+this.x +'</font><br/>● '+ this.series.name +':'+ this.y + index;
		        	}
		        },
		        plotOptions: {
		        	column : {
						// pointPadding: 0.23,
						borderWidth : 1,
						events : {
							legendItemClick : function(event) {
								return false;
							}
						}
					}
		        },
		        credits : {
					enabled : false
				},
				xAxis : {
			       categories : data.x
					              
				},
				yAxis : [
						{ // Primary yAxis
							title : {
								text : null,
								style : {
									color : '#89A54E'
								}
							},
							labels : {
								formatter : function() {
									if(this.value >=0){
										return Highcharts.numberFormat(
												this.value, 2)+index;
									}
									
								},
								style : {
									color : '#89A54E'
								}
							}
						}],
				/*legend: {
		            layout: 'vertical',
		            y:40,
		            verticalAlign: 'buttom',
		            backgroundColor: '#FFFFFF'
		        },*/
		        series: data.loadRightTop
			});
		}, 'json');
  }
 /*
  *下面的柱状图 
  */
 var buttomColumnChart;
 function loadButtom(path,condition,text){
	 debugger;
	 var color=[ '#14f5a2','#ed6e29', '#b72cea', '#417CBD','#89A54E', '#cd0a94', '#9e13d1', '#11a53b', '#2c17c8'];
		var color1; 
		var color2;
		var text;
		var name;
		var index;
		var decimals;
		if(condition=='landCount'){
			color1=color[0];
			color2=color[1];
			text=text;
			name='宗数';
			index='宗';
			decimals=0;
		}
		if(condition=='sellArea'){
			color1=color[3];
			color2=color[4];
			text=text;
			name='面积';
			index='亩';
			decimals=0;
		}
		if(condition=='contractMoney'){
			color1=color[2];
			color2=color[7];
			text=text;
			name='金额';
			index='亿元';
			decimals=2;
		}
		$.post(path+'/landMarket/loadButtom.do','condition='+condition, function(data) {
			buttomColumnChart = new Highcharts.Chart({ 
		        chart: { 
		        	type: 'column',
		            renderTo: 'buttonRightContrainer' //图表放置的容器，关联DIV#id 
		           
		            //因为是柱状图和曲线图共存在一个图表中，所以默认图表类型不在这里设置。 
		        },
		        colors: [color1,color2],
		        title: { 
		            text: data.titleName //图表标题 
		        }, 
		        credits: { 
		            enabled: false   //不显示LOGO 
		        }, 
		        xAxis: [{ //X轴标签 
		            categories:data.companyName, 
		            labels: { 
		                rotation: -45,  //逆时针旋转45°，标签名称太长。 
		                align: 'right' , //设置右对齐 
		                overflow: 'justify',
		                formatter:function(){
		                	return "<span>"+this.value.substr(0, 4) + "..";
		                }
		            } 
		        }], 
		        yAxis: { //设置Y轴-第一个（增幅） 
		        	title : {
						text : null,
						style : {
							color : '#89A54E'
						}
					},
		            labels: { 
		                formatter: function() { //格式化标签名称 
		                    return this.value + index; 
		                }, 
		                style: { 
		                    color: '#89A54E' //设置标签颜色 
		                } 
		            }
		        }, 
		        legend: {
					enabled: false
				},
		        tooltip: { //鼠标滑向数据区显示的提示框 
		        	formatter : function() {	//标签格式化
		        		return '<font style="font-size: 11px;">'+this.x +'</font><br/>● '+ this.series.name +':'+ this.y + index;
		        	}
		        }, 
		        series: data.series
		    }); 
	});
}