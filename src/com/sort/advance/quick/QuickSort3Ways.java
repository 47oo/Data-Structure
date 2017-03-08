package com.sort.advance.quick;

import com.sort.base.ISort;
import com.sort.util.Utils;

public class QuickSort3Ways implements ISort{

	@Override
	public <T extends Comparable<T>> void sort(T[] arr, int n) {
		quickSort3Ways(arr,0,arr.length-1);
	}

	private <T extends Comparable<T>> void quickSort3Ways(T[] arr, int l, int r) {
		if(l>=r){
			return;
		}
		T v = arr[l];
		int lt =l; //arr[l+1,lt]; 这边是小于v的范围
		int gt = r+1; //arr[gt,r] 这边是大于v的范围
		int i = l+1;//arr[lt+1,i) 这边是等于v的范围
		//3路排序是一个将确定等于v的单个位置变成为确定等于v的范围的位置
		while(i<gt){
			if(Utils.aLb(arr[i], v)){
				Utils.swap(arr, i, lt+1);//当前位置i与lt+1即此时的位置的元素刚好属于等于v的范围进行位置交换
				i++;//中间指针向右移动一位
				lt++;//左指针向右移动一位
			}else if(Utils.aRb(arr[i], v)){
				Utils.swap(arr, i, gt-1);
				gt--;//右指针向左移动一位,这里i是不需要移动的
			}else{//数值相等的时候
				i++; //中间指针向右移动一位
			}
		}
		Utils.swap(arr, l, lt);
		quickSort3Ways(arr, l, lt-1);
		quickSort3Ways(arr, gt, r);
	}
	
	public static void main(String[] args) {
		Integer [] arr = {1,23,23,24,5356,3,6,1};
		new QuickSort3Ways().sort(arr, arr.length);
		Utils.printArr(arr, "3W");
	}

}
