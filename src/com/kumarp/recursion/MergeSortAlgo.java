package com.kumarp.recursion;

public class MergeSortAlgo {
	
	
	public static void merge(int []arr,int low,int mid,int high) {
	    int left=low;
	    int right=mid+1;
	    int result[]=new int[high-low+1];
	    int index=0;
	    while(left<=mid && right<=high) {
	    	if(arr[left]>arr[right]) {
	    		result[index++]=arr[right];
	    		right++;
	    	}else {
	    		result[index++]=arr[left];
	    		left++;
	    	}
	    }
	    
	    while(left<=mid) {
	    	result[index++]=arr[left];
	    	left++;
	    }
	    
	    while(right<=high) {
	    	result[index++]=arr[right++];
	    	right++;
	    }
	    
	    for(int i=low;i<=high;i++) {
	    	arr[i]=result[i-low];
	    }
	}
	public static void ms(int [] arr,int low,int high) {
		if (low>=high)return;
		int mid=(low+high)/2;
		ms(arr,low,mid);
		ms(arr,mid+1,high);
		merge(arr,low,mid,high);
	}
	
	public static void main(String[] args) {
		int arr []=new int []{5,17,8,100,1};
		
		ms(arr,0,arr.length-1);
		
		for(int a: arr) {
			System.out.print(a+" ");
		}
		
	}
	

}
