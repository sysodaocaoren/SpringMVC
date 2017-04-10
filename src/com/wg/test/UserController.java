package com.wg.test;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.wg.bean.User;
import com.wg.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("regist")
	public ModelAndView regist(HttpServletRequest request, User user) {
		try {
			userService.saveUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("username", user.getUsername());
		request.setAttribute("password", user.getPassword());
		System.out.println(user.toString());
		return new ModelAndView("succ");
	}

	/***
	 * �û���½
	 * <p>
	 * ע�����ã�ֻ����POST�ύ���÷���
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("login")
	public ModelAndView login(String username, String password) {
		// ��֤���ݹ����Ĳ����Ƿ���ȷ�����򷵻ص���½ҳ�档
		if (this.checkParams(new String[] { username, password })) {
			// ָ��Ҫ���ص�ҳ��Ϊsucc.jsp
			ModelAndView mav = new ModelAndView("succ");
			// ���������ظ�ҳ��
			mav.addObject("username", username);
			mav.addObject("password", password);
			System.out
					.println("username=" + username + " password=" + password);
			return mav;
		}
		return new ModelAndView("testtag");
	}

	/***
	 * ��֤�����Ƿ�Ϊ��
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