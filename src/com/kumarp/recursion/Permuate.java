package com.kumarp.recursion;

public class Permuate {
	
	public static void solution(String suffix,String prefix) {
		if(suffix.length()==0) {
			System.out.println(prefix);
		}
		for(int i=0;i<suffix.length();i++) {
			String character=suffix.substring(i, i+1);
			prefix=prefix+character;
			String temp=suffix;
			suffix=suffix.substring(0, i)+suffix.substring(i+1, suffix.length());
			solution(suffix,prefix);
			suffix=temp;
			prefix=prefix.substring(0,prefix.length()-1);
		
		}
	}
	
	public static void main(String[] args) {
		solution("123","");
	}

}
