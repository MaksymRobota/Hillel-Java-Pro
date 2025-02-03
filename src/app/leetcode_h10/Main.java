package app.leetcode_h10;

import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
// Task 1. isPalindrome
        String example1 = "A man, a plan, a canal: Panama";
        System.out.println("Is palindrome? " + (isPalindrome(example1) ? "Yes" : "No"));
        String example2 = "race a car";
        System.out.println("Is palindrome? " + (isPalindrome(example2) ? "Yes" : "No"));
        String example3 = " ";
        System.out.println("Is palindrome? " + (isPalindrome(example3) ? "Yes" : "No"));
// Task 2. containsDuplicate
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4}) ? "Duplicate found" : "No duplicates");
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}) ? "Duplicate found" : "No duplicates");
// Task 3. twoSum
//      Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//      You may assume that each input would have exactly one solution, and you may not use the same element twice.
//      You can return the answer in any order.

        int[] result1 = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(result1[0] + ", " + result1[1]);
        int[] result2 = twoSum(new int[]{3, 2, 4}, 6);
        System.out.println(result2[0] + ", " + result2[1]);
        int[] result3 = twoSum(new int[]{3, 3}, 6);
        System.out.println(result3[0] + ", " + result3[1]);
    }

    public static boolean isPalindrome(String s) {
        String normalized = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        String reversed = new StringBuilder(normalized).reverse().toString();
        return normalized.equals(reversed);
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No solution found");
    }
}