//首页js方法
var fullYear = new Date().getFullYear();
/*
 *年度收益综合分析图
 */
var chart;
function loadAnnualSummary(url){
	/* 创建图表 start */
	$.post(url +'/deskTop/loadAnnualSummary.do', function(data) {
		//alert(data.series);
						if (data.years.length == 0) {		//判断是否存在数据
							$("#container").html("<b style='position:absolute;top:40%;left:50%;'>没有数据!</b>");
							return;
						}
						//循环处理线条颜色、填充色、线条宽度
						for ( var i = 0; i < data.series.length; i++) {
							var sery = data.series[i];
							if (sery.type == 'spline') {
								sery.marker = {
									lineWidth : 2,
									lineColor : Highcharts.getOptions().colors[3],		//从那里取出来的
									fillColor : 'white'
								};
								sery.yAxis = 1;  		//设置y轴数
							}
						}

						chart = new Highcharts.Chart({  //实例化绑定容器
							chart : {
								ignoreHiddenSeries : false,  //不显示坐标轴
								renderTo : 'container',   //ID
								style : {					//图表宽度、高度设置
									width : '100%',
									height : '100%'
								},
								backgroundColor : '#FFFFFF'  //图表背景色设置
							},
							colors:[ '#6AF9C4','#c1e2fb', '#FF9655', '#FF391E','#64E572', '#FF391E' ],
							title : {
								floating : true,    //是否浮动
								y : 25,				//竖直方向偏移
								text : '年度综合收支分析图（亿元）',
								style : {
									fontSize : '12px'
								}
							},
							xAxis : {			//设置x轴数据
								categories : data.years
							},
							yAxis : [			//设置y轴数据、标题、样式等
									{ // Primary yAxis
										title : {
											text : '金额',
											style : {
												color : '#89A54E'
											}
										},
										labels : {  //设置y轴各分类名称的样式style，格式formatter，角度rotation等。
											formatter : function() {
												return Highcharts.numberFormat(
														this.value, 1)
														+ '亿元';
											},
											style : {
												color : '#89A54E'
											}
										}
									}, { // Secondary yAxis
										title : {
											text : '数量',
											style : {
												color : '#4572A7'
											}
										},
										labels : {
											formatter : function() {
												return Highcharts.numberFormat(
														this.value, 0)
														+ '个';
											},
											style : {
												color : '#4572A7'
											}
										},
										opposite : true
									} ],
							tooltip : {      //设置提示框
								formatter : function() {	//标签格式化
									if (this.series.type == 'column') {
										return '<b>'
												+ this.x
												+ this.series.name
												+ ':'
												+ Highcharts.numberFormat(this.y, 2) + '亿元</b>';
									} else {
										return '<b>' + this.x + '</b>: '
												+ this.y + '个';
									}
								}
							},
							plotOptions : {  //绘图线条控制
								spline : {// 禁用线的图裂点击
									events : {
										legendItemClick : function(event) {
											return false;
										}
									}
								},
								column : {
									// pointPadding: 0.23,
									borderWidth : 0,
									events : {
										legendItemClick : function(event) {
											return false;
										}
									}
								}
							},
							 credits : {         //版权信息
									enabled : false
								},
							series : data.series    //y轴数据
						});
					}, 'json');
}
/*
 * 月度收支分析
 */
var chartIncome;
function loadIncome (url){
	//debugger;
	$.post(url +'/deskTop/loadIncome.do', function(data) {
		//alert(this.value);
		chartIncome = new Highcharts.Chart({
			chart : {
				ignoreHiddenSeries : false,  //是否隐藏图表数据
				renderTo : 'containerIncome',
				style : {
					width : '100%',
					height : '100%'
				},
				backgroundColor : '#FFFFFF'
			},
			colors : [ '#64E572', '#FF9655', '#64E572','#FFF263', '#6AF9C4' ],
			title : {
				floating : true,		//是否浮动
				y : 25,					
				text : fullYear+'年度月度收支分析',
				style : {
					fontSize : '16px'
				}
			},
			xAxis : {
				categories : data.months
			},
			yAxis : { // Primary yAxis
				title : {
					text : '金额',
					style : {
						color : '#89A54E'
					}
				},
				labels : {
					formatter : function() {
						if(this.value / 100000000 >=0){
							return Highcharts.numberFormat(this.value / 100000000,
									2)
									+ '亿元';
						}
						
					},
					style : {
						color : '#89A54E'
					}
				}
			},
			tooltip : {
				formatter : function() {
					return '<b>'
							+ Highcharts.numberFormat(this.y / 100000000, 3)
							+ '亿元</b> '
				}
			},
			legend : {     //图例说明
				layout : 'vertical',
				align : 'right',
				verticalAlign : 'middle',
				borderWidth : 0
			},
			credits : {
				enabled : false
			},
			series : data.seriesIncome
		});
	},'json');
}
/*
 * 综合应收尽收进度
 */

var charPlan;
function loadPlan(url,currNum){
	debugger;
	$.post(url+'/deskTop/loadPlan.do', function(data) {
		$('#totalContainer').append('<div id="gauge0" style="position:relative;width:20%;height:50%;"></div>');
		charPlan = new Highcharts.Chart({
			chart : {
				type : 'gauge',
				plotBackgroundColor: null,
	            plotBackgroundImage: null,
	            plotBorderWidth: 0,
	            renderTo : 'gauge0',		 //指定显示图表区域
	            plotShadow: false
			},
			title : {
				text : '年度综合应收尽收进度',
				style : {
					fontSize : '14px',
					margin : 2,
				},
				x : 10,
				align:'center'
			},
			credits: {			//版权信息
           	 text: ' ',
        	 href: ' '
			},
			pane : {
				startAngle : -150,
				endAngle : 150,
				background : [ {
					backgroundColor : '#FFFFFF'
				} ],
				center : [ "50%", "45%" ]
			},
			yAxis : {
				min : 0,
				max : 100,
				plotBands : [ {
					from : 0,
					to :40,
					color : '#FF391E' // green#64E572
				}, {
					from :40,
					to : 70,
					color : '#FFFF14' // yellow
				}, {
					from : 70,
					to : 100,
					color : '#64E572' // red
				} ]
			},
			series : [{
				name : ['speed'],
				data : [data[0].ratio]
			}]
		},
		function (chart) {
            if (!chart.renderer.forExport) {
                setInterval(function () {
                	
                }, 3000);
            }
        });
		if(currNum==undefined || currNum=="1"){
			$('#containerPlan1').empty();
			for (var i = 1; i < 3; i++) {
				$('#containerPlan1').append( '<div id="gauge'+ i + '" style="position:relative;float:left;width:33%;height:100%;margin-left:20px;margin-right:20px;" ></div>');
				charPlan = new Highcharts.Chart({
					chart : {
						type : 'gauge',
						plotBackgroundColor: null,
			            plotBackgroundImage: null,
			            plotBorderWidth: 0,
			            renderTo : 'gauge' + i,		 //指定显示图表区域
			            plotShadow: false,
			            style : {
							width : '100%',
							height : '100%'
						}
					},
					title : {
						text : data[i].curmainName,
						style : {
							fontSize : '12px',
							marginButtom:10,
							margin : 2,
						},
						y : 50,
						align:'center'
					},
					credits: {			//版权信息
			           	 text: ' ',
			        	 href: ' '
					},
					pane : {
						startAngle : -150,
						endAngle : 150,
						background : [ {
							backgroundColor : '#FFFFFF'
						} ],
						center : [ "55%", "50%" ]
					},
					yAxis : {
						min : 0,
						max : 100,

						minorTickInterval : 'auto',
						minorTickWidth : 1,
						minorTickLength : 10,
						minorTickPosition : 'inside',
						minorTickColor : '#666',

						tickPixelInterval : 30,
						tickWidth : 2,
						tickPosition : 'inside',
						tickLength : 10,
						tickColor : '#666',
						labels : {
							step : 2,
							rotation : 'auto'
						},

						plotBands : [ {
							from : 0,
							to :40,
							color : '#FF391E' // green#64E572
						}, {
							from :40,
							to : 70,
							color : '#FFFF14' // yellow
						}, {
							from : 70,
							to : 100,
							color : '#64E572' // red
						} ]
					},
					series : [{
						name : ['speed'],
						data : [data[i].ratio]
					}]
				},
				function (chart) {
		            if (!chart.renderer.forExport) {
		                setInterval(function () {
		                	
		                }, 3000);
		            }
		        });
			}
		}
		//3-5
		if(currNum!=undefined && currNum=="2"){
			$('#containerPlan1').empty();
			for (var i = 3; i < 5; i++) {
				$('#containerPlan1') .append( '<div id="gauge'+ i + '" style="position:relative;float:left;width:33%;height:100%;margin-left:20px;margin-right:20px;" ></div>');
				charPlan = new Highcharts.Chart({
					chart : {
						type : 'gauge',
						plotBackgroundColor: null,
			            plotBackgroundImage: null,
			            plotBorderWidth: 0,
			            renderTo : 'gauge' + i,		 //指定显示图表区域
			            plotShadow: false,
			            style : {
							width : '100%',
							height : '100%'
						}
					},
					title : {
						text : data[i].curmainName,
						style : {
							fontSize : '12px',
							marginButtom:10,
							margin : 2,
						},
						y : 55,
						align:'center'
					},
					credits: {			//版权信息
			           	 text: ' ',
			        	 href: ' '
					},
					pane : {
						startAngle : -150,
						endAngle : 150,
						background : [ {
							backgroundColor : '#FFFFFF'
						} ],
						center : [ "55%", "50%" ]
					},
					yAxis : {
						min : 0,
						max : 100,

						minorTickInterval : 'auto',
						minorTickWidth : 1,
						minorTickLength : 10,
						minorTickPosition : 'inside',
						minorTickColor : '#666',

						tickPixelInterval : 30,
						tickWidth : 2,
						tickPosition : 'inside',
						tickLength : 10,
						tickColor : '#666',
						labels : {
							step : 2,
							rotation : 'auto'
						},

						plotBands : [ {
							from : 0,
							to :40,
							color : '#FF391E' // green#64E572
						}, {
							from :40,
							to : 70,
							color : '#FFFF14' // yellow
						}, {
							from : 70,
							to : 100,
							color : '#64E572' // red
						} ]
					},
					series : [{
						name : ['speed'],
						data : [data[i].ratio]
					}]
				},
				function (chart) {
		            if (!chart.renderer.forExport) {
		                setInterval(function () {
		                	
		                }, 3000);
		            }
		        });
			}
		}
		//5-7
		if(currNum!=undefined && currNum=="3"){
			$('#containerPlan1').empty();
			for (var i = 5; i < 7; i++) {
				$('#containerPlan1') .append( '<div id="gauge'+ i + '" style="position:relative;float:left;width:33%;height:100%;margin-left:20px;margin-right:20px;" ></div>');
				charPlan = new Highcharts.Chart({
					chart : {
						type : 'gauge',
						plotBackgroundColor: null,
			            plotBackgroundImage: null,
			            plotBorderWidth: 0,
			            renderTo : 'gauge' + i,		 //指定显示图表区域
			            plotShadow: false,
			            style : {
							width : '100%',
							height : '100%'
						}
					},
					title : {
						text : data[i].curmainName,
							style : {
								fontSize : '12px',
								marginButtom:10,
								margin : 2,
							},
							y : 50
					},
					credits: {			//版权信息
			           	 text: ' ',
			        	 href: ' '
					},
					pane : {
						startAngle : -150,
						endAngle : 150,
						background : [ {
							backgroundColor : '#FFFFFF'
						} ],
						center : [ "55%", "50%" ]
					},
					yAxis : {
						min : 0,
						max : 100,

						minorTickInterval : 'auto',
						minorTickWidth : 1,
						minorTickLength : 10,
						minorTickPosition : 'inside',
						minorTickColor : '#666',

						tickPixelInterval : 30,
						tickWidth : 2,
						tickPosition : 'inside',
						tickLength : 10,
						tickColor : '#666',
						labels : {
							step : 2,
							rotation : 'auto'
						},

						plotBands : [ {
							from : 0,
							to :40,
							color : '#FF391E' // green#64E572
						}, {
							from :40,
							to : 70,
							color : '#FFFF14' // yellow
						}, {
							from : 70,
							to : 100,
							color : '#64E572' // red
						} ]
					},
					series : [{
						name : ['speed'],
						data : [data[i].ratio]
					}]
				},
				function (chart) {
		            if (!chart.renderer.forExport) {
		                setInterval(function () {
		                	
		                }, 3000);
		            }
		        });
			}
		}
		//7-9
		if(currNum!=undefined && currNum=="4"){
			$('#containerPlan1').empty();
			for (var i = 7; i < 9; i++) {
				$('#containerPlan1') .append( '<div id="gauge'+ i + '" style="position:relative;float:left;width:33%;height:100%;margin-left:20px;margin-right:20px;" ></div>');
				charPlan = new Highcharts.Chart({
					chart : {
						type : 'gauge',
						plotBackgroundColor: null,
			            plotBackgroundImage: null,
			            plotBorderWidth: 0,
			            renderTo : 'gauge' + i,		 //指定显示图表区域
			            plotShadow: false,
			            style : {
							width : '100%',
							height : '100%'
						}
					},
					title : {
						text : data[i].curmainName,
							style : {
								fontSize : '12px',
								marginButtom:10,
								margin : 2,
							},
							y : 50
					},
					credits: {			//版权信息
			           	 text: ' ',
			        	 href: ' '
					},
					pane : {
						startAngle : -150,
						endAngle : 150,
						background : [ {
							backgroundColor : '#FFFFFF'
						} ],
						center : [ "55%", "50%" ]
					},
					yAxis : {
						min : 0,
						max : 100,

						minorTickInterval : 'auto',
						minorTickWidth : 1,
						minorTickLength : 10,
						minorTickPosition : 'inside',
						minorTickColor : '#666',

						tickPixelInterval : 30,
						tickWidth : 2,
						tickPosition : 'inside',
						tickLength : 10,
						tickColor : '#666',
						labels : {
							step : 2,
							rotation : 'auto'
						},

						plotBands : [ {
							from : 0,
							to :40,
							color : '#FF391E' // green#64E572
						}, {
							from :40,
							to : 70,
							color : '#FFFF14' // yellow
						}, {
							from : 70,
							to : 100,
							color : '#64E572' // red
						} ]
					},
					series : [{
						name : ['speed'],
						data : [data[i].ratio]
					}]
				},
				function (chart) {
		            if (!chart.renderer.forExport) {
		                setInterval(function () {
		                	
		                }, 3000);
		            }
		        });
			}
		}
		//9-11
		if(currNum!=undefined && currNum=="5"){
			$('#containerPlan1').empty();
			for (var i = 9; i < 11; i++) {
				$('#containerPlan1') .append( '<div id="gauge'+ i + '" style="position:relative;float:left;width:33%;height:100%;margin-left:20px;margin-right:20px;" ></div>');
				charPlan = new Highcharts.Chart({
					chart : {
						type : 'gauge',
						plotBackgroundColor: null,
			            plotBackgroundImage: null,
			            plotBorderWidth: 0,
			            renderTo : 'gauge' + i,		 //指定显示图表区域
			            plotShadow: false,
			            style : {
							width : '100%',
							height : '100%'
						}
					},
					title : {
						text : data[i].curmainName,
							style : {
								fontSize : '12px',
								marginButtom:10,
								margin : 2,
							},
							y : 50
					},
					credits: {			//版权信息
			           	 text: ' ',
			        	 href: ' '
					},
					pane : {
						startAngle : -150,
						endAngle : 150,
						background : [ {
							backgroundColor : '#FFFFFF'
						} ],
						center : [ "55%", "50%" ]
					},
					yAxis : {
						min : 0,
						max : 100,

						minorTickInterval : 'auto',
						minorTickWidth : 1,
						minorTickLength : 10,
						minorTickPosition : 'inside',
						minorTickColor : '#666',

						tickPixelInterval : 30,
						tickWidth : 2,
						tickPosition : 'inside',
						tickLength : 10,
						tickColor : '#666',
						labels : {
							step : 2,
							rotation : 'auto'
						},

						plotBands : [ {
							from : 0,
							to :40,
							color : '#FF391E' // green#64E572
						}, {
							from :40,
							to : 70,
							color : '#FFFF14' // yellow
						}, {
							from : 70,
							to : 100,
							color : '#64E572' // red
						} ]
					},
					series : [{
						name : ['speed'],
						data : [data[i].ratio]
					}]
				},
				function (chart) {
		            if (!chart.renderer.forExport) {
		                setInterval(function () {
		                	
		                }, 3000);
		            }
		        });
			}
		}
		//11-13
		if(currNum!=undefined && currNum=="6"){
			$('#containerPlan1').empty();
			for (var i = 11; i < 13; i++) {
				$('#containerPlan1') .append( '<div id="gauge'+ i + '" style="position:relative;float:left;width:33%;height:100%;margin-left:20px;margin-right:20px;" ></div>');
				charPlan = new Highcharts.Chart({
					chart : {
						type : 'gauge',
						plotBackgroundColor: null,
			            plotBackgroundImage: null,
			            plotBorderWidth: 0,
			            renderTo : 'gauge' + i,		 //指定显示图表区域
			            plotShadow: false,
			            style : {
							width : '100%',
							height : '100%'
						}
					},
					title : {
						text : data[i].curmainName,
							style : {
								fontSize : '12px',
								marginButtom:10,
								margin : 2,
							},
							y : 50
					},
					credits: {			//版权信息
			           	 text: ' ',
			        	 href: ' '
					},
					pane : {
						startAngle : -150,
						endAngle : 150,
						background : [ {
							backgroundColor : '#FFFFFF'
						} ],
						center : [ "55%", "50%" ]
					},
					yAxis : {
						min : 0,
						max : 100,

						minorTickInterval : 'auto',
						minorTickWidth : 1,
						minorTickLength : 10,
						minorTickPosition : 'inside',
						minorTickColor : '#666',

						tickPixelInterval : 30,
						tickWidth : 2,
						tickPosition : 'inside',
						tickLength : 10,
						tickColor : '#666',
						labels : {
							step : 2,
							rotation : 'auto'
						},

						plotBands : [ {
							from : 0,
							to :40,
							color : '#FF391E' // green#64E572
						}, {
							from :40,
							to : 70,
							color : '#FFFF14' // yellow
						}, {
							from : 70,
							to : 100,
							color : '#64E572' // red
						} ]
					},
					series : [{
						name : ['speed'],
						data : [data[i].ratio]
					}]
				},
				function (chart) {
		            if (!chart.renderer.forExport) {
		                setInterval(function () {
		                	
		                }, 3000);
		            }
		        });
			}
		}
		//13-data.length
		if(currNum!=undefined && currNum=="7"){
			$('#containerPlan1').empty();
			for (var i = 13; i < data.length; i++) {
				$('#containerPlan1') .append( '<div id="gauge'+ i + '" style="position:relative;float:left;width:33%;height:100%;margin-left:20px;margin-right:20px;" ></div>');
				charPlan = new Highcharts.Chart({
					chart : {
						type : 'gauge',
						plotBackgroundColor: null,
			            plotBackgroundImage: null,
			            plotBorderWidth: 0,
			            renderTo : 'gauge' + i,		 //指定显示图表区域
			            plotShadow: false,
			            style : {
							width : '100%',
							height : '100%'
						}
					},
					title : {
						text : data[i].curmainName,
							style : {
								fontSize : '12px',
								marginButtom:10,
								margin : 2,
							},
							y : 50
					},
					credits: {			//版权信息
			           	 text: ' ',
			        	 href: ' '
					},
					pane : {
						startAngle : -150,
						endAngle : 150,
						background : [ {
							backgroundColor : '#FFFFFF'
						} ],
						center : [ "55%", "50%" ]
					},
					yAxis : {
						min : 0,
						max : 100,

						minorTickInterval : 'auto',
						minorTickWidth : 1,
						minorTickLength : 10,
						minorTickPosition : 'inside',
						minorTickColor : '#666',

						tickPixelInterval : 30,
						tickWidth : 2,
						tickPosition : 'inside',
						tickLength : 10,
						tickColor : '#666',
						labels : {
							step : 2,
							rotation : 'auto'
						},

						plotBands : [ {
							from : 0,
							to :40,
							color : '#FF391E' // green#64E572
						}, {
							from :40,
							to : 70,
							color : '#FFFF14' // yellow
						}, {
							from : 70,
							to : 100,
							color : '#64E572' // red
						} ]
					},
					series : [{
						name : ['speed'],
						data : [data[i].ratio]
					}]
				},
				function (chart) {
		            if (!chart.renderer.forExport) {
		                setInterval(function () {
		                	
		                }, 3000);
		            }
		        });
			}
		}
	}, 'json');
}
/*
 * 地王表查询
 */
var searchCharts;
function loadSearchLandKing(url,condition){
	$.post(url+'/deskTop/loadSearchLandKing.do','condition='+condition, function(data) {
		searchCharts = new Highcharts.Chart({
			chart : {
				ignoreHiddenSeries : false,
				renderTo : 'searchLandKing',
				style : {
					width : '100%',
					height : '100%'
				},
				type : 'bar',
				backgroundColor : '#FFFFFF'
			},

			title : {
				text : data.titleName,
				style : {
					fontSize : '12px'
				}
			},
			subtitle : {
				text : ''
			},
			xAxis : {
				categories : data.companyName,
				labels : {
					formatter : function() {
						// 获取到刻度值
						var labelVal = this.value;
						// 实际返回的刻度值
						var reallyVal = labelVal;
						// 判断刻度值的长度
						if (labelVal.length > 10) {
						/*	var lineCount=Math.floor(labelVal.length/10);
							for(var i=0;i<=lineCount;i++){
								if(i==lineCount){
									reallyVal=reallyVal+labelVal.substr(10*i, labelVal.length)+ "<br/>";
								}else{
									reallyVal=reallyVal+labelVal.substr(10*i, 10*(i+1))+ "<br/>";
								}
							}*/
							// 截取刻度值
							reallyVal ="<span>"+labelVal.substr(0, 9) + "..";
									//+ labelVal.substring(10, labelVal.length)+"</span>";
									//+labelVal.substring(20, labelVal.length);
						}
						return reallyVal;
					}
				},
				
			},
			yAxis : {
				min : 0,
				title : {
					text : '       ',
					align : 'high'
				},
				labels : {
					overflow : 'justify',
					text : '',
					formatter : function() {
						return this.value; 
					}

				},
				style : {
					fontSize : '8px'
				}
			},
			/*
			 * tooltip: { valueSuffix: '亿元', },
			 */

			plotOptions : {
				bar : {
					dataLabels : {
						enabled : true,
						formatter : function() {
							
							return this.value;
						}
					},
					showInLegend : true,
					size:180
				},
				series : {
					colorByPoint : true
				}
			},
			credits : {
				enabled : false
			},
			series : data.series
		});
	}, 'json');
}