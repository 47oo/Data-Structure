package com.sort.base.bubble;

import com.sort.base.ISort;
import com.sort.util.Utils;

/**
 * ð������
 * @author 47
 *
 */
public class BubbleSort implements ISort{

	@Override
	public <T extends Comparable<T>> void sort(T[] arr, int n) {
		boolean swapped;
		do{
			swapped = false;
			for(int i=1;i<n;i++){ 
				//ÿһ�ν���forѭ���ͻὫ��ǰ��Χ������һ�����õ���ǰ��Χ��ĩβ
				if(Utils.aRb(arr[i-1], arr[i])) 
					Utils.swap(arr, i-1, i);
				swapped = true;
			}
			n--;
		}while(swapped);
	}
	
	
}
