package com.woniuxy.test;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public int[] twoSum(int[] nums, int target) {
		int[] arr = new int [2];
		for (int i = 0; i < nums.length-1; i++) {
			for (int j = i; j < nums.length-1-i; j++) {
				if (nums[i]+nums[j]==target) {
					arr[0]=i;
					arr[1]=j;
				}
			}
		}
		return arr;
       
    }
	public static void main(String[] args) {
		Test solution = new Test();
		int [] arr = new int[] {2,5,5,11};
		int target = 10;
		
		int [] list=  solution.twoSum(arr, target);
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}
	

}
