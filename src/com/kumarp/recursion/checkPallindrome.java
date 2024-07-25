package com.kumarp.recursion;

import java.util.logging.Logger;

public class checkPallindrome {
	
	private static Logger logger=Logger.getLogger("test");
	
	public static boolean isPallindrome(int index,String str) {
		int length=str.length();
		if(index>(length/2)) {
			return true;
		}else if (str.charAt(index)!=str.charAt(length-index-1)){
			return false;
		}
		else
			return  isPallindrome(index+1, str);
	}
	
	public static void main(String[] args) {
		System.out.println(isPallindrome(0, "madam"));
		System.out.println(isPallindrome(0, "c"));

		
		assert isPallindrome(0, "madamT")==true;
		
	}
	

}
