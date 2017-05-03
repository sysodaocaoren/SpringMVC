package com.onlineMarket.business.util.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TestDataTableController {
	
	@RequestMapping("testDataPage")
	public String testDataPage(){
		return "testpage/testDataTable";
	}
}
