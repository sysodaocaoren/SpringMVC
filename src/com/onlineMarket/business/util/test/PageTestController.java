package com.onlineMarket.business.util.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.onlineMarket.business.util.page.Page;

@Controller
public class PageTestController {
	@Autowired 
	PageTestServices pageTestServices;
	
	@RequestMapping("listPageTest")
	public ModelAndView pageList(ModelMap model,Page page){
		List<PageTest> tests=pageTestServices.list(page);
		model.put("testList", tests);
		model.put("pageobj", page);
		return new ModelAndView("testpage/pageList",model);
	}
	
	@RequestMapping("testBootstrap")
	public ModelAndView testBootstrap(ModelMap model){
		return new ModelAndView("testpage/testBootstrap",model);
	}
}
