package com.heap.base;

import com.sort.base.ISort;
import com.sort.util.Utils;

public class Heapify implements ISort{

	@Override
	public <T extends Comparable<T>> void sort(T[] arr, int n) {
		MaxHeap<T> mh =new MaxHeap<>(arr,n);
		for(int i=n-1;i>=0;i--){
			arr[i]=mh.removeMax();
		}
	}
	public <T extends Comparable<T>> void sort1(T[] arr, int n) {
		MaxHeap<T> mh =new MaxHeap<>(n);
		for(int i=0;i<n;i++){
			mh.insert(arr[i]);
		}
		for(int i=n-1;i>=0;i--){
			arr[i] = mh.removeMax();
		}
	}
	
	public static void main(String[] args) {
		Integer[] arr = {1,23,2,4,25,512};
		new Heapify().sort1(arr, arr.length);
		Utils.printArr(arr, "∂—≈≈–Ú");
	}
}
