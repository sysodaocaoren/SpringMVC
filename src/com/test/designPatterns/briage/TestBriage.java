package com.test.designPatterns.briage;

public class TestBriage {
	
	/**
	 * Sunny软件公司欲开发一个数据转换工具，可以将数据库中的数据转换成多种文件格式，
	 * 例如txt、xml、pdf等格式，同时该工具需要支持多种不同的数据库。试使用桥接模式对其进行设计。
	 * @param args
	 */
	public static void main(String[] args){
		Patten pt=new XmlPatten();
		DataSource dt=new SqlServerDataSource();
		dt.setPattem(pt);
		dt.changeData("sb");
		
		String str="CN = ca_test0002,OU = NOMzY0MGU=,C = CN";
		getOU(str);
	}

	private static String getOU(String str) {
		str=str.replaceAll(" ", "");//先将空格全部去掉
		int index=str.indexOf(",OU");//获取 ,ou的位置
		
		String [] result1=str.split("OU=");//先根据 ou=截取，得到一个数组，取数组的第二个（截取的右边部分）
		String rightStr=result1[1];
		String [] result2=rightStr.split(",");//再根据 ，截取，获取截取的第一个 （截取的最左边部分）
		String result=result2[0];
		System.out.println(result);
		return result;
	}
}
