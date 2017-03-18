package com.graph.mst;

import java.util.ArrayList;
import java.util.List;

import com.graph.advance.Edge;
import com.graph.advance.IGraph;
import com.graph.advance.Iterator;
import com.heap.base.MinHeap;
import com.union.find.UnionFind1;
/**
 * 克鲁斯卡尔算法
 * @author 47
 *
 * @param <T>
 */
public class KruskalMST<T extends Comparable<T>> {
	
	private List<Edge<T>> mst = new ArrayList<>();
	private String mstWeight="";
	public KruskalMST(IGraph<Edge<T>> ig){
		//堆容量要放的是边数!!!
		MinHeap<Edge<T>> mh = new MinHeap<>(ig.E());
		for(int i=0;i<ig.V();i++){
			Iterator<Edge<T>> it = ig.iterator(i);
			while(it.hasNext()){
				Edge<T> e = it.next();
				if(e.a()<e.b()){ //这里的作用是为了防止放入重复的边
					mh.add(e);
				}
			}
		}//到这里所有的边都已经放入老人
		UnionFind1 uf = new UnionFind1(ig.V());//用于判断两个顶点是否已经连通
		while(!mh.isEmpty()&&mst.size()<ig.V()-1){  //边数=顶点数-1
			Edge<T> e = mh.removeMin(); 
			if(uf.isConnected(e.a(), e.b()))
				 continue;  
			mst.add(e);
			uf.unionElements(e.a(), e.b());
		}//每次都去未连通中最小的边
		for(int i=0;i<mst.size();i++){
			mstWeight+= mst.get(i).weight()+" ";
		}
		//进行两边去空格操作
		mstWeight.trim();
	}
	public List<Edge<T>> mstEdges(){
		return mst;
	}
	public String result(){
		return mstWeight;
	}
}
