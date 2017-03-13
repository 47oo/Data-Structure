package com.graph.traverse;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.graph.basic.IGraph;
import com.graph.basic.Iterator;

public class Path {
	private IGraph ig;
	
	private boolean[] visited;
	
	private int[] from;
	
	private void dfs(int v){
		visited[v] = true;
		Iterator it = ig.iterator(v);
		while(it.hasNext()){
			int i = it.next();
			from[i] = v;
			dfs(i);
		}
	}
	/**
	 * 
	 * @param ig  ��װ�ɵ�ͼ����
	 * @param s    (start)  Ѱ·�����
	 */
	public Path(IGraph ig,int s){
		visited = new boolean[ig.V()];
		from = new int[ig.V()];
		for(int i=0;i<ig.V();i++){
			from[i] = -1;
		}
		//Ѱ·�㷨
		dfs(s);
	}
	//�����ж�a��s��û��·��
	public boolean hasPath(int a){
		rangeOfSize(a);
		return visited[a];
	}
	
	public void path(int w,List<Integer> vec){
		Stack<Integer> s = new Stack<>();
		int p =w;
		while(p!=-1){
			s.push(p);
			p = from[p];
		}
		while(!s.empty()){
			vec.add(s.pop());
		}
	}
	//��s ��w��·��
	public void showPath(int w){
		List<Integer> vec = new ArrayList<>();
		path(w,vec);
		for(int i=0;i<vec.size();i++){
			System.out.print(vec.get(i));
			if(i==vec.size()-1)
				System.out.println();
			else
				System.out.print(" -> ");
		}
	}
	private void rangeOfSize(int a){
		if(a<0||a>=ig.V()){
			throw new RuntimeException("������ѯ��Χ");
		}
	}
}
