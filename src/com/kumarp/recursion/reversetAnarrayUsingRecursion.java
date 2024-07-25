package com.kumarp.recursion;

public class reversetAnarrayUsingRecursion {

	public static void reverse(int i, int[] arr) {
		int len = arr.length;
		if (i > (len / 2)) {
			return;
		} else { // swap value
			int temp = arr[i];
			arr[i] = arr[len - i - 1];
			arr[len - i - 1] = temp;
		}
		reverse(++i, arr);

	}

	public static void main(String[] args) {
		int arr []=new int[] { 1, 3, 5 ,100};
		reverse(0, arr);
		for(int a:arr) {
			System.out.println(a);
		}

	}
}
