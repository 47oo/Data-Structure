package com.sort.util;

import com.sort.base.ISort;
/**
 * 工具类
 * @author 47
 *
 */
public class Utils {
	//交换数组中两个元素的位置
	public static <T> void swap(T[] arr,int x,int y){
		T temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
	//sortName为null则不打印sortname
	public static <T> void printArr(T[] arr,String sortName){
		if(sortName!=null){
			System.out.println("======="+sortName+"========");
		}
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
	//判断A是否大于B
	public static<T extends Comparable<T>> boolean aRb(T a,T b){
		
		return a.compareTo(b)>0;
	}
	//判断a是否小于b
	public static<T extends Comparable<T>> boolean aLb(T a,T b){
		return a.compareTo(b)<0;
	}
	//用于性能测试
	public static<T extends Comparable<T>> void testTime(ISort is,T[] arr,String sortName){
		long start = System.currentTimeMillis();
		is.sort(arr, arr.length);
		long end = System.currentTimeMillis();
		System.out.println(sortName+" : "+(end -start));
	}
}
