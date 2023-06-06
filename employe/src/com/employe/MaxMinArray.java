package com.employe;


public class MaxMinArray {
	public static void main(String[] args) {
		int[] arr1= {-4,-3,4,7};
		int[] arr2=new int[4];
		int max=0,min=0;
		for(int i=0;i<arr1.length;i++) {
			if(arr1[i]>0) {
				max+=arr1[i];
				arr1[i]=0;
			}
			min=min+arr1[i];
			arr2[i]=max+min;
			System.out.print(arr2[i]);
			System.out.print(i==arr1.length-1 ? "" : ", ");
		}
	}
}
