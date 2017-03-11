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
			throw new RuntimeException("�������ҷ�Χ");
		}
		return id[p];
	}
	//�ж������ڵ��Ƿ���ͨ
	public boolean isConnected(int p, int q) {
		return find(p) == find(q);
	}
	//���ڱ���������ڵ��Ѿ���ͨ
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
