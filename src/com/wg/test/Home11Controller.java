package com.wg.test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	@RequestMapping("testModelattribute")
	public ModelAndView testModelattribute(HttpServletRequest request,@ModelAttribute("getString") String str) {
		// 创建模型跟视图，用于渲染页面。并且指定要返回的页面为home页面
		System.out.println(str);
		return new ModelAndView("succ");
	}
	
	
}