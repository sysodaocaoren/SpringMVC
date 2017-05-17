package com.test.transactional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("testtrant")
public class TestTransactionalController {
	
	@Resource
	private TestTransactionalService testTransactionalService;
	
	@RequestMapping("testdo")
	public String testdo(){
//		this.testTransactionalService.testdo();
//		this.testTransactionalService.testdo2();
//		this.testTransactionalService.testDelete();
//		this.testTransactionalService.testInsert();
//		this.testTransactionalService.TestMore();
		this.testTransactionalService.testRollback();
		
		return "succ";
	}
}
