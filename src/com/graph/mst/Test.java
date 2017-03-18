package com.graph.mst;

import java.io.File;
import java.util.List;

import com.graph.advance.DenseGraph;
import com.graph.advance.Edge;
import com.graph.advance.IGraph;
import com.graph.util.Utils;
import com.heap.base.MinHeap;

public class Test {
	public static void main(String[] args) {
		IGraph<Edge<Integer>> ig = new DenseGraph<>(8, false);
		Utils.readFileToLoadGraphAdvance(ig, new File("G:/workspace_maven/Data Structure(Java)/file/G2.txt"));
		LazyPrimMST<Integer> lpmst = new LazyPrimMST<>(ig, new MinHeap<>(16));
		List<Edge<Integer>> lplist = lpmst.mstEdges();
		for(int i=0;i<lplist.size();i++){
			System.out.print(lplist.get(i).a()+"--->"+lplist.get(i).b()+"\n");
		}
		System.out.println();
		System.out.println(lpmst.result());
		System.out.println("=====================");
		KruskalMST<Integer> lmst = new KruskalMST<>(ig);
		List<Edge<Integer>> llist = lmst.mstEdges();
		for(int i=0;i<llist.size();i++){
			System.out.print(llist.get(i).a()+"--->"+llist.get(i).b()+"\n");
		}
		System.out.println();
		System.out.println(lmst.result());
	}
}
