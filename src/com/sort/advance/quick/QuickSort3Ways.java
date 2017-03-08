package com.sort.advance.quick;

import com.sort.base.ISort;
import com.sort.util.Utils;

public class QuickSort3Ways implements ISort{

	@Override
	public <T extends Comparable<T>> void sort(T[] arr, int n) {
		quickSort3Ways(arr,0,arr.length-1);
	}

	private <T extends Comparable<T>> void quickSort3Ways(T[] arr, int l, int r) {
		if(l>=r){
			return;
		}
		T v = arr[l];
		int lt =l; //arr[l+1,lt]; �����С��v�ķ�Χ
		int gt = r+1; //arr[gt,r] ����Ǵ���v�ķ�Χ
		int i = l+1;//arr[lt+1,i) ����ǵ���v�ķ�Χ
		//3·������һ����ȷ������v�ĵ���λ�ñ��Ϊȷ������v�ķ�Χ��λ��
		while(i<gt){
			if(Utils.aLb(arr[i], v)){
				Utils.swap(arr, i, lt+1);//��ǰλ��i��lt+1����ʱ��λ�õ�Ԫ�ظպ����ڵ���v�ķ�Χ����λ�ý���
				i++;//�м�ָ�������ƶ�һλ
				lt++;//��ָ�������ƶ�һλ
			}else if(Utils.aRb(arr[i], v)){
				Utils.swap(arr, i, gt-1);
				gt--;//��ָ�������ƶ�һλ,����i�ǲ���Ҫ�ƶ���
			}else{//��ֵ��ȵ�ʱ��
				i++; //�м�ָ�������ƶ�һλ
			}
		}
		Utils.swap(arr, l, lt);
		quickSort3Ways(arr, l, lt-1);
		quickSort3Ways(arr, gt, r);
	}
	
	public static void main(String[] args) {
		Integer [] arr = {1,23,23,24,5356,3,6,1};
		new QuickSort3Ways().sort(arr, arr.length);
		Utils.printArr(arr, "3W");
	}

}
