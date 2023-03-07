import java.util.Arrays;

public class Class_4
{
    public static void main(String[] args) {
        // Нахождение самой длинной строки общего префикса среди массива строк

        String[] args1 = new String[]{"abc", "abcde", "abcde", "abcdefg", "abcde", "ab"};
        String prefix = longestPrefix(args1);
        System.out.printf("Общий префикс: %s", prefix);
    }

    public static String longestPrefix (String[] str) {
        String prefix = "";

        for (int i = 0; i < str[0].length(); i++) {
            char sample = str[0].charAt(i);
            boolean check = false;

            for (int j = 1; j < str.length; j++) {
                if (i < str[j].length() && sample == str[j].charAt(i)) 
                    check = true;
                else {
                    check = false;
                    break;
                }
            }

            if (check) prefix += sample;
            else break;
        }

        return prefix;
    }
}
