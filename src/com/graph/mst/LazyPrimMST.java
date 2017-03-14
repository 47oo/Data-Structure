package com.graph.mst;

import java.util.List;

import com.graph.advance.Edge;
import com.graph.advance.IGraph;
import com.graph.advance.Iterator;
import com.heap.base.MinHeap;

public class LazyPrimMST<T extends Comparable<T>> {
	private IGraph<T> ig;
	private MinHeap<Edge<T>> mh;
	private boolean[] marked;
	private List<Edge<T>> mst;
	private String mstWeight;
	
	private void visit(int v){
		if(!marked[v]){
			marked[v] = true;
			Iterator<Edge<T>> it = ig.iterator(v);
			while(it.hasNext()){
				Edge<T> e = it.next();
				if(!marked[e.other(v)]){
					mh.add(e);
				}
			}
		}
	}
	private void lazy(int v){
		visit(v);
		while(!mh.isEmpty()){
			Edge<T> e = mh.removeMin();
			if(marked[e.a()]==marked[e.b()]){
				continue;
			}
			mst.add(e);
			if(!marked[e.a()]){
				visit(e.a());
			}else{
				visit(e.b());
			}
		}
		mstWeight = mst.get(0).weight()+" ";
		for(int i=0;i<mst.size();i++){
			mstWeight+= mst.get(i).weight()+" ";
		}
		mstWeight.trim();
	}
	public LazyPrimMST(IGraph<T> ig,MinHeap<Edge<T>> mh){
		this.ig = ig;
		this.mh = mh;
		marked = new boolean[ig.V()];
		lazy(0);
		
	}
	public List<Edge<T>> mstEdges(){
		return mst;
	}
	public String result(){
		return mstWeight;
	}
}
