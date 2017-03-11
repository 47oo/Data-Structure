package com.union.find;

public class UnionFind3 {
	
	private int[] parent;
	private int[] sz; //sz[i]表示以i为根的集合中元素个数
	private int count;
	
	public UnionFind3(int count){
		parent = new int[count];
		sz = new int[count];
		this.count =count;
		for(int i=0;i<count;i++){
			parent[i] = i;
			sz[i]=1;
		}
	}
	
	public int find(int p){
		if(p>=count||p<0){
			throw new RuntimeException("超出查找范围");
		}
		while(p!=parent[p]){
			p = parent[p];
		}
		return p;
	}
	public boolean isConnected(int p,int q){
		return find(p)==find(q);
	}
	public void unionElements(int p,int q){
		int pRoot = find(p);
		int qRoot = find(q);
		if(pRoot==qRoot){
			return;
		}
		if(sz[pRoot]<sz[qRoot]){
			parent[pRoot] = qRoot;
			sz[qRoot]+=sz[pRoot];
		}else{
			parent[qRoot]=pRoot;
			sz[pRoot]+=sz[qRoot];
		}
	}
}
