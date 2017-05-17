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
 * red alarm:��ͬһ�����У����һ��������������һ��û������������û����������ĵ�������������ķ�����������Ч��
 *           ���仰˵������������ķ���������ⲿ���ã��������Ч
 * ����ʵ�ַ�ʽ��1.ע��  2.������ ʹ��aop����ʵ��   
 * �����һЩ������1.��д   ��    
 *
 */
@Service("TestTransactionalService")
//@Transactional(value="txManager" )//�������������
public class TestTransactionalServiceImpl implements TestTransactionalService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private TestTransactionalService2 testTransactionalService2;
	
	@Transactional(value="txManager" )//������ʽ
	public void testdo() {
		User user =new User();
		user.setUsername("what");
		user.setPassword("where");
		this.userDao.insertUser(user);
		
		user.setUsername("where");
		user.setPassword("what");
		this.userDao.updateLastUser(user);
		
	}
	//@Transactional(value="txManager" )//���ע�����ӣ���Ȼ����testdo��������Ч
	public void testdo2(){
		testDirtyRead();
	}
	/**
	 * ͬһ������û�ύҲ���Զ�ȡ��
	 */
	//@Transactional(value="txManager")
	//@Transactional(value="txManager",propagation=Propagation.NOT_SUPPORTED)//����������������
	//@Transactional(value="txManager",propagation=Propagation.REQUIRED)//�������������뵽����û�еĶ�Լ�����һ������
	//@Transactional(value="txManager",propagation=Propagation.MANDATORY)//����Ϊ�������������񣬲�Ȼ�ᱨ��(���ø÷����Ļ�������������)
	//@Transactional(value="txManager",propagation=Propagation.REQUIRES_NEW)//ԭ����������Լ�����һ������
	//@Transactional(value="txManager",propagation=Propagation.NESTED)//����������������
	//@Transactional(value="txManager",propagation=Propagation.NEVER)//����������������,�������ᱨ��
	//@Transactional(value="txManager",propagation=Propagation.SUPPORTS)//��������Լ����������񣬽������˵�����
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
	 * ��������ɾ����һ�����ݣ���ʹ��û�ύ�������Ҳ���ᱻ�����
	 */
	@Transactional(value="txManager",propagation=Propagation.REQUIRES_NEW)//ԭ����������Լ�����һ������
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
	 * ��ͬһ�������У��²�������ݼ�ʹû���ύҲ�ᱻ�����
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
	 * ����Propagation.REQUIRES_NEW
	 * �¼�һ�������ԭ���������޹أ�ԭ�����������
	 */
	@Transactional(value="txManager" ,propagation=Propagation.REQUIRED ,isolation=Isolation.READ_UNCOMMITTED)
	public void TestMore(){
		User user =new User();
		user.setPassword("22222222");
		user.setUsername("2222222");
		
		this.userDao.insertUser(user);
		
		insert();
		
		testTransactionalService2.delete2();//�������������Ǵ�����ʽ��REQUIRES_NEW�������ⲿ������Դ�û�й�ϵ,����ᱻɾ��

		testTransactionalService2.testRead();
		/*testTransactionalService2.delete2();//���������������Ƕ�������������񱨴��˻�ع�������ɾ��������
		
		testTransactionalService2.delete3();*/
		
		//throw new RuntimeException("���ⱨ�˸���");
		
	}
	
	
	
	
	@Transactional(value="txManager" ,propagation=Propagation.REQUIRED)
	public void insert(){
		User user =new User();
		user.setPassword("11111");
		user.setUsername("22211122");
		
		this.userDao.insertUser(user);
	}
	
	/**
	 * PROPAGATION_REQUIRES_NEW ����һ���µ�, �������ڻ����� "�ڲ�" ����. 
	 * ������񽫱���ȫ commited �� rolled back �����������ⲿ����, 
	 * ��ӵ���Լ��ĸ��뷶Χ, �Լ�����, �ȵ�. ���ڲ�����ʼִ��ʱ, �ⲿ���񽫱�����, �����������ʱ, �ⲿ���񽫼���ִ��. 
	 */
	@Transactional(value="txManager" ,propagation=Propagation.REQUIRES_NEW)
	public void delete(){
		User user=new User();
		user.setId(10l);
		user.setPassword("111111");
		
		int res=this.userDao.deleteUser(10l);
	}
	/**
	 * PROPAGATION_NESTED ��ʼһ�� "Ƕ�׵�" ����,  �����Ѿ����������һ��������������.
	 *  Ǳ������ʼִ��ʱ,  ����ȡ��һ�� savepoint. ������Ƕ������ʧ��, ���ǽ��ع����� savepoint. 
	 *  Ǳ���������ⲿ�����һ����, ֻ���ⲿ������������Żᱻ�ύ.
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
