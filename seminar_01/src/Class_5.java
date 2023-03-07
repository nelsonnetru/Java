public class Class_5
{
    public static void main(String[] args) {
        // переставить слова в строке в обратном порядке

        String str = "Добро пожаловать на курс по Java";
        String[] words = str.split(" ");
        String new_str = "";

        for (int i = words.length-1; i >= 0; i--) {
            new_str += words[i] + " ";
        }
        
        System.out.println(new_str);
    }
}
