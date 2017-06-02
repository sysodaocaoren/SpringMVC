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
//		System.out.println(file.exists());//判断文件是否存在
//		if(!file.exists()){
//			file.createNewFile();//创建文件，不是文件夹
//		}
//		System.out.println(file.exists());//再次判断是否存在
//		System.out.println(file.getName());//获取文件的名字
//		System.out.println(file.getAbsolutePath());//获取文件的绝对路径
//		System.out.println(file.getPath());//获取文件的相对路径
//		System.out.println(file.getParent());//获取文件的父路径
//		System.out.println(file.canRead());//文件是否可读
//		System.out.println(file.canWrite());//文件是否可写
//		System.out.println(file.length());//文件的长度
//		System.out.println(file.lastModified());//文件最后一次修改的时间
//		System.out.println(file.isDirectory());//判断文件是否是一个目录
//		System.out.println(file.isHidden());//文件是否隐藏
//		System.out.println(file.isFile());//判断文件是否存在
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
//		System.out.println("请输入一个值：");
//		String jjjj="的解答时发生纠纷和积分";
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
            ps.println("http://www.jb51.net");// 往文件里写入字符串
            ps.append("http://www.jb51.net");// 在已有的基础上添加字符串
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void WriteStringToFile2(String filePath) {
        try {
            FileWriter fw = new FileWriter(filePath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.append("在已有的基础上添加字符串");
            bw.write("abc\r\n ");// 往已有的文件上添加字符串
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
