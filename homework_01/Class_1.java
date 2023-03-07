import java.util.Scanner;

public class Class_1
{
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите число N: ");
        int numberN = iScanner.nextInt();
        iScanner.close();

        System.out.println("\t" + numberN + "-ое треугольное число = " + triangleNumber(numberN));
        System.out.println("\tАрифметическая прогрессия = " + arithmeticProgr(numberN));
        System.out.println("\tФакториал числа " + numberN + "! = " + factNumber(numberN));
    }

    public static int triangleNumber (int a) {
        return a * (a + 1) / 2;
    }

    public static int arithmeticProgr (int a) {
        if (a == 0) return a;
        else return a + arithmeticProgr(a - 1);
    }

    public static int factNumber (int a) {
        if (a == 1) return a;
        else return a * factNumber(a - 1);
    }
}
