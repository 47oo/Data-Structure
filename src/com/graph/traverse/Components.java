package com.graph.traverse;

import com.graph.basic.IGraph;
import com.graph.basic.Iterator;

public class Components {
	
	private IGraph ig;
	private boolean[] visited;
	private int count;
	private int[] id;
	//------------------------
	//------------------------
	/**
	 * 深度优先搜索算法
	 * @param v 要遍历的顶点
	 */
	private void dfs(int v){
		//标记这个顶点已经被走过了
		visited[v] =true;
		id[v] = count;
		Iterator it = ig.iterator(v);
		while(it.hasNext()){
			int i = it.next();
			if(!visited[i])
				dfs(i);
		}
	}
	
	public Components(IGraph ig){
		this.ig = ig;
		visited = new boolean[ig.V()];
		count=0;
		id = new int[ig.V()];
		for(int i=0;i<ig.V();i++){
			id[i] = -1;
		}
		for(int i=0;i<ig.V();i++){
			if(!visited[i]){
				dfs(i);
				count++;
			}
		}
	}
	
	public int count(){
		return count;
	}
	public boolean isConnected(int a,int b){
		return id[a]==id[b];
	}
}
