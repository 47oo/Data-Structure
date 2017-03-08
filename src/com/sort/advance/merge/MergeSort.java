package com.sort.advance.merge;

import com.sort.base.ISort;
import com.sort.util.Utils;
/**
 * ��ͨ��鲢����
 * @author 47
 *
 */
public class MergeSort implements ISort {
	private Object[] temp;

	@Override
	public <T extends Comparable<T>> void sort(T[] arr, int n) {
		temp = new Object[n];
		mergeSort(arr, 0, n - 1);
	}

	// �ݹ�ʹ�ù鲢����,��arr[l...r]�ķ�Χ��������
	private <T extends Comparable<T>> void mergeSort(T[] arr, int l, int r) {
		if (l >= r) {
			// l==rҲ��Ϊ����������ԭ����ͬһ��Ԫ���ǲ���Ҫ������
			return;
		}
//		if(r-l<=15){
			//���Զ�С��Χ����ʹ�ò�������
//			new InsertSort().sort(arr,l,r);
//		}
		// int mid = (l+r)/2;
		int mid = l + (r - l) / 2; // ��ֹ�������
		mergeSort(arr, l, mid);
		mergeSort(arr, mid + 1, r);
		merge(arr, l, mid, r);
	}

	// �����Ǿ���,�鲢�Ĺ���
	@SuppressWarnings("unchecked")
	private <T extends Comparable<T>> void merge(T[] arr, int l, int mid, int r) {
		// Ϊ�˼����ж�������͵����
		for (int i = l; i <= r; i++) {
			temp[i] = arr[i];
		}
		int i = l, j = mid + 1;
		// �����һ��ѭ����ʾ��ԭʼ�����в���Ĵ�ʱ
		for (int k = l; k <= r; k++) {
			if (i > mid) {
				arr[k] = (T) temp[j];
				j++;
			} else if (j > r) {
				arr[k] = (T) temp[i];
				i++;
			} else if (Utils.aLb((T) temp[i], (T) temp[j])) {
				arr[k] = (T) temp[i];
				i++;
			} else {
				arr[k] = (T) temp[j];
				j++;
			}

		}
	}

	public static void main(String[] args) {
		Integer[] arr = { 6, 3, 9, 6, 0, 7, 5,10 };
		new MergeSort().sort(arr, arr.length);
		Utils.printArr(arr, "�鲢����");
	}
}
