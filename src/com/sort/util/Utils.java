package com.sort.util;

import com.sort.base.ISort;
/**
 * ������
 * @author 47
 *
 */
public class Utils {
	//��������������Ԫ�ص�λ��
	public static <T> void swap(T[] arr,int x,int y){
		T temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
	//sortNameΪnull�򲻴�ӡsortname
	public static <T> void printArr(T[] arr,String sortName){
		if(sortName!=null){
			System.out.println("======="+sortName+"========");
		}
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
	//�ж�A�Ƿ����B
	public static<T extends Comparable<T>> boolean aRb(T a,T b){
		
		return a.compareTo(b)>0;
	}
	//�ж�a�Ƿ�С��b
	public static<T extends Comparable<T>> boolean aLb(T a,T b){
		return a.compareTo(b)<0;
	}
	//�������ܲ���
	public static<T extends Comparable<T>> void testTime(ISort is,T[] arr,String sortName){
		long start = System.currentTimeMillis();
		is.sort(arr, arr.length);
		long end = System.currentTimeMillis();
		System.out.println(sortName+" : "+(end -start));
	}
}
