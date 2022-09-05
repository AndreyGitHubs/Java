import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeTwo {
    public static void main(String[] args) {
        int[] arr = new int[] { 7, 1, 19, 5 };
        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSort(int[] arr, int left, int right) {
        if (left >= right)
            return;

        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int next = mid + 1;
        int prev = left;
        int count = 0;
        while (prev <= mid && next <= right) {
            if (arr[prev] < arr[next]) {
                temp[count++] = arr[prev++];
            } else {
                temp[count++] = arr[next++];
            }
        }
        while (prev <= mid)
            temp[count++] = arr[prev++];
        while (next <= right)
            temp[count++] = arr[next++];

        for (int i = left; i <= right; i++) {
            arr[i] = temp[i - left];
        }
    }

    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> result = new ArrayList<>();
            if (n < k)
                return result;
            int[] arr = new int[n];
            for (int i = 1; i <= n; i++)
                arr[i - 1] = i;
            backback(k, 0, arr, new ArrayList<Integer>(), result);
            return result;
        }

        private static void backback(int k, int start, int[] arr, List<Integer> list, List<List<Integer>> result) {
            if (k == 0)
                result.add(new ArrayList<Integer>(list));
            else {
                for (int i = start; i <= arr.length - k; i++) {
                    list.add(arr[i]);
                    backback(k - 1, i + 1, arr, list, result);
                    list.remove(list.size() - 1);
                }
            }

            // if (k == 0) {
            // result.add(new ArrayList<Integer>(list));
            // return;
            // }

            // for (int i = start; i <= arr.length - k; i++) {
            // list.add(arr[i]);
            // backback(k - 1, i + 1, arr, list, result);
            // list.remove(list.size() - 1);
            // }
        }
    }
}
