package com.test.testToken;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.config.persDefAnnotation.Token;


/**
 * ≤‚ ‘token∑¿÷π÷ÿ∏¥Ã·Ωª
 * @author zhuyumeng
 *
 */
@Controller
@RequestMapping("testToken")
public class TestTokenController {
	
	@RequestMapping("toPage")
	@Token(save=true)
	public String toTestTokenPage(HttpServletRequest request){
		return "testToken/test11";
	}
	
	@RequestMapping("testCommits")
	@Token(remove=true)
	public void  testCommits(HttpServletRequest request){
		System.out.println("---------------------success-------------------------");
	}
}
