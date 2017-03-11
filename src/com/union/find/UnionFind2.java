package com.union.find;

public class UnionFind2 {

	private int[] parent;
	private int count;

	public UnionFind2(int count) {
		this.count = count;
		parent = new int[count];
		for (int i = 0; i < count; i++) {
			parent[i] = i;
		}
	}

	public int find(int p) {
		if (p < 0 || p >= count) {
			throw new RuntimeException("²Ù×÷³¬³ö·¶Î§");
		}
		while (p != parent[p]) {
			p = parent[p];
		}
		return p;
	}

	public boolean isConnection(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		return pRoot == qRoot;
	}
	
	public void unionElements(int p,int q){
		int pRoot = find(p);
		int qRoot = find(q);
		if(pRoot==qRoot){
			return;
		}
		parent[pRoot] = qRoot;
	}
}
