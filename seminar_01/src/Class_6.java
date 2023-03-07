import java.util.Scanner;

public class Class_6
{
    public static void main(String[] args) {
        // написать функцию возведения числа a в степень b
        
        Scanner iScanner = new Scanner(System.in);

        System.out.print("Введите a: ");
        int a = iScanner.nextInt();
        
        System.out.print("Введите b: ");
        int b = iScanner.nextInt();
        iScanner.close();

        System.out.println("a^b = " + Math.pow(a, b));
    }
}
