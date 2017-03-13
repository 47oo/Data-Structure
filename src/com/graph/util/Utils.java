package com.graph.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.graph.basic.IGraph;

public class Utils {
	private static final String SINGLE_SPACE=" ";
	public void readFileToLoadGraph(IGraph ig,File f){
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
	
}
