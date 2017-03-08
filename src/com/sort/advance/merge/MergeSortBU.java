package com.sort.advance.merge;

import com.sort.base.ISort;
import com.sort.util.Utils;
/**
 * �Ե׶��ϵĹ鲢����
 * @author 47
 *
 */
public class MergeSortBU implements ISort{
	private Object[] temp;
	@Override
	public <T extends Comparable<T>> void sort(T[] arr, int n) {
		//��������Ż��ķ�����
		//��һ�����ȵ�������в�������
		//����[0.....n]
		//[0,size][size+1,2*size]�Ĳ��ֽ��в�������
		temp = new Object[n];
		//�����sz�ĺ������ÿ�ι鲢�ĳ��ȵ�һ���Ƕ���
		for(int sz=1;sz<n;sz+=sz){
			for(int i=0;i<n;i+=2*sz){
				merge(arr,i,i+sz-1,Math.min(i+2*sz-1, n-1));
			}
		}
	}

	@SuppressWarnings("unchecked")
	private <T extends Comparable<T>>void merge(T[] arr, int l, int mid, int r) {
		for(int i=l;i<=r;i++){
			temp[i] = arr[i];
		}
		int i =l;
		int j = mid +1;
		
		for(int k=l;k<=r;k++){
			if(i>mid){
				arr[k]=(T)temp[j];
				j++;
			}else if(j>r){
				arr[k]=(T)temp[i];
				i++;
			}else if(Utils.aLb((T)temp[i], (T)temp[j])){
				arr[k]=(T)temp[i];
				i++;
			}else{
				arr[k]=(T)temp[j];
				j++;
			}
		}
	}
	public static void main(String[] args) {
		Integer[] arr ={7,392,23,1,42,1312};
		new MergeSortBU().sort(arr, arr.length);
		Utils.printArr(arr, "MSBU");
	}

}
