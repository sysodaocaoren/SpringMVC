package com.onlineMarket.system.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	/**
	 * �����½����
	 * @author zhuyumeng
	 *
	 */
	@RequestMapping("tologin2")
	public ModelAndView tologin(){
		return new ModelAndView ("005/index");
	}
	/**
	 * ��½�ɹ�����ת
	 * @author zhuyumeng
	 *
	 */
	@RequestMapping("login2")
	public ModelAndView login(){
		return new ModelAndView ("005/dashboard");
	}
	/**
	 * ��ѯ�����Է�ҳ��ѯ
	 * @author zhuyumeng
	 *
	 */
	@RequestMapping("testPage")
	public ModelAndView testPage(){
		return new ModelAndView ("005/dashboard");
	}
}
