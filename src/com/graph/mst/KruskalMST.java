package com.graph.mst;

import java.util.ArrayList;
import java.util.List;

import com.graph.advance.Edge;
import com.graph.advance.IGraph;
import com.graph.advance.Iterator;
import com.heap.base.MinHeap;
import com.union.find.UnionFind1;
/**
 * ¿ËÂ³Ë¹¿¨¶ûËã·¨
 * @author 47
 *
 * @param <T>
 */
public class KruskalMST<T extends Comparable<T>> {
	
	private List<Edge<T>> mst = new ArrayList<>();
	private String mstWeight="";
	public KruskalMST(IGraph<Edge<T>> ig){
		MinHeap<Edge<T>> mh = new MinHeap<>(ig.E());
		for(int i=0;i<ig.V();i++){
			Iterator<Edge<T>> it = ig.iterator(i);
			while(it.hasNext()){
				Edge<T> e = it.next();
				if(e.a()<e.b()){
					mh.add(e);
				}
			}
		}
		UnionFind1 uf = new UnionFind1(ig.V());
		while(!mh.isEmpty()&&mst.size()<ig.V()-1){
			Edge<T> e = mh.removeMin();
			if(uf.isConnected(e.a(), e.b()))
				 continue;
			mst.add(e);
			uf.unionElements(e.a(), e.b());
		}
		for(int i=0;i<mst.size();i++){
			mstWeight+= mst.get(i).weight()+" ";
		}
	}
	public List<Edge<T>> mstEdges(){
		return mst;
	}
	public String result(){
		return mstWeight;
	}
}
