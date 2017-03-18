package com.graph.mst;

import java.util.ArrayList;
import java.util.List;

import com.graph.advance.Edge;
import com.graph.advance.IGraph;
import com.graph.advance.Iterator;
import com.heap.base.MinHeap;
/**
 * prim 算法 普利姆算法
 * @author 47
 *
 * @param <T>
 */
public class LazyPrimMST<T extends Comparable<T>> {
	//将图转化为对象
	private IGraph<Edge<T>> ig;
	//小顶堆 具体位置清寒heap包的相关内容,这里存放的是边的长度,也就是说容量是边数
	private MinHeap<Edge<T>> mh;
	//用于标记顶点是否被访问过
	private boolean[] marked;
	//这里我直接就是初始化了
	private List<Edge<T>> mst = new ArrayList<>();
	//返回的边的长度
	private String mstWeight="";
	//当所有的顶点都访问一次结束就表示最小生成树已经有了
	private void visit(int v){
		if(!marked[v]){
			marked[v] = true;
			Iterator<Edge<T>> it = ig.iterator(v);
			while(it.hasNext()){
				Edge<T> e = it.next();
				//只有当 a----b 两个顶点都标记了,才能确定这条边已经在小顶堆里面了
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
			//用于处理环形边即 a--a,默认跳过
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
		for(int i=0;i<mst.size();i++){
			mstWeight+= mst.get(i).weight()+" ";
		}
		mstWeight.trim();
	}
	public LazyPrimMST(IGraph<Edge<T>> ig,MinHeap<Edge<T>> mh){
		this.ig = ig;
		this.mh = mh;
		marked = new boolean[ig.V()];
		//这里直接用默认的顶点0开始
		lazy(0);
		
	}
	public List<Edge<T>> mstEdges(){
		return mst;
	}
	public String result(){
		return mstWeight;
	}
}
