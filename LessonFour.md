# LinkedList

Представляет собой двусвязный список.
Список – гибкая структура данных, позволяющая легко менять свой размер. Элементы доступны для вставки или удаления в любой позиции.

\* односвязный список \* - кода информация хранится о текущем и о следующем значении
\* двусвязынй список \*- когда информация хранится о текущем, следующем и предыдущем значении.
\* циклический односвязынй список \* - если в односвязном списке есть информация о том, что идет после последнего элемента и этим элементов является первый элемент.
\* двунаправленный циклический список \* - если в двусвязном списке есть информация, что после последнего элемента идет первый и перед первым идет последний

# Queue

Queue<Integer> queue = new LinkedList<Integer>();
queue.add(2); // добавление элемента
int item = queue.remove(); - // удаление элемента. Удаляет с самого начала списка

import java.util.*;
public class Ex002_Queue {
   public static void main(String[] args) {
       Queue<Integer> queue = new LinkedList<Integer>();
       queue.add(1);
       queue.add(2);
       queue.add(3);
       queue.add(4);
       System.out.println(queue); // [1, 2, 3, 4]
       int item = queue.remove();
       System.out.println(queue); // [2, 3, 4]
       queue.offer(2809);
       item = queue.remove();
       System.out.println(queue); // [3, 4, 2809]
       item = queue.remove();
       System.out.println(queue); // [4, 2809]
       item = queue.poll();
       System.out.println(queue); // [2809]
   }
}

import java.util.*;
public class Ex002_Queue {
   public static void main(String[] args) {
       Queue<Integer> queue = new LinkedList<Integer>();
       queue.add(1);
       int item = queue.remove();
       queue.offer(2809);
       item = queue.poll();
       System.out.println(queue);
       queue.remove(2809); // зачем очередь??
       queue.element()
       queue.peek()
   }
}

# PriorityQueue
Наивысший приоритет имеет «наименьший» элемент.

import java.util.*;

public class Ex000 {
    Public static void main(String[] args){
        PriorityQoeue<Integer> pq = new PriorityQoeue<Integer>();
        pq.add(123);
        pq.add(3);
        pq.add(13);
        pq.add(1);
        System.out.println(pq);  // [ 1,3,13,123 ] // все по порядку
        System.out.println(pq.poll()); - извлекаем (наивысший приоритет имеет меньшее значение)
    }
}

# Deque

Линейная коллекция, которая поддерживает вставку и удаление элементов на обоих концах. 

import java.util.*;
public class Ex003_Deque {
   public static void main(String[] args) {
       Deque<Integer> deque = new ArrayDeque<>();
       Deque<Integer> deque = new ArrayDeque<>();
       deque.addFirst(1);   deque.addLast(2);
       deque.removeLast();  deque.removeLast();
       deque.offerFirst(1); deque.offerLast(2);
       deque.pollFirst();   deque.pollLast();
       deque.getFirst();    deque.getLast();
       deque.peekFirst();   deque.peekLast();
   }
}

# Stack

То что пришло в первую очередть будет обработано в последнюю очередь.
Stack представляет собой обработку данных по принципу LIFO. Расширяет Vector пятью операциями, которые позволяют рассматривать вектор как стек.


push(E item)
pop()

import java.util.*;
public class Ex004_Stack {
   public static void main(String[] args) {
       Stack<Integer> stack = new Stack<>();
       stack.push(1);
       stack.push(12);
       stack.push(123);
       System.out.println(stack.pop()); // 123
       System.out.println(stack.pop()); // 12
       System.out.println(stack.pop()); // 1
   }
}

123*+ - разбираем пример написания кода

import java.util.Stack;

public class Seminar4 {
    private static boolean isDigit(String[]){
    public static void main(String[] args) {

        //var exp = "1 2 3 * 4 * + 10 5 / * 20".split(" ");
        //var exp = "1 2 + 3 *".split(" "); 
        var exp = "1 2 3 * +".split(" ");  // 1 + 2 * 3 - есть выражение в постфиксной форме, далее разбираем его с помощью сплита и разделителя пробела
        int res = 0;// результат выражения
        System.out.println(exp);
            
            //int isDigit(int character[]);
            Stack<Integer> st = new Stack<>(); // стек где хранятся числа
            for(int i = 0; i < exp.length; i++){  // пробегаемся циклом по всем элементам выражения
                
                if(isDigit(exp[i])){ // если текущий элемент является числом
                    st.push(Integer.parseInt(exp[i])); // добавляем в стек преобразовав его из строки в число
                } else {
                    switch (exp[i]){
                        case "+":
                            res = st.pop() + st.pop();
                            st.push(res);
                            break;
                        case "-":
                            res = -st.pop() + st.pop();
                            st.push(res);
                            break;
                        case "*":
                            res = st.pop() * st.pop();
                            st.push(res);
                            break;
                        case "/":
                            res = st.pop() / st.pop();
                            st.push(res);
                            break;
                        default:
                            break;
                    }
                }
            }
        System.out.printf("%d\n", st.pop());
    }
}
}
