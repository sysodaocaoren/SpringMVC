package com.test.designPatterns.briage;

public class TestBriage {
	
	/**
	 * Sunny�����˾������һ������ת�����ߣ����Խ����ݿ��е�����ת���ɶ����ļ���ʽ��
	 * ����txt��xml��pdf�ȸ�ʽ��ͬʱ�ù�����Ҫ֧�ֶ��ֲ�ͬ�����ݿ⡣��ʹ���Ž�ģʽ���������ơ�
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
		str=str.replaceAll(" ", "");//�Ƚ��ո�ȫ��ȥ��
		int index=str.indexOf(",OU");//��ȡ ,ou��λ��
		
		String [] result1=str.split("OU=");//�ȸ��� ou=��ȡ���õ�һ�����飬ȡ����ĵڶ�������ȡ���ұ߲��֣�
		String rightStr=result1[1];
		String [] result2=rightStr.split(",");//�ٸ��� ����ȡ����ȡ��ȡ�ĵ�һ�� ����ȡ������߲��֣�
		String result=result2[0];
		System.out.println(result);
		return result;
	}
}
