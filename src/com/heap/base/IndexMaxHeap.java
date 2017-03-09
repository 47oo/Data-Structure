package com.heap.base;

import com.sort.util.Utils;
/**
 * �����ѵĹؼ�����
 * ��ʵ����λ��ʼ�ղ���
 * �仯��������λ��,����λ�õ�Ԫ�ش���data�о��Ǳ�ʾ��ʵ���ݵ�λ��
 * @author 47
 *
 * @param <T>
 */
public class IndexMaxHeap<T extends Comparable<T>> {
	// ��ʵ����  
	private Object[] data;
	// ����λ��
	private Integer[] indexes;

	private int capacity;
	private int count;

	public IndexMaxHeap(int capacity) {
		data = new Object[capacity + 1];
		indexes = new Integer[capacity + 1];
		count = 0;
		this.capacity = capacity;
	}

	public int size() {
		return count;
	}

	public boolean isEmpty() {
		return count == 0;
	}
	//��Ϊ����ĵ�һ��Ԫ����0,����iĬ�ϴ�0��ʼ
	public void insert(int i,T t){
		if(count+1>capacity){
			throw new RuntimeException("����������Χ");
		}
		if(i+1<1&&i+1>capacity){
			throw new RuntimeException("����������Χ֮��");
		}
		i++;
		data[i] = t; //��iλ�ñ���ʵ�ʵ�����
		indexes[count+1]=i; //��indexes��count+1��λ�ñ���i,ÿ�ζ�������汣��
		count++;
		shiftUp(count);
	}
	
	@SuppressWarnings("unchecked")
	public T removeMax(){
		if(count<=0){
			throw new RuntimeException("�Ѿ�û��������");
		}
		//�������Ԫ��
		T max = (T) data[indexes[1]];
		Utils.swap(indexes, 1, count);
		count--;
		shiftDown(1);
		return max;
	}
	@SuppressWarnings("unchecked")
	private void shiftDown(int k) {
		while(2*k<=count){
			int j =2*k;
			if(j+1<=count&&Utils.aRb((T)data[indexes[j+1]], (T)data[indexes[j]]))
				j++;
			if(Utils.aRb((T)data[indexes[k]], (T)data[indexes[j]]))
				 break;
			
			Utils.swap(indexes, k, j);
			k=j;
		}
		
	}

	@SuppressWarnings("unchecked")
	private void shiftUp(int k) {
		while(k>1&&Utils.aLb((T)data[indexes[k/2]], (T)data[indexes[k]])){
			Utils.swap(indexes, k/2, k);
			k = k/2;
		}
	}
	public static void main(String[] args) {
		Integer[] arr = {2,323,1,24,14,1};
		IndexMaxHeap<Integer> im = new IndexMaxHeap<>(arr.length);
		for(int i=0;i<arr.length;i++){
			im.insert(i, arr[i]);
		}
		for(int i=0;i<arr.length;i++){
			System.out.print(im.removeMax()+" ");
		}
	}
}
