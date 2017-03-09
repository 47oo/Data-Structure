package com.heap.base;

import com.sort.util.Utils;

/**
 * �󶥶�
 * Ҫ��,���ڵ�����ӽڵ㼰�ӽڵ���������Խڵ�
 * ����Ҫ���ֵܽڵ�λ�õĴ�С
 * @author hp
 *
 * @param <T>
 */
public class MaxHeap<T extends Comparable<T>> {
	//���ڴ��ʵ�ʵ�����
	private Object[] data;
	//����ȷ������Ԫ�صĶ���
	private int count;
	
	private int capacity;
	public MaxHeap(int capacity) {
		//���鳤��ΪҪ�����Ԫ�س���+1
		//ԭ��  
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
		// count/2ΪҶ�ӽڵ�ĸ��ڵ�
		for(int i=count/2;i>=1;i--){
			shiftDown(i);
		}
	}
	public void insert(T t){
		if(count+1>capacity){
			throw new RuntimeException("������Χ");
		}
		data[count+1] = t;
		count++;
		shiftUp(count);
	}
	public T removeMax(){
		if(count<=0){
			throw new RuntimeException("�����Ѿ�û��Ԫ����");
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
		//˵��k�������ӽڵ�,��������ڵ�
		while(2*k<=count){
			int j= 2*k;//�õ����ӽڵ�
			if(j+1<=count&&Utils.aRb((T)data[j+1], (T)data[j])){
				j++;
				//������ҽڵ�,������ֵ�������ڵ�,�����ǾͰ�����ҽڵ���Ϊ���ڵ�
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
