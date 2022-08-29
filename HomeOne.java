public class HomeOne {
    public static void main(String[] args) {

    }

    public static void duplicateZeros(int[] arr) {

        int[] copy = arr.clone();
        int last = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = copy[last];
            if (copy[last] == 0) {
                if (i + 1 < arr.length)
                    arr[i + 1] = 0;
                i++;
            }
            last++;
        }
    }

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    public static String reverseWords(String s) {
        StringBuilder list = new StringBuilder();
        int end = s.length() - 1;
        while (end >= 0) {
            if (s.charAt(end) == ' ') {
                end -= 1;
                continue;
            }
            int start = end - 1;
            while (start >= 0 && s.charAt(start) != ' ') {
                start -= 1;
            }
            list.append(" ");
            list.append(s.substring(start + 1, end + 1));
            end = start - 1;
        }
        if (list.length() > 0) {
            list.deleteCharAt(0);
        }
        return list.toString();
    }
}