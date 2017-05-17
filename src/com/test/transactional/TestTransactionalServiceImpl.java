package com.test.transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wg.bean.User;
import com.wg.dao.UserDao;
/**
 * 
 * @author zhuyumeng
 * 
 * red alarm:在同一个类中，如果一个配置了事务，另一个没有配置事务。则没有配置事务的调用配置了事务的方法，事务不生效。
 *           换句话说，配置了事务的方法必须从外部调用，事务才生效
 * 事务实现方式：1.注解  2.做切面 使用aop配置实现   
 * 事务的一些参数：1.读写   ：    
 *
 */
@Service("TestTransactionalService")
//@Transactional(value="txManager" )//给整个类加事务
public class TestTransactionalServiceImpl implements TestTransactionalService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private TestTransactionalService2 testTransactionalService2;
	
	@Transactional(value="txManager" )//基本形式
	public void testdo() {
		User user =new User();
		user.setUsername("what");
		user.setPassword("where");
		this.userDao.insertUser(user);
		
		user.setUsername("where");
		user.setPassword("what");
		this.userDao.updateLastUser(user);
		
	}
	//@Transactional(value="txManager" )//这个注解必须加，不然事务testdo的事务不生效
	public void testdo2(){
		testDirtyRead();
	}
	/**
	 * 同一事务中没提交也可以读取到
	 */
	//@Transactional(value="txManager")
	//@Transactional(value="txManager",propagation=Propagation.NOT_SUPPORTED)//这个方法不添加事务
	//@Transactional(value="txManager",propagation=Propagation.REQUIRED)//如果有事物则加入到事务，没有的额话自己创建一个事务
	//@Transactional(value="txManager",propagation=Propagation.MANDATORY)//必须为这个方法添加事务，不然会报错(调用该方法的环境必须有事务)
	//@Transactional(value="txManager",propagation=Propagation.REQUIRES_NEW)//原有事务挂起，自己创建一个事务
	//@Transactional(value="txManager",propagation=Propagation.NESTED)//这个方法不添加事务
	//@Transactional(value="txManager",propagation=Propagation.NEVER)//这个方法不添加事务,添加事务会报错
	//@Transactional(value="txManager",propagation=Propagation.SUPPORTS)//这个方法自己不创建事务，借助别人的事务
	public void testDirtyRead(){
		User user=new User();
		user.setId(10l);
		user.setPassword("111111");
		int res=this.userDao.updateUser(user);
		
		User user2=this.userDao.getUser(user);
		System.out.println(user2.getPassword());
		
		this.userDao.updateLastUser(user);
		
	}
	
	/**
	 * 在事务中删除了一条数据，即使在没提交的情况下也不会被查出来
	 */
	@Transactional(value="txManager",propagation=Propagation.REQUIRES_NEW)//原有事务挂起，自己创建一个事务
	public void testDelete(){
		User user=new User();
		user.setId(10l);
		user.setPassword("111111");
		
		int res=this.userDao.deleteUser(10l);
		
		User user2=this.userDao.getUser(user);
		System.out.println(user2.getPassword());
		
		this.userDao.updateLastUser(user);
		
	}
	/**
	 * 在同一个事务中，新插入的数据即使没有提交也会被查出来
	 */
	@Transactional(value="txManager" ,propagation=Propagation.REQUIRED)
	public void testInsert(){
		User user =new User();
		user.setPassword("22222");
		user.setUsername("22222");
		
		this.userDao.insertUser(user);;
		
		User user2=this.userDao.getUserByName(user);
		
		System.out.println(user2.getPassword());
		
		this.userDao.updateLastUser(user);
	}
	
	/**
	 * 测试Propagation.REQUIRES_NEW
	 * 新加一个事物，与原来的事务无关，原来的事务挂起
	 */
	@Transactional(value="txManager" ,propagation=Propagation.REQUIRED ,isolation=Isolation.READ_UNCOMMITTED)
	public void TestMore(){
		User user =new User();
		user.setPassword("22222222");
		user.setUsername("2222222");
		
		this.userDao.insertUser(user);
		
		insert();
		
		testTransactionalService2.delete2();//由于他的事务是传播方式是REQUIRES_NEW，所以外部的事务对此没有关系,结果会被删掉

		testTransactionalService2.testRead();
		/*testTransactionalService2.delete2();//这个方法的事务是嵌套事务，外层的事务报错了会回滚，不会删除掉数据
		
		testTransactionalService2.delete3();*/
		
		//throw new RuntimeException("故意报了个错");
		
	}
	
	
	
	
	@Transactional(value="txManager" ,propagation=Propagation.REQUIRED)
	public void insert(){
		User user =new User();
		user.setPassword("11111");
		user.setUsername("22211122");
		
		this.userDao.insertUser(user);
	}
	
	/**
	 * PROPAGATION_REQUIRES_NEW 启动一个新的, 不依赖于环境的 "内部" 事务. 
	 * 这个事务将被完全 commited 或 rolled back 而不依赖于外部事务, 
	 * 它拥有自己的隔离范围, 自己的锁, 等等. 当内部事务开始执行时, 外部事务将被挂起, 内务事务结束时, 外部事务将继续执行. 
	 */
	@Transactional(value="txManager" ,propagation=Propagation.REQUIRES_NEW)
	public void delete(){
		User user=new User();
		user.setId(10l);
		user.setPassword("111111");
		
		int res=this.userDao.deleteUser(10l);
	}
	/**
	 * PROPAGATION_NESTED 开始一个 "嵌套的" 事务,  它是已经存在事务的一个真正的子事务.
	 *  潜套事务开始执行时,  它将取得一个 savepoint. 如果这个嵌套事务失败, 我们将回滚到此 savepoint. 
	 *  潜套事务是外部事务的一部分, 只有外部事务结束后它才会被提交.
	 */
	@Transactional(value="txManager" ,propagation=Propagation.NESTED)
	public void delete2(){
		User user=new User();
		user.setId(11l);
		user.setPassword("111111");
		
		int res=this.userDao.deleteUser(10l);
	}
	@Transactional(value="txManager" ,propagation=Propagation.NESTED,rollbackFor=RuntimeException.class,timeout=20)
	public void testRollback(){
		User user =new User();
		user.setPassword("4325364646456");
		user.setUsername("22211122");
		try {
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.userDao.insertUser(user);
		throw new RuntimeException();
	}
}
