package com.test.designPatterns.briage;

public class MysqlDataSource extends DataSource{

	@Override
	public void changeData(String name) {
		Margin mg=new Margin();
		this.pattem.change(mg);;
		System.out.println("��mysql���ݿ���ת��");
	}
	
}
