package com.heap.base;

import com.sort.util.Utils;
/**
 * 索引堆的关键点是
 * 真实数据位置始终不变
 * 变化的是索引位置,索引位置的元素代入data中就是表示真实数据的位置
 * @author 47
 *
 * @param <T>
 */
public class IndexMaxHeap<T extends Comparable<T>> {
	// 真实数据  
	private Object[] data;
	// 索引位置
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
	//因为数组的第一个元素是0,所以i默认从0开始
	public void insert(int i,T t){
		if(count+1>capacity){
			throw new RuntimeException("超出容器范围");
		}
		if(i+1<1&&i+1>capacity){
			throw new RuntimeException("不在容器范围之内");
		}
		i++;
		data[i] = t; //在i位置保存实际的数据
		indexes[count+1]=i; //在indexes的count+1的位置保存i,每次都在最后面保存
		count++;
		shiftUp(count);
	}
	
	@SuppressWarnings("unchecked")
	public T removeMax(){
		if(count<=0){
			throw new RuntimeException("已经没有数据了");
		}
		//获得最大的元素
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
