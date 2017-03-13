package com.graph.basic;

/**
 * ����ͼ - �ڽӾ���
 * @author 47
 *
 */
public class DenseGraph implements IGraph{
	//������
	private int n;
	//����
	private int m;
	//�Ƿ�Ϊ����ͼ
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
			throw new RuntimeException("�������㷶Χ");
		}
		if(b<0&&b>=n){
			throw new RuntimeException("�������㷶Χ");
		}
	}
	//��һ��������Ż��̳������,�ҿ�����
	public class DGIterator extends Iterator{
		//��Ҫ�����ж��Ƿ�����һ��Ԫ��
		private int index;
		private boolean[] varr;
		//Ҫѡ��Ķ���
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
		//�� nextΪ-1��ʱ��,�����뵱ǰ����ֱ�����������ݶ����������
		public int next(){
			return index;
		}
	}
	@Override
	public Iterator iterator(int v) {
		return new DGIterator(v);
	}
}
