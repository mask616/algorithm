package com.mask.leetcode.reverseLeftWords;

public class ReverseLeftWords {

	public String reverseLeftWords(String s, int n) {
		return  s.substring(n, s.length()) + s.substring(0, n) ;
	}

	public static void main(String[] args) {
		String s = "abcdefg";
		int k = 2;
		System.out.println(new ReverseLeftWords().reverseLeftWords(s, k));
	}
}
