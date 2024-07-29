package com.kumarp.recursion;
import java.util.LinkedList;
import java.util.List;

public class TargetSum2 {
	
	public static void solution(int  [] arr,int index,int targetsum,LinkedList<Integer> ll) {
		if(targetsum==0 && index==arr.length) {
			System.out.println(ll);
			return ;
		}
		else if(index==arr.length) {
			return ;
		}
		
		
		if(targetsum-arr[index]>=0) {
			ll.addLast(arr[index]);
			solution(arr,index,targetsum-arr[index],ll);
			ll.removeLast();
		}
		solution(arr,index+1,targetsum,ll);
		
	}

	public static void main(String[] args) {
		solution(new int [] {1,2},0,6,new LinkedList<Integer>());

	}

}
