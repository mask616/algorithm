package com.mask.leetcode.ReplaceSpace;

public class ReplaceSpace {

	public String replaceSpace(String s) {
		StringBuilder stringBuilder = new StringBuilder();
		for (char temp :s.toCharArray()) {
			if (temp == ' ') {
				stringBuilder.append("%20");
			}
			else {
				stringBuilder.append(temp);
			}
		}

		return stringBuilder.toString();
	}

	public static void main(String[] args) {
		String s = "We are happy.";

		System.out.println(new ReplaceSpace().replaceSpace(s));
	}
}
