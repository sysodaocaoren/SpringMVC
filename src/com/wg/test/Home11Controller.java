package com.wg.test;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试modelAttribute标签
 * @author Administrator
 *
 */

@Controller
public class Home11Controller {
    
	@ModelAttribute("getString")
	public String getString(){
		return "111111";
	}
	/***
	 * 首页 返回至/page/home.jsp页面
	 * 
	 * @return
	 */
	@RequestMapping("hello111")
	public void index(HttpRequest request,@ModelAttribute("getString") String str) {
		// 创建模型跟视图，用于渲染页面。并且指定要返回的页面为home页面
		System.out.println(str);
	}
	
	
}