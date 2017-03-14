package com.graph.advance;

public interface IGraph<T extends Comparable<T>>{
	void addEdge(int a,int b,T weight);
	boolean hasEdge(int a,int b);
	int V();
	int E();
	<E>Iterator<E> iterator(int v);
}
