package com.graph.path_shortest;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.graph.advance.Edge;
import com.graph.advance.IGraph;
import com.graph.advance.Iterator;
import com.heap.base.advance.IndexMinHeap;

/**
 * 迪杰斯特拉；狄克斯特拉；最短路径
 * 
 * @author 47
 *
 * @param <T>  目前只能是Integer
 */
public class Dijkstra<T extends Comparable<T>> {

	private IGraph<Edge<T>> ig;
	//s=>start起点
	private int s;
	//因为Java不支持操作符的重定义,所以这里用Integer
	private Integer[] distTo;
	private boolean[] marked;
	private Edge<T>[] from;
	
	@SuppressWarnings("unchecked")
	public Dijkstra(IGraph<Edge<T>> ig,int s){
		this.s =s;
		this.ig = ig;
		distTo = new Integer[ig.V()];
		for(int i=0;i<ig.V();i++){
			distTo[i]=0;
		}
		marked = new boolean[ig.V()];
		from = new Edge[ig.V()];
		dijkstra();
	}
	
	@SuppressWarnings( "unchecked" )
	private void dijkstra(){
		IndexMinHeap<T> imh = new IndexMinHeap<>(ig.E());
		distTo[s] = 0;
		imh.insert(s, (T) distTo[s]);
		marked[s] = true;
		while(!imh.isEmpty()){
			int a = imh.removeMinIndex();
			//disTo[v] 就是s到v的最短距离
			marked[a] = true;
			Iterator<Edge<T>> it = ig.iterator(a);
			while(it.hasNext()){
				Edge<T> e = it.next();
				int b = e.other(a);
				if(!marked[b]){
					if(from[b]==null||distTo[a]+Integer.valueOf((String)e.weight())<distTo[b]){
						distTo[b] = distTo[a]+Integer.valueOf((String)e.weight());
						from[b] = e;
						if(imh.contain(b)){
							imh.change(b, (T) distTo[b]);
						}else{
							imh.insert(b, (T) distTo[b]);
						}
					}
				}
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public T shortestPathTo(int e){
		return (T)distTo[e];
	}
	public boolean hasPath(int e){
		return marked[e];
	}
	
	public void shortestPath(int e,List<Edge<T>> vec){
		Stack<Edge<T>> s = new Stack<>();
		Edge<T> v = from[e];
		while(v.a()!=this.s){
			s.push(v);
			v = from[v.a()];
		}
		s.push(v);
		while(!s.empty()){
			vec.add(s.pop());
		}
	}
	//e ==end
	public void showPath(int e){
		List<Edge<T>> vec = new ArrayList<>();
		shortestPath(e, vec);
		for(int i=0;i<vec.size();i++){
			System.out.print(vec.get(i).a()+"->");
			if(i==vec.size()-1){
				System.out.println(vec.get(i).b());
			}
		}
	}
}
