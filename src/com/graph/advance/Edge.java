package com.graph.advance;
//做比较的时候可以直接使用Utils包下的东东
public class Edge<T extends Comparable<T>> {
	//--------------
	private int a; 
	private int b;
	//----------  a,b是作为一条边的两个顶点 a------b
	private T weight; //边的长度
	
	public Edge(int a,int b,T weight){
		this.a = a;
		this.b = b;
		this.weight = weight;
	}
	
	public int a(){
		return a;
	}
	public int b(){
		return b;
	}
	public T weight(){
		return weight;
	}
	public int other(int x){
		return x==a?b:a;
	}
	//this<other
	public boolean smallToOther(Edge<T> e){
		return weight.compareTo(e.weight())<0;
	}
	//this>other
	public boolean bigToOther(Edge<T> e){
		return weight.compareTo(e.weight())>0;
	}
	//this==other
	public boolean equalToOther(Edge<T> e){
		return weight.compareTo(e.weight())==0;
	}
}
