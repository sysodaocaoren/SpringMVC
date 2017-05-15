package com.test.designPatterns.sigleton;

/**
 * ¿¡∫∫ Ω
 * @author zhuyumeng
 *
 */
public class TestSignleton {
	private TestSignleton instance;
	private TestSignleton(){
		
	}
	public TestSignleton getInstance(){
		if(instance==null){
			return new TestSignleton();
		}else{
			return instance;
		}
	}
}
/**
 * ehanshi
 * @author zhuyumeng
 *
 */
class TestSignleton2{
	private TestSignleton2(){
		
	}
	private TestSignleton2 instance=new TestSignleton2();
	public TestSignleton2 getTestSignleton2(){
		return instance;
	}
}