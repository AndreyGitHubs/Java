# Set

Коллекции, содержащие уникальные элементы. 
Быстрая работа с данными.
«Основан» на Map’ах без пары.
Порядок добавления не хранится.

# HashSet

isEmpty() – проверка на пустоту.
add(V) – добавление элемента в коллекцию.
remove(V) – удаление элемента из коллекцию.
contains(V) – проверка на включение элемента в коллекции.
clear() – удаление всех элементов коллекции.
size() – возвращает количество элементов коллекции.

public class Ex001_HashSet {
  public static void main(String[] args) {
    Set<Integer> set = new HashSet<>();
    set.add(1); set.add(12); set.add(123);
    set.add(1234); set.add(1234);
    System.out.println(set.contains(12)); // true
    set.add(null);
    System.out.println(set.size()); // 5
    System.out.println(set); // [null, 1, 1234, 123, 12]
    set.remove(12);
    for (var item : set) System.out.println(item); // null 1 1234 123
    set.clear();
    System.out.println(set); // []
   }
}

addAll(Coll) – объединение множеств.
retainAll(Coll) – пересечение множеств.
removeAll(Coll) – разность множеств.

public class Ex002_MathSet {
   public static void main(String[] args) {
       var a = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7));
       var b = new HashSet<>(Arrays.asList(2,3,5,7,11,13,17));
       var u = new HashSet<Integer>(a); u.addAll(b);
       var r = new HashSet<Integer>(a); r.retainAll(b);
       var s = new HashSet<Integer>(a); s.removeAll(b);
       System.out.println(a); // [1, 2, 3, 4, 5, 6]
       System.out.println(b); // [17, 2, 3, 5, 7, 11]
       System.out.println(u); // [1, 17, 2, 3, 4, 5, 6, 11]
       System.out.println(r); // [2, 3, 5, 7]
       System.out.println(s); // [1, 4, 6]       boolean res = a.addAll(b);
   }
}

HashSet как синоним множества
first()
last()
headSet(E)
tailSet(E)
subSet(E1, E2)

import java.util.*;
public class Ex003_TreeSet {
   public static void main(String[] args) {
       var a = new TreeSet<>(Arrays.asList(1,7,2,3,6,4,5));
       var b = new TreeSet<>(Arrays.asList(13,3,17,7,2,11,5));

       System.out.println(a); // [1, 2, 3, 4, 5, 6, 7]
       System.out.println(b); // [2, 3, 5, 7, 11, 13, 17]
       System.out.println(a.headSet(4)); // [1, 2, 3]
       System.out.println(a.tailSet(4)); // [4, 5, 6, 7]
       System.out.println(a.subSet(3, 5)); // [3, 4]
   }
}

# TreeSet
В основе HashMap.
Упорядочен по возрастанию.
null’ов быть не может.

import java.util.*;

public class Ex003_TreeSet {
   public static void main(String[] args) {
       var a = new TreeSet<>(Arrays.asList(1,7,2,3,6,4,5));
       var b = new TreeSet<>(Arrays.asList(13,3,17,7,2,11,5));

       System.out.println(a); // [1, 2, 3, 4, 5, 6, 7]
       System.out.println(b); // [2, 3, 5, 7, 11, 13, 17]
       System.out.println(a.contains(1)); // true
   }
}

# LinkedHashSet

В основе HashMap.
Помнит порядок.

Использовать, когда нужен HashSet с запоминанием порядка элемента.

isEmpty() – проверка на пустоту.
add(V) – добавление элемента в коллекцию.
remove(V) – удаление элемента из коллекцию.
contains(V) – проверка на включение элемента в коллекции.
clear() – удаление всех элементов коллекции.
size() – возвращает количество элементов коллекции.

import java.util.*;

public class Ex004_LinkedHashSet {
   public static void main(String[] args) {
       var a = new LinkedHashSet<>(Arrays.asList(1,7,2,3,6,4,5));
       var b = new LinkedHashSet<>(Arrays.asList(13,3,17,7,2,11,5));
       a.add(28);
       System.out.println(a); // [1, 7, 2, 3, 6, 4, 5, 28]
       System.out.println(b); // [13, 3, 17, 7, 2, 11, 5]
   }
}

# §2. Введение в создание собственных типов

Java является объектно-ориентированным языком. 

Программа, написанная на Java, должна соответствовать 
парадигме объектно-ориентированного программирования. 
Следует понимать, что принципы ООП не просто определяют 
структуру программы. Это некий фундаментальный подход, 
с которым нам предстоит разобраться.

Спагетти-код – код, в котором данные связаны с методами 
для их обработки и в итоге может получиться так, что отдельные 
ветви алгоритма переплетаются, образуя запутанный клубок, 
в котором невозможно разобраться

Решение проблемы получило название объектно-ориентированное программирование или объектно-ориентированное проектирование или ООП.

При использовании данного подхода, упорядочивание кода базируется 
на объединении данных, с одной стороны, и методов для обработки этих 
данных, с другой стороны, в одно целое. Это «одно целое» в ООП называется экземпляром класса. 

Вся программа при этом имеет блочную структуру, что существенно упрощает анализ кода и внесение в него изменения.

ООП – искусственный прием, в большинстве случаев не зависящий, от языка программирования.

Если говорят, что разработка идет с использованием ООП – это говорит о том, что используются классы и экземпляры этих классов.
Каждый экземпляр класса определяется общим шаблоном, который называется классом. 
В рамках класса задается общая структура, на основе которой затем создаются экземпляры. 
Данные, относящиеся к классу, называются полями класса, а код для их обработки — методами класса.

Файл Worker.java

public class Worker {
    int id;
    int salary;
    String firstName;
    String lastName;
    
    public String toString {
       // String res = String.formatt("id:%d fn:%s ln:%s s:%d", id, //firstName, lastName, salary);
       //return res;
       
       return String.formatt("id:%d fn:%s ln:%s s:%d", id, //firstName, lastName, salary);
    }
    
    public boolean equals(Object o){
        Warker t = (Worker) o;
        return id == t.id && firstName == t.firstName;
    }
    
    public int hashCode(){
        return id;
    }
}

Файл New.java

Worker w1 = new Worker();
w1.firstName = "Имя_1";
w1.lastName = "Фамилия_1";
w1.salary = 100;
w1.id = 1000;

Worker w4 = new Worker();
w4.firstName = "Имя_1";
w4.lastName = "Фамилия_1";
w4.salary = 100;
w4.id = 1000;

Worker w2 = new Worker();
w2.firstName = "Имя_2";
w2.lastName = "Фамилия_2";
w2.salary = 100;
w2.id = 1000;

System.out.printlp(w1); //part2.Worker@7344699f  - хэш код человека
System.out.printlp(w2); //part2.Worker@6b95977
System.out.printlp(w3); //part2.Worker@7e9e5f8a

System.out.printlp(w1.toString()); // id: 100 fn:Имя_1 ln:Фамилия_1 s:100

System.out.printlp(w1==w4); //false 
System.out.printlp(w1.equals(w4));  //false

var workers = new HashSet<Worker>(Arrays.asList(w1, w2, w3));
System.out.printlp(workers.contains(w4)); // false