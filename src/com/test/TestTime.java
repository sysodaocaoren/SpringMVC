package com.test;

import java.util.Date;

public class TestTime {
	public static void main(String[] args) {
		Date date=new Date();
		System.out.println(date.getTime());
		
		//draw(10);
		
		//draw2(10);
		
		String [] names = {"{name"};

		String strs = names[0];
	
		String  [] sSplit =  strs.split("\\{");
		 
		String ss =  sSplit[0];
		
		System.out.println(ss==null);
		System.out.println("".equals(ss));

	}
	//数组画法
	public static void draw(int row){
		//先声明一个二维数组
		int [][] row1=new int[row][row];
		for(int i=0;i<row1.length;i++){
			for(int k=row1.length-1;k>i;k--){
				System.out.print(" ");
			}
			row1[i]=new int[i+1];
			
			row1[i][0]=1;
			row1[i][i]=1;
			
			String str="";
			for(int j=1;j<i;j++){
				row1[i][j]=row1[i-1][j]+row1[i-1][j-1];
			}
			
			for(int m=0;m<row1[i].length;m++){
				str+=row1[i][m]+" ";
			}
			System.out.println(str);
		}
	}
	
	//递归算法
	public static void draw2(int rows){
		if(rows<=0){
			System.out.println("false!!");
			return;
		}
		
		for(int i=1;i<=rows;++i){
			for(int j=1;j<=i;++j){
				System.out.print(getN(i,j));
				System.out.print(" ");
			}
			System.out.println();
		}
		
	}
	
	public static int getN(int i,int j){
		if(j==1||i==j){
			return 1;
		}else{
			return getN(i-1,j)+getN(i-1,j-1);
		}
	}
}
