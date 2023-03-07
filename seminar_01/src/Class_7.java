import java.util.Scanner;

public class Class_7
{
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);

        System.out.print("Введите a: ");
        int a = iScanner.nextInt();

        System.out.print("Введите b: ");
        int b = iScanner.nextInt();

        System.out.print("Введите значение c для К1 (умножение): ");
        int c = iScanner.nextInt();

        System.out.print("Введите значение d для К2 (сумма): ");
        int d = iScanner.nextInt();

        iScanner.close();

        int x = generate(a, b, c, d, "");
        System.out.println("\n" + x);
    }

    public static int generate (int a, int b, int c, int d, String command) {
        if (a == b) {
            System.out.println( "\n FINISH: " + a + "=" + b);
            return 1;
        }
        else if (a > b) return 0;
        else  {
            System.out.print(command);
            return generate (a + d, b, c, d, "K2") + generate (a * c, b, c, d, "K1");
        }
    }

}
