import java.util.Scanner;

public class Class_02
{
    public static void main(String[] args) {
        String str = "aaaaabbbcccdg";
        
        if (str.length() == 0) return;

        char sample = str.charAt(0);
        int count = 1;
        StringBuilder result = new StringBuilder(); 

        for (int i = 1; i < str.length(); i++) {

            if (sample == str.charAt(i)) {
                count++;
            }
            else {
                result.append(sample + "" + count);
                sample = str.charAt(i);
                count = 1;
            }
        }
        result.append(sample + "" + count);
        System.out.println(result);
    }
}
