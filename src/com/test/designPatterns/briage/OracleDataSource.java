package com.test.designPatterns.briage;

public class OracleDataSource extends DataSource{

	@Override
	public void changeData(String name) {
		Margin mg=new Margin();
		this.pattem.change(mg);
		System.out.println("ʹ��oracle���ݿ�ת��");
	}

}
