package com.sort.base.select;

import com.sort.base.ISort;
import com.sort.base.Student;
import com.sort.util.Utils;

public class SelectSort implements ISort{
	@Override
	public<T extends Comparable<T>> void sort(T[] arr,int n){
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
//		Integer [] arr  = {1,3,4,5,6,2,3,1};
		Student[] sarr = {new Student(1,"hh"),new Student(2,"bb"),new Student(0,"hb")};
		new SelectSort().sort(sarr, sarr.length);
		Utils.printArr(sarr, "Ñ¡Ôñ");
	}
}
