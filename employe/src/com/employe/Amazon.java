package com.employe;

public class Amazon {
	static void NoOfLetter(String str) {
		char[] arr=str.toCharArray();
		for(int i=0;i<str.length();i++) {
			int c=0;
			for(int j=0;j<arr.length;j++) {
				if(str.charAt(i)==arr[j]) {
					c++;
					
				}
			}
			if(c>0) {
				System.out.println(str.charAt(i)+"--"+c);
			}
		}
	}
	
	static boolean stringPalindrome(String str) {
		boolean res=true;
		int start=0,end=str.length()-1;
		while(true) {
			if(str.charAt(start)!=str.charAt(end)) {
				res=false;
				break;
			}
			if(start==end||start+1==end) {
				break;
			}
			start++;
			end--;
		}
		return res;
	}
	public static void main(String[] args) {
		NoOfLetter("hhhello");
		System.out.println(stringPalindrome("weh"));
		
	}
}
