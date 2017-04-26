package com.wg.test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wg.bean.User;

/**
 * 测试modelAttribute标签
 * @author Administrator
 * 1.@ModelAttribute
	 public User getString(){
		User user=new User();
		user.setUsername("1234321");
		return user;
	 }
	这种写法在这个controller里面调任何方法都会调这个方法，在前台${user.username}能获取到1234321 
   2.@ModelAttribute("useruser")
	 public User getString(){
		User user=new User();
		user.setUsername("1234321");
		return user;
	 }
	这种写法zaicontroller里面调用任何方法都是调用这个方法，1.在前台$(useruser.username)嫩获取到1234431 
	      2.可以在其他方法注解中@ModelAttribute("useruser") User user获取到这个值
 *
 */

@Controller
public class Home11Controller {
    
	@ModelAttribute("useruser")
	public User getString(){
		User user=new User();
		user.setUsername("1234321");
		return user;
	}
	/***
	 * 首页 返回至/page/home.jsp页面
	 * 
	 * @return
	 */
	@RequestMapping("testModelattribute")
	public String testModelattribute(HttpServletRequest request,@ModelAttribute("useruser") User user) {
		// 创建模型跟视图，用于渲染页面。并且指定要返回的页面为home页面
		return "succ";
	}
	
	
}