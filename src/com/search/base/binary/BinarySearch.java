package com.search.base.binary;

import com.search.base.ISearch;
import com.sort.util.Utils;

public class BinarySearch implements ISearch{
	/**
	 * 
	 * @param arr  查找的数组,必须有序
	 * @param n    数组的长度
	 * @param target  查找的目标
	 * @return  返回在数组中的位置 ,没有查找到则返回 -1
	 */
	@Override
	public <T extends Comparable<T>> int search(T[] arr,int n,T target){
		int l =0,r = n-1;
		while(l<=r){
			int mid = l+(r-l)/2;
			if(Utils.aEb(target, arr[mid])){
				return mid;
			}else if(Utils.aLb(target, arr[mid])){
				r = mid -1;
			}else {
				l = mid+1;
			}
		}
		return -1;
	}
	//用递归的方式写二分查找发
	public <T extends Comparable<T>> int search0(T[] arr,int n,T target){
		
		return search2(arr, 0, n-1, target);
	}
	private <T extends Comparable<T>> int search2(T[] arr,int l,int r,T target){
		if(l>r){
			return -1;
		}
		int mid = l+(r-l)/2;
		if(Utils.aEb(target, arr[mid])){
			return mid;
		}else if(Utils.aLb(target, arr[mid])){
			return search2(arr,l,mid-1,target);
		}else {
			return search2(arr,mid+1,r,target);
		}
	}
	public static void main(String[] args) {
		Integer[] arr = {1,2,3,4,5,6,7};
		BinarySearch bs= new BinarySearch();
		System.out.println(bs.search(arr, arr.length, 1));
		System.out.println(bs.search0(arr, arr.length, 1));
	}
}
