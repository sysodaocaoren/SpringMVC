package com.wg.test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * ����modelAttribute��ǩ
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
	 * ��ҳ ������/page/home.jspҳ��
	 * 
	 * @return
	 */
	@RequestMapping("testModelattribute")
	public ModelAndView testModelattribute(HttpServletRequest request,@ModelAttribute("getString") String str) {
		// ����ģ�͸���ͼ��������Ⱦҳ�档����ָ��Ҫ���ص�ҳ��Ϊhomeҳ��
		System.out.println(str);
		return new ModelAndView("succ");
	}
	
	
}