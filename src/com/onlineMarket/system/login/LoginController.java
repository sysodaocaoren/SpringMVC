package com.onlineMarket.system.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	/**
	 * 进入登陆界面
	 * @author zhuyumeng
	 *
	 */
	@RequestMapping("tologin2")
	public ModelAndView tologin(){
		return new ModelAndView ("005/index");
	}
	/**
	 * 登陆成功，跳转
	 * @author zhuyumeng
	 *
	 */
	@RequestMapping("login2")
	public ModelAndView login(){
		return new ModelAndView ("005/dashboard");
	}
	/**
	 * 查询，测试分页查询
	 * @author zhuyumeng
	 *
	 */
	@RequestMapping("testPage")
	public ModelAndView testPage(){
		return new ModelAndView ("005/dashboard");
	}
}
