package com.wg.test;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.common.config.commonClass.BaseController;
import com.wg.bean.User;
import com.wg.service.UserService;

@Controller
public class UserController extends BaseController{

	@Autowired
	private UserService userService;

	@RequestMapping("regist/{id}")
	public ModelAndView regist(@PathVariable("id") String id,
								@RequestParam("id") String paramsId,
								@RequestHeader ( "Host" ) String hostAddr,
								//@CookieValue("age") String age,
								HttpServletRequest request,HttpServletResponse response, User user) {
		try {
			userService.saveUser(user);
			Cookie cookie=new Cookie("age","123");
			response.addCookie(cookie);
			System.out.println(id);
			System.out.println(paramsId);
			System.out.println(hostAddr);
			System.out.println(user.getUsername());
			//System.out.println("age="+age);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("username", user.getUsername());
		request.setAttribute("password", user.getPassword());
		System.out.println(user.toString());
		return new ModelAndView("succ");
	}

	/***
	 * 用户登陆
	 * <p>
	 * 注解配置，只允许POST提交到该方法
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("login")
	public ModelAndView login(HttpServletRequest request,
			 User user,@CookieValue(value="age",defaultValue="") String age) {
		// 验证传递过来的参数是否正确，否则返回到登陆页面。
		// 指定要返回的页面为succ.jsp
		ModelAndView mav = new ModelAndView("succ");
		// 将参数返回给页面
		mav.addObject("username", 111);
		mav.addObject("password", 222);
		System.out.println(age);
		System.out.println("username=" + 11 + " password=" + 222);
		return mav;
	}
	
	@RequestMapping("toLogin")
	public ModelAndView toLogin(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	@RequestMapping("toAngularjs")
	public ModelAndView toAngularjs(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("AngularJS/test001");
		return mav;
	}
	
	/***
	 * 验证参数是否为空
	 * 
	 * @param params
	 * @return
	 */
	private boolean checkParams(String[] params) {
		for (String param : params) {
			if (param == "" || param == null || param.isEmpty()) {
				return false;
			}
		}
		return true;
	}
}
