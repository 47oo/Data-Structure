package com.sort.base;

public class Student implements Comparable<Student>{
	
	public int num;
	public String name;
	@Override
	public int compareTo(Student o) {
		return num -o.num;
	}

}
