//public class HomeFore {

// public class Solution {

//     public static void main(String[] args) {
//         simplifyPath(" /home/ ");
//         System.out.println(sb);
//     }

//     public static String simplifyPath(String path) {

//         String[] pass = path.split("/");
//         int[] prev = new int[pass.length]; 
//         int last = -1; 
//         StringBuilder sb = new StringBuilder();
//         sb.append('/');

//         for (int i = 1; i < pass.length; i++) {

//             if (pass[i].equals(".") || pass[i].equals(""))
//                 continue;

//             else if (pass[i].equals("..")) {

//                 if (last != -1) {
//                     sb.delete(sb.length() - pass[last].length() - 1, sb.length());
//                     last = prev[last];
//                 }
//             } else {
//                 prev[i] = last;
//                 last = i;
//                 sb.append(pass[i]);
//                 sb.append('/');
//             }
//         }
//         int len = sb.length();

//         if (sb.charAt(len - 1) == '/' && len > 1)
//             sb.delete(len - 1, len);

//         return sb.toString();
//     }
// }

// еще один вариант решения только есть ошибка. надо разобрать!

// public static String simplifyPath(String path) {
//     Stack<String> stack = new Stack<>();
//     StringBuilder ans = new String Builder();

// String[] tokens = path.split("/");
// for(String token : tokens){
//     if ("..".equals(token)){
//         if (!stack.isEmpty()){
//             stack.pop();
//         }                
//     } else if (!".".equals(token) && !token.isBlanck()){
//         stack.push(token);
//     }
// }

// ans.append("/");

// while (!stack.isEmpty()){
//     ans.append(stack.pop())
//     .append("/");
// }

// ans.deleteCharAt(ans.length() - 1);
// return ans.toString();

// }
//

import java.util.Stack;

class Solution {

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    stack.push(')');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != ')')
                        return false;
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '}')
                        return false;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != ']')
                        return false;
                    break;
                default:
                    return false;
            }
        }
        return stack.empty();
    }
}

// }
