import java.time.LocalDateTime;
import java.util.Scanner;

public class Class_1
{
    public static void main(String[] args) {
        // Ввод имени в консоль и приветствие в зависимости от времени суток
        
        LocalDateTime nowTime = LocalDateTime.now();
        System.out.println("Сейчас: " + nowTime);
        int nowHour = nowTime.getHour();

        String helloWords = "";
        if (nowHour >= 5 && nowHour < 12) helloWords = "Доброе утро";
        else if (nowHour >= 12 && nowHour < 18) helloWords = "Добрый день";
        else if (nowHour >= 18 && nowHour <= 22) helloWords = "Добрый вечер";
        else if ((nowHour >= 23) || (nowHour >= 0 && nowHour < 5)) helloWords = "Доброй ночи";

        // String userName = System.console().readLine();
        System.out.print("Введите имя: ");
        Scanner iScanner = new Scanner(System.in);
        String userName = iScanner.nextLine();

        System.out.printf("%s, %s!", helloWords, userName);
        iScanner.close();
    }
}
