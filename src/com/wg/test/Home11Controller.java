package com.wg.test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wg.bean.User;

/**
 * ����modelAttribute��ǩ
 * @author Administrator
 * 1.@ModelAttribute
	 public User getString(){
		User user=new User();
		user.setUsername("1234321");
		return user;
	 }
	����д�������controller������κη�������������������ǰ̨${user.username}�ܻ�ȡ��1234321 
   2.@ModelAttribute("useruser")
	 public User getString(){
		User user=new User();
		user.setUsername("1234321");
		return user;
	 }
	����д��zaicontroller��������κη������ǵ������������1.��ǰ̨$(useruser.username)�ۻ�ȡ��1234431 
	      2.��������������ע����@ModelAttribute("useruser") User user��ȡ�����ֵ
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
	 * ��ҳ ������/page/home.jspҳ��
	 * 
	 * @return
	 */
	@RequestMapping("testModelattribute")
	public String testModelattribute(HttpServletRequest request,@ModelAttribute("useruser") User user) {
		// ����ģ�͸���ͼ��������Ⱦҳ�档����ָ��Ҫ���ص�ҳ��Ϊhomeҳ��
		return "succ";
	}
	
	
}