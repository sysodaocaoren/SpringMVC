
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
					x : 10
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
				center : [ "50%", "60%" ]
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
			for (var i = 1; i < 4; i++) {
				$('#containerPlan1').append( '<div id="gauge'+ i + '" style="position:relative;float:left;width:33%;height:100%;" ></div>');
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
		//4-7
		if(currNum!=undefined && currNum=="2"){
			$('#containerPlan1').empty();
			for (var i = 4; i < 7; i++) {
				$('#containerPlan1') .append( '<div id="gauge'+ i + '" style="position:relative;float:left;width:33%;height:100%;" ></div>');
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
		if(currNum!=undefined && currNum=="3"){
			$('#containerPlan1').empty();
			for (var i = 7; i < 10; i++) {
				$('#containerPlan1') .append( '<div id="gauge'+ i + '" style="position:relative;float:left;width:33%;height:100%;" ></div>');
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
		//10-13
		if(currNum!=undefined && currNum=="4"){
			$('#containerPlan1').empty();
			for (var i = 10; i < 13; i++) {
				$('#containerPlan1') .append( '<div id="gauge'+ i + '" style="position:relative;float:left;width:33%;height:100%;" ></div>');
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
		if(currNum!=undefined && currNum=="5"){
			$('#containerPlan1').empty();
			for (var i = 13; i < data.length; i++) {
				$('#containerPlan1') .append( '<div id="gauge'+ i + '" style="position:relative;float:left;width:33%;height:100%;" ></div>');
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