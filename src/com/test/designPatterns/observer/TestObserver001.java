package com.test.designPatterns.observer;

public class TestObserver001 {

	public static void main(String[] args) {
		//�ȳ���һ����ƱȺ
		ShareControllercenterImpl shareCenter=new ShareControllercenterImpl("��������ƱȺ");
		
		//����һЩ��
		Shareder xiaoming=new Shareder("С��");
		Shareder daming=new Shareder("����");
		Shareder zhangsan=new Shareder("����");
		Shareder lisi=new Shareder("����");
		
		//��Щ�˲�Լ��ͬ�������˹�Ʊ
		shareCenter.join(xiaoming);
		shareCenter.join(daming);
		shareCenter.join(zhangsan);
		shareCenter.join(lisi);
		
		//һ�죬С�����ֹ�Ʊ���� 5%��ͬʱ�����������Ʊ����Ҳ���ܵ���Ʊ���ĵ�֪ͨ
		xiaoming.shareChange(shareCenter);
		
	}

}
