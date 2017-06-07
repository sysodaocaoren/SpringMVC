package com.test.designPatterns.observer;

public class ShareControllercenterImpl extends ShareControllerCenter{

	public ShareControllercenterImpl(String allName){
		System.out.println("股票群建立成功！！");
		this.allName=allName;
	}
	
	@Override
	public void notifyAll(String name) {
		System.out.println("紧急通知："+name+"的股票上涨了！！");
		for(Shareder shareder:this.shareders){
			if(!name.equals(shareder.getName())){
				shareder.notices();
			}
		}
	}

}
