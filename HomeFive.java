import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HomeFive {

    static int[] nums1 = new int[] { 1, 2, 2, 1 };
    static int[] nums2 = new int[] { 2, 2 };

    public static void main(String[] args) {

    }

    class Solution {

        public static int[] intersect(int[] nums1, int[] nums2) {

            Map<Integer, Integer> map = new HashMap<>();
            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < nums1.length; i++) {
                map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
            }

            for (int i = 0; i < nums2.length; i++) {
                int num = nums2[i];
                if (map.containsKey(num) && map.get(num) != 0) {
                    map.put(num, map.get(num) - 1);
                    list.add(num);
                }
            }

            int[] ans = new int[list.size()];
            int i = 0;

            for (int num : list) {
                ans[i++] = num;
            }
            return ans;
        }
    }
}
