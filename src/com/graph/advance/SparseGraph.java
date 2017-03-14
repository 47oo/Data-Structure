package com.graph.advance;

import java.util.ArrayList;
import java.util.List;

/**
 * Í¼µÄÌáÉý°æ
 * @author 47
 *
 */
public class SparseGraph<T extends Comparable<T>> {
	//¶¥µãÊý
	private int n;
	//±ßÊý
	private int m;
	//ÊÇ·ñÎªÓÐÏòÍ¼
	private boolean directed;
	
	private List<Edge<T>>[] g;
	
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
	public int V(){
		return n;
	}
	public int E(){
		return m;
	}
	
	public void addEdge(int a,int b,T weight){
		OutOfRange(a,b);
		g[a].add(new Edge<T>(a,b,weight));
		if(a!=b&&!directed){
			g[b].add(new Edge<T>(b,a,weight));
		}
		m++;
	}
	public boolean hasEdge(int a,int b){
		OutOfRange(a,b);
		for(int i=0;i<g[a].size();i++){
			if(g[a].get(i).other(a)==b){
				return true;
			}
		}
		return false;
	}
	private void OutOfRange(int a,int b){
		if(a<0&&a>=n){
			throw new RuntimeException("³¬³ö¶¥µã·¶Î§");
		}
		if(b<0&&b>=n){
			throw new RuntimeException("³¬³ö¶¥µã·¶Î§");
		}
	}
}
