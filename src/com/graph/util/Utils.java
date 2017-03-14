package com.graph.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.graph.basic.IGraph;
import com.graph.basic.SparseGraph;

public class Utils {
	private static final String SINGLE_SPACE=" ";
	public static void readFileToLoadGraph(IGraph ig,File f){
		Scanner in = null;
		try {
			in = new Scanner(f);
			String n = in.nextLine().split(SINGLE_SPACE)[0];
			if(ig.V()!=Integer.valueOf(n)){
				throw new RuntimeException("顶点数目不对");
			}
			while(in.hasNextLine()){
				String line = in.nextLine();
				String[] arr = line.split(SINGLE_SPACE);
				ig.addEdge(Integer.valueOf(arr[0]), Integer.valueOf(arr[1]));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			in.close();
		}
	}
	//目前只支持String类型
	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>>void readFileToLoadGraphAdvance(com.graph.advance.IGraph<T> ig,File f){
		Scanner in = null;
		try {
			in = new Scanner(f);
			String n = in.nextLine().split(SINGLE_SPACE)[0];
			if(ig.V()!=Integer.valueOf(n)){
				throw new RuntimeException("顶点数目不对");
			}
			while(in.hasNextLine()){
				String line = in.nextLine();
				String[] arr = line.split(SINGLE_SPACE);
				ig.addEdge(Integer.valueOf(arr[0]), Integer.valueOf(arr[1]),(T)arr[3]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			in.close();
		}
	}
	public static void main(String[] args) {
		IGraph ig = new SparseGraph(13, false);
		readFileToLoadGraph(ig,new File("G:/workspace_maven/Data Structure(Java)/file/G2.txt"));
		System.out.println(ig.hasEdge(0, 3));
	}
}
