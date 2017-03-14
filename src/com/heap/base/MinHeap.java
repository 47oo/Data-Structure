package com.heap.base;

import com.sort.util.Utils;

public class MinHeap<T extends Comparable<T>> {
	
	private Object[] data;
	private int count;
	public MinHeap(int capacity){
		data = new Object[capacity+1];
	}
	public void add(T item){
		data[count+1] = item;
		shiftUp(count+1);
		count++;
	}
	@SuppressWarnings("unchecked")
	public T removeMin(){
		T min = (T)data[1];
		Utils.swap(data, 1, count);
		count--;
		shiftDown(1);
		return min;
	}
	@SuppressWarnings("unchecked")
	private void shiftDown(int k) {
		while(2*k<=count){
			int j = 2*k;
			if(j+1<=count&&Utils.aLb((T)data[j+1], (T)data[j]))
				j++;
			if(Utils.aLb((T)data[k], (T)data[j])) break;
			Utils.swap(data, k, j);
			k = j;
		}
	}
	@SuppressWarnings("unchecked")
	private void shiftUp(int k) {
		while(k>1&&Utils.aRb((T)data[k/2], (T)data[k])){
			Utils.swap(data, k, k/2);
			k = k/2;
		}
	}
	public boolean isEmpty(){
		return count==0;
	}
	public int size(){
		return count;
	}
	
}
