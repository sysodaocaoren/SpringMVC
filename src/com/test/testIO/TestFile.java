package com.test.testIO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

public class TestFile {

	public static void main(String[] args) throws IOException {
//		File file=new File("E:\\tmp\\kft-activiti-demo\\LeaveBill\\1\\testIO.txt");
//		System.out.println(file.exists());//�ж��ļ��Ƿ����
//		if(!file.exists()){
//			file.createNewFile();//�����ļ��������ļ���
//		}
//		System.out.println(file.exists());//�ٴ��ж��Ƿ����
//		System.out.println(file.getName());//��ȡ�ļ�������
//		System.out.println(file.getAbsolutePath());//��ȡ�ļ��ľ���·��
//		System.out.println(file.getPath());//��ȡ�ļ������·��
//		System.out.println(file.getParent());//��ȡ�ļ��ĸ�·��
//		System.out.println(file.canRead());//�ļ��Ƿ�ɶ�
//		System.out.println(file.canWrite());//�ļ��Ƿ��д
//		System.out.println(file.length());//�ļ��ĳ���
//		System.out.println(file.lastModified());//�ļ����һ���޸ĵ�ʱ��
//		System.out.println(file.isDirectory());//�ж��ļ��Ƿ���һ��Ŀ¼
//		System.out.println(file.isHidden());//�ļ��Ƿ�����
//		System.out.println(file.isFile());//�ж��ļ��Ƿ����
//		
//		File file1=new File("E:\\tmp\\kft-activiti-demo\\LeaveBill\\1\\testIO1.txt");
//		if(!file1.exists()){
//			file.createNewFile();
//		}
//		FileInputStream fs=new FileInputStream(file);
//		FileOutputStream fo=new FileOutputStream(file1);
//		int n=5;   byte  buffer[]=new  byte[n]; 
//		String result1="";
//		while((fs.read(buffer,0,n))!=-1){
//			result1+=new String(buffer);
//			fo.write(buffer,0,n);
//		}
//		System.out.println(result1);
//		System.out.println("������һ��ֵ��");
//		String jjjj="�Ľ��ʱ�������׺ͻ���";
//		InputStream is2=System.in;
//		int m=3;   byte  buffer2[]=new  byte[n];
//		while((is2.read(buffer2,0,m))!=-1){
//			fo.write(buffer2,0,m);
//		}
//		//fo.write(jjjj.getBytes());
//		fo.close();
//		WriteStringToFile("E:\\tmp\\kft-activiti-demo\\LeaveBill\\1\\testIO1.txt");
//		WriteStringToFile2("E:\\tmp\\kft-activiti-demo\\LeaveBill\\1\\testIO1.txt");
		WriteStringToFile5("E:\\tmp\\kft-activiti-demo\\LeaveBill\\1\\testIO1.txt");
	}
	public static void WriteStringToFile(String filePath) {
        try {
            File file = new File(filePath);
            PrintStream ps = new PrintStream(new FileOutputStream(file));
            ps.println("http://www.jb51.net");// ���ļ���д���ַ���
            ps.append("http://www.jb51.net");// �����еĻ���������ַ���
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void WriteStringToFile2(String filePath) {
        try {
            FileWriter fw = new FileWriter(filePath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.append("�����еĻ���������ַ���");
            bw.write("abc\r\n ");// �����е��ļ�������ַ���
            bw.write("def\r\n ");
            bw.write("hijk ");
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void WriteStringToFile3(String filePath) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(filePath));
            pw.println("abc ");
            pw.println("def ");
            pw.println("hef ");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void WriteStringToFile4(String filePath) {
        try {
            RandomAccessFile rf = new RandomAccessFile(filePath, "rw");
            rf.writeBytes("op\r\n");
            rf.writeBytes("app\r\n");
            rf.writeBytes("hijklllll");
            rf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void WriteStringToFile5(String filePath) {
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            String s = "http://www.jb51.netl";
            fos.write(s.getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
