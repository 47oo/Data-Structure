package com.heap.base.advance;

import com.sort.util.Utils;

public class IndexMaxHeap<T extends Comparable<T>> {
	//�����ʵ������
	private Object[] data;
	//��Ҫ���ж����������
	private Integer[] indexes;
	//�����ʵ������������λ��
	private Integer[] reverse;
	
	private int capacity;
	private int count;
	public IndexMaxHeap(int capacity){
		this.capacity = capacity;
		data = new Object[capacity+1];
		indexes = new Integer[capacity+1];
		reverse = new Integer[capacity+1];
		count = 0;
	}
	public void insert(int i,T t){
		if(count+1>capacity){
			throw new RuntimeException("����������Χ");
		}
		if(i+1<1&&i+1>capacity){
			throw new RuntimeException("����������Χ֮��");
		}
		i++;
		data[i] = t;
		indexes[count+1]=i;
		reverse[i]=count+1;
		count++;
		shiftUp(count);
	}
	@SuppressWarnings("unchecked")
	public T removeMax(){
		if(count<=0){
			throw new RuntimeException("�����Ѿ�û��Ԫ����");
		}
		T max = (T)data[indexes[1]];
		Utils.swap(indexes, 1, count);
		reverse[indexes[1]] =1;
		//reverse[indexes[count]]=0;
		reverse[indexes[count]]=count;
		count--;
		shiftDowm(1);
		return max;
	}
	@SuppressWarnings("unchecked")
	private void shiftDowm(int k) {
		while(2*k<=count){
			int j=2*k;
			if(j+1<=count&&Utils.aRb((T)data[indexes[j+1]], (T)data[indexes[j]]))
				j++;
			if(Utils.aRb((T)data[indexes[k]], (T)data[indexes[j]])) break;
			Utils.swap(indexes, k, j);
			reverse[indexes[k]]=k;
			reverse[indexes[j]]=j;
			k=j;
		}
	}
	@SuppressWarnings("unchecked")
	private void shiftUp(int k) {
		while(k>1&&Utils.aLb((T)data[indexes[k/2]], (T)data[indexes[k]])){
			Utils.swap(indexes, k/2, k);
			reverse[indexes[k/2]]=k/2;
			reverse[indexes[k]]=k;
			k=k/2;
		}
	}
	//Ҳ�Ǵ�0��ʼ��
	public void change(int index,T v){
		if(index<0||index>count){
			throw new RuntimeException("������Χ");
		}
		index++;
		data[index] =v;
		int j = reverse[index];
		shiftUp(j);
		shiftDowm(j);
	}
	public int size(){
		return count;
	}
	public boolean isEmpty(){
		return count == 0;
	}
	public static void main(String[] args) {
		Integer[] arr ={1,2,3,4,5};
		IndexMaxHeap<Integer> im = new IndexMaxHeap<>(arr.length);
		for(int i=0;i<arr.length;i++){
			im.insert(i, arr[i]);
		}
		for(int i=0;i<arr.length;i++){
			System.out.print(im.removeMax()+" ");
		}
		System.out.println("=========================");
		for(int i=0;i<arr.length;i++){
			im.insert(i, arr[i]);
		}
		im.change(3, 10);
		for(int i=0;i<arr.length;i++){
			System.out.print(im.removeMax()+" ");
		}
	}
}
