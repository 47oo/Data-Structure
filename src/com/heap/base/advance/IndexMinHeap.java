package com.heap.base.advance;

import com.sort.util.Utils;

public class IndexMinHeap<T extends Comparable<T>> {
	private Object[] data;

	private Integer[] indexes;
	private Integer[] reverses;
	private int count;

	public IndexMinHeap(int capacity) {
		this.count = 0;
		data = new Object[capacity + 1];
		indexes = new Integer[capacity + 1];
		reverses = new Integer[capacity + 1];
		
	}

	public int size() {
		return count;
	}

	public boolean isEmpty() {
		return count == 0;
	}

	// 实在是懒得写判断index的范围,以后会补上
	public void add(T item) {
		data[count+1] = item;
		indexes[count + 1] = count + 1;
		reverses[indexes[count + 1]] = count + 1;
		count++;
		shiftUp(count);
	}
	public void insert(int index,T item){
		index += 1;
        data[index] = item;
        indexes[count+1] = index;
        reverses[index] = count+1;
        count++;
        shiftUp(count);
	}
	@SuppressWarnings("unchecked")
	private void shiftUp(int k) {
		while(k>1&&Utils.aRb((T)data[indexes[k/2]], (T)data[indexes[k]])){
			Utils.swap(indexes, k, k/2);
			reverses[indexes[k/2]] = k/2;
			reverses[indexes[k]] = k;
			k =k/2;
		}
	}
	@SuppressWarnings("unchecked")
	public T removeMin(){
		T min = (T)data[1];
		Utils.swap(indexes,1,count);
		reverses[indexes[count]] = count;
		reverses[indexes[1]] =1;
		count--;
		shiftDowm(1);
		return min;
	}
	public int removeMinIndex(){
		int minIndex = indexes[1]-1;
		Utils.swap(indexes, 1, count);
		reverses[indexes[count]] = count;
		reverses[indexes[1]] =1;
		count--;
		shiftDowm(1);
		return minIndex;
	}
	@SuppressWarnings("unchecked")
	private void shiftDowm(int k) {
		while(2*k<=count){
			int j = 2*k;
			if(j+1<=count&&Utils.aRb((T)data[indexes[j]], (T)data[indexes[j+1]]))
				j++;
			if(Utils.aLb((T)data[indexes[k]], (T)data[indexes[j]])) break;
			
			Utils.swap(indexes, j, k);
			reverses[indexes[j]] = j;
			reverses[indexes[k]]=k;
			k=j;
		}
	}
	public boolean contain( int index ){

        return reverses[index+1] != null&&reverses[index+1]!=0;
    }
	public void change(int index,T newItem){
		index++;
		data[index] = newItem;
		shiftUp(reverses[index]);
		shiftDowm(reverses[index]);
	}
}
