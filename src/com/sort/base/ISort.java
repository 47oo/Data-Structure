package com.sort.base;

public interface ISort {
	public<T extends Comparable<T>> void sort(T[] arr,int n);
}
