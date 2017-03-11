package com.union.find;

public class UnionFind1 {

	private int[] id;
	private int count;

	public UnionFind1(int n) {
		count = n;
		id = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
	}

	public int find(int p) {
		if (p < 0 || p >= count) {
			throw new RuntimeException("超出查找范围");
		}
		return id[p];
	}
	//判断两个节点是否连通
	public boolean isConnected(int p, int q) {
		return find(p) == find(q);
	}
	//用于标记这两个节点已经连通
	public void unionElements(int p, int q) {
		int pID = find(p);
		int qID = find(q);
		if(pID==qID){
			return;
		}
		for(int i=0;i<count;i++){
			if(id[i]==pID){
				id[i]=qID;
			}
		}
	}
}
