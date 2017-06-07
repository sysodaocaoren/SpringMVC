package com.test.designPatterns.observer;

public class TestObserver001 {

	public static void main(String[] args) {
		//先成立一个股票群
		ShareControllercenterImpl shareCenter=new ShareControllercenterImpl("发发发股票群");
		
		//声明一些人
		Shareder xiaoming=new Shareder("小明");
		Shareder daming=new Shareder("大明");
		Shareder zhangsan=new Shareder("张三");
		Shareder lisi=new Shareder("李四");
		
		//这些人不约而同的玩起了股票
		shareCenter.join(xiaoming);
		shareCenter.join(daming);
		shareCenter.join(zhangsan);
		shareCenter.join(lisi);
		
		//一天，小明发现股票涨了 5%，同时，其他的玩股票的人也会受到股票中心的通知
		xiaoming.shareChange(shareCenter);
		
	}

}
