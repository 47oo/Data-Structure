package com.sort.base;

public class Student implements Comparable<Student>{
	
	public int num;
	public String name;
	public Student(int num,String name){
		this.name= name;
		this.num = num;
	}
	@Override
	public int compareTo(Student o) {
		return num -o.num;
	}
	public String toString(){
		return "["+name+" "+num+"]";
	}

}
