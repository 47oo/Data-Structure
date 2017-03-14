package com.graph.traverse;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.graph.basic.IGraph;
import com.graph.basic.Iterator;
import com.graph.basic.SparseGraph;
import com.graph.util.Utils;

public class Path {
	private IGraph ig;
	
	private boolean[] visited;
	//from[a] = b  即表示a的上一个顶点是b
	private int[] from;
	
	private void dfs(int v){
		visited[v] = true;
		Iterator it = ig.iterator(v);
		while(it.hasNext()){
			int i = it.next();
			if(!visited[i]){
				from[i] = v;
				dfs(i);
			}
		}
	}
	/**
	 * 
	 * @param ig  包装成的图对象
	 * @param s    (start)  寻路的起点
	 */
	public Path(IGraph ig,int s){
		this.ig = ig;
		visited = new boolean[ig.V()];
		from = new int[ig.V()];
		for(int i=0;i<ig.V();i++){
			from[i] = -1;
		}
		//寻路算法
		dfs(s);
	}
	//用于判断a到s有没有路径
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
	//从s 到w的路径
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
			throw new RuntimeException("超出查询范围");
		}
	}
	public static void main(String[] args) {
		IGraph ig = new SparseGraph(13, false);
		Utils.readFileToLoadGraph(ig,new File("G:/workspace_maven/Data Structure(Java)/file/G1.txt"));
		boolean is = new Path(ig,0).hasPath(12);
		System.out.println(is);
	}
}
