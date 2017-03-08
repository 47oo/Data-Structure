package com.sort.util;

public class Utils {
	
	public static <T> void swap(T[] arr,int x,int y){
		T temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
	public static <T> void printArr(T[] arr,String sortName){
		System.out.println("======="+sortName+"========");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
}
