package com.graph.advance;

//���Ƚϵ�ʱ�����ֱ��ʹ��Utils���µĶ���
public class Edge<T extends Comparable<T>> implements Comparable<T> {
	//--------------
	private int a; 
	private int b;
	//----------  a,b����Ϊһ���ߵ��������� a------b
	private T weight; //�ߵĳ���
	
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

	@Override
	public int compareTo(T o) {
		return weight.compareTo(o);
	}

}
