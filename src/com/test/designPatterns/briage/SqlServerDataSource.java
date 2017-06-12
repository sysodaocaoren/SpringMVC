package com.test.designPatterns.briage;

public class SqlServerDataSource extends DataSource{

	@Override
	public void changeData(String name) {
		Margin mg=new Margin();
		this.pattem.change(mg);
		System.out.println("Ê¹ÓÃSqlServer×ª»»");
	}

}
