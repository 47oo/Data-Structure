package com.sort.advance.merge;

import com.sort.base.ISort;
import com.sort.util.Utils;
/**
 * 普通版归并排序
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

	// 递归使用归并排序,对arr[l...r]的范围进行排序
	private <T extends Comparable<T>> void mergeSort(T[] arr, int l, int r) {
		if (l >= r) {
			// l==r也作为返回条件的原因是同一个元素是不需要交换的
			return;
		}
//		if(r-l<=15){
			//可以对小范围排序使用插入排序
//			new InsertSort().sort(arr,l,r);
//		}
		// int mid = (l+r)/2;
		int mid = l + (r - l) / 2; // 防止数据溢出
		mergeSort(arr, l, mid);
		mergeSort(arr, mid + 1, r);
		merge(arr, l, mid, r);
	}

	// 这里是精髓,归并的过程
	@SuppressWarnings("unchecked")
	private <T extends Comparable<T>> void merge(T[] arr, int l, int mid, int r) {
		// 为了减少判断这里我偷个懒
		for (int i = l; i <= r; i++) {
			temp[i] = arr[i];
		}
		int i = l, j = mid + 1;
		// 这里的一层循环表示往原始数组中插入的此时
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
		Utils.printArr(arr, "归并排序");
	}
}
