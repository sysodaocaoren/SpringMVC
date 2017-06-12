package com.test.designPatterns.composite;
/**
 * ���ģʽ
 * ���ģʽ�Ĺؼ��Ƕ�����һ�����󹹼��࣬���ȿ��Դ���Ҷ�ӣ��ֿ��Դ������������ͻ�����Ըó��󹹼�����б�̣�
 * ����֪�������ױ�ʾ����Ҷ�ӻ������������Զ������ͳһ����
 * @author zhuyumeng
 *
 */
public class TestComposite {

	public static void main(String[] args) {
		//�����ĸ��ļ���
		Fold f1=new Fold("A");
		Fold f2=new Fold("B");
		Fold f3=new Fold("C");
		Fold f4=new Fold("D");
		
		//����һЩ�ļ�
		File fi1=new File("1.txt");
		File fi2=new File("2.txt");
		File fi3=new File("3.txt");
		File fi4=new File("4.txt");
		File fi5=new File("5.txt");
		File fi6=new File("6.txt");
		File fi7=new File("7.txt");
		File fi8=new File("8.txt");
		File fi9=new File("9.txt");
		File fi10=new File("10.txt");
		File fi11=new File("11.txt");
		File fi12=new File("12.txt");
		
		//���ļ��ŵ��ļ�����
		f1.add(fi1);
		f1.add(fi2);
		f1.add(fi3);
		
		f2.add(fi4);
		f2.add(fi5);
		f2.add(fi6);
		f2.add(fi7);
		f2.add(fi8);
		f2.add(fi9);
		f2.add(fi11);
		
		f3.add(fi10);
		f3.add(fi12);
		
		f4.add(f1);
		f4.add(f2);
		f4.add(f3);
		
		f4.killVirSu();
	}

}
