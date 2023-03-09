import java.util.Scanner;

public class Class_01
{
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите четное число N: ");

        if (iScanner.hasNextInt()) {
            int numberN = iScanner.nextInt();

            if (numberN%2 == 0 && numberN > 0) {
                System.out.print("Введите символ с1: ");
                String c1 = iScanner.next();

                System.out.print("Введите символ c2: ");
                String c2 = iScanner.next();

                if (c1.length() == 1 && c2.length() == 1)
                   System.out.println(methodC1C2(numberN/2, c1, c2));
                else {
                    System.out.println("Необходимо ввести символы c1 и с2, а не наборы символов");
                    return;
                }
            }
            else {
                System.out.println("Число должно быть четным и положительным");
                return;
            }
        }
        else {
            System.out.println("Неоходимо ввести число");
            return;
        }

        iScanner.close();
    }

    public static String methodC1C2 (int n, String c1, String c2) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            result = result.append(c1+c2);
        }

        return result.toString();
    }
}
