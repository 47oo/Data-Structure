package com.graph.basic;

public interface IGraph{
	void addEdge(int a,int b);
	boolean hasEdge(int a,int b);
	int V();
	int E();
	Iterator iterator(int v);
}
