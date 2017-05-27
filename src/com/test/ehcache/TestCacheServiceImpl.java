package com.test.ehcache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service

//@CacheEvict(value=”users”,key=”0″,beforeInvocation=true)//这里清除的是指定缓存，也就是count方法中
//@Cacheable(value=”users”,key=”0″)//指定缓存的key
//@CacheEvict(value=”users”,allEntries=true,beforeInvocation=true)是清除所有的缓存，这里我就不演示了，道理是一样的
public class TestCacheServiceImpl implements TestCacheService{
	
	@Cacheable("users")
	public String test1(String name) {
		System.out.println("执行了11111111111------test1--------");
		return "11111";
	}
	@Cacheable(value="users",key="0")
	public String test11(String name,String key) {
		System.out.println("执行了11111111111-------test11-------");
		return "11111";
	}
	@Cacheable("users")
	@CacheEvict(value="users",key="0",beforeInvocation=true)
	public String test2(String name) {
		System.out.println("执行了11111111111-------test2-------");
		return "11111";
	}
	@CacheEvict(value="users",allEntries=true,beforeInvocation=true)
	public String test3(String name) {
		System.out.println("执行了11111111111-------test3-------");
		return "11111";
	}

}
