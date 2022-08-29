
// import java.nio.charset.MalformedInputException;
// import java.util.ArrayList;
// import java.util.List;

// class Solution {
//     List<List<Integer>> ans = new ArrayList<>();

//     public List<List<Integer>> combine(int n, int k){
//         genComb(n, k, 0, new ArrayList<>());
//         return ans;
//     }

//     private void genComb(int n, int k, int prevEl, List<Integer> curComb){
//         if (curComb.size() == k){
//             ans.add(new ArrayList<>(curComb));
//         }
//         for (int i = prevEl + 1; i <= n; i++){
//             curComb.add(i);
//             genComb(n, k, i, curComb);
//             curComb.remove(curComb.size() - 1);
//         }
//     }
// }

import java.util.ArrayList;
import java.util.List;

public class Seminar3 {
    static List<String> ans = new ArrayList<>();
    static char[] equation;
    static List<Integer> signIndexes = new ArrayList<Integer>();

    public static void main(String[] args) {
        String eq = "2? + ?5 = 69";
        solveEquation(eq);

        for (String string : ans) {
            System.out.print(string);
        }
    }

    private static void solveEquation(String eq) {
        equation = eq.replaceAll("\\s+", "").toCharArray();

        for (int i = 0; i < eq.length(); i++) {
            if (equation[i] == '?')
                signIndexes.add(i);
        }

        genComb(signIndexes.size(), new ArrayList<>());
    }

    private static void genComb(int k, List<Character> curComb) {
        if (curComb.size() == k) {
            checkComb(curComb);
            return;
        }
        for (char i = '0'; i <= '9'; i++) {
            curComb.add(i);
            genComb(k, curComb);
            curComb.remove(curComb.size() - 1);
        }
    }

    private static void checkComb(List<Character> curComb) {

        // String[] parts = eq.split("=");
        // String q = parts[0].split("+")[0].trim();
        // String w = parts[0].split("+")[1].trim();
        // String e = parts[1].trim();

        for (int i = 0; i < signIndexes.size(); i++) {
            equation[signIndexes.get(i)] = curComb.get(i);
        }
        int index = 0;
        int q = 0, w = 0, e = 0;

        while (equation[index] != '+') {
            q = q * 10 + (equation[index] - '0');
            index++;
        }
        index++;

        while (equation[index] != '=') {
            w = w * 10 + (equation[index] - '0');
            index++;
        }
        index++;

        while (index < equation.length) {
            e = e * 10 + (equation[index] - '0');
            index++;
        }
        if (q + w == e) {
            ans.add(String.format("%d + %d = %d", q, w, e));
        }

    }
}
