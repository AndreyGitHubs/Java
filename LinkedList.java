import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

// public class Seminar4 {
//     public static void main(String[] args) {

//     }

// разворот массива [1,2,3,4,5] -> [5,4,3,2,1]
// class Solution {
// public ListNode reverseList(ListNode head) {
// ListNode prev = null;
// ListNode curr = head;

// while (curr != null) {
// ListNode next = curr.next;
// curr.next = prev;
// prev = curr;
// curr = next;
// }
// return prev;
// }
// }

public class LinkedList {

    public static void main(String[] args) {
        String[] tokens = { "2", "1", "+", "3", "*" };
        System.out.print(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Set<String> operator = Set.of("+", "-", "/", "*");
        Deque<Integer> dq = new ArrayDeque<>();
        for (String token : tokens) {
            if (!operator.contains(token)) {
                dq.addLast(Integer.valueOf(token));
            } else {
                int op2 = dq.pollLast();
                int op1 = dq.pollLast();
                dq.addLast(calculate(op1, op2, token));
            }
        }
        return dq.pollLast();
    }

    public static int calculate(int op1, int op2, String token) {

        int result = 0;
        switch (token) {
            // case "+" -> res = op1 + op2;
            // case "-" -> res = op1 - op2;
            // case "/" -> res = op1 / op2;
            // case "*" -> res = op1 * op2;
            case "+":
                return result = op1 + op2;
            case "-":
                return result = op1 - op2;
            case "/":
                return result = op1 / op2;
            case "*":
                return result = op1 * op2;
        }
        return 0;
    }
}

// }
