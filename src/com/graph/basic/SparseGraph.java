package com.graph.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * ϡ��ͼ - �ڽӱ�
 * @author 47
 *
 */
public class SparseGraph implements IGraph{
	//������
	private int n;
	//����
	private int m;
	//�ж��ǲ�������ͼ
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
	 * ������ͼ��Ĭ������a->b
	 * @param a ����
	 * @param b ����
	 */
	public void addEdge(int a,int b){
		OutOfRange(a,b);
		g[a].add(b);
		if(a!=b&&!directed){
			g[b].add(a);
		}
		//����+1
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
	//���ض�����vertex
	public int V(){
		return n;
	}
	//����edge
	public int E(){
		return m;
	}
	private void OutOfRange(int a,int b){
		if(a<0&&a>=n){
			throw new RuntimeException("�������㷶Χ");
		}
		if(b<0&&b>=n){
			throw new RuntimeException("�������㷶Χ");
		}
	}
	//��ϡ��ͼĳ��������б����ĵ�����
	private class SGIterator extends Iterator{
		//������λ��
		private int index;
		
		private List<Integer> varr;
		//Ҫѡ������Ķ���
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
