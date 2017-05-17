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
	 * �´���һ���������ԭ���������й�ϵ
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void delete(){
		User user=new User();
		user.setId(13l);
		user.setPassword("111111");
		
		int res=this.userDao.deleteUser(55l);
		//�������д����ʱ�򣬻�ʹ�ⲿ������ع�
		//throw new RuntimeException("REQUIRES_NEW �б��˸���");
	}
	
	/**
	 * �´���һ�����Ƕ����ԭ������������
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
