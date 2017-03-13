package com.graph.basic;

/**
 * 稠密图 - 邻接矩阵
 * @author 47
 *
 */
public class DenseGraph implements IGraph{
	//顶点数
	private int n;
	//边数
	private int m;
	//是否为有向图
	private boolean directed;
	private boolean[][] g;
	
	public DenseGraph(int n,boolean directed){
		this.n =n;
		this.m = 0;
		this.directed =directed;
		g = new boolean[n][n];
	}
	public int V(){
		return n;
	}
	public int E(){
		return m;
	}
	@Override
	public void addEdge(int a,int b){
		OutOfRange(a,b);
		g[a][b] = true;
		if(a!=b&&!directed){
			g[b][a]=true;
		}
		m++;
	}
	@Override
	public boolean hasEdge(int a, int b) {
		OutOfRange(a,b);
		return g[a][b];
	}
	private void OutOfRange(int a,int b){
		if(a<0&&a>=n){
			throw new RuntimeException("超出顶点范围");
		}
		if(b<0&&b>=n){
			throw new RuntimeException("超出顶点范围");
		}
	}
	//这一块可以做优化继承与组合,我考虑下
	public class DGIterator extends Iterator{
		//主要用于判定是否还有下一个元素
		private int index;
		private boolean[] varr;
		//要选择的顶点
		public DGIterator(int a){
			varr =g[a];
			this.index =-1;
		}
		public boolean hasNext(){
			for(index+=1;index<varr.length;index++){
				if(varr[index]){
					break;
				}else {
					index = -1;
				}
			}
			return index!=-1;
		}
		//当 next为-1的时候,就是与当前顶点直接相连的数据都遍历完成了
		public int next(){
			return index;
		}
	}
	@Override
	public Iterator iterator(int v) {
		return new DGIterator(v);
	}
}
