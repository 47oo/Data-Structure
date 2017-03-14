package com.graph.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * 稀疏图 - 邻接表
 * @author 47
 *
 */
public class SparseGraph implements IGraph{
	//顶点数
	private int n;
	//边数
	private int m;
	//判断是不是有向图
	private boolean directed;
	private List<Integer>[] g;
	
	@SuppressWarnings("unchecked")
	public SparseGraph(int n,boolean directed){
		this.n = n;
		this.m = 0;
		this.directed = directed;
		g = new List[n];
		for(int i=0;i<n;i++){
			g[i] = new ArrayList<>();
		}
	
	}
	/**
	 * 在有向图中默认是由a->b
	 * @param a 顶点
	 * @param b 顶点
	 */
	public void addEdge(int a,int b){
		OutOfRange(a,b);
		g[a].add(b);
		if(a!=b&&!directed){
			g[b].add(a);
		}
		//边数+1
		m++;
		
	}
	public boolean hasEdge(int a,int b){
		OutOfRange(a,b);
		for(int i=0;i<g[a].size();i++){
			if(g[a].get(i).equals(b)){
				return true;
			}
		}
		return false;
	}
	//返回顶点数vertex
	public int V(){
		return n;
	}
	//边数edge
	public int E(){
		return m;
	}
	private void OutOfRange(int a,int b){
		if(a<0&&a>=n){
			throw new RuntimeException("超出顶点范围");
		}
		if(b<0&&b>=n){
			throw new RuntimeException("超出顶点范围");
		}
	}
	//对稀疏图某个顶点进行遍历的迭代器
	private class SGIterator extends Iterator{
		//迭代的位置
		private int index;
		
		private List<Integer> varr;
		//要选择遍历的顶点
		public SGIterator(int a){
			this.index = 0;
			varr = g[a];
		}
		public boolean hasNext(){
			return index<varr.size();
		}
		public int next(){
			int thisone = index;
			index++;
			return varr.get(thisone);
//			return varr.get(index++);
		}
	}
	@Override
	public Iterator iterator(int v) {
		
		return new SGIterator(v);
	}
}
