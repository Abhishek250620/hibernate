package com.employe;

import java.util.Scanner;

public class Max {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int size=sc.nextInt();
		int[] arr=new int[size];
		for(int i=0;i<arr.length;i++) {
			arr[i]=sc.nextInt();
		}
		int max=1;
		int[] arr2=arr;
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]+" "+arr2[i]);
		}
		int c=0;
		for(int i=0;i<size;i++) {

			for(int j=0;j<size;j++) {
				if(arr[i]==arr2[j]) {
					c++;
					arr2[j]=-1;
				}
			}
			c=0;
			System.out.println("c="+c);
			if(c>max) {
				max=c;
			}
		}
		System.out.println(max);
	}
}
