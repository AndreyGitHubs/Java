// import java.util.Scanner;

// LessonOne - коментарии

/** коментарии
 * var - неявная типизация переменной
 * 
 * %d: целочисленных значений
 * %x: для вывода шестнадцатеричных чисел
 * %f: для вывода чисел с плавающей точкой
 * %e: для вывода чисел в экспоненциальной форме, например, 3.1415e+01
 * %c: для вывода одиночного символа
 * %s: для вывода строковых значений
 * 
 * 
 */

public class LessonOne {
    public static void main(String[] args) {
        var d = 123;
        System.out.println(d);
        System.out.println(getType(d));

        // int a = 123;
        // a = a-- - -- a;
        // System.out.println(a);

        // int[] arr = new int[] {1,2,3};
        // arr[2] = 13;
        // System.out.println(arr[2]);

        // int [][] arr = new int [3][5];

        // for (int i = 0; i < arr.length; i++){
        //     for (int j = 0; j < arr[i].length; j++){
        //         System.out.printf("%d", arr[i][j]);
        //     }
        // }
  
        // Scanner iScanner = new Scanner(System.in); // сканер ввода с клавиатуры
        // System.out.printf("name: "); // запрос что вводить
        // String name = iScanner.nextLine(); // перехват данных с клавиатуры
        // System.out.printf("Привет, %s!", name); // вывод ответа

        // Scanner iScanner = new Scanner(System.in);
        // System.out.printf("int a: ");
        // int x = iScanner.nextInt();
        // System.out.printf("double a: ");
        // double y = iScanner.nextDouble();
        // System.out.printf("%d + %f = %f", x, y, x + y);
        // iScanner.close();

        // Scanner iScanner = new Scanner(System.in);
        // System.out.printf("int a: ");
        // boolean flag = iScanner.hasNextInt();
        // System.out.println(flag);
        // int i = iScanner.nextInt();
        // System.out.println(i);       
        // iScanner.close();

        // int a = 1, b = 2;
        // int c = a + b;
        // String res = a + " + " + b + " = " + c;
        // System.out.println(res);

        // int[] arr = new int[] {1,0,2,3,0,4,5,0};
        // int[] ar = new int[8];
        // for (int i = 0 ; i < arr.length; i++){
        //     if (arr[i]==0){
        //         arr[i]=ar[i];
        //         ar[i+1]=arr[i];
        //     } else{
        //         arr[i]=ar[i];
        //     }
        //     System.out.printf("% d", ar[i]);
        // }
        
        // for (int i = 0 ; i < ar.length; i++){
        //     System.out.printf("% d", ar[i]);
        // }

//     String word1 = "abc";
//     String word2 = "pqr";
//     String merget;
//     for (int i = 0; i > word1.length; i ++){
//         merget = word1[i]+word2[i];
//     }
    
    

//     static String getType(Object o){
//         return o.getClass().getSimpleName();
// }

// }
