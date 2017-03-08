package com.sort.base.insert;

import com.sort.base.ISort;
import com.sort.util.Utils;

public class InsertSort_Advance implements ISort{

	@Override
	public <T extends Comparable<T>> void sort(T[] arr, int n) {
		//写法三
		for(int i=1;i<n;i++){
			T e = arr[i];
			int j;//e应该插入的位置
			for(j=i;j>0&&Utils.aLb(e, arr[j-1]);j--){
				arr[j]=arr[j-1];
			}
			arr[j]=e;
		}
	}
	public static void main(String[] args) {
		Integer[] arr = {1,2,3,4,5,2,3,1};
		new  InsertSort_Advance().sort(arr, arr.length);
		Utils.printArr(arr, "插入排序");
	}
}
