import java.util.Scanner;

public class Class_4
{
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите выражение (например 2?+?5=69): ");
        String inputStr = iScanner.nextLine();
        iScanner.close();
        
        System.out.println();

        int indexExpr = inputStr.indexOf('+');
        int indexEq = inputStr.indexOf('=');

        String aStr = inputStr.substring(0, indexExpr).trim();
        String bStr = inputStr.substring(indexExpr+1, indexEq).trim();
        int result = Integer.parseInt(inputStr.substring(indexEq+1, inputStr.length()).trim());

        boolean flag = false;

        for (int i = 0; i <= 9; i++) {
           int aInt = Integer.parseInt(aStr.replace("?", i+""));
            for (int j = 0; j <= 9; j++) {
                int bInt = Integer.parseInt(bStr.replace("?", j+""));
                if (aInt + bInt == result) {
                    System.out.printf("%d + %d = %d\n", aInt, bInt, result);
                    flag = true;
                }
            }
        }

        if (!flag) System.out.println("Для уравнения нет решения");
    }
}
