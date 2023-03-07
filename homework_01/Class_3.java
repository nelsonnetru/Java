// 3. Реализовать простой калькулятор

import java.util.Scanner;

public class Class_3
{
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);

        System.out.println("Введите число A: ");
        float aDigit = iScanner.nextFloat();

        System.out.println("Введите число B: ");
        float bDigit = iScanner.nextFloat();

        System.out.println("Введите операцию + - / *: ");
        char doing = iScanner.next().charAt(0);

       iScanner.close();

       float result = 0f;

        if (doing == '-') result = aDigit - bDigit;
        else if (doing == '+') result = aDigit + bDigit;
        else if (doing == '*') result = aDigit * bDigit;
        else if (doing == '/') result = aDigit / bDigit;
    
        System.out.printf("%.2f %s %.2f = %.2f", aDigit, doing, bDigit, result);
    }
}
