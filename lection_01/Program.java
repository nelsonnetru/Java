import java.util.Scanner;

public class Program
{
    public static void main (String[] args) {
        System.out.println("Hello World");
        System.out.println(Integer.MAX_VALUE);

        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите текст: ");
        String str = iScanner.nextLine();

        System.out.println("Введено: " + str);
    }
}

