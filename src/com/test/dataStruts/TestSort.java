package com.test.dataStruts;

import java.util.Arrays;

public class TestSort {
	public static void main(String[] args){
		int [] intArray={2,3,4,6,3,8,3,5,6,7,2};
		
		//冒泡排序
		//System.out.println("maopao:"+Arrays.toString(maopao(intArray)));
		
		//选择排序
		//System.out.println("xuanze"+Arrays.toString(xuanze(intArray)));
		
		//插入排序
		System.out.println("charu"+Arrays.toString(charu(intArray)));
	}
	
	//冒泡排序
	/**
	 * 冒泡排序，小的往前去
	 * 1.一次拿数组中的一个数与前面的数比较，如果比前面的小，就交换
	 * @param ints
	 * @return
	 */
	public static int[] maopao(int[] ints){
		for(int i=0;i<ints.length-1;i++){
			for(int j=0;j<ints.length-i-1;j++){
				if(ints[j]<ints[j+1]){
					int temp=ints[j];
					ints[j]=ints[j+1];
					ints[j+1]=temp;
				}
			}
		}
		return ints;
	}
	
	//选择排序
	
	public static int[] xuanze(int[] ints){
		for(int i=0;i<ints.length-1;i++){
			int min=i;
			for(int j=i+1;j<ints.length;j++){
				if(ints[j]<ints[min]){
					min=j;
				}
			}
			int temp=ints[i];
			ints[i]=ints[min];
			ints[min]=temp;
		}
		return ints;
	}
	
	//插入排序
	public static int[] charu(int[] ints){
		int mark;
		int compare;
		
		for(mark=1;mark<ints.length;mark++){
			int temp=ints[mark];
			compare=mark;
			while(compare>0&&ints[compare-1]>temp){
				ints[compare]=ints[compare-1];
				compare--;
			}
			ints[compare]=temp;
		}
		return ints;
	}
}
