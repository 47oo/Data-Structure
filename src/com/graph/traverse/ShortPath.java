package com.graph.traverse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.graph.basic.IGraph;
import com.graph.basic.Iterator;

public class ShortPath {
	
	private IGraph ig;
	private boolean[] visited;
	private int[] from;
	private int[] ord;
	
	public ShortPath(IGraph ig,int s){
		this.ig =ig;
		visited = new boolean[ig.V()];
		from = new int[ig.V()];
		ord = new int[ig.V()];
		for(int i=0;i<ig.V();i++){
			from[i] = -1;
			ord[i] = -1;
		}
		ord[s] = 0;
		bfs(s);
	}
	public boolean hasPath(int a){
		return visited[a];
	}
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
	public int size(int w){
		return ord[w];
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
	private void bfs(int s){
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		visited[s] =true;
		ord[s] = 0;
		while(!q.isEmpty()){
			int v = q.poll();
			Iterator it = ig.iterator(v);
			while(it.hasNext()){
				int i= it.next();
				if(!visited[i]){
					q.add(i);
					visited[i] = true;
					from[i] =v;
					ord[i] = ord[v]+1;
				}
			}
		}
	}
}
