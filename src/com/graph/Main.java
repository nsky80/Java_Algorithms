package com.graph;

public class Main{
	
	public static void main(String [] args){
		String str=new String("5");
		String str2="5";
		System.out.println(str == str2);
		String str3 = new String("5");
		System.out.println(str == str3);
		System.out.println(str.hashCode() == str3.hashCode());
		double d = 1.0000;
		if (d == 1) {
			System.out.println("hello");
		}
	}
	
}