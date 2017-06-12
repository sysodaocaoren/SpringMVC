package com.test.designPatterns.briage;

public class OracleDataSource extends DataSource{

	@Override
	public void changeData(String name) {
		Margin mg=new Margin();
		this.pattem.change(mg);
		System.out.println("使用oracle数据库转换");
	}

}
