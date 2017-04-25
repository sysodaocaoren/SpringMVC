package com.common.config.forward;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ForwardController {
	@RequestMapping("forward")
	public ModelAndView forwardController(HttpServletRequest request,
			ModelAndView model,@RequestParam("page")String pageName){
		return new ModelAndView(pageName);
	}
}
