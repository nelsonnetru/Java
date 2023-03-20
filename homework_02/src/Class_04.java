import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;

public class Class_04
{
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in); 

        float aDigit = inputForCalc("A", iScanner);
        float bDigit = inputForCalc("B", iScanner);
        char doing = inputForCalc(iScanner);

        iScanner.close();

        try {
            calc(doing, aDigit, bDigit);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static float inputForCalc (String nameNumber, Scanner idScan) {
        System.out.printf("Введите число %s: ", nameNumber);
        float fDigit = idScan.nextFloat();
        return fDigit;
    }

    public static char inputForCalc (Scanner idScan) {
        System.out.printf("Введите операцию + - / *: ");
        char doing = idScan.next().charAt(0);
        return doing;
    }


    public static void calc (char doing, float aDigit, float bDigit) throws IOException {
        Logger logger = Logger.getLogger(Class_02.class.getName());
        logger.setLevel(Level.INFO);
        
        FileHandler fHandler = new FileHandler ("log_calc.txt", true);
        logger.addHandler(fHandler);

        SimpleFormatter sFormat = new SimpleFormatter();
        fHandler.setFormatter(sFormat);

        if (bDigit == 0 && doing == '/') {
            System.out.println("Ошибка! Делить на ноль нельзя!");
            logger.log(Level.WARNING, "CALC_ERROR: " + aDigit + ";" + doing + ";" + bDigit + " // Division by zero!");
        }
        else {
            float result = 0.0f;
            if (doing == '-') result = aDigit - bDigit;
            else if (doing == '+') result = aDigit + bDigit;
            else if (doing == '*') result = aDigit * bDigit;
            else if (doing == '/') result = aDigit / bDigit;
            else {
                logger.log(Level.WARNING, "CALC_ERROR: " + aDigit + ";" + doing + ";" + bDigit + " // Unknown operation!");
                return;
            }
            
            System.out.printf("%.2f %s %.2f = %.2f\n", aDigit, doing, bDigit, result); 
            logger.log(Level.INFO, "CALC: " + aDigit + ";" + doing + ";" + bDigit + ";" + result);
        }
    }
}
