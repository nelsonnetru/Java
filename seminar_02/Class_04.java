import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Class_04
{
    private static int col = 100;
    private static String word = "TEST\n";

    public static void main(String[] args) {
        // col = 11;
        // word = "PRESS ";
        String txt = hundredTest(col, word);
        try {
            writeToFile(txt);
            readFromFile();
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static String hundredTest (int col, String word) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < col; i++)
            result.append(word);

        return result.toString();
    }

    public static void writeToFile (String str) throws IOException {

            FileWriter fw = new FileWriter("file.txt", false);
            fw.write(str);
            fw.flush();
            fw.close();
    }

    public static void readFromFile () throws IOException {
            FileReader fw = new FileReader("file1.txt");
            BufferedReader br = new BufferedReader(fw);
            String str;

            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }

            br.close();
            fw.close();
     }
}
