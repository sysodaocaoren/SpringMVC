package com.test.designPatterns.observer;

public class ShareControllercenterImpl extends ShareControllerCenter{

	public ShareControllercenterImpl(String allName){
		System.out.println("��ƱȺ�����ɹ�����");
		this.allName=allName;
	}
	
	@Override
	public void notifyAll(String name) {
		System.out.println("����֪ͨ��"+name+"�Ĺ�Ʊ�����ˣ���");
		for(Shareder shareder:this.shareders){
			if(!name.equals(shareder.getName())){
				shareder.notices();
			}
		}
	}

}
