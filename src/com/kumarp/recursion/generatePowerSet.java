package com.kumarp.recursion;

import java.util.LinkedList;
import java.util.List;

public class generatePowerSet {

	
	public static void solution(int cindex,LinkedList l,int [] originalarray) {
		if(cindex==originalarray.length) {
			System.out.println(l);
	        System.out.println(System.identityHashCode(l));
			return;
		}
		l.addLast(originalarray[cindex]);
		solution(cindex+1,l,originalarray);
		l.removeLast();
		solution(cindex+1,l,originalarray);
		
	}
	
	public static void main(String[] args) {
		LinkedList ll=new LinkedList();
		solution(0,ll,new int [] {1,2,3});
		
	}
}
