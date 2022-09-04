public class Seminar2 {
    private static int count = 0;

    public static void main(String[] args) {
        // System.out.println(power(3, 2));
        // System.out.println(power(2, -2));
        // System.out.println(power(3, 0));
        // System.out.println(power(0, 0));
        // System.out.println(power(10, 3));

        // twoNumbers(1, 7, 2, 1, "");
        // twoNumbers(11, 7, 2, 1, "");
        game(3, "1", "2", "3");
    }

    public static double power(double a, int b) {
        if (b == 0)
            return 1;
        if (b == 1)
            return a;
        if (b < 0)
            return power(1 / a, -b);
        double c = 1;
        if (b % 2 != 0)
            c = a;
        return power(a, b / 2) * power(a, b / 2) * c;
    }

    public static void twoNumbers(int a, int b, int c, int d, String result) {
        if (a > b) {
            if (count == 0)
                System.out.println("нет решений");
            return;
        }
        if (a == b) {
            count++;
            System.out.println(result);
            return;
        }
        twoNumbers(a * c, b, c, d, result + ", k1");
        twoNumbers(a + d, b, c, d, result + ", k2");
    }

    public static void game(int disk, String source, String dest, String buffer) {
        if (disk == 1) {
            System.out.println("Переместите диск " + source + " на " + dest);
            return;
        }
        game(disk - 1, source, buffer, dest);
        System.out.println("Переместите диск " + disk + " с " + source + " на " + dest);
        game(disk - 1, buffer, dest, source);
    }
}