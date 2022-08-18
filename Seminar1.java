public class Seminar1 {
    public static void main(String[] args) {

        // №1
        // int prod = 1, summ = 0;
        // int n = 4421;
        // while (n > 0) {
        //     int dic = n % 10;
        //     prod *= dic;
        //     summ += dic;
        //     n /= 10;
        // }
        // System.out.print(prod - summ);

        // №2
        // int a = word1.length() > word2.length() ? word1.length() : word2.length();
        // String result = "";
        // for (int i = 0; i < a; i++){
        //     if (i < word1.length()) result += word1.charAt(i);
        //     if (i < word2.length()) result += word2.charAt(i);
        // }
        // return result;

        // №3
        // int num1 = a.length() - 1;
        // int num2 = b.length() - 1;
        // String result = "";
        // int carry = 0;
        
        // while (num1 >=0 || num2 >=0){
        //     int firstDigit = num1 >= 0 ? a.charAt(num1--) - '0' : 0;
        //     int secondDigit = num2 >= 0 ? b.charAt(num2--) - '0' : 0;
        //     int summ = firstDigit + secondDigit + carry;
        //     carry = summ / 2;
        //     result = summ % 2 + result;
        // }
        // if (carry == 1) result = 1 + result;
        // return result;

        // №4
        // int n = nums.length;
        // for(int i = 0; i < n; i++){
        //      nums[i] = n * (nums[nums[i]] % n) + nums[i];
        // }
        // for(int i = 0; i < n; i++){
        //     nums[i] = nums[i] / n;
        // }
        // return nums;
    
        // или так   
        // int [] result = new int[nums.length];
        // for(int i = 0; i < result.length; i++){
        //     result[i] = nums[nums[i]];
        // }
        // return result;

        // №5
        // if (n == 0) return;
        
        // int last = n + m - 1;
        // m = m - 1;
        // n = n - 1;
        
        // while (n >= 0){
        //     if (m >= 0 && nums1[m] > nums2[n]){
        //         nums1[last--] = nums1[m--];
        //     } else {
        //         nums1[last--] = nums2[n--];
        //     }
        // }




    }
}
