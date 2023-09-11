package com.java;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static String addNumeric(String a, String b, int base) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry == 1) {
            if (i >= 0) {
                carry += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                carry += b.charAt(j--) - '0';
            }
            sb.append(carry % base);
            carry /= base;
        }

        return sb.reverse().toString();
    }

    public static int mySqrt(int x) {
        int start=0, end=x;
        long mid=0;

        while(start <= end){
            mid = (start + end) / 2;
            long check = mid * mid;
            if (check == x) {
                return (int) (mid);
            } else if (check > x) {
                end = (int) (mid - 1);
            } else {
                start = (int) (mid + 1);
            }
        }
        return end;
    }

    public static int climbStairs(int n) {
        if (n == 1) {
            return n;
        }

        int n1 = 1;
        int n2 = 2;

        for (int i = 3; i <= n; i++) {
            int next = n1;
            n1 = n2;
            n2 = next + n2;
        }

        return n2;
    }

    public static int climbStairsRecursively(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return climbStairsRecursively(n - 1) + climbStairsRecursively(n - 2);
    }

    public static int majorityElement(int[] nums) {
        //Arrays.sort(nums);
        //return nums[nums.length / 2];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums){
            map.putIfAbsent(i, 0);
            map.put(i, map.get(i) + 1);
            if (map.get(i) > (nums.length / 2)){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String firstResult = Solution.addNumeric("11", "10", 2);
        System.out.println(firstResult);

        String secondResult = Solution.addNumeric("114", "69", 10);
        System.out.println(secondResult);

        int thirdResult = Solution.mySqrt(101);
        System.out.println(thirdResult);

        int fourthResult = Solution.climbStairs(22);
        System.out.println(fourthResult);

        int fifthResult = Solution.climbStairsRecursively(22 + 1);
        System.out.println(fifthResult);

        int sixthResult = Solution.majorityElement(new int[] {3, 3, 3, 3, 6, 6, 6, 6, 6, 6, 6});
        System.out.println(sixthResult);
    }
}
