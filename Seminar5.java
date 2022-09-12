// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.HashMap;
// import java.util.HashSet;
// import java.util.List;
// import java.util.Map;
// import java.util.Set;

public class Seminar5 {
    public static void main(String[] args) {
        // leetcode 1
        // int[] nums = { 2, 7, 11, 15 };
        // int target = 9;

        // System.out.println(Arrays.toString(twoSum(nums, target)));

        // leetcode 349
        // int[] nums1 = { 4, 9, 5 };
        // int[] nums2 = { 9, 4, 9, 8, 4 };

        // System.out.println(Arrays.toString(intersection(nums1, nums2)));

        // leetcode 13
        // String s = "MCMXCIV";
        // // s = "III";
        // romanToInt(s);
    }

    // leetcode 1
    // public static int[] twoSum(int[] nums, int targer) {
    // // int[] result = new int[2];
    // Map<Integer, Integer> numsMap = new HashMap<>();

    // for (int i = 0; i < nums.length; i++) {
    // int dif = targer - nums[i];

    // if (numsMap.containsKey(dif)) {
    // return new int[] { numsMap.get(dif), i };
    // }
    // numsMap.put(nums[i], i);
    // }
    // return null;

    // leetcode 13

    // public static int romanToInt(String s) {
    // Map<Character, Integer> map = new HashMap<>();
    // map.put('I', 1);
    // map.put('V', 5);
    // map.put('X', 10);
    // map.put('L', 50);
    // map.put('C', 100);
    // map.put('D', 500);
    // map.put('M', 1000);
    // int result = 0;
    // for (int i = 0; i < s.length() - 1; i++) {
    // if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) {
    // result += map.get(s.charAt(i));
    // } else {
    // result -= map.get(s.charAt(i));
    // }
    // }

    // result += map.get(s.charAt(s.length() - 1));
    // System.out.println(result);
    // return result;
    // }

    // leetcode 349
    // public static int[] intersection(int[] nums1, int[] nums2) {

    // if (nums1.length > nums2.length) {
    // int[] temp = nums2;
    // nums2 = nums1;
    // nums1 = temp;
    // }
    // List<Integer> res = new ArrayList<>();

    // Set<Integer> smallSet = new HashSet<>();
    // for (int i = 0; i < nums1.length; i++) {
    // smallSet.add(nums1[i]);
    // }

    // for (int i = 0; i < nums2.length; i++) {
    // if (smallSet.contains(nums2[i])) {
    // res.add(nums2[i]);
    // smallSet.remove(nums2[i]);
    // }
    // }

    // int[] result = new int[res.size()];
    // for (int i = 0; i < res.size(); i++) {
    // result[i] = res.get(i);
    // }
    // return result;
    // }

    // leetcode 350
}
