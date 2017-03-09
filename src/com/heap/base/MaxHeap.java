package com.heap.base;

import com.sort.util.Utils;

/**
 * 大顶堆
 * 要求,父节点大于子节点及子节点下面的所以节点
 * 并不要求兄弟节点位置的大小
 * @author hp
 *
 * @param <T>
 */
public class MaxHeap<T extends Comparable<T>> {
	//用于存放实际的数据
	private Object[] data;
	//用于确定队内元素的多少
	private int count;
	
	private int capacity;
	public MaxHeap(int capacity) {
		//数组长度为要放入的元素长度+1
		//原因  
		 /**      1
		  *     2   3
		  */
		data = new Object[capacity+1];
		count=0;
		this.capacity = capacity;
	}
	public MaxHeap(T[] arr,int n){
		data = new Object[n+1];
		capacity = n;
		for(int i=0;i<n;i++){
			data[i+1]=arr[i];
		}
		count =n;
		// count/2为叶子节点的父节点
		for(int i=count/2;i>=1;i--){
			shiftDown(i);
		}
	}
	public void insert(T t){
		if(count+1>capacity){
			throw new RuntimeException("超出范围");
		}
		data[count+1] = t;
		count++;
		shiftUp(count);
	}
	public T removeMax(){
		if(count<=0){
			throw new RuntimeException("堆中已经没有元素了");
		}
		@SuppressWarnings("unchecked")
		T max = (T) data[1];
		Utils.swap(data, 1, count);
		count--;
		shiftDown(1);
		return max;
	}
	@SuppressWarnings("unchecked")
	private void shiftDown(int k) {
		//说明k下面有子节点,至少有左节点
		while(2*k<=count){
			int j= 2*k;//得到做子节点
			if(j+1<=count&&Utils.aRb((T)data[j+1], (T)data[j])){
				j++;
				//如果有右节点,并且其值大于做节点,那我们就把这个右节点作为父节点
			}
			if(Utils.aRb((T)data[k], (T)data[j])) break;
			Utils.swap(data, k, j);
			k=j;
		}
	}
	@SuppressWarnings("unchecked")
	private void shiftUp(int k) {
		while(k>1&&Utils.aLb((T)data[k/2], (T)data[k])){
			Utils.swap(data, k/2, k);
			k=k/2;
		}
	}
	public int size(){
		return count;
	}
	public boolean isEmpty(){
		return count ==0;
	}
	
	public static void main(String[] args) {
		Integer[] arr = {1,3,4,6,7,2};
		MaxHeap<Integer> mh = new MaxHeap<Integer>(arr.length);
		for(int i =0;i<arr.length;i++){
			mh.insert(arr[i]);
		}
		for(int i=0;i<arr.length;i++){
			System.out.print(mh.removeMax()+" ");
		}
	}
}
