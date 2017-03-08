package com.sort.base.shell;

import com.sort.base.ISort;
import com.sort.util.Utils;

/**
 * 希尔排序
 * 
 * @author 47
 *
 */
public class ShellSort implements ISort {

	@Override
	public <T extends Comparable<T>> void sort(T[] arr, int n) {
		int h = 1;
		while (h < n / 3) {
			h = 3 * h + 1; // 用于决定每间隔几个元素进行排序
		}
		while (h >= 1) {
			// h还要等于1的原因是,无论如何都需要进行间隔为0的排序
			// 前面的排序是为了保证h=1时排序时交换次数变少
			for (int i = h; i < n; i++) {
				T e = arr[i];
				int j;
				for (j = i; j >= h && Utils.aLb(e, arr[j - h]); j -= h) {
					arr[j] = arr[j - h];
				}
				arr[j] = e;
			}
			h=h/3;
		}
	}
	public static void main(String[] args) {
		Integer [] arr = {1,2,3,4,5,8,2,3};
		new ShellSort().sort(arr, arr.length);
		Utils.printArr(arr, "Shell");
	}
}
