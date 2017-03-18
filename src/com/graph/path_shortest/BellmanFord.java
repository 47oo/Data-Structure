package com.graph.path_shortest;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.graph.advance.Edge;
import com.graph.advance.IGraph;
import com.graph.advance.Iterator;

/**
 * ±´¶ûÂü
 * 
 * @author 47
 *
 * @param <T>
 */
public class BellmanFord<T extends Comparable<T>> {
	private IGraph<Edge<T>> ig;
	private int s;
	private Integer[] distTo;
	private Edge<T>[] from;
	private boolean hasNegativeCycle;

	@SuppressWarnings("unchecked")
	public BellmanFord(IGraph<Edge<T>> ig, int s) {
		this.ig = ig;
		this.s = s;
		distTo = new Integer[ig.V()];
		from = new Edge[ig.V()];
		for(int i=0;i<ig.V();i++){
			distTo[i]=0;
		}
		bellman();
		hasNegativeCycle = detectNegativeCycle();
	}

	private boolean detectNegativeCycle() {
		for(int i=0;i<ig.V();i++){
			Iterator<Edge<T>> it = ig.iterator(i);
			while (it.hasNext()) {
				Edge<T> e = it.next();
				if (from[e.b()] == null || distTo[e.a()] + Integer.valueOf((String) e.weight()) < distTo[e.b()]) {
					return true;
				}
			}
		}
		return false;
	}

	private void bellman() {
		distTo[s] = 0;
		for (int pass = 1; pass < ig.V(); pass++) {
			for (int i = 0; i < ig.V(); i++) {
				Iterator<Edge<T>> it = ig.iterator(i);
				while (it.hasNext()) {
					Edge<T> e = it.next();
					if (from[e.b()] == null || distTo[e.a()] + Integer.valueOf((String) e.weight()) < distTo[e.b()]) {
						distTo[e.b()] = distTo[e.a()] + Integer.valueOf((String) e.weight());
						from[e.b()] = e;
					}

				}
			}
		}
	}
	public boolean negativeCycle(){
		return hasNegativeCycle;
	}
	@SuppressWarnings("unchecked")
	public T shortestPathTo(int end){
		return (T) distTo[end];
	}
	public boolean hasPath(int end){
		return from[end]!=null;
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
