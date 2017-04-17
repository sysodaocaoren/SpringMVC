package com.wg.test;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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
	@RequestMapping("hello111")
	public void index(HttpRequest request,@ModelAttribute("getString") String str) {
		// ����ģ�͸���ͼ��������Ⱦҳ�档����ָ��Ҫ���ص�ҳ��Ϊhomeҳ��
		System.out.println(str);
	}
	
	
}