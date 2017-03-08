package com.sort.base.insert;

import com.sort.base.ISort;
import com.sort.util.Utils;
/**
 * ��������Ҫ��ǰ����������Ѿ��ź����
 * @author 47
 *
 */
public class InsertSort implements ISort{

	@Override
	public <T extends Comparable<T>> void sort(T[] arr, int n) {
		for(int i=1;i<n;i++){
			//Ѱ��Ԫ��arr[i]���ʵ�λ�ò���
			//д��1
//			for(int j=i;j>0;j--){
//				if(arr[j].compareTo(arr[j-1])<0){
//					Utils.swap(arr, j, j-1);
//				}else{
//					break;
//				}
//			}
			//д����
			for(int j=i;j>0&&arr[j].compareTo(arr[j-1])<0;j--){
				Utils.swap(arr, j, j-1);
			}
		}
	}
	
	public static void main(String[] args) {
		Integer[] arr ={1,5,7,8,2,3,}; 
		new InsertSort().sort(arr, arr.length);
		Utils.printArr(arr, "��������");
	}
}
