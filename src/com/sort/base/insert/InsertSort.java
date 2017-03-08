package com.sort.base.insert;

import com.sort.base.ISort;
import com.sort.util.Utils;
/**
 * 插入排序要求前面的数据是已经排好序的
 * @author 47
 *
 */
public class InsertSort implements ISort{

	@Override
	public <T extends Comparable<T>> void sort(T[] arr, int n) {
		for(int i=1;i<n;i++){
			//寻找元素arr[i]合适的位置插入
			//写法1
//			for(int j=i;j>0;j--){
//				if(arr[j].compareTo(arr[j-1])<0){
//					Utils.swap(arr, j, j-1);
//				}else{
//					break;
//				}
//			}
			//写法二
			for(int j=i;j>0&&arr[j].compareTo(arr[j-1])<0;j--){
				Utils.swap(arr, j, j-1);
			}
		}
	}
	
	public static void main(String[] args) {
		Integer[] arr ={1,5,7,8,2,3,}; 
		new InsertSort().sort(arr, arr.length);
		Utils.printArr(arr, "插入排序");
	}
}
