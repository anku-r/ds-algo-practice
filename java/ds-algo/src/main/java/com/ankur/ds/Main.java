package com.ankur.ds;

import com.ankur.ds.linkedlist.Stack;

public class Main {
	
	public static void main(String[] args) {
		
		Stack<String> names = new Stack<>();
		
		names.push("Bruce Wayne");
		names.push("Barry Allen");
		names.push("Tony Stark");
		names.push("Diana Prince");
		names.push("Steve Rogers");
			
		names.forEach(System.out::println);
	}

}
