package com.test.ehcache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("testCache")
public class TestCacheController {
	
	@Autowired
	private TestCacheService testCacheService;
	/**
	 * �����Ļ���
	 */
	@RequestMapping("test1")
	public void test1(){
		String name="����";
		String key ="23";
		String result=testCacheService.test1(name);
		String result11=testCacheService.test11(name,key);
		System.out.println("TestCacheController.test1:"+result);
		System.out.println("TestCacheController.test11:"+result11);
	}
	/**
	 * ����ָ������
	 */
	@RequestMapping("test2")
	public void test2(){
		String name="����";
		String result2=testCacheService.test2(name);
		System.out.println("TestCacheController.test2:"+result2);
	}
	/**
	 * �������еĻ���
	 */
	@RequestMapping("test3")
	public void test3(){
		String name="����";
		String result3=testCacheService.test3(name);
		System.out.println("TestCacheController.test3:"+result3);
	}
}
