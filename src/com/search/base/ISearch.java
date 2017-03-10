package com.search.base;

public interface ISearch {
	
	public<T extends Comparable<T>> int search(T[] arr,int n,T target);
}
