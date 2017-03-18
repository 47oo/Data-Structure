package com.graph.advance;

public class DenseGraph<T extends Comparable<T>> implements IGraph<T> {

	private int m;
	private int n;
	private boolean directed;
	private Edge<T>[][] g;

	@SuppressWarnings("unchecked")
	public DenseGraph(int n, boolean directed) {
		this.directed = directed;
		this.n = n;
		this.m = 0;
		g = new Edge[n][n];
	}

	@Override
	public void addEdge(int a, int b, T weight) {
		OutOfRange(a, b);
		g[a][b] = new Edge<T>(a, b, weight);
		if (!directed) {
			g[b][a] = new Edge<T>(b, a, weight);
		}
		m++;
	}

	public void show() {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				if (g[i][j] != null)
					System.out.print(g[i][j].weight() + "\t");
				else
					System.out.print("NULL\t");
			System.out.println();
		}
	}

	@Override
	public boolean hasEdge(int a, int b) {
		OutOfRange(a, b);
		return g[a][b] != null;
	}

	@Override
	public int V() {
		return n;
	}

	@Override
	public int E() {
		return m;
	}

	private class DGIterator extends Iterator<Edge<T>> {
		private int index;
		private Edge<T>[] varr;
		private boolean flag;
		public DGIterator(int s) {
			varr = g[s];
			index=-1;
		}

		@Override
		public boolean hasNext() {
			for(index+=1;index<varr.length;index++){
				if(varr[index]!=null){
					flag = true;
					break;
				}else {
					flag = false;
				}
			}
			return flag;
		}

		@Override
		public Edge<T> next() {
			flag = false;
			return varr[index];
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterator<Edge<T>> iterator(int s) {
		return new DGIterator(s);
	}

	private void OutOfRange(int a, int b) {
		if (a < 0 && a >= n) {
			throw new RuntimeException("³¬³ö¶¥µã·¶Î§");
		}
		if (b < 0 && b >= n) {
			throw new RuntimeException("³¬³ö¶¥µã·¶Î§");
		}
	}
}
