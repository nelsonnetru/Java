import java.util.Scanner;

public class Class_03
{
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите строку для проверки на палиндром: ");
        String str = iScanner.nextLine();
        str = str.toLowerCase().replace(" ", "");
        iScanner.close();

        if (checkPalindrome(str)) System.out.println("Строка является палиндромом");
        else System.out.println("Строка не является палиндромом");
    }

    public static boolean checkPalindrome (String str) {

        int length = str.length();

        for (int i = 0; i < length / 2; i++)
            if (str.charAt(i) != str.charAt(length - i - 1)) 
                return false;

        return true;
    }
}
