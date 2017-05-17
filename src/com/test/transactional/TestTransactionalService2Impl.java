package com.test.transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wg.bean.User;
import com.wg.dao.UserDao;

@Service("TestTransactionalService2")
public class TestTransactionalService2Impl implements TestTransactionalService2{
	
	@Autowired
	private UserDao userDao;
	
	/**
	 * 新创建一个事物，不与原来的事务有关系
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void delete(){
		User user=new User();
		user.setId(13l);
		user.setPassword("111111");
		
		int res=this.userDao.deleteUser(55l);
		//在这里有错误的时候，会使外部的事务回滚
		//throw new RuntimeException("REQUIRES_NEW 中报了个错");
	}
	
	/**
	 * 新创建一个事物，嵌套在原来的事务下面
	 */
	@Transactional(value="txManager" ,propagation=Propagation.NESTED,isolation=Isolation.READ_UNCOMMITTED)
	public void delete2(){
		User user=new User();
		user.setId(11l);
		user.setPassword("111111");
		
		int res=this.userDao.deleteUser(56l);
	}
	
	@Transactional(value="txManager" ,propagation=Propagation.REQUIRED)
	public void delete3() {
		User user=new User();
		user.setId(12l);
		user.setPassword("111111");
		
		int res=this.userDao.deleteUser(56l);
		
	}
	@Transactional(value="txManager" ,propagation=Propagation.REQUIRED ,isolation=Isolation.READ_UNCOMMITTED)
	public void testRead(){
		User user =new User();
		user.setPassword("22222");
		user.setUsername("22211122");
		
		User user2=this.userDao.getUserByName(user);
		System.out.println(user2.getPassword());
	}
}
