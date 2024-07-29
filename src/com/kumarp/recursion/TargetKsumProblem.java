package com.kumarp.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TargetKsumProblem {
	// given an array and target sum
	//find if target sum can be achieved using this 
	//each element can be selected only once

	public static int solution(int[] arr, int targetsum, int index, LinkedList ll) {
		if (targetsum == 0 && index==arr.length) {
			return 1;
		}
		if (index >= arr.length || targetsum < 0)
			return 0;

		ll.addLast(arr[index]);
		int left=solution(arr, targetsum - arr[index], index + 1, ll);
		ll.removeLast();
		int right=solution(arr, targetsum, index + 1, ll);
		return left+right;

	}

	public static void main(String[] args) {
		int[] arr = new int[100];
		for(int i=0;i<100;i++) {
			arr[i]=i;
		}
		
		int total=solution(arr, 500, 0, new LinkedList());
		System.out.println(total);
	}
}
