package com.sort.base;

import com.sort.util.Utils;

public class Main {
	
	public<T extends Comparable<T>> void selectSort(T[] arr,int n){
		for(int i=0;i<n;i++){
			int minIndex = i;
			for(int j=i+1;j<n;j++){
				if(arr[j].compareTo(arr[minIndex])<0){
					minIndex = j;
				}
			}
			Utils.swap(arr, i, minIndex);
		}
	}
	public static void main(String[] args) {
		Integer [] arr  = {1,3,4,5,6,2,3,1};
		new Main().selectSort(arr, arr.length);
		Utils.printArr(arr, "Ñ¡ÔñÅÅÐò");
	}
}
